package com.github.wesleyegberto.simplecompiler.parser;

/**
 * Created by wesley on 05/04/16.
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
