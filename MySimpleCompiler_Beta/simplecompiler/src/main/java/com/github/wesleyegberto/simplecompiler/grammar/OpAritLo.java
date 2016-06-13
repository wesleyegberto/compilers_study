package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;
import com.github.wesleyegberto.simplecompiler.lexer.TokenType;

/**
 * OP_ARIT_LO → +
 * OP_ARIT_LO → -
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class OpAritLo extends GrammarRule {
	private Token opAritLow;

	public OpAritLo(Token opAritLow) {
		if(opAritLow.getTokenType() != TokenType.BINOP_ADD
			&& opAritLow.getTokenType() != TokenType.BINOP_SUB) {
			throw new IllegalArgumentException("Operador aritmético inválido: " + opAritLow.getLexeme());
		}
		this.opAritLow = opAritLow;
	}

	@Override
	public String toString() {
		return "OpAritLo{" +
			"opAritLow=" + opAritLow +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		memory.addParamToArg(opAritLow.getLexeme());
	}
}
