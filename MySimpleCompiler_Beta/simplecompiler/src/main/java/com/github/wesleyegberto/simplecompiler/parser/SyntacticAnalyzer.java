package com.github.wesleyegberto.simplecompiler.parser;

import com.github.wesleyegberto.simplecompiler.grammar.GrammarRule;
import com.github.wesleyegberto.simplecompiler.grammar.NodeASTFactory;
import com.github.wesleyegberto.simplecompiler.lexer.LexerAnalyzer;
import com.github.wesleyegberto.simplecompiler.lexer.Token;
import com.github.wesleyegberto.simplecompiler.lexer.TokenType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Classe que efetuará a análise sintática do stream de tokens.
 *
 * @author Wesley Egberto
 *
 */
public class SyntacticAnalyzer {
    // Constantes de ação
    private static final int ERROR = -1;
    private static final int SUCCESS = 0;
    private static final int SHIFT = 1;
    private static final int REDUCE = 2;
    private static final int GOTO = 3;

    private final LexerAnalyzer lexerAnalyzer;
    private Token cachedToken;

	private GrammarRule generatedSyntacticTree;

    public SyntacticAnalyzer(LexerAnalyzer lexerAnalyzer) {
        this.lexerAnalyzer = lexerAnalyzer;
    }

	/**
     * Tabela de transições do automato.
     */
    private static final int[][][] TRANSITION_TABLE;

    // Bloco estatico para iniciar TRANSITION_TABLE
    static {
        File f = new File("parser_transition_table.dat");
        // Lista de stados
        List<int[][]> states = new ArrayList<>();
        String line = null;
        //System.out.println(f.getAbsolutePath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            // Le cada linha (estado)
            while ((line = br.readLine()) != null) {
                String[] rawTransitions = line.split(";");
                int[][] transitions = new int[rawTransitions.length][2];
                // Percorre a linha extraindo as açoes de cada estado
                for(int i = 0; i < rawTransitions.length; i++) {
                    String[] data = rawTransitions[i].split(",");
                    transitions[i] = new int[] { Integer.parseInt(data[0]), Integer.parseInt(data[1]) };
                }
                states.add(transitions);
            }
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Erro ao efetuar leitura de estado: " + ex.getMessage());
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao efetuar leitura do arquivo com estados do parser: " + ex.getMessage());
        }
        TRANSITION_TABLE = states.toArray(new int[][][] {});

        if(TRANSITION_TABLE.length != states.size()) {
            throw new RuntimeException("Quantidade de transiçoes divergiram");
        }
    }

    /**
     * Produçoes com suas posições na tabela GoTo e a
     * quantidade de elementos para serem retirados da pilha.
     */
    private static final int[][] PRODUCTIONS = {
            {28, 1 },
            {29, 4},
            {30, 2},
            {30, 1},
            {31, 1 },
            {31, 2 },
            {32, 1 },
            {32, 1 },
            {32, 1 },
            {33, 8 },
            {33, 7 },
            {34, 4 },
            {35, 19 },
            {36, 7 },
            {37, 4 },
            {37, 3 },
            {38, 1 },
            {40, 4 },
            {40, 3 },
            {39, 2 },
            {41, 2 },
            {41, 1 },
            {42, 3 },
            {42, 2 },
            {43, 2 },
            {43, 1 },
            {44, 3 },
            {44, 2 },
            {45, 1 },
            {45, 1 },
            {47, 1 },
            {47, 1 },
            {46, 1 },
            {46, 1 },
            {46, 1 },
            {46, 1 },
            {46, 1 },
            {46, 1 },
            {48, 1 },
            {48, 1 },
            {49, 1 },
            {49, 1 },
            {50, 1 },
            {50, 1 },
            {51, 1 },
            {51, 1 }
    };

	public GrammarRule getGeneratedSyntacticTree() {
		return generatedSyntacticTree;
	}

	/**
     * Efetua a análise sintática e retorna uma árvore sintática.
     * Se ocorrer um erro é lançada uma exception.
     */
    public boolean parse() {
        Deque<Integer> stateStack = new LinkedList<>();
		Deque<Object> rulesStack = new LinkedList<>();
        stateStack.push(0);
        int state = 0;
		Object nodeAst = null;
        Token token = null;

        while((token = nextToken()) != null) {
            state = stateStack.peek();
            //System.out.println("Estado: " + state + " Token: " + token);
            // lê a transição e sua ação
            int[] transition = nextAction(state, token);
            int action = transition[0];
            int stateToAct = transition[1];

            switch (action) {
                case SUCCESS:
					generatedSyntacticTree = (GrammarRule) rulesStack.pop();
					System.out.println("Last elem: " + generatedSyntacticTree);
					return true;
                case SHIFT:
                    // empilha o estado
					//System.out.println("Shift: " + stateToAct);
					stateStack.push(stateToAct);
					rulesStack.push(token);
                    eat();
                    break;
                case REDUCE:
                    // Retira da pilha a qtde de elementos da regra reduzida
                    int[] production = PRODUCTIONS[stateToAct];
                    int nElemToPop = production[1];
					// Tokens para a árvore gramatical
					Object[] elementsOfRule = new Object[nElemToPop];

					//System.out.print("Reduce rule " + stateToAct + ": ");
					for(int i = 0, j = nElemToPop - 1; i < nElemToPop; i++, j--) {
						stateStack.pop();
						//System.out.print(stateStack.pop() + " ");
						// A ordem dos elementos da regra está invertida (pilha)
						elementsOfRule[j] = rulesStack.pop();
						//System.out.print("(" + elementsOfRule[j] + ") ");
					}
					//System.out.println();
					nodeAst = NodeASTFactory.createGrammar(stateToAct, elementsOfRule);
					//System.out.println("AST: " + nodeAst);

					// Muda para o estado do GoTo
                    int oldState = stateStack.peek();
                    stateStack.push(TRANSITION_TABLE[oldState][production[0]][1]);
					rulesStack.push(nodeAst);
					//System.out.println("GoTo: " + TRANSITION_TABLE[oldState][production[0]][1]);
                    break;
                case ERROR:
                    throw new ParserException("Token invalido: " + token.getLexeme());
            }
        }

        if(state != 1)
            throw new ParserException("Código inválido");

        return false;
    }

    private int[] nextAction(int state, Token token) {
        if(token.getTokenType() == TokenType.END_OF_FILE)
            return TRANSITION_TABLE[state][token.getTokenType().getState()];
        return TRANSITION_TABLE[state][token.getTokenType().getState() - 1];
    }

    private Token nextToken() {
        if(cachedToken == null) {
            cachedToken = lexerAnalyzer.nextToken();
            if(cachedToken == null)
                return new Token(TokenType.END_OF_FILE, "$", 0, 0);
        }
        return cachedToken;
    }

    private void eat() {
        cachedToken = null;
    }
}
