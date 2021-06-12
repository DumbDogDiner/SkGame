/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.query

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.createType
import kotlin.reflect.typeOf

abstract class Query<T : Any>(val elements: List<T>) {
    val includeClasses = mutableListOf<KClass<*>>()
    val includeTypes = mutableListOf<KType>()

    val excludeClasses = mutableListOf<KClass<*>>()
    val excludeTypes = mutableListOf<KType>()

    /**
	 * Include the following types in the query.
	 */
    fun include(vararg classes: KClass<*>): Query<T> {
        this.includeClasses.addAll(classes)
        return this
    }

    /**
	 * Include objects of the target type in the query.
	 */
    @OptIn(ExperimentalStdlibApi::class)
    inline fun <reified T : Any> include(): Query<T> {
        val type = typeOf<T>()
        this.includeTypes.add(type)
        return this
    }

    /**
	 * Exclude the following types from the query.
	 */
    fun exclude(vararg classes: KClass<*>): Query<T> {
        this.excludeClasses.addAll(classes)
        return this
    }

    /**
	 * Exclude objects of the target type from the query.
	 */
    @OptIn(ExperimentalStdlibApi::class)
    inline fun <reified K : Any> exclude(): Query<T> {
        val type = typeOf<K>()
        this.excludeTypes.add(type)
        return this
    }

    /**
	 * Fetch the first component of type T.
	 */
    fun first(): T {
        val item = this.elements.find {
            it::class.createType(type.arguments, type.isMarkedNullable, type.annotations) == type
        } ?: throw RuntimeException("Failed to find an item of type $type")
        // check null
        return item as T
    }

    /**
	 * Get the first query item or
	 */
    fun firstOrNull(): T? {
        return try {
            this.first()
        } catch (_: Exception) {
            null
        }
    }

    /**
	 * Return this query as a list.
	 */
    abstract fun asList(): List<T>

    /**
	 * Return this query as an iterator.
	 */
    fun asIter(): Iterator<T> {
        return this.asList().iterator()
    }
}
