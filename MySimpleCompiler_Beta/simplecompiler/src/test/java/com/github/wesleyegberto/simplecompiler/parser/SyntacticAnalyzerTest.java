package com.github.wesleyegberto.simplecompiler.parser;

import com.github.wesleyegberto.simplecompiler.grammar.GrammarRule;
import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.LexicalException;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Classe para testar o analisador sintático.
 */
public class SyntacticAnalyzerTest {

	private String getGeneratedCode(SyntacticAnalyzer parser) {
		GrammarRule tree = parser.getGeneratedSyntacticTree();
		Table codeTable = new Table();
		tree.generateCode(codeTable);
		String generatedCode = codeTable.streamCode();

		System.out.println("Generated code: " + generatedCode);

		return generatedCode;
	}

	@Test
	public void Parse_SimpleProgram_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{viraEsquerda();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("a0|$"));
	}

	@Test
	public void Parse_ProgramCallMethod_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{avanca(1);}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("w1|$"));
	}

	@Test
	public void Parse_ProgramCallManyMethods_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{avanca(2);avanca(5);viraEsquerda();avanca(5);viraDireita();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("w2|w5|a0|w5|d0|$"));
	}

	@Test(expected = LexicalException.class)
	public void Parse_ProgramCallMethodWithTwoParam_Exception() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{avancar(3,3);}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithSimpleIf_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(5<9){avanca(1);viraEsquerda();recua(1);viraEsquerda();avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("c5<9|z7|w1|a0|s1|a0|w1|$"));
	}

	@Test
	public void Parse_ProgramWithIf_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1.5){viraDireita();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfElse_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1){viraDireita();}else{viraEsquerda();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithNestedIf_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1){if(2<3){viraEsquerda();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithNestedIfElse_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1){if(2<3){viraEsquerda();}else{viraDireita();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfUsingMethodInExpBool_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia()<30){viraEsquerda();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfTwoExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia()<30 and 3==3){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfManyExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia()<=50 and 3==3 and 3<=4 and 5 > 5 and 8 >= 3){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithWhile_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(2>1){acendeLedVermelho();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithWhileManyExp_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(medeDistancia()<100 and 10 <= 20 and 40 > 4 and 1== 1 and 3 >= 3){viraDireita();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithTwoWhile_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(2>1){acendeLedVermelho();}while(3<5){viraEsquerda();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithNestedWhile_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(2>1){while(1<5){viraDireita();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithFor_Parsed() {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{for(i=0;i<10;i=i+1){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfElseNestedFor() throws Exception {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{for(i=0;i<10;i=i+2){if(medeDistancia() / 10>50){avanca(4);}else{avanca(1);}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfArithExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia() / 10>50){avanca(4);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithManyArithExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia() / 10 + 3>50 and medeDistancia() * 2 - 10 < 120){avanca(4);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_GeneratedCode_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia()<=20){acendeLedVermelho();viraDireita();apagaLedVermelho();}acendeLedVerde();for(i=1;i<=10;i=i+1){avanca(1);}apagaLedVerde();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}
}
