/**
 * Código para avançar o apontador adiante
 */

/*

se apontador_adiante estiver ao fim da primeira metade então
inicio
	recarregar a segunda metade
	apontador_adiante := apontador_adiante + 1
fim
senão se apontador_adiante estiver ao fim da segunda metade então
inicio
	recarregar a primeira metade
	deslocar apontador_adiante para o inicio da primeira metade
fim
senão apontador_adiante := apontador_adiante + 1

*/

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