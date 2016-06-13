package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

/**
 * @author Wesley Egberto on 31/05/16.
 */
public abstract class GrammarRule {

	// TODO: Definir argumento para controlar posição memória (array)
	public abstract void generateCode(Table memory);

}
