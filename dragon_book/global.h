#include <stdio.h> // I/O
#include <ctype.h> // char tests

#define BSIZE 128
#define NONE -1
#define EOS '\0'

#define NUM		256
#define DIV		257
#define MOD		258
#define ID 		259
#define DONE	260

int tokenval; // token attribute value
int cline; // line count

// simbol table input
struct entry {
	char *lexptr;
	int token;
};

struct entry symb_tab[];