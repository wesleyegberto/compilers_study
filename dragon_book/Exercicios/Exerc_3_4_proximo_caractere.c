
#define BUFFER_FIRST_END 49;
#define BUFFER_SECOND_END 99;

char[100] buffer;
int tokenStart = 0;
int forwardPointer = 0;

void reloadFirstHalf() {

}

void reloadSecondHalf() {

}

char next_character() {
	char next = '\0';

	if(forwardPointer == BUFFER_FIRST_END) {
		reloadSecondHalf();
		next = buffer[forwardPointer];
		forwardPointer++;
	} else if(forwardPointer == BUFFER_SECOND_END) {
		reloadFirstHalf();
		next = buffer[forwardPointer];
		forwardPointer = 0;
	} else {
		next = buffer[forwardPointer];
		forwardPointer++;
	}

	return next;
}