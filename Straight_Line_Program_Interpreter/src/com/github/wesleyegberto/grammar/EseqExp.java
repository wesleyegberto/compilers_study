package com.github.wesleyegberto.grammar;

import com.github.wesleyegberto.types.IntAndTable;

/**
 * Exp → ( Stm , Exp )
 */
public class EseqExp extends Exp {
	Stm stm;
	Exp exp;

	public EseqExp(Stm s, Exp e) {
		stm = s;
		exp = e;
	}

	@Override
	public IntAndTable interpExp(IntAndTable t) {
		return exp.interpExp(stm.interpStm(t));
	}
	
}
