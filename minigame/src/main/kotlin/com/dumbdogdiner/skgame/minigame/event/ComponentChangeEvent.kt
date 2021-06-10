/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.event

/**
 * Represents a component change event.
 */
class ComponentChangeEvent<C : Any, E : Any>(val component: C, val entity: E) : Event {
    override val parameterClasses = listOf(component::class, entity::class)
}
