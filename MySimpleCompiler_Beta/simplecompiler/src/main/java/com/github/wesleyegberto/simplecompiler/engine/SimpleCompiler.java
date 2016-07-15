package com.github.wesleyegberto.simplecompiler.engine;

import com.github.wesleyegberto.simplecompiler.grammar.GrammarRule;
import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.LexerAnalyzer;
import com.github.wesleyegberto.simplecompiler.lexer.LexicalException;
import com.github.wesleyegberto.simplecompiler.parser.ParserException;
import com.github.wesleyegberto.simplecompiler.parser.SyntacticAnalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author Wesley Egberto on 16/06/16.
 */
public class SimpleCompiler {

	public String compile(String sourceCode) throws LexicalException, ParserException {
		try(BufferedReader br = new BufferedReader(new StringReader(sourceCode))) {
			LexerAnalyzer lexerAnalyzer = new LexerAnalyzer(br);
			SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer(lexerAnalyzer);

			if(syntacticAnalyzer.parse()) {
				GrammarRule tree = syntacticAnalyzer.getGeneratedSyntacticTree();
				Table instructionMemory = new Table();
				tree.generateCode(instructionMemory);
				return instructionMemory.streamCode();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
