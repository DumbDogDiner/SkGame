/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.event

/**
 * Represents an entity creation event.
 */
class EntityCreateEvent<T : Any>(val entity: T) : Event {
    override val parameterClasses = listOf(entity::class)
}
