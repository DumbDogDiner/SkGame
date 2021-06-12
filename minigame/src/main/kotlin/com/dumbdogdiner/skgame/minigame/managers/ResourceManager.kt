/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.managers

import com.dumbdogdiner.skgame.minigame.Game
import com.dumbdogdiner.skgame.minigame.internal.ResourceInternal

/**
 * Manages internal resources.
 */
internal class ResourceManager(internal val game: Game) {
	internal val resourceObjects = mutableListOf<Any>()
	internal val resources = mutableListOf<ResourceInternal>()
}
