#include "global.h"

struct entry key_words[] = {
	"div", DIV,
	"mod", MOD,
	0, 0
};

void init() {
	struct entry *p;
	for(p = key_words; p->token; p++) {
		insert(p->lexptr, p->token);
	}
}