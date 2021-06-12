package com.dumbdogdiner.skgame.minigame.query

import com.dumbdogdiner.skgame.minigame.Game
import com.dumbdogdiner.skgame.minigame.annotation.Resource

/**
 * Look for a given component.
 */
class ResourceQuery(val game: Game) : Query<Resource>(game.resourceManager.resources) {}
