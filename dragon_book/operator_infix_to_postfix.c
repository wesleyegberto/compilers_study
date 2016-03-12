/**
 * Código completo do interpretador do capítulo 2
 */
// Contants
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

#define STRMAX 9999 // length of array of lexeme
#define SYMMAX 100 //  length of symbol table

// Variables
int tokenval = NONE; // token attribute value
int cline = 1; // line count
char lexbuf[BSIZE];

// simbol table input
struct entry {
	char *lexptr;
	int token;
};
struct entry symb_tab[SYMMAX];
int lastentry = 0; // last position of symb_tab

char lexemes[STRMAX];
int lastchar = -1; // last position of lexemes

int lookahead;

// key words
struct entry key_words[] = {
	"div", DIV,
	"mod", MOD,
	0, 0
};

// Proto functions
void error(char *m);
void emit(int t, int tval);
int insert(char s[], int tok);
int search(char s[]);
int lexan();
void parse();
void expr();
void term();
void factor();
void recognize();
void init();


// Functions
void error(char *m) {
	fprintf(stderr, "Line: %d: %s\n", cline, m);
	exit(1);
}

void emit(int t, int tval) {
	switch(t) {
		case '+':
		case '-':
		case '*':
		case '/':
			printf("Token: %c\n", t); break;
		case DIV:
			printf("Token: DIV\n"); break;
		case MOD:
			printf("Token: MOD\n"); break;
		case NUM:
			printf("Token: NUM\n"); break;
		case ID:
			printf("Token: ID\n"); break;
		default:
			printf("token %d, tokenval %d\n", t, tval);
	}
}


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


/** Lexer analiser */
int lexan() {
	int t;

	while(1) {
		t = getchar();

		if(t == ' ' || t == '\t') {
			// remove blank spaces
		} else if(t == '\n') {
			cline++;
		} else if(isdigit(t)) { // is digit
			ungetc(t, stdin); // return the input to read as an int
			scanf("%d", &tokenval);
			return NUM; // return token num
		} else if(isalpha(t)) { // is letter
			int p, b = 0;
			while(isalnum(t)) { // is alpha-numeric
				lexbuf[b] = t;
				t = getchar();
				b++;
				if(b >= BSIZE)
					error("Error compiler");
			}
			lexbuf[b] = EOS;
			if(t != EOF)
				ungetc(t, stdin);
			// search the lexem in the symbol table
			p = search(lexbuf);
			// if wasn't there then insert it
			if(p == 0)
				p = insert(lexbuf, ID);
			// position in the table
			tokenval = p;
			return symb_tab[p].token;
		} else if(t == EOF) {
			return DONE;
		} else {
			tokenval = NONE;
			return t;
		}
	}
}

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


void init() {
	struct entry *p;
	for(p = key_words; p->token; p++) {
		insert(p->lexptr, p->token);
	}
}

void main() {
	init();
	parse();
	exit(0);
}