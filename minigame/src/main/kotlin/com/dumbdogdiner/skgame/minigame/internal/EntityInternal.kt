/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.internal

import com.dumbdogdiner.skgame.minigame.annotation.InvalidAnnotationException
import kotlin.reflect.full.hasAnnotation

/**
 * Represents an internal entity.
 */
internal class EntityInternal(vararg components: ComponentInternal) {
    /**
	 * A list of components attached to this entity.
	 */
    val components: List<ComponentInternal>

    init {
        // create components
        this.components = components.asList()
    }
}
