package com.dumbdogdiner.skgame.minigame.query.iterator;

public class IteratorResult<T> {
	T value;
	boolean done;

	IteratorResult(T value, boolean done) {
		this. value = value;
		this.done = done;
	}
}
