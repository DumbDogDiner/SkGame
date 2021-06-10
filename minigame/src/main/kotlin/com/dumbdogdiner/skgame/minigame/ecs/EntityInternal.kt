/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.ecs

import com.dumbdogdiner.skgame.minigame.ecs.annotation.Entity
import com.dumbdogdiner.skgame.minigame.ecs.annotation.InvalidAnnotationException
import kotlin.reflect.full.hasAnnotation

/**
 * Represents an internal entity.
 */
internal class EntityInternal(child: Any) {
    init {
        // ensure annotation
        if (!child::class.hasAnnotation<Entity>()) {
            throw InvalidAnnotationException(child, Entity::class)
        }
    }

    /**
	 * A list of components attached to this entity.
	 */
    val components = listOf<ComponentInternal>()
}
