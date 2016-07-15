package com.github.wesleyegberto.simplecompiler.parser;

/**
 * @author Wesley Egberto
 */
public class ParserException extends RuntimeException {
	private static final long serialVersionUID = 2153733039112318838L;

	public ParserException() {
		super();
	}

	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParserException(String message) {
		super(message);
	}

	public ParserException(Throwable cause) {
		super(cause);
	}

}
