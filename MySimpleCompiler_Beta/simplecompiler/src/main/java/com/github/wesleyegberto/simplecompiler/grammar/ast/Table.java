package com.github.wesleyegberto.simplecompiler.grammar.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wesley Egberto on 31/05/16.
 */
public class Table {
	private int currentIndex;
	private String currentArg = "";

	private List<String> commands = new ArrayList<>();

	public int getCurrentIndex() {
		return currentIndex;
	}

	public int getNumberLines() {
		return commands.size();
	}

	private void incrementIndex() {
		currentIndex++;
	}

	public void addParamToArg(String param) {
		currentArg = currentArg + param;
	}

	public void addInstruction(char code) {
		addInstruction(code, currentArg);
		currentArg = "";
	}

	public void addInstruction(char code, String arg) {
		incrementIndex();
		commands.add(code + arg);
	}
}
