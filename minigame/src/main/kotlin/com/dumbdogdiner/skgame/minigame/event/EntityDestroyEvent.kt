/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.event

/**
 * Represents an entity destroy event.
 */
class EntityDestroyEvent<T : Any>(val entity: T) : Event {
    override val parameterClasses = listOf(entity::class)
}
