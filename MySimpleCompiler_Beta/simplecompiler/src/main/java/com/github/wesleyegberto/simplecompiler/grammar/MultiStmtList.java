package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * STMT_LIST → STMT STMT_LIST
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class MultiStmtList extends StmtList {

	private Stmt stmt;
	private StmtList stmtList;

	public MultiStmtList(Stmt stmt, StmtList stmtList) {
		this.stmt = stmt;
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "MultiStmtList{" +
			"stmt=" + stmt +
			", stmtList=" + stmtList +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		stmt.generateCode(memory);
		stmtList.generateCode(memory);
	}
}
