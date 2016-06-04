package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * FACTOR → VAR
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class VarFactor extends Factor {
	private Var var;

	public VarFactor(Var var) {
		this.var = var;
	}

	@Override
	public String toString() {
		return "VarFactor{" +
			"var=" + var +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
