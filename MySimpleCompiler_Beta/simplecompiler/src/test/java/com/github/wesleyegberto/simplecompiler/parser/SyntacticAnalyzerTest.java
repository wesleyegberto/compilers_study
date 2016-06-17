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
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{viraEsquerda();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("a0|$"));
	}

	@Test
	public void Parse_ProgramCallMethod_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{avanca(1);}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("w1|$"));
	}

	@Test
	public void Parse_ProgramCallMethodArgMethod_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{avanca(1.5);}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramCallManyMethods_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{avanca(2);avanca(5);viraEsquerda();avanca(5);viraDireita();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("w2|w5|a0|w5|d0|$"));
	}

	@Test(expected = LexicalException.class)
	public void Parse_ProgramCallMethodWithTwoParam_Exception() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{avancar(3,3);}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithSimpleIf_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(5<9){avanca(1);viraEsquerda();recua(1);viraEsquerda();avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("c5<9|z7|w1|a0|s1|a0|w1|$"));
	}

	@Test
	public void Parse_ProgramWithIf_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(2>1.5){viraDireita();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("c2>1.5|z3|d0|$"));
	}

	@Test
	public void Parse_ProgramWithIfElse_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(2>1){viraDireita();avanca(1);}else{viraEsquerda();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("c2>1|z5|d0|w1|j6|a0|$"));
	}

	@Test
	public void Parse_ProgramWithNestedIf_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()>20){if(5<10){avanca(1);}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm>20|z5|c5<10|z5|w1|$"));
	}

	@Test
	public void Parse_ProgramWithNestedIfElse_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()>20){if(2<3){viraEsquerda();}else{viraDireita();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm>20|z7|c2<3|z6|a0|j7|d0|$"));
	}

	@Test
	public void Parse_ProgramWithIfUsingMethodInExpBool_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()<30){viraEsquerda();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm<30|z3|a0|$"));
	}

	@Test
	public void Parse_ProgramWithIfUsingTwoMethodInExpBool_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()<=medeDistancia()){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm<=m|z3|w1|$"));
	}

	@Test
	public void Parse_ProgramWithIfUsingManyMethodInExpBool_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()>10 and medeDistancia()<30){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm>10&m<30|z3|w1|$"));
	}

	@Test
	public void Parse_ProgramWithIfMethod_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()>20){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm>20|z3|w1|$"));
	}


	@Test
	public void Parse_ProgramWithIfTwoExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()<30 and 3==3){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm<30&3==3|z3|w1|$"));
	}

	@Test
	public void Parse_ProgramWithIfManyExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()<=50 and 3==3 and 3<=4 and 5 > 5 and 8 >= 3){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("cm<=50&3==3&3<=4&5>5&8>=3|z3|w1|$"));
	}

	@Test
	public void Parse_ProgramWithWhile_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{while(2>1){acendeLedVermelho();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("c2>1|z4|r0|j0|$"));
	}

	@Test
	public void Parse_ProgramWithCommandWhile_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{avanca(1);while(medeDistancia()<=20){acendeLedVermelho();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("w1|cm<=20|z5|r0|j1|$"));
	}


	@Test
	public void Parse_ProgramWithWhileManyExp_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{while(medeDistancia()<100 and 10 <= 20 and 40 > 4 and 1== 1 and 3 >= 3){viraDireita();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithTwoWhile_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{while(2>1){acendeLedVermelho();}while(3<5){viraEsquerda();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithNestedWhile_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{while(2>1){while(1<5){viraDireita();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithFor_Parsed() {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{for(i=0;i<10;i=i+1){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		assertThat(getGeneratedCode(parser), is("i0|cc<10|z6|w1|p1|j1|$"));
	}

	@Test
	public void Parse_ProgramWithIfElseNestedFor() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{for(i=0;i<10;i=i+2){if(medeDistancia() / 10>50){avanca(4);}else{avanca(1);}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfArithExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia() / 10>50){avanca(4);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithManyArithExp_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia() / 10 + 3>50 and medeDistancia() * 2 - 10 < 120){avanca(4);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_GeneratedCode_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{if(medeDistancia()<=20){acendeLedVermelho();viraDireita();apagaLedVermelho();}acendeLedVerde();for(i=1;i<=10;i=i+1){avanca(1);}apagaLedVerde();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test(expected = IllegalArgumentException.class)
	public void Parse_GeneratedCodeWithErro_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{recua(4);avanca(2);recua();if(medirDistancia()<medirDistancia()){avanca(3);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_GeneratedCodeToSample_Parsed() throws Exception {
		SyntacticAnalyzer parser = SyntacticAnalyzerBuilder.from("program{acendeLedVerde();if(medeDistancia()>=20){avanca(1);}apagaLedVerde();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
		getGeneratedCode(parser);
	}
}
