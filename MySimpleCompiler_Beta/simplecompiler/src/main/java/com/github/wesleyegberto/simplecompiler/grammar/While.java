package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * WHILE → while ( EXP_BOOL ) { STMT_LIST }
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class While extends GrammarRule {
	private ExpBool expBool;
	private StmtList stmtList;

	public While(ExpBool expBool, StmtList stmtList) {
		this.expBool = expBool;
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "While{" +
			"expBool=" + expBool +
			", stmtList=" + stmtList +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		expBool.generateCode(memory);
		stmtList.generateCode(memory);
	}
}
