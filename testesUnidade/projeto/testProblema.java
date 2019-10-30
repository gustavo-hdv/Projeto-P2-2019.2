import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testProblema {
	
	@Test
	void constructProblema() {
		try {
			Problema testProblema = new Problema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void constructProblemaNull() {
		try {
			Problema testProblema = new Problema(null, 3);
			fail("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	void constructProblemaEmpty() {
		try {
			Problema testProblema = new Problema(" ", 4);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void constructProblemaViabilidade() {
		try {
			Problema testProblema = new Problema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 0);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			Problema testProblema = new Problema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 6);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void problemaToString() {
		try {
			Problema testProblema = new Problema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			assertEquals(testProblema.exibeProblema(), "A dificuldade da predicao do sistema eleitoral brasileiro - 5");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}
}
