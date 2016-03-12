#include "global.h"

#define STRMAX 9999 // length of array of lexeme
#define SYMMAX 100 //  length of symbol table

char lexemes[STRMAX];
int lastchar = -1; // last position of lexemes

struct entry symb_tab[SYMMAX];
int lastentry = 0; // last position of symb_tab

/**
 * Search s in the symb_tab and return its position or 0
 */
int search(char s[]) {
	int p;
	for(p = lastentry; p > 0; p--) {
		if(strcmp(symb_tab[p].lexptr, s) == 0)
			return p;
	}
	return 0;
}

/**
 * Insert a symbol in the symb_tab
 */
int insert(char s[], int tok) {
	int len = strlen(s);

	if(lastentry + len >= SYMMAX)
		error("Symbol table overflow");

	if(lastchar + len + 1 >= STRMAX)
		error("Lexeme array overflow");

	lastentry++;
	symb_tab[lastentry].token = tok;
	symb_tab[lastentry].lexptr = &lexemes[lastchar + 1];

	strcpy(symb_tab[lastentry].lexptr, s);
	return lastentry;
}