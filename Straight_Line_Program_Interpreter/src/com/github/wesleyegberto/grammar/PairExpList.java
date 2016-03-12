package com.github.wesleyegberto.grammar;

/**
 * ExpList → Exp , ExpList
 */
public class PairExpList extends ExpList {
	Exp head;
	ExpList tail;

	public PairExpList(Exp h, ExpList t) {
		head = h;
		tail = t;
	}
}
