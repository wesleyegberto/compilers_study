package com.github.wesleyegberto.grammar;

import com.github.wesleyegberto.types.IntAndTable;

/**
 * Stm → print ( ExpList )
 */
public class PrintStm extends Stm {
	ExpList exps;

	public PrintStm(ExpList e) {
		exps = e;
	}

	@Override
	public IntAndTable interpStm(IntAndTable t) {
		ExpList el = exps;
		IntAndTable r;
		
		while(!(el instanceof LastExpList)) {
			r = ((PairExpList) el).head.interpExp(t);
			System.out.print(r.i);
			System.out.print(" ");
			el = ((PairExpList) el).tail;
		}
		r = ((LastExpList) el).head.interpExp(t);
		System.out.println(r.i);
		return r;
	}
}
