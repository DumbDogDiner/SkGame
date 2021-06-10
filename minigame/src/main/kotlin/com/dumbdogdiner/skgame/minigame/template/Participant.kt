/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.template

import com.dumbdogdiner.skgame.minigame.annotation.Component
import com.dumbdogdiner.skgame.minigame.annotation.Resource
import org.bukkit.entity.Player

@Component
class WithPlayer(val player: Player)

@Resource
class GameState {
    val winningPlayer: Player? = null
}
