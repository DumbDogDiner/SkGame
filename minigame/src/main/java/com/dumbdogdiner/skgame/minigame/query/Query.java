package com.dumbdogdiner.skgame.minigame.query;

import com.dumbdogdiner.skgame.minigame.query.iterator.QueryIterator;

import java.util.Iterator;
import java.util.function.Predicate;

public class Query<T> {
	private Iterator<T> iterator;

	Query<T> filter(Predicate<T> predicate) {
		for (Iterator<T> it = this.iterator; it.hasNext(); ) {
			T val = it.next();


		}
	}

	Query<T> iterate(QueryIterator<T> iterator) {
		this.iterator = iterator;
		return this;
	}
}
