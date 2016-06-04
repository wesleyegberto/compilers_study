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

			case 2: // STMT_LIST → STMT STMT_LIST
				return new MultiStmtList((Stmt) args[0], (StmtList) args[1]);

			case 3: // STMT_LIST → STMT
				return new SingleStmtList((Stmt) args[0]);

			case 4: // STMT → CTRL_FLUX
				return new CtrlFluxStmt((CtrlFlux) args[0]);

			case 5: // STMT → FUNCTION ;
				return new FunctionStmt((Function) args[0]);

			case 6: // CTRL_FLUX → IF
				return new IfCtrlFlux((If) args[0]);

			case 7: // CTRL_FLUX → FOR
				return new ForCtrlFlux((For) args[0]);

			case 8: // CTRL_FLUX → WHILE
				return new WhileCtrlFlux((While) args[0]);

			case 9: // IF → if ( EXP_BOOL ) { STMT_LIST } ELSE
				return new IfElse((ExpBool) args[2], (StmtList) args[5], (Else) args[7]);

			case 10: // IF → if ( EXP_BOOL ) { STMT_LIST }
				return new SimpleIf((ExpBool) args[2], (StmtList) args[5]);

			case 11: // ELSE → else { STMT_LIST }
				return new Else((StmtList) args[2]);

			case 12: // FOR → for ( i = EXP ; i OP_REL EXP ; i = i OP_ARIT EXP ) { STMT_LIST }
				return new For((Exp) args[4], (OpRel) args[7], (Exp) args[8],
								(OpArit) args[13], (Exp) args[14], (StmtList) args[17]);

			case 13: // WHILE → while ( EXP_BOOL ) { STMT_LIST }
				return new While((ExpBool) args[2], (StmtList) args[5]);

			case 14: // FUNCTION → id ( PARAMS )
				return new ParamFunction((Token) args[0], (Param) args[2]);

			case 15: // FUNCTION → id ( )
				return new NoParamFunction((Token) args[0]);

			case 16: // PARAMS → VAR
				return new Param((Var) args[0]);

			case 17: // EXP_BOOL → EXP OP_REL EXP MORE_EXP_BOOL
				return new MultiExpBool((Exp) args[0], (OpRel) args[1], (Exp) args[2], (MoreExpBool) args[3]);

			case 18: // EXP_BOOL → EXP OP_REL EXP
				return new SingleExpBool((Exp) args[0], (OpRel) args[1], (Exp) args[2]);

			case 19: // MORE_EXP_BOOL → OP_BOOL EXP_BOOL
				return new MoreExpBool((OpBool) args[0], (ExpBool) args[1]);

			case 20: // EXP → TERM MORE_TERM
				return new MultiExp((Term) args[0], (MoreTerm) args[1]);

			case 21: // EXP → TERM
				return new SingleExp((Term) args[0]);

			case 22: // MORE_TERM → OP_ARIT_LO TERM  MORE_TERM
				return new MultiMoreTerm((OpAritLo) args[0], (Term) args[1], (MoreTerm) args[2]);

			case 23: // MORE_TERM → OP_ARIT_LO TERM
				return new SingleMoreTerm((OpAritLo) args[0], (Term) args[1]);

			case 24: // TERM → FACTOR MORE_FACTOR
				return new MultiTerm((Factor) args[0], (MoreFactor) args[1]);

			case 25: // TERM → FACTOR
				return new SingleTerm((Factor) args[0]);

			case 26: // MORE_FACTOR → OP_ARIT_HI FACTOR MORE_FACTOR
				return new MultiMoreFactor((OpAritHi) args[0], (Factor) args[1], (MoreFactor) args[2]);

			case 27: // MORE_FACTOR → OP_ARIT_HI FACTOR
				return new SingleMoreFactor((OpAritHi) args[0], (Factor) args[1]);

			case 28: // FACTOR → VAR
				return new VarFactor((Var) args[0]);

			case 29: // FACTOR → FUNCTION
				return new FunctionFactor((Function) args[0]);

			case 30: // OP_ARIT → OP_ARIT_LO
				return new LowOpArit((OpAritLo) args[0]);

			case 31: // OP_ARIT → OP_ARIT_HI
				return new HighOpArit((OpAritHi) args[0]);

			case 32: // OP_REL → RELOP_LT
			case 33: // OP_REL → RELOP_LTE
			case 34: // OP_REL → RELOP_GT
			case 35: // OP_REL → RELOP_GTE
			case 36: // OP_REL → RELOP_EQ
			case 37: // OP_REL → RELOP_NEQ
				return new OpRel((Token) args[0]);

			case 38: // OP_ARIT_LO → +
			case 39: // OP_ARIT_LO → -
				return new OpAritLo((Token) args[0]);

			case 40: // OP_ARIT_HI → *
			case 41: // OP_ARIT_HI → /
				return new OpAritHi((Token) args[0]);

			case 42: // OP_BOOL → and
			case 43: // OP_BOOL → or
				return new OpBool((Token) args[0]);

			case 44: // VAR → num
			case 45: // VAR → real
				return new Var((Token) args[0]);

			default:
				throw new IllegalArgumentException("Regra inválida");
		}
	}


}
