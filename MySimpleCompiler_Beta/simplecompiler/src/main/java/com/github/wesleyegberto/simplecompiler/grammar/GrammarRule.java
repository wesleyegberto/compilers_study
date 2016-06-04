package com.github.wesleyegberto.simplecompiler.grammar;

import com.github.wesleyegberto.simplecompiler.grammar.ast.Table;

import java.lang.reflect.Field;

/**
 * @author Wesley Egberto on 31/05/16.
 */
public abstract class GrammarRule {

	// TODO: Definir argumento para controlar posição memória (array)
	public abstract String generateCode(Table memory);

}
