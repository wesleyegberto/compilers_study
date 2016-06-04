package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * TERM → FACTOR MORE_FACTOR
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class MultiTerm extends Term {
	private Factor factor;
	private MoreFactor moreFactor;

	public MultiTerm(Factor factor, MoreFactor moreFactor) {
		this.factor = factor;
		this.moreFactor = moreFactor;
	}

	@Override
	public String toString() {
		return "MultiTerm{" +
			"factor=" + factor +
			", moreFactor=" + moreFactor +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
