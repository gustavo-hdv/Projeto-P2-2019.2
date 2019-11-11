package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.ProblemaController;

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
	void apagaProblemaBasico() {
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			problemaController.apagarProblema("P1");
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}

	@Test
	void apagaProblemaCodigoVazio() {
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			problemaController.apagarProblema(" ");
			fail("Era esperado excecao");
		} catch (Exception e) {

		}
	}

	@Test
	void apagaProblemaCodigoNulo(){
		try {
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			problemaController.apagarProblema(null);
			fail("Era esperado excecao");
		} catch (Exception e) {

		}
	}
	
	@Test
	void toStringBasico() {
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			assertEquals(problemaController.exibeProblema("P1"), "P1 - A dificuldade da predicao do sistema eleitoral brasileiro - 5");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}

	@Test
	void toStringOrdem() {
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			problemaController.apagarProblema("P1");
			problemaController.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 2);
			assertEquals(problemaController.exibeProblema("P2"), "P2 - A problematica do aprendizado dos conceitos de programacao orientada a objeto - 2");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}

	@Test
	void toStringCodigoInexistente() {
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			assertEquals(problemaController.exibeProblema("P11"), "P1 - A dificuldade da predicao do sistema eleitoral brasileiro - 5");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void toStringCodigoNulo(){
		try {
			problemaController.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 5);
			assertEquals(problemaController.exibeProblema(null), "P1 - A dificuldade da predicao do sistema eleitoral brasileiro - 5");
			fail("Era esperado excecao");
		} catch (NullPointerException e) {

		}
	}

}
