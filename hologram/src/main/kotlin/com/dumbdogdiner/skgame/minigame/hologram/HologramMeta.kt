package com.dumbdogdiner.skgame.minigame.hologram

import org.bukkit.Location

/**
 * Represents hologram metadata.
 */
data class HologramMeta(
	/**
	 * The position of this hologram in the world.
	 */
	val location: Location,

	/**
	 * A list of strings containing the text content of this hologram.
	 */
	val lines: MutableList<String>,
)
