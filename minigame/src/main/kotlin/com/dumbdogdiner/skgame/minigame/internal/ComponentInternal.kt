/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.internal

import com.dumbdogdiner.skgame.minigame.ecs.annotation.Component
import com.dumbdogdiner.skgame.minigame.ecs.annotation.InvalidAnnotationException
import kotlin.reflect.full.hasAnnotation

/**
 * Represents a component internal.
 */
internal class ComponentInternal(val child: Any) {
    init {
        // ensure annotation
        if (!child::class.hasAnnotation<Component>()) {
            throw InvalidAnnotationException(child, Component::class)
        }
    }
}
