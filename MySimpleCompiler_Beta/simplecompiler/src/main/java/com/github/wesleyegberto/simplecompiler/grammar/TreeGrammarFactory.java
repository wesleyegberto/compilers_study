package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.lexer.Token;

/**
 * @author Wesley Egberto on 31/05/16.
 */
public class TreeGrammarFactory {

	/**
	 * Create a node of Abstract Syntax Tree.
	 * @param indexRule index of the rule
	 * @param args all elementos (terminal and variables) of the rule
	 * @return node
	 */
	public static GrammarRule createGrammar(int indexRule, Object[] args) {

		switch (indexRule) {
			case 1: // PGM → program { STMT_LIST }
				return new Pgm((StmtList) args[2]);

			case 3: // STMT_LIST → STMT
				return new SingleStmtList((Stmt) args[0]);

			case 5: // STMT → FUNCTION ;
				return new FunctionStmt((Function) args[0]);

			case 15: // FUNCTION → id ( )
				return new NoParamFunction((Token) args[0]);

			default:
				//throw new IllegalArgumentException("Invalid rule");
		}
		return null;
	}


}
