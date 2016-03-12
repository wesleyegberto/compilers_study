package com.github.wesleyegberto.grammar;

import com.github.wesleyegberto.types.IntAndTable;

/**
 * Exp → Exp Binop Exp 
 */
public class OpExp extends Exp {
	public Exp left, right;
	public int oper;

	public final static int PLUS = 1, MINUS = 2, TIMES = 3, DIV = 4;

	public OpExp(Exp l, int o, Exp r) {
		left = l;
		oper = o;
		right = r;
	}

	@Override
	public IntAndTable interpExp(IntAndTable t) {
		switch(oper) {
			case PLUS:
				return new IntAndTable(left.interpExp(t).i + right.interpExp(t).i, t.t);
			case MINUS:
				return new IntAndTable(left.interpExp(t).i - right.interpExp(t).i, t.t);
			case TIMES:
				return new IntAndTable(left.interpExp(t).i * right.interpExp(t).i, t.t);
			case DIV:
				return new IntAndTable(left.interpExp(t).i / right.interpExp(t).i, t.t);
			default:
				throw new IllegalArgumentException("Invalid operator");
		}
	}
	
	
}
