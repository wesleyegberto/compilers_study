package com.github.wesleyegberto.types;

/**
 * Sequence of assignments:
 * {a → 3, c → 4, a → 12}
 * Stand for:
 * a = 3
 * c = 4
 * a = 12
 */
public class Table {
	String id;
	int value;
	Table tail;

	public Table(String i, int v, Table t) {
		id = i;
		value = v;
		tail = t;
	}

	public int lookup(String key) {
		return (id != null && id.equals(key) ? value : (tail != null ? tail.lookup(key) : 0));
	}

	public Table insert(String id2, int i2) {
		return new Table(id2, i2, this);
	}
}