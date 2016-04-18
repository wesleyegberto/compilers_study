package com.github.wesleyegberto.simplecompiler.lexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * Classe para testar o analisador léxico.
 */
public class LexerAnalyzerTest {

	@Test
	public void testTokenCounter() {
		StringReader sr = new StringReader("i");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.COUNTER, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testTokenIf() {
		StringReader sr = new StringReader("if");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.IF, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenElse() {
		StringReader sr = new StringReader("else");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.ELSE, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenFor() {
		StringReader sr = new StringReader("for");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.FOR, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenWhile() {
		StringReader sr = new StringReader("while");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.WHILE, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenProgram() {
		StringReader sr = new StringReader("program");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.PROGRAM, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenAnd() {
		StringReader sr = new StringReader("and");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.AND, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenOr() {
		StringReader sr = new StringReader("or");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.OR, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenLPar() {
		StringReader sr = new StringReader("(");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.LPAR, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenRPar() {
		StringReader sr = new StringReader(")");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RPAR, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenLCurb() {
		StringReader sr = new StringReader("{");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.LCURB, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenRCurb() {
		StringReader sr = new StringReader("}");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RCURB, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenAdd() {
		StringReader sr = new StringReader("+");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.BINOP_ADD, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenSub() {
		StringReader sr = new StringReader("-");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.BINOP_SUB, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenMul() {
		StringReader sr = new StringReader("*");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.BINOP_MUL, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenDiv() {
		StringReader sr = new StringReader("/");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.BINOP_DIV, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenAssign() {
		StringReader sr = new StringReader("=");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.OP_ASSIGN, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenEq() {
		StringReader sr = new StringReader("==");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RELOP_EQ, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenNeq() {
		StringReader sr = new StringReader("!=");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RELOP_NEQ, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenGt() {
		StringReader sr = new StringReader(">");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RELOP_GT, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenGte() {
		StringReader sr = new StringReader(">=");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RELOP_GTE, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenLt() {
		StringReader sr = new StringReader("<");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RELOP_LT, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenLte() {
		StringReader sr = new StringReader("<=");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.RELOP_LTE, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTokenNum() {
		StringReader sr = new StringReader("2 1510 1561 990011");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals("2", token.getLexeme());
			Assert.assertEquals(TokenType.NUM, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("1510", token.getLexeme());
			Assert.assertEquals(TokenType.NUM, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("1561", token.getLexeme());
			Assert.assertEquals(TokenType.NUM, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("990011", token.getLexeme());
			Assert.assertEquals(TokenType.NUM, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenReal() {
		StringReader sr = new StringReader("2.0 1510.1 1561.55 990011.665");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals("2.0", token.getLexeme());
			Assert.assertEquals(TokenType.REAL, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("1510.1", token.getLexeme());
			Assert.assertEquals(TokenType.REAL, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("1561.55", token.getLexeme());
			Assert.assertEquals(TokenType.REAL, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("990011.665", token.getLexeme());
			Assert.assertEquals(TokenType.REAL, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenId() {
		StringReader sr = new StringReader("n name na31 whil idade");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals("n", token.getLexeme());
			Assert.assertEquals(TokenType.ID, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("name", token.getLexeme());
			Assert.assertEquals(TokenType.ID, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("na31", token.getLexeme());
			Assert.assertEquals(TokenType.ID, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("whil", token.getLexeme());
			Assert.assertEquals(TokenType.ID, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals("idade", token.getLexeme());
			Assert.assertEquals(TokenType.ID, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTokenSintax() {
		StringReader sr = new StringReader("if(medeDistancia() <10){acendeLedVermelho();}");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			Token token = lexer.nextToken();
			Assert.assertEquals(TokenType.IF, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals(TokenType.LPAR, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals("medeDistancia", token.getLexeme());
			Assert.assertEquals(TokenType.ID, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals(TokenType.LPAR, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals(TokenType.RPAR, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals(TokenType.RELOP_LT, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals("10", token.getLexeme());
			Assert.assertEquals(TokenType.NUM, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals(TokenType.RPAR, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals(TokenType.LCURB, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals("acendeLedVermelho", token.getLexeme());
			Assert.assertEquals(TokenType.ID, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals(TokenType.LPAR, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals(TokenType.RPAR, token.getTokenType());

			token = lexer.nextToken();
			Assert.assertEquals(TokenType.SECO, token.getTokenType());
			
			token = lexer.nextToken();
			Assert.assertEquals(TokenType.RCURB, token.getTokenType());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(expected = LexicalException.class)
	public void testTokenInvalidNeq() {
		StringReader sr = new StringReader("!");
		
		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));
			
			lexer.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = LexicalException.class)
	public void testTokenInvalidCharacter() {
		StringReader sr = new StringReader("$");

		try (BufferedReader br = new BufferedReader(sr)) {
			LexerAnalyzer lexer = new LexerAnalyzer(new BufferedReader(br));

			lexer.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
