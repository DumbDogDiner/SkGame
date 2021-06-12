/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.managers

import com.dumbdogdiner.skgame.minigame.Game
import com.dumbdogdiner.skgame.minigame.internal.ComponentInternal

/**
 * Manages components in the current game.
 */
internal class ComponentManager(internal val game: Game) {
    internal val components = mutableListOf<ComponentInternal>()

    /**
     * Register the target component, returning a new internal component.
     */
    internal fun registerComponent(component: Any): ComponentInternal {
        val componentInternal = ComponentInternal(component)
        this.components.add(componentInternal)
        return componentInternal
    }
}
