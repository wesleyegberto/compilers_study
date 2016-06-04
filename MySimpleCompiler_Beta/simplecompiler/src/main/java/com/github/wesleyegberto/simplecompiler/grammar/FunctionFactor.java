package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * FACTOR → FUNCTION
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class FunctionFactor extends Factor {
	private Function function;

	public FunctionFactor(Function function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "FunctionFactor{" +
			"function=" + function +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
