/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.managers

import com.dumbdogdiner.skgame.minigame.internal.ComponentInternal
import com.dumbdogdiner.skgame.minigame.internal.EntityInternal

/**
 * Manages the creation of entities.
 */
internal class EntityManager {
    /**
	 * A list of entities
	 */
    private val entities = mutableMapOf<Any, EntityInternal>()

    /**
	 * Create a new entity.
	 */
    fun create(entity: Any, vararg components: Any): EntityManager {
        this.entities[entity] = EntityInternal(
            entity, components = components.map { ComponentInternal(it) }.toTypedArray()
        )
        return this
    }
}
