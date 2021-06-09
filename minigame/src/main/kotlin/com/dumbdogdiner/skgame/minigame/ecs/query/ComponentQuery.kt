package com.dumbdogdiner.skgame.minigame.ecs.query

import java.lang.RuntimeException
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.createType
import kotlin.reflect.typeOf

/**
 * Look for a given component.
 */
class ComponentQuery {
	val includeClasses = mutableListOf<KClass<*>>()
	val includeTypes = mutableListOf<KType>()

	val excludeClasses = mutableListOf<KClass<*>>()
	val excludeTypes = mutableListOf<KType>()

	/**
	 * Include the following types in the query.
	 */
	fun include(vararg componentTypes: KClass<*>): ComponentQuery {
		this.includeClasses.addAll(componentTypes)
		return this
	}

	/**
	 * Include objects of the target type in the query.
	 */
	@OptIn(ExperimentalStdlibApi::class)
	inline fun <reified T : Any> include(): ComponentQuery {
		val type = typeOf<T>()
		this.includeTypes.add(type)
		return this
	}

	/**
	 * Exclude the following types from the query.
	 */
	fun exclude(vararg componentTypes: KClass<*>): ComponentQuery {
		this.excludeClasses.addAll(componentTypes)
		return this
	}

	/**
	 * Exclude objects of the target type from the query.
	 */
	@OptIn(ExperimentalStdlibApi::class)
	inline fun <reified T : Any> exclude(): ComponentQuery {
		val type = typeOf<T>()
		this.excludeTypes.add(type)
		return this
	}

	/**
	 * Fetch the first component of type T.
	 */
	@OptIn(ExperimentalStdlibApi::class)
	inline fun <reified T : Any> first(): T {
		val type = typeOf<T>()
		// iterate through all matching types and get first
		val item = this.get().find {
			it::class.createType(type.arguments, type.isMarkedNullable, type.annotations) == type
		} ?: throw RuntimeException("Failed to find an item of type $type")
		// check null
		return item as T
	}

	/**
	 * Fetch the first component of type T, or return null.
	 */
	inline fun <reified T : Any> firstOrNull(): T? {
		return try {
			this.first()
		} catch (e: Exception) {
			null
		}
	}

	/**
	 * Return a list of components.
	 */
	fun get(): List<Any> {
		TODO("Add component manager impl")
	}
}
