package com.dumbdogdiner.skgame.minigame.query.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

public abstract class QueryIterator<T> implements Iterator<IteratorResult<T>> {
	protected final IteratorResult<T> result = new IteratorResult<>(null, false);

	@Override
	public boolean hasNext() {
		return !this.result.done;
	}

	@Override
	public IteratorResult<T> next() {
		this.result.value = this.get();
		this.result.done = this.result.value == null;
		return this.result;
	}

	@Override
	public void remove() {
		throw new IllegalStateException("cannot remove from query iterator");
	}

	@Override
	public void forEachRemaining(Consumer<? super IteratorResult<T>> action) {
		Iterator.super.forEachRemaining(action);
	}

	void reset() {
		this.result.value = null;
		this.result.done = false;
	}

	abstract T get();
}
