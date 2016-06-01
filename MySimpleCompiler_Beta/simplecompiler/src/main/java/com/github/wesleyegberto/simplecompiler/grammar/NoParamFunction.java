package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;

/**
 * FUNCTION → id ( )
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class NoParamFunction extends Function {

	private Token id;

	public NoParamFunction(Token id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NoParamFunction{id=" + id + '}';
	}

	@Override
	public String generateCode(Table memory) {
		return id.getLexeme();
	}
}
