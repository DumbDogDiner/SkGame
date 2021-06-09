package com.dumbdogdiner.skgame.minigame.ecs

import com.dumbdogdiner.skgame.minigame.ecs.annotation.Entity
import com.dumbdogdiner.skgame.minigame.ecs.annotation.InvalidAnnotationException
import kotlin.reflect.full.hasAnnotation

/**
 * Represents an internal entity.
 */
internal class EntityInternal(child: Any) {
	init {
		// ensure annotation
		if (!child::class.hasAnnotation<Entity>()) {
			throw InvalidAnnotationException(child, Entity::class)
		}
	}

	val components = listOf<ComponentInternal>()
}
