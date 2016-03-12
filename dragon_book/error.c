#include "global.h"

void error(char *m) {
	fprintf(stderr, "Line: %d: %s\n", cline, m);
	exit(1);
}