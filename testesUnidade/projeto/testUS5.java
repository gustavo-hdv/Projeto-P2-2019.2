package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.Controller;
import controllers.ObjetivoController;
import controllers.PesquisaController;
import controllers.ProblemaController;

class testUS5 {

	private Controller controleGeral;
	private ProblemaController controleProblema;
	private ObjetivoController controleObjetivo;
	private PesquisaController controlePesquisa;
	
	public testUS5() {
		this.controleGeral = new Controller();
		this.controleProblema = new ProblemaController();
		this.controleObjetivo = new ObjetivoController();
		this.controlePesquisa = new PesquisaController();
	}
	
	@Test
	void associaPesquisaProblema() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		try {
			assertEquals(controleGeral.associaProblema("COM1", "P1"), true);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void associaPesquisaNullProblema() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		try {
			controleGeral.associaProblema(null, "P1");
			fail("Era esperado excecao");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void associaPesquisaEmptyProblema() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		try {
			controleGeral.associaProblema(" ", "P1");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	void associaPesquisaProblemaNull() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		try {
			controleGeral.associaProblema("COM1", null);
			fail("Era esperado excecao");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void associaPesquisaProblemaEmpty() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		try {
			controleGeral.associaProblema("COM1", " ");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException iae) {
		}
	}

	@Test
	void desassociaProblema() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		assertEquals(controleGeral.associaProblema("COM1", "P1"), true);
		try {
			assertEquals(controleGeral.desassociaProblema("COM1"), true);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void desassociaProblemaNull() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		assertEquals(controleGeral.associaProblema("COM1", "P1"), true);
		try {
			controleGeral.desassociaProblema(null);
			fail("Era esperado excecao");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void desassociaProblemaEmpty() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		assertEquals(controleGeral.associaProblema("COM1", "P1"), true);
		try {
			controleGeral.desassociaProblema(" ");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	void associaPesquisaObjetivo() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		controleGeral.cadastraObjetivo("GERAL", "Aumentar a porcentagem de pessoas que entregam os laboratorios na disciplina de LP2.", 4, 4);
		try {
			assertEquals(controleGeral.associaObjetivo("COM1", "O1"), true);
			assertEquals(controleGeral.associaObjetivo("COM1", "O1"), false);
			assertEquals(controleGeral.associaObjetivo("FER1", "O2"), true);
			assertEquals(controleGeral.associaObjetivo("FER1", "O2"), false);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void associaPesquisaObjetivoExistente() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		controleGeral.cadastraObjetivo("GERAL", "Aumentar a porcentagem de pessoas que entregam os laboratorios na disciplina de LP2.", 4, 4);
		try {
			assertEquals(controleGeral.associaObjetivo("FER1", "O1"), true);
			assertEquals(controleGeral.associaObjetivo("COM1", "O1"), false);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	void associaPesquisaNullObjetivo() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		try {
			assertEquals(controleGeral.associaObjetivo(null, "O1"), false);
			fail("Era esperado excecao");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void associaPesquisaEmptyObjetivo() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		try {
			assertEquals(controleGeral.associaObjetivo(" ", "O1"), false);
			fail("Era esperado excecao");
		} catch (Exception e) {
		}
	}
	
	@Test
	void associaPesquisaObjetivoNull() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		try {
			assertEquals(controleGeral.associaObjetivo("COM1", null), false);
			fail("Era esperado excecao");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void associaPesquisaObjetivoEmpty() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia"); // COM1
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		try {
			assertEquals(controleGeral.associaObjetivo("COM1", " "), false);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	void desassociaPesquisaObjetivo() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		assertEquals(controleGeral.associaObjetivo("FER1", "O1"), true);
		try {
			assertEquals(controleGeral.desassociaObjetivo("FER1", "O1"), true);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void desassociaPesquisaNullObjetivo() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		assertEquals(controleGeral.associaObjetivo("FER1", "O1"), true);
		try {
			assertEquals(controleGeral.desassociaObjetivo(null, "O1"), false);
			fail("Era esperado excecao");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void desassociaPesquisaObjetivoNull() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		assertEquals(controleGeral.associaObjetivo("FER1", "O1"), true);
		try {
			assertEquals(controleGeral.desassociaObjetivo("FER1", null), false);
			fail("Era esperado excecao");
		} catch (NullPointerException npe) {
		}
	}
	
	@Test
	void desassociaPesquisaEmptyObjetivo() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		assertEquals(controleGeral.associaObjetivo("FER1", "O1"), true);
		try {
			assertEquals(controleGeral.desassociaObjetivo(" ", "O1"), false);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	void desassociaPesquisaObjetivoEmpty() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		assertEquals(controleGeral.associaObjetivo("FER1", "O1"), true);
		try {
			assertEquals(controleGeral.desassociaObjetivo("FER1", " "), false);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException iae) {
		}
	}
	
	@Test
	void listaPesquisasProblema() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia"); // COM1
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3); // P1
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de segundo periodo", 4); // P2
		controleGeral.associaProblema("COM1", "P1");
		controleGeral.associaProblema("FER1", "P2");
		
		assertEquals(controleGeral.listaPesquisas("PROBLEMA"), "FER1 - Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces. - fermentacao, cerveja | COM1 - Homofobia em mensagens online de alunos de computacao do primeiro periodo. - computacao, homofobia");
	}
	
	@Test
	void listaPesquisasProblemaIgual() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia"); // COM1
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3); // P1
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de segundo periodo", 4); // P2
		controleGeral.associaProblema("COM1", "P1");
		controleGeral.associaProblema("FER1", "P1");
		
		assertEquals(controleGeral.listaPesquisas("PROBLEMA"), "FER1 - Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces. - fermentacao, cerveja | COM1 - Homofobia em mensagens online de alunos de computacao do primeiro periodo. - computacao, homofobia");
	}
	
	@Test
	void listaPesquisasObjetivos() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia"); // COM1
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3); // P1
		controleGeral.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de segundo periodo", 4); // P2
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		controleGeral.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de segundo periodo de computacao.", 4, 2);
		controleGeral.associaProblema("COM1", "P1");
		controleGeral.associaProblema("FER1", "P2");
		controleGeral.associaObjetivo("COM1", "O1");
		controleGeral.associaObjetivo("FER1", "O2");
		
		assertEquals(controleGeral.listaPesquisas("OBJETIVOS"), "FER1 - Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces. - fermentacao, cerveja | COM1 - Homofobia em mensagens online de alunos de computacao do primeiro periodo. - computacao, homofobia");
	}
	
	@Test
	void listaPesquisasCodigo() {
		controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia"); // COM1
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		
		assertEquals(controleGeral.listaPesquisas("PESQUISA"), "FER1 - Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces. - fermentacao, cerveja | COM1 - Homofobia em mensagens online de alunos de computacao do primeiro periodo. - computacao, homofobia");
	}
}
