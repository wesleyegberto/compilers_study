package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * MORE_TERM → OP_ARIT_LO TERM
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class SingleMoreTerm extends MoreTerm {
	private OpAritLo opAritLo;
	private Term term;

	public SingleMoreTerm(OpAritLo opAritLo, Term term) {
		this.opAritLo = opAritLo;
		this.term = term;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
