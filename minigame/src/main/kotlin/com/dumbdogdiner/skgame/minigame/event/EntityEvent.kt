/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.event

/**
 * A generic entity event.
 */
abstract class EntityEvent : Event {
    /**
	 * The components attached to this entity.
	 */
    abstract val components: List<Any>
}
