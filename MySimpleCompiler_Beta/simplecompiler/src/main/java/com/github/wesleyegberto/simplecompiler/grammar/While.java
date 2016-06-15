package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * WHILE → while ( EXP_BOOL ) { STMT_LIST }
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class While extends GrammarRule {
	private ExpBool expBool;
	private StmtList stmtList;

	public While(ExpBool expBool, StmtList stmtList) {
		this.expBool = expBool;
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "While{" +
			"expBool=" + expBool +
			", stmtList=" + stmtList +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		// Adiciona a intrução de comparação
		int initialLine = memory.getCurrentIndex();
		expBool.generateCode(memory);
		memory.addInstruction('c');

		Table instructionToJump = new Table();
		// A linha atual é para instrução de salto, por isso soma 1
		instructionToJump.setCurrentIndex(memory.getCurrentIndex() + 1);
		stmtList.generateCode(instructionToJump);

		// O desvio é setado para a próxima linha depois da última instrução de salto
		int lineToJump = memory.getCurrentIndex() + instructionToJump.getTotalInstructions() + 2;
		// Adiciona a instrução de salto condicional (desvio registrador de comparação for 0)
		memory.addInstruction('z', String.valueOf(lineToJump));

		memory.copyFrom(instructionToJump);

		// Adiciona a instrução de salto para voltar à comparação do loop
		memory.addInstruction('j', String.valueOf(initialLine));
	}
}
