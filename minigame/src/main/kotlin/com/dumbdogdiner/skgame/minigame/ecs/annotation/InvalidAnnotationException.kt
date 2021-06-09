package com.dumbdogdiner.skgame.minigame.ecs.annotation

import kotlin.reflect.KClass

/**
 * A generic annotation exception.
 */
class InvalidAnnotationException(val target: Any, val expected: KClass<*>) : RuntimeException() {
	override val message
		get() = "Expected object ${target::class.simpleName} to have annotation ${expected.simpleName}"
}
