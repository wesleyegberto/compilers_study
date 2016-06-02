package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * CTRL_FLUX → FOR
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class ForCtrlFlux extends CtrlFlux {

	private For aFor;

	public ForCtrlFlux(For aFor) {
		this.aFor = aFor;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
