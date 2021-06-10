/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame

import com.dumbdogdiner.skgame.minigame.managers.ComponentManager
import com.dumbdogdiner.skgame.minigame.managers.EntityManager
import com.dumbdogdiner.skgame.minigame.managers.SystemManager

/**
 * The minigame root class.
 */
class Game {
    private val entityManager = EntityManager()
    private val componentManager = ComponentManager()
    private val systemManager = SystemManager()

    /**
     * Add a system that runs on startup.
     */
    fun addStartupSystem(cb: (commands: Commands) -> Unit): Game {
        this.systemManager.addStartupSystem(cb)
        return this
    }

    /**
     * Add a system that runs every tick.
     */
    fun addSystem(cb: (commands: Commands) -> Unit): Game {
        this.systemManager.addStartupSystem(cb)
        return this
    }
}
