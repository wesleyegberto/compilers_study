package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * CTRL_FLUX → IF
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class IfCtrlFlux extends CtrlFlux {
	private If anIf;

	public IfCtrlFlux(If anIf) {
		this.anIf = anIf;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
