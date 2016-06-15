package com.github.wesleyegberto.simplecompiler.parser;

import com.github.wesleyegberto.simplecompiler.lexer.LexerAnalyzer;

import java.io.BufferedReader;
import java.io.StringReader;

public class SyntacticAnalyzerBuilder {
	private LexerAnalyzer lexer;

	public SyntacticAnalyzerBuilder(String inputSourceCode) {
		lexer = new LexerAnalyzer(new BufferedReader(new StringReader(inputSourceCode)));
	}

	public static SyntacticAnalyzerBuilder from(String inputSource) {
		return new SyntacticAnalyzerBuilder(inputSource);
	}


	public SyntacticAnalyzer build() {
		return new SyntacticAnalyzer(lexer);
	}
}
