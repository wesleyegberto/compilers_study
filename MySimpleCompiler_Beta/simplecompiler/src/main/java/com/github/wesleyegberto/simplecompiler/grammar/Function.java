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
}
