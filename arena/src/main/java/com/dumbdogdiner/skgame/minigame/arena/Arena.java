package com.dumbdogdiner.skgame.minigame.arena;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a generic arena implementation.
 */
public abstract class Arena {
	@Getter
	protected Set<Player> players = new HashSet<>();
}
