package com.dumbdogdiner.skgame.minigame.hologram

import org.bukkit.Location
import org.bukkit.entity.ArmorStand

/**
 * A armor-stand-based hologram for displaying text.
 */
open class Hologram(
	private val location: Location, 
	private val armorStand: List<ArmorStand>
) {
	/**
	 * Destroy this hologram, killing all entites attached to it.
	 */
	fun destroy() {
		// set all armor stand health values to zero
		this.armorStand.forEach { it.health = 0.0 }
	}	
}
