package com.example.MarketSystem;

import java.util.List;

public interface DataAccessObject<E> {

		public E add(E newEntity);
		public List<E> find(int key);

}
