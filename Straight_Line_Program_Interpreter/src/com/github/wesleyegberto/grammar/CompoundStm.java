package com.github.wesleyegberto.grammar;

import com.github.wesleyegberto.types.IntAndTable;

/**
 * Stm → Stm ; Stm
 */
public class CompoundStm extends Stm {
	public Stm stm1, stm2;

	public CompoundStm(Stm s1, Stm s2) {
		stm1 = s1;
		stm2 = s2;
	}

	@Override
	public IntAndTable interpStm(IntAndTable t) {
		return stm2.interpStm(stm1.interpStm(t));
	}
}
