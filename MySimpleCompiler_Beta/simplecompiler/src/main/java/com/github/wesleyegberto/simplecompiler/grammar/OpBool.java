package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;
import com.github.wesleyegberto.simplecompiler.lexer.TokenType;

/**
 * OP_BOOL → and
 * OP_BOOL → or
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class OpBool extends GrammarRule {
	private Token opBool;

	public OpBool(Token opBool) {
		if(opBool.getTokenType() != TokenType.AND
			&& opBool.getTokenType() != TokenType.OR) {
			throw new IllegalArgumentException("Operador lógico inválido: " + opBool.getLexeme());
		}
		this.opBool = opBool;
	}

	@Override
	public String toString() {
		return "OpBool{" +
			"opBool=" + opBool +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
