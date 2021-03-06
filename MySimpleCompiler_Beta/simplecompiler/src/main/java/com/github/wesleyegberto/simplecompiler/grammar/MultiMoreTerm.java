package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * MORE_TERM → OP_ARIT_LO TERM MORE_TERM
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class MultiMoreTerm extends MoreTerm {
	private OpAritLo opAritLo;
	private Term term;
	private MoreTerm moreTerm;

	public MultiMoreTerm(OpAritLo opAritLo, Term term, MoreTerm moreTerm) {
		this.opAritLo = opAritLo;
		this.term = term;
		this.moreTerm = moreTerm;
	}

	@Override
	public String toString() {
		return "MultiMoreTerm{" +
			"opAritLo=" + opAritLo +
			", term=" + term +
			", moreTerm=" + moreTerm +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		opAritLo.generateCode(memory);
		term.generateCode(memory);
		moreTerm.generateCode(memory);
	}
}
