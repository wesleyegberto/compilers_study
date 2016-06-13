package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;
import com.github.wesleyegberto.simplecompiler.lexer.TokenType;

/**
 * OP_REL → RELOP_LT
 * OP_REL → RELOP_LTE
 * OP_REL → RELOP_GT
 * OP_REL → RELOP_GTE
 * OP_REL → RELOP_EQ
 * OP_REL → RELOP_NEQ
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class OpRel extends GrammarRule {
	private Token relop;

	public OpRel(Token relop) {
		if(relop.getTokenType() != TokenType.RELOP_LT
			&& relop.getTokenType() != TokenType.RELOP_LTE
			&& relop.getTokenType() != TokenType.RELOP_GT
			&& relop.getTokenType() != TokenType.RELOP_GTE
			&& relop.getTokenType() != TokenType.RELOP_NEQ
			&& relop.getTokenType() != TokenType.RELOP_EQ) {
			throw new IllegalArgumentException("Operador relacional inválido: " + relop.getLexeme());
		}
		this.relop = relop;
	}

	@Override
	public String toString() {
		return "OpRel{" +
			"relop=" + relop +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		memory.addParamToArg(relop.getLexeme());
	}
}
