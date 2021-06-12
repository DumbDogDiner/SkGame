/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame

/**
 * Class of commands.
 */
class Commands(internal val game: Game) {
	/**
	 * Create a new entity.
	 */
	fun createEntity(vararg components: List<Any>) {
		game.entityManager.create(components)
	}
}
