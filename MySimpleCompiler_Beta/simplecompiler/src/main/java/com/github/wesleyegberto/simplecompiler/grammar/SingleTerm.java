package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * TERM → FACTOR
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class SingleTerm extends Term {
	private Factor factor;

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
