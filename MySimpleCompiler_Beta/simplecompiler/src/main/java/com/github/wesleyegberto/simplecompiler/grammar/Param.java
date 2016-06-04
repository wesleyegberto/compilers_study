package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * PARAMS → VAR
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class Param extends GrammarRule {
	private Var var;

	public Param(Var var) {
		this.var = var;
	}

	@Override
	public String toString() {
		return "Param{" +
			"var=" + var +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
