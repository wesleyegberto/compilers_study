package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * MORE_FACTOR → OP_ARIT_HI FACTOR
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class SingleMoreFactor extends MoreFactor {
	private OpAritHi opAritHi;
	private Factor factor;

	public SingleMoreFactor(OpAritHi opAritHi, Factor factor) {
		this.opAritHi = opAritHi;
		this.factor = factor;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
