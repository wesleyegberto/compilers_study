package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * IF → if ( EXP_BOOL ) { STMT_LIST }
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class SimpleIf extends If {
	private ExpBool expBool;
	private StmtList stmtList;

	public SimpleIf(ExpBool expBool, StmtList stmtList) {
		this.expBool = expBool;
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "SimpleIf{" +
			"expBool=" + expBool +
			", stmtList=" + stmtList +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		// TODO: Controle de fluxo
		// Adiciona a intrução de comparação: c3<4, c10>5, c2+2>3
		expBool.generateCode(memory);
		memory.addInstruction('c');

		Table instructionToJump = new Table();
		stmtList.generateCode(instructionToJump);

		// O desvio é setado para a próxima linha depois da última instrução interna
		int lineToJump = memory.getCurrentIndex() + instructionToJump.getTotalInstructions() + 1;
		// Adiciona a instrução de salto condicional (desvio registrador de comparação for 0)
		memory.addInstruction('z', String.valueOf(lineToJump));

		memory.copyFrom(instructionToJump);
	}
}
