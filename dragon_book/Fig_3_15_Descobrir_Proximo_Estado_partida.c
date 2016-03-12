int estado = 0, partida = 0;
// Para retornar o segundo componente de um token
int valor_lexico;

int falhar() {
	apontador_adiante = inicio_token;
	switch(partida) {
		case 0: partida = 9; break;
		case 9: partida = 12; break;
		case 12: partida = 20; break;
		case 20: partida = 25; break;
		case 25: recuperar(); break;
		default: error("Erro do compilador");
	}
	return partida;
}