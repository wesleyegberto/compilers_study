package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;
import com.github.wesleyegberto.simplecompiler.lexer.Token;

/**
 * FUNCTION → id ( )
 *
 * @author Wesley Egberto on 31/05/16.
 */
public class NoParamFunction extends Function {

	private Token id;

	public NoParamFunction(Token id) {
		boolean exists = false;
		for(String functionName : METHODS_WITHOUT_PARAMS) {
			if(functionName.equals(id.getLexeme())) {
				exists = true;
				break;
			}
		}
		if(!exists) {
			System.out.println(id);
			throw new IllegalArgumentException("Função sem parâmetro não identificada: " + id.getLexeme());
		}
		this.id = id;
	}

	@Override
	public String toString() {
		return "NoParamFunction{id=" + id + '}';
	}

	@Override
	public void generateCode(Table memory) {
		char instructionCode = getInstructionFor(id.getLexeme());
		if(instructionCode == '\0')
			throw new IllegalArgumentException("Função não existe: " + id.getLexeme());

		memory.addInstruction(instructionCode, "0");
	}
}
