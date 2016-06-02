package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * OP_ARIT → OP_ARIT_LO
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class LowOpArit extends OpArit {
	private OpAritLo opAritLo;

	public LowOpArit(OpAritLo opAritLo) {
		this.opAritLo = opAritLo;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
