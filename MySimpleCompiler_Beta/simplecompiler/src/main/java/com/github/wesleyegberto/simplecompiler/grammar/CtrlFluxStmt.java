package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * STMT → CTRL_FLUX
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class CtrlFluxStmt extends Stmt {
	//private CtrlFlux ctrlFlux;

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
