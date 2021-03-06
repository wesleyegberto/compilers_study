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

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public int getTotalInstructions() {
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

	public String streamCode() {
		return String.join("|", commands);
	}

	public void clearAll() {
		commands.clear();
		currentArg = "";
		currentIndex = 0;
	}

	public void copyFrom(Table instructionToJump) {
		for(String cmd : instructionToJump.commands) {
			commands.add(cmd);
			incrementIndex();
		}
	}

	public void copyArgFrom(Table functionToUse) {
		if(functionToUse.getTotalInstructions() > 0) {
			// Extrai a função e adiciona como argumento
			String cmd = functionToUse.commands.get(0);
			addParamToArg(String.valueOf(cmd.charAt(0)));
		} else {
			addParamToArg(functionToUse.currentArg);
		}
	}
}
