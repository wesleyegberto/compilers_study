package com.github.wesleyegberto.grammar;

import com.github.wesleyegberto.types.IntAndTable;

/**
 * Exp → num
 */
public class NumExp extends Exp {
	public int num;

	public NumExp(int n) {
		num = n;
	}

	@Override
	public IntAndTable interpExp(IntAndTable t) {
		return new IntAndTable(num, t.t);
	}
	
	
}
