package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * FOR → for ( i = EXP ; i OP_REL EXP ; i = i OP_ARIT EXP ) { STMT_LIST }
 *
 * @author Wesley Egberto on 01/06/16.
 */
public class For extends GrammarRule {
	private Exp initialExp;
	private OpRel opRel;
	private Exp finalExp;
	private OpArit opArit;
	private Exp stepExp;
	private StmtList stmtList;

	public For(Exp initialExp, OpRel opRel, Exp finalExp, OpArit opArit, Exp stepExp, StmtList stmtList) {
		this.initialExp = initialExp;
		this.opRel = opRel;
		this.finalExp = finalExp;
		this.opArit = opArit;
		this.stepExp = stepExp;
		this.stmtList = stmtList;
	}

	@Override
	public String toString() {
		return "For{" +
			"initialExp=" + initialExp +
			", opRel=" + opRel +
			", finalExp=" + finalExp +
			", opArit=" + opArit +
			", stepExp=" + stepExp +
			", stmtList=" + stmtList +
			'}';
	}

	@Override
	public void generateCode(Table memory) {
		// Inicializa o contador
		initialExp.generateCode(memory);
		memory.addInstruction('i');

		int instructionCompIndex = memory.getCurrentIndex();

		// Adiciona a instrução de comparação
		memory.addParamToArg("c");
		opRel.generateCode(memory);
		finalExp.generateCode(memory);
		memory.addInstruction('c');


		Table instructionToJump = new Table();
		// A linha atual é para instrução de salto, por isso soma 1
		instructionToJump.setCurrentIndex(memory.getCurrentIndex() + 1);
		stmtList.generateCode(instructionToJump);

		// O desvio é setado para a próxima linha depois da última instrução interna
		// Soma 3 devido a instrução de incremento e salto incondicional
		int lineToJump = memory.getCurrentIndex() + instructionToJump.getTotalInstructions() + 3;
		// Adiciona a instrução de salto condicional (desvio registrador de comparação for 0)
		memory.addInstruction('z', String.valueOf(lineToJump));

		memory.copyFrom(instructionToJump);

		// Adiciona a instrução de incremento
		memory.addInstruction('p', "1");
		// Adiciona a instrução de salto incondicional para a comparação
		memory.addInstruction('j', String.valueOf(instructionCompIndex));
	}
}
