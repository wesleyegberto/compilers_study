package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;
import com.github.wesleyegberto.simplecompiler.lexer.TokenType;

/**
 * OP_ARIT_LO → *
 * OP_ARIT_LO → /
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class OpAritHi extends GrammarRule {
	private Token opAritHigh;

	public OpAritHi(Token opAritHigh) {
		if(opAritHigh.getTokenType() != TokenType.BINOP_MUL
			&& opAritHigh.getTokenType() != TokenType.BINOP_DIV) {
			throw new IllegalArgumentException("Operador aritmético inválido: " + opAritHigh.getLexeme());
		}
		this.opAritHigh = opAritHigh;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
