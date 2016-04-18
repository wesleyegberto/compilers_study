package com.github.wesleyegberto.simplecompiler.lexer;

/**
 * Exception que é gerada durante a análise léxica.
 * 
 * @author Wesley Egberto
 */
public class LexicalException extends RuntimeException {
	private static final long serialVersionUID = 2153733039112318838L;

	public LexicalException() {
		super();
	}

	public LexicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public LexicalException(String message) {
		super(message);
	}

	public LexicalException(Throwable cause) {
		super(cause);
	}

}
