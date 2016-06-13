package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * TERM → FACTOR
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class SingleTerm extends Term {
	private Factor factor;

	public SingleTerm(Factor factor) {
		this.factor = factor;
	}

	@Override
	public String toString() {
		return "SingleTerm{" +
			"factor=" + factor +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		factor.generateCode(memory);
	}
}
