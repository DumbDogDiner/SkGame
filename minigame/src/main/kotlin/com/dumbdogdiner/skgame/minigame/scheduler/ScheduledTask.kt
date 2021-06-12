/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.scheduler

import com.dumbdogdiner.skgame.minigame.Commands

/**
 * Represents a scheduled task.
 */
class ScheduledTask(
    val delay: Int,
    val period: Int,
    val cb: (cmds: Commands) -> Unit
)
