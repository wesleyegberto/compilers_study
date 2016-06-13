package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * STMT → FUNCTION ;
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class FunctionStmt extends Stmt {

	private Function function;

	public FunctionStmt(Function function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "FunctionStmt{function=" + function + '}';
	}

	@Override
	public void generateCode(Table memory) {
		function.generateCode(memory);
	}
}
