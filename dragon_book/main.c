/**
 * Compile: gcc lexer.c parser.c emitter.c symbol.c init.c error.c main.c
 */

#include "global.h"

void main() {
	init();
	parse();
	exit(0);
}