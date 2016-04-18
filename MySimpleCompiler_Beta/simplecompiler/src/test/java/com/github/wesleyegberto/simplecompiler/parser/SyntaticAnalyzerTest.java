package com.github.wesleyegberto.simplecompiler.parser;

import com.github.wesleyegberto.simplecompiler.lexer.LexicalException;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Classe para testar o analisador sintático.
 */
public class SyntaticAnalyzerTest {

	@Test
	public void Parse_SimpleProgram_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{metodo();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramCallMethod_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{viraEsquerda();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramCallManyMethods_Parsed() throws Exception {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{avanca(2);avanca(5);viraEsquerda();avanca(5);viraDireita();}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test(expected = LexicalException.class)
	public void Parse_ProgramCallMethodWithTwoParam_Exception() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{avancar(3,3);}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIf_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1.5){metodo();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfElse_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1){metodo1();}else{metodo2();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithNestedIf_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1){if(2<3){metodo1();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithNestedIfElse_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(2>1){if(2<3){metodo1();}else{metodo2();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfUsingMethodInExpBool_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia()<30){metodo();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfTwoExp_Parsed() throws Exception {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia()<30 and 3==3){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfManyExp_Parsed() throws Exception {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia()<=50 and 3==3 and 3<=4 and 5 > 5 and 8 >= 3){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithWhile_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(2>1){metodo();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithWhileManyExp_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(medeDistancia()<100 and 10 <= 20 and 40 > 4 and 1== 1 and 3 >= 3){metodo();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithTwoWhile_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(2>1){metodo();}while(3<5){metodo();}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithNestedWhile_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{while(2>1){while(1<5){metodo();}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithFor_Parsed() {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{for(i=0;i<10;i=i+1){avanca(1);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfElseNestedFor() throws Exception {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{for(i=0;i<10;i=i+2){if(medeDistancia() / 10>50){avanca(4);}else{avanca(1);}}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithIfArithExp_Parsed() throws Exception {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia() / 10>50){avanca(4);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}

	@Test
	public void Parse_ProgramWithManyArithExp_Parsed() throws Exception {
		SyntaticAnalyzer parser = SyntaticAnalyzerBuilder.from("program{if(medeDistancia() / 10 + 3>50 and medeDistancia() * 2 - 10 < 120){avanca(4);}}").build();
		boolean parsed = parser.parse();
		assertThat(parsed, is(true));
	}
}
