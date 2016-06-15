package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * IF → if ( EXP_BOOL ) { STMT_LIST } ELSE
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class IfElse extends If {
	private ExpBool expBool;
	private StmtList stmtList;
	private Else anElse;

	public IfElse(ExpBool expBool, StmtList stmtList, Else anElse) {
		this.expBool = expBool;
		this.stmtList = stmtList;
		this.anElse = anElse;
	}

	@Override
	public String toString() {
		return "IfElse{" +
			"expBool=" + expBool +
			", stmtList=" + stmtList +
			", anElse=" + anElse +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		// TODO: Controle de fluxo
		expBool.generateCode(memory);
		memory.addInstruction('c');

		Table instructionToJump = new Table();
		// A linha atual é para instrução de salto, por isso soma 1
		instructionToJump.setCurrentIndex(memory.getCurrentIndex() + 1);
		stmtList.generateCode(instructionToJump);

		// O desvio é setado para a próxima linha depois da última instrução interna
		// Somou 2 por causa da instrução de desvio do fim das instruções do if{}
		int lineToJump = memory.getCurrentIndex() + instructionToJump.getTotalInstructions() + 2;
		// Adiciona a instrução de salto condicional para as instruções else (desvio registrador de comparação for 0)
		memory.addInstruction('z', String.valueOf(lineToJump));

		memory.copyFrom(instructionToJump);

		Table elseInstructionToJump = new Table();
		// A linha atual é para instrução de salto, por isso soma 1
		elseInstructionToJump.setCurrentIndex(memory.getCurrentIndex() + 1);
		anElse.generateCode(elseInstructionToJump);

		// Adiciona a instrução de salto incondicional (para saltar as instruções do else)
		lineToJump = memory.getCurrentIndex() + elseInstructionToJump.getTotalInstructions() + 1;
		memory.addInstruction('j', String.valueOf(lineToJump));

		memory.copyFrom(elseInstructionToJump);

	}
}
