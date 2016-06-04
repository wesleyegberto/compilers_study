package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * FOR → for ( i = EXP ; i OP_REL EXP ; i = i OP_ARIT EXP ) { STMT_LIST }
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class For extends GrammarRule {
	private Exp initialExp;
	private OpRel opRel;
	private Exp finalExp;
	private OpArit opArit;
	private Exp stepExp;
	private StmtList stmtList;

	public For(Exp initialExp, OpRel opRel, Exp finalExp, OpArit opArit, Exp stepExp, StmtList stmtList) {
		this.initialExp = initialExp;
		this.opRel = opRel;
		this.finalExp = finalExp;
		this.opArit = opArit;
		this.stepExp = stepExp;
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "For{" +
			"initialExp=" + initialExp +
			", opRel=" + opRel +
			", finalExp=" + finalExp +
			", opArit=" + opArit +
			", stepExp=" + stepExp +
			", stmtList=" + stmtList +
			'}';
	}

	@Override
	public String generateCode(Table memory) {
		return null;
	}
}
