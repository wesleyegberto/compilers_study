package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * CTRL_FLUX → WHILE
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class WhileCtrlFlux extends CtrlFlux {
	private While aWhile;

	public WhileCtrlFlux(While aWhile) {
		this.aWhile = aWhile;
	}

	@Override
	public String toString() {
		return "WhileCtrlFlux{" +
			"aWhile=" + aWhile +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		aWhile.generateCode(memory);
	}
}
