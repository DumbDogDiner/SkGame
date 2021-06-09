package com.dumbdogdiner.skgame.minigame.ecs.event

import kotlin.reflect.KClass

/**
 * Represents a component change event.
 */
class ComponentChangeEvent<C : Any, E : Any>(val component: C, val entity: E) : Event {
	override val parameterClasses = listOf(component::class, entity::class)
}
