package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * EXP_BOOL → EXP OP_REL EXP
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class SingleExpBool extends ExpBool {
	private Exp firstExp;
	private OpRel opRel;
	private Exp secondExp;

	public SingleExpBool(Exp firstExp, OpRel opRel, Exp secondExp) {
		this.firstExp = firstExp;
		this.opRel = opRel;
		this.secondExp = secondExp;
	}

	@Override
	public String toString() {
		return "SingleExpBool{" +
			"firstExp=" + firstExp +
			", opRel=" + opRel +
			", secondExp=" + secondExp +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		Table functionToUse = new Table();
		firstExp.generateCode(functionToUse);
		memory.copyArgFrom(functionToUse);

		opRel.generateCode(memory);

		functionToUse.clearAll();
		secondExp.generateCode(functionToUse);
		memory.copyArgFrom(functionToUse);
	}
}
