package com.github.wesleyegberto.simplecompiler.lexer;

/**
 * Representa um Token.
 * 
 * @author Wesley Egberto
 */
public class Token {
	private TokenType tokenType;
	private String lexeme;
	private int start;
	private int end;

	public Token(TokenType tokenType, String lexeme, int start, int end) {
		this.tokenType = tokenType;
		this.lexeme = lexeme;
		this.start = start;
		this.end = end;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public String getLexeme() {
		return lexeme;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public String toString() {
		return "Token [tokenType=" + tokenType + ", lexeme=" + lexeme + ", start=" + start + ", end=" + end + "]";
	}

}
