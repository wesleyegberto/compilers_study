package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * OP_ARIT → OP_ARIT_HI
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class HighOpArit extends OpArit {
	private OpAritHi opAritHi;

	public HighOpArit(OpAritHi opAritHi) {
		this.opAritHi = opAritHi;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
