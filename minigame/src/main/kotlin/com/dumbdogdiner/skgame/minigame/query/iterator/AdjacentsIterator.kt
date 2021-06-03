package com.dumbdogdiner.skgame.minigame.query.iterator

import jdk.nashorn.internal.objects.Global.undefined
import org.bukkit.util.Vector
import java.util.function.Function


val LATERALS = listOf( // X
	Vector(1, 0, 0),
	Vector(-1, 0, 0),  // Y
	Vector(0, 1, 0),
	Vector(0, -1, 0),  // Z
	Vector(0, 0, 1),
	Vector(0, 0, -1)
)
val DIAGONALS = listOf( // Same row
	Vector(1, 1, 0),
	Vector(-1, 1, 0),
	Vector(-1, -1, 0),
	Vector(1, -1, 0),  // Above
	Vector(1, 1, 1),
	Vector(-1, 1, 1),
	Vector(-1, -1, 1),
	Vector(1, -1, 1),  // below
	Vector(1, 1, -1),
	Vector(-1, 1, -1),
	Vector(-1, -1, -1),
	Vector(1, -1, -1)
)

class AdjacentsIterator<T> internal constructor(
	private val laterals: Boolean,
	private val diagonals: Boolean,
	private val handler: Function<Vector, T>
) : QueryIterator<T>() {

	private val index = 0
	fun get(): T? {
		val value: Vector? = when {
			this.laterals -> LATERALS.getOrElse(this.index) {
				if (this.diagonals) {
					DIAGONALS.getOrNull(this.index - LATERALS.size)
				} else {
					null
				}
			}
			this.diagonals -> DIAGONALS.getOrNull(this.index)
			else -> null
		}
		return if (value != null) handler.apply(value) else null
	}
}