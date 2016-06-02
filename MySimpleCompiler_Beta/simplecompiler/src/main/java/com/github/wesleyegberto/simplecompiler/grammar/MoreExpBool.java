package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * MORE_EXP_BOOL → OP_BOOL EXP_BOOL
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class MoreExpBool extends GrammarRule {
	private OpBool opBool;
	private ExpBool expBool;

	public MoreExpBool(OpBool opBool, ExpBool expBool) {
		this.opBool = opBool;
		this.expBool = expBool;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
