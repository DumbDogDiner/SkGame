package com.dumbdogdiner.skgame.minigame.ecs

import com.dumbdogdiner.skgame.minigame.ecs.annotation.Component
import com.dumbdogdiner.skgame.minigame.ecs.annotation.InvalidAnnotationException
import kotlin.reflect.full.hasAnnotation

/**
 * Represents a component internal.
 */
internal class ComponentInternal(val child: Any) {
	init {
		// ensure annotation
		if (!child::class.hasAnnotation<Component>()) {
			throw InvalidAnnotationException(child, Component::class)
		}
	}
}
