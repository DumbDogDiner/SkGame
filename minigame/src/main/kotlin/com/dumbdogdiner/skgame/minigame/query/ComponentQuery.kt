/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.query

import com.dumbdogdiner.skgame.minigame.Game
import com.dumbdogdiner.skgame.minigame.internal.ComponentInternal

/**
 * Look for a given component.
 */
class ComponentQuery(val game: Game) : Query<ComponentInternal>(game.componentManager.components)
