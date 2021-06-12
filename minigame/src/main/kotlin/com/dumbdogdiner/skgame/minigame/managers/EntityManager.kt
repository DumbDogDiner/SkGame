/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.managers

import com.dumbdogdiner.skgame.minigame.Game
import com.dumbdogdiner.skgame.minigame.internal.EntityInternal

/**
 * Manages the creation of entities.
 */
internal class EntityManager(internal val game: Game) {
    /**
	 * A list of entities
	 */
    private val entities = mutableListOf<EntityInternal>()

    /**
	 * Create a new entity.
	 */
    fun create(vararg components: Any): EntityManager {
        // register components
        val internalComponents = components.map {
            game.componentManager.registerComponent(it)
        }
        // create entity
        this.entities.add(EntityInternal(
            components = internalComponents.toTypedArray()
        ))
        return this
    }
}
