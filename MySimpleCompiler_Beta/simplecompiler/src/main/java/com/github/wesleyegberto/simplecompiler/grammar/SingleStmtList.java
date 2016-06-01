package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * STMT_LIST → STMT
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class SingleStmtList extends StmtList {

	private Stmt stmt;

	public SingleStmtList(Stmt stmt) {
		this.stmt = stmt;
	}

	@Override
	public String toString() {
		return "SingleStmtList{stmt=" + stmt + '}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
