package com.github.wesleyegberto.simplecompiler.lexer;

/**
 * Tipo do Token.
 * 
 * @author Wesley Egberto
 */
public enum TokenType {
	/** Token informando fim do arquivo */
	END_OF_FILE(0),
	/** Carecteres para ignorar */
	SKIP(1),
	/** Variável i do loop for */
	COUNTER(2),
	/** Ponto-e-vírgula */
	SECO(3),
	IF(4),
	ELSE(5),
	FOR(6),
	WHILE(7),
	PROGRAM(8),
	AND(9),
	OR(10),
	/** Nome de variável ou método */
	ID(11),
	/** Números inteiros */
	NUM(12),
	/** Números reais */
	REAL(13),
	/** Abertura de chaves - { */
	LCURB(14),
	/** Fechamento de chaves - } */
	RCURB(15),
	/** Abertura de parênteses - ( */
	LPAR(16),
	/** Fechamento de parênteses - ) */
	RPAR(17),
	/** Operador binário de adição */
	BINOP_ADD(18),
	/** Operador binário de subtração */
	BINOP_SUB(19),
	/** Operador binário de multiplicação */
	BINOP_MUL(20),
	/** Operador binário de divisão */
	BINOP_DIV(21),
	/** Operador de atribuição */
	OP_ASSIGN(22),
	/** Operador relacional de Igual */
	RELOP_EQ(23),
	/** Operador relacional de Diferente */
	RELOP_NEQ(24),
	/** Operador relacional de Maior */
	RELOP_GT(25),
	/** Operador relacional de Maior ou Igual */
	RELOP_GTE(26),
	/** Operador relacional de Menor */
	RELOP_LT(27),
	/** Operador relacional de Menor ou Igual */
	RELOP_LTE(28)
	;
	
	private final short state;
	
	private TokenType(int state) {
		this.state = (short) state;
	}
	
	public short getState() {
		return this.state;
	}
	
	public static TokenType getTokenTypeFrom(int state) {
		if(state > 30 && state < 49)
			return ID;
		for(TokenType t : TokenType.values()) {
			if(t.getState() == state) return t;
		}
		return null;
	}
}
