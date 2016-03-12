package com.github.wesleyegberto.grammar;

import com.github.wesleyegberto.types.IntAndTable;

/**
 * Exp → id
 */
public class IdExp extends Exp {
	public String id;

	public IdExp(String i) {
		id = i;
	}

	@Override
	public IntAndTable interpExp(IntAndTable t) {
		return new IntAndTable(t.t.lookup(id), t.t);
	}
}
