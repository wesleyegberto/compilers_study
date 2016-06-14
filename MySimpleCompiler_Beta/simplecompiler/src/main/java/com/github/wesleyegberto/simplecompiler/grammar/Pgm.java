package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * PGM → program { STMT_LIST }
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class Pgm extends GrammarRule {
	private StmtList stmtList;

	public Pgm(StmtList stmtList) {
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "Pgm{stmtList=" + stmtList + '}';
	}

	@Override
	public void generateCode(Table memory) {
		stmtList.generateCode(memory);
		// Adiciona o fim de instruções
		memory.addInstruction('$', "");
	}
}
