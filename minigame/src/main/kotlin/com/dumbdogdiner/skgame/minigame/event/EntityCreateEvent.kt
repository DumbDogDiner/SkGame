/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.event

import kotlin.reflect.KClass

/**
 * Represents an entity creation event.
 */
class EntityCreateEvent(override val components: List<Any>) : EntityEvent() {
    override val parameterClasses = listOf<KClass<*>>()
}
