#include "global.h"

char lexbuf[BSIZE];
int cline = 1;
int tokenval = NONE;

/** Lexer analiser */
int lexan() {
	int t;

	while(1) {
		t = getchar();

		if(t == ' ' || t == '\t') {
			continue; // remove blank spaces
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