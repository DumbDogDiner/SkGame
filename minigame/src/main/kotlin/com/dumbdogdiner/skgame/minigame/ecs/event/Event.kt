package com.dumbdogdiner.skgame.minigame.ecs.event

import kotlin.reflect.KClass

/**
 * Represents a generic event.
 */
interface Event {
	val parameterClasses: List<KClass<*>>
}
