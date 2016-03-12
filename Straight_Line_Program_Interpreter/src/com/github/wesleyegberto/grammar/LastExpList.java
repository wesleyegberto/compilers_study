package com.github.wesleyegberto.grammar;

/**
 * ExpList → Exp
 */
public class LastExpList extends ExpList {
	Exp head;

	public LastExpList(Exp h) {
		head = h;
	}
}