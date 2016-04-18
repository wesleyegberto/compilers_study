package com.github.wesleyegberto.simplecompiler.parser;

import com.github.wesleyegberto.simplecompiler.lexer.LexerAnalyzer;

import java.io.BufferedReader;
import java.io.StringReader;

public class SyntaticAnalyzerBuilder {
	private LexerAnalyzer lexer;

	public SyntaticAnalyzerBuilder(String inputSourceCode) {
		lexer = new LexerAnalyzer(new BufferedReader(new StringReader(inputSourceCode)));
	}

	public static SyntaticAnalyzerBuilder from(String inputSource) {
		return new SyntaticAnalyzerBuilder(inputSource);
	}


	public SyntaticAnalyzer build() {
		return new SyntaticAnalyzer(lexer);
	}
}
