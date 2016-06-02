package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.lexer.Token;

/**
 * Fábrica de nós da Árvore Sintática Abstrata (Abstract Syntax Tree).
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class NodeASTFactory {

	/**
	 * Cria um nó da AST
	 * @param indexRule índice da regra
	 * @param args todos os elementos da regra (terminais e variáveis)
	 * @return nó
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
