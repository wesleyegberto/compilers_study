package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * EXP → TERM
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class SingleExp extends Exp {
	private Term term;

	public SingleExp(Term term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "SingleExp{" +
			"term=" + term +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
