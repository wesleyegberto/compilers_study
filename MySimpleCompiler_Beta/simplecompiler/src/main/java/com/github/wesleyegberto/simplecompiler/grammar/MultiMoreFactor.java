package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * MORE_FACTOR → OP_ARIT_HI FACTOR MORE_FACTOR
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class MultiMoreFactor extends MoreFactor {
	private OpAritHi opAritHi;
	private Factor factor;
	private MoreFactor moreFactor;

	public MultiMoreFactor(OpAritHi opAritHi, Factor factor, MoreFactor moreFactor) {
		this.opAritHi = opAritHi;
		this.factor = factor;
		this.moreFactor = moreFactor;
	}

	@Override
	public String toString() {
		return "MultiMoreFactor{" +
			"opAritHi=" + opAritHi +
			", factor=" + factor +
			", moreFactor=" + moreFactor +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		opAritHi.generateCode(memory);
		factor.generateCode(memory);
		moreFactor.generateCode(memory);
	}
}
