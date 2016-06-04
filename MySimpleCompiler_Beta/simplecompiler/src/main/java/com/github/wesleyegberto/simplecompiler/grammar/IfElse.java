package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.If;
import com.github.wesleyegberto.simplecompiler.grammar.StmtList;
import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * IF → if ( EXP_BOOL ) { STMT_LIST } ELSE
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class IfElse extends If {
	private ExpBool expBool;
	private StmtList stmtList;
	private Else anElse;

	public IfElse(ExpBool expBool, StmtList stmtList, Else anElse) {
		this.expBool = expBool;
		this.stmtList = stmtList;
		this.anElse = anElse;
	}

	@Override
	public String toString() {
		return "IfElse{" +
			"expBool=" + expBool +
			", stmtList=" + stmtList +
			", anElse=" + anElse +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
