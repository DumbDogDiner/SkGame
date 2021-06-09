package com.dumbdogdiner.skgame.minigame.ecs.event

import kotlin.reflect.KClass

/**
 * Represents an entity destroy event.
 */
class EntityDestroyEvent<T : Any>(val entity: T) : Event {
	override val parameterClasses = listOf(entity::class)
}
