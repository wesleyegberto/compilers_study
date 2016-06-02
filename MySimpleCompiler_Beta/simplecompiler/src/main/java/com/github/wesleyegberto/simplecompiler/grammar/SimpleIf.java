package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * IF → if ( EXP_BOOL ) { STMT_LIST }
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class SimpleIf extends If {
	private ExpBool expBool;
	private StmtList stmtList;

	public SimpleIf(ExpBool expBool, StmtList stmtList) {
		this.expBool = expBool;
		this.stmtList = stmtList;
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
