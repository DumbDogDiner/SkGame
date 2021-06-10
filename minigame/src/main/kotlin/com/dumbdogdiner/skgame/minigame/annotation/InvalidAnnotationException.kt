/*
 * Copyright (c) 2020-2021 DumbDogDiner <dumbdogdiner.com>. All rights reserved.
 * Licensed under the MIT license, see LICENSE for more information...
 */
package com.dumbdogdiner.skgame.minigame.ecs.annotation

import kotlin.reflect.KClass

/**
 * A generic annotation exception.
 */
class InvalidAnnotationException(val target: Any, val expected: KClass<*>) : RuntimeException() {
    override val message
        get() = "Expected object ${target::class.simpleName} to have annotation ${expected.simpleName}"
}
