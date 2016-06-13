package com.github.wesleyegberto.simplecompiler.grammar;

/**
 * Classe para variável FUNCTION.
 *
 * @author Wesley Egberto on 31/05/16.
 */
public abstract class Function extends GrammarRule {
	protected static final String[] METHODS_WITHOUT_PARAMS = {
		"viraEsquerda", "viraDireita",
		"acendeLedVerde", "apagaLedVerde",
		"acendeLedAmarelo", "apagaLedAmarelo",
		"acendeLedVermelho", "apagaLedVermelho",
		"medeDistancia"
	};

	protected static final String[] METHODS_WITH_PARAMS = {
		"avanca", "recua"
	};

	protected static char getInstructionFor(String functionName) {
		switch (functionName) {
			case "avanca":
				return 'w';
			case "recua":
				return 's';
			case "viraEsquerda":
				return 'a';
			case "viraDireita":
				return 'd';
			case "acendeLedVerde":
				return 'g';
			case "apagaLedVerde":
				return 'h';
			case "acendeLedAmarelo":
				return 'y';
			case "apagaLedAmarelo":
				return 'u';
			case "acendeLedVermelho":
				return 'r';
			case "apagaLedVermelho":
				return 't';
			case "medeDistancia":
				return 'm';
		}
		return '\0';
	}

}
