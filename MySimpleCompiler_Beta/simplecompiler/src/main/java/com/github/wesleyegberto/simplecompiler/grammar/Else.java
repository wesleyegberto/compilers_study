package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * ELSE → else { STMT_LIST }
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class Else extends GrammarRule {
	private StmtList stmtList;

	public Else(StmtList stmtList) {
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "Else{" +
			"stmtList=" + stmtList +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
