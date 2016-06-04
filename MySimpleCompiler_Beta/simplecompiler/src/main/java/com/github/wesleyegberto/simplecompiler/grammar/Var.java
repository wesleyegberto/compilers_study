package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;
import com.github.wesleyegberto.simplecompiler.lexer.TokenType;

/**
 * VAR → num
 * VAR → real
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class Var extends GrammarRule {
	private Token var;

	public Var(Token var) {
		if(var.getTokenType() != TokenType.NUM
			&& var.getTokenType() != TokenType.REAL) {
			throw new IllegalArgumentException("Valor numérico inválido: " + var.getLexeme());
		}
		this.var = var;
	}

	@Override
	public String toString() {
		return "Var{" +
			"var=" + var +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
