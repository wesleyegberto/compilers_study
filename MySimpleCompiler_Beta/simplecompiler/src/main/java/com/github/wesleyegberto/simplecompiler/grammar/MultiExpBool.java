package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * EXP_BOOL → EXP OP_REL EXP MORE_EXP_BOOL
 *
 * @author Wesley Egberto on 02/06/16.
 */
public class MultiExpBool extends ExpBool {
	private Exp firstExp;
	private OpRel opRel;
	private Exp secondExp;
	private MoreExpBool moreExpBool;

	public MultiExpBool(Exp firstExp, OpRel opRel, Exp secondExp, MoreExpBool moreExpBool) {
		this.firstExp = firstExp;
		this.opRel = opRel;
		this.secondExp = secondExp;
		this.moreExpBool = moreExpBool;
	}

	@Override
	public String toString() {
		return "MultiExpBool{" +
			"firstExp=" + firstExp +
			", opRel=" + opRel +
			", secondExp=" + secondExp +
			", moreExpBool=" + moreExpBool +
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

		moreExpBool.generateCode(memory);
	}
}
