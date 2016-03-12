package com.github.wesleyegberto.types;

/**
 * Return Int for Expr and Table for side effects
 */
public class IntAndTable {
	public int i;
	public Table t;

	public IntAndTable(int ii, Table tt) {
		i = ii;
		t = tt;
	}
	
	int lookup(String key) {
		return t.lookup(key);
	}

	public Table insert(String id, int i2) {
		return t = t.insert(id, i2);
	}
}