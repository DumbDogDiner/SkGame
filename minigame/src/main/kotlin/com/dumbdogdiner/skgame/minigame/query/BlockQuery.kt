package com.dumbdogdiner.skgame.minigame.query

import org.bukkit.Material
import org.bukkit.block.Block

class BlockQuery : Query<Block>() {
	fun adjacents(includeDiagonals: Boolean): BlockQuery {}

	fun laterals(): BlockQuery {}
	fun diagonals(): BlockQuery {}
	fun hasMaterial(material: Material): BlockQuery {
		return this.iterate()
	}

	val isFilled: BlockQuery
		get() {}
	val isEmpty: BlockQuery
		get() {}
}
