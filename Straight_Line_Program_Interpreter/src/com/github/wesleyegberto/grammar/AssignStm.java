package com.github.wesleyegberto.grammar;

import com.github.wesleyegberto.types.IntAndTable;

/**
 * Stm → id := Exp
 */
public class AssignStm extends Stm {
	public String id;
	public Exp exp;

	public AssignStm(String i, Exp e) {
		id = i;
		exp = e;
	}

	@Override
	public IntAndTable interpStm(IntAndTable t) {
		int temp = exp.interpExp(t).i;
		return new IntAndTable(temp, t.insert(id, temp));
	}
}
