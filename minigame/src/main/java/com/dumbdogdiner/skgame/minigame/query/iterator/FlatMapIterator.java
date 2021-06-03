package com.dumbdogdiner.skgame.minigame.query.iterator;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class FlatMapIterator<P, T> extends QueryIterator<T> {
	private QueryIterator<T> parent;
	private QueryIterator<T> childIterator;
	private Function<P, T> handler;

	public FlatMapIterator(QueryIterator<T> parent, Function<P, T> handler) {
		this.parent = parent;
		this.handler = handler;
	}

	public void reset() {
		super.reset();
		this.parent.reset();
	}

	@Nullable
	T get() {
		if (this.result.done) {
			return null;
		} else if (this.childIterator != null) {
	}
}
