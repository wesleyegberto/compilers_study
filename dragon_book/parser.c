/**
 * Recursive descent parser
 */

#include "global.h"

int lookahead;

void parse() {
	lookahead = lexan();
	while(lookahead != DONE) {
		expr(); recognize(';');
	}
}

void expr() {
	int t;

	term();
	while(1) {
		switch(lookahead) {
			case '+':
			case '-':
				t = lookahead;
				recognize(lookahead); term(); emit(t, NONE);
				continue;
			default:
				return;
		}
	}
}

void term() {
	int t;

	factor();
	while(1) {
		switch(lookahead) {
			case '*':
			case '/':
				t = lookahead;
				recognize(lookahead); factor(); emit(t, NONE);
				continue;
			default:
				return;
		}
	}
}

void factor() {
	switch(lookahead) {
		case '(':
			recognize('('); expr(); recognize(')'); break;
		case NUM:
			emit(NUM, tokenval); recognize(NUM); break;
		case ID:
			emit(ID, tokenval); recognize(ID); break;
		default:
			error("Syntax error");
	}
}

void recognize(int t) {
	if(lookahead == t) {
		lookahead = lexan();
	} else {
		error("Syntax error");
	}
}