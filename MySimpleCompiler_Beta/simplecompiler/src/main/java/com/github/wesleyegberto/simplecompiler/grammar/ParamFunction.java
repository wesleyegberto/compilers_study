package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;

/**
 * FUNCTION → id ( PARAMS )
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class ParamFunction extends Function {
	private Token id;
	private Param param;

	public ParamFunction(Token id, Param param) {
		boolean exists = false;
		for(String functionName : METHODS_WITH_PARAMS) {
			if(functionName.equals(id.getLexeme())) {
				exists = true;
				break;
			}
		}
		if(!exists) {
			throw new IllegalArgumentException("Função com parâmetro não identificada: " + id.getLexeme());
		}
		this.id = id;
		this.param = param;
	}

	@Override
	public String toString() {
		return "ParamFunction{" +
			"id=" + id +
			", param=" + param +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		char instructionCode = getInstructionFor(id.getLexeme());
		if(instructionCode == '\0')
			throw new IllegalArgumentException("Função não existe: " + id.getLexeme());

		param.generateCode(memory);
		memory.addInstruction(instructionCode);
	}
}
