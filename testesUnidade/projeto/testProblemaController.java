import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testProblemaController {

	private ProblemaController problemaController = new ProblemaController();
	
	@Test
	void cadastraProblema() {
		try {
			problemaController.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void cadastraProblemaNull() {
		try {
			problemaController.cadastraProblema(null, 3);
			fail("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	void cadastraProblemaEmpty() {
		try {
			problemaController.cadastraProblema(" ", 4);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void viabilidadeOutRange() {
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 0);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 6);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void apagaProblema() {
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			problemaController.apagaProblema("P1");
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			problemaController.apagaProblema(" ");
			fail("Era esperado excecao");
		} catch (Exception e) {
			
		}
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			problemaController.apagaProblema(null);
			fail("Era esperado excecao");
		} catch (Exception e) {

		}
	}
	
	@Test
	void ToString() {
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			assertEquals(problemaController.get("P1").exibeProblema(), "P1 - A dificuldade da predicao do sistema eleitoral brasileiro - 5");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}
	
	@Test
	void ToString_1() {
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			problemaController.apagaProblema("P1");
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			assertEquals(problemaController.get("P2").exibeProblema(), "P2 - A problematica do aprendizado dos conceitos de programacao orientada a objeto - 2");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}
	
	@Test
	void ToString_2() {
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			assertEquals(problemaController.get("P11").exibeProblema(), "P1 - A dificuldade da predicao do sistema eleitoral brasileiro - 5");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {

		}
	}
	
	@Test
	void toString_3() {
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			assertEquals(problemaController.get(null).exibeProblema(), "P1 - A dificuldade da predicao do sistema eleitoral brasileiro - 5");
			fail("Era esperado excecao");
		} catch (NullPointerException e) {

		}
	}

}
