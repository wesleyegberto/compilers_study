package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * EXP → TERM MORE_TERM
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class MultiExp extends Exp {
	private Term term;
	private MoreTerm moreTerm;

	public MultiExp(Term term, MoreTerm moreTerm) {
		this.term = term;
		this.moreTerm = moreTerm;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
