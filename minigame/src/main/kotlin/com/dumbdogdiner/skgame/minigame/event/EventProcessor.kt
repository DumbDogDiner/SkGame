/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.event

import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.createType
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.valueParameters
import kotlin.reflect.typeOf

/**
 * Handles the processing of events.
 */
class EventProcessor {
    /**
	 * An array of listeners.
	 */
    val listeners = mutableListOf<Listener>()

    /**
	 * Register a new listener.
	 */
    fun registerListener(l: Listener) {
        this.listeners.add(l)
    }

    /**
	 * Call the target event.
	 */
    fun call(e: Event) {
        val listeners = this.findMatchingListeners(e)
        listeners.forEach { pair ->
            pair.second.call(pair.first, e)
        }
    }

    /**
	 * Find listeners that match the type of the target event.
	 */
    @OptIn(ExperimentalStdlibApi::class)
    private fun findMatchingListeners(e: Event): List<Pair<Listener, KFunction<*>>> {
        return this.listeners.flatMap {
                listener -> listener::class.declaredFunctions.map { Pair(listener, it)
        } }.filter { it.second.hasAnnotation<EventListener>() }
            .filter {
                val ev = it.second.valueParameters[0]
                ev.kind == KParameter.Kind.VALUE &&
                    ev.type.isSubtypeOf(typeOf<Event>())
            }.filter {
                val args = it.second.valueParameters[0].type.arguments
                var equal = true
                for (i in args.indices) {
                    val type = args[i].type
                    if (type != e.parameterClasses[i].createType()) {
                        equal = false
                        break
                    }
                }
                equal
            }
    }
}
