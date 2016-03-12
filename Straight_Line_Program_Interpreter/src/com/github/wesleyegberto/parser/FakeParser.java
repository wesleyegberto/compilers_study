package com.github.wesleyegberto.parser;

import com.github.wesleyegberto.grammar.AssignStm;
import com.github.wesleyegberto.grammar.CompoundStm;
import com.github.wesleyegberto.grammar.EseqExp;
import com.github.wesleyegberto.grammar.IdExp;
import com.github.wesleyegberto.grammar.LastExpList;
import com.github.wesleyegberto.grammar.NumExp;
import com.github.wesleyegberto.grammar.OpExp;
import com.github.wesleyegberto.grammar.PairExpList;
import com.github.wesleyegberto.grammar.PrintStm;
import com.github.wesleyegberto.grammar.Stm;
import com.github.wesleyegberto.types.IntAndTable;
import com.github.wesleyegberto.types.Table;

public class FakeParser {
	public Stm generateTree() {
		Stm prog = new CompoundStm(
				new AssignStm("a",
						new OpExp(
								new NumExp(
										5),
								OpExp.PLUS, new NumExp(3))),
				new CompoundStm(
						new AssignStm("b",
								new EseqExp(
										new PrintStm(new PairExpList(new IdExp("a"),
												new LastExpList(
														new OpExp(new IdExp("a"), OpExp.MINUS, new NumExp(1))))),
										new OpExp(new NumExp(10), OpExp.TIMES, new IdExp("a")))),
						new PrintStm(new LastExpList(new IdExp("b")))));
		
		/*Stm prog = new CompoundStm(
				new AssignStm("a", new NumExp(13)),
				new CompoundStm(
					new AssignStm("b", new NumExp(14)),
					new CompoundStm(
						new AssignStm("c", new OpExp(new IdExp("a"), OpExp.PLUS, new IdExp("b"))),
						new PrintStm(
							new PairExpList(
								new IdExp("c"),
								new LastExpList(new IdExp("a"))
							)
						)
					)
				)
			); */
		return prog;
	}
	
	public static void main(String[] args) {
		new FakeParser().generateTree().interpStm(new IntAndTable(0, new Table("", 0, null)));
	}
}
