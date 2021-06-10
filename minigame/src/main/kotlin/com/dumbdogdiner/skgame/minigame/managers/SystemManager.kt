/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.managers

import com.dumbdogdiner.skgame.minigame.Commands
import com.dumbdogdiner.skgame.minigame.internal.SystemInternal

/**
 * Manages systems.
 */
internal class SystemManager {
    private val startupSystems = mutableListOf<SystemInternal>()
    private val systems = mutableListOf<SystemInternal>()

    /**
	 * Add a system to the manager.
	 */
    fun addSystem(cb: (commands: Commands) -> Unit): SystemManager {
        this.systems.add(SystemInternal(cb))
        return this
    }

    /**
	 * Add a startup system.
	 */
    fun addStartupSystem(cb: (commands: Commands) -> Unit): SystemManager {
        this.startupSystems.add(SystemInternal(cb))
        return this
    }
}
