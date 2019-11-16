package junitest;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import controllers.PesquisaController;

public class testPesquisaController {

	private PesquisaController pesqC = new PesquisaController();;

	@Test
	void testCadastraPesquisa() {
		try {
			pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia");
		} catch (RuntimeException RTE) {
			fail("Nao era esperado excessao");
		}
	}

	@Test
	void testCadastraPesquisaDescricaoNula() {
		try {
			pesqC.cadastraPesquisa(null, "computacao, homofobia");
			fail("Era esperado excessao");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testCadastraPesquisaDescricaoVazia() {
		try {
			pesqC.cadastraPesquisa("", "computacao, homofobia");
			fail("Era esperado excessao");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testCadastraPesquisaCampoDeInteresseNulo() {
		try {
			pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", null);
			fail("Era esperado excessao");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testCadastraPesquisaCampoDeInteresseVazio() {
		try {
			pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"     ");
			fail("Era esperado excessao");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraDescricao() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"DESCRICAO", "Autoavaliacao na Disciplina de Programacao Orientada a Objeto.");
		} catch (RuntimeException RTE) {
			fail("Nao era esperado excessao");
		}
	}

	@Test
	void testAlteraCampoDeInteresse() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "computacao, poo");
		} catch (RuntimeException RTE) {
			fail("Nao era esperado excessao");
		}
	}

	@Test
	void testAlteraDescricaoNula() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"DESCRICAO", null);
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraDescricaoVazia() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"DESCRICAO", "   ");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseNulo() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", null);
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseVazio() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraDescricaoConteudoNulo() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"DESCRICAO", null);
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraDescricaoConteudoVazio() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"DESCRICAO", "");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraDescricaoInvalida() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"DESCRICAO",
					"receita de bolo de cenoura pela metade    \r\n" + "\r\n" + "1/2 x�cara (cha) de oleo\r\n"
							+ "3 cenouras medias raladas\r\n" + "4 ovos\r\n" + "2 xicaras (cha) de acucar\r\n"
							+ "2 e 1/2 xicaras (cha) de farinha de trigo\r\n" + "1 colher (sopa) de fermento em po\r\n"
							+ "1 colher (sopa) de manteiga\r\n" + "3 colheres (sopa) de chocolate em po");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseConteudoNulo() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", null);
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseConteudoVazio() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseInvalido() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "computacao, homofobia, sociedade, preconceito, universidade");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseInvalido2() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "computacao, homofobia,, universidade");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseInvalido21() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "computacao, homofobia ,, universidade");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseInvalido22() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "computacao, homofobia , , universidade");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraCampoDeInteresseInvalido3() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"CAMPO", "ab, cd, ef");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraPesquisaInexistente() {
		try {
			pesqC.alteraPesquisa("COM1", "DESCRICAO", "Autoavaliacao na Disciplina de Programacao Orientada a Objeto.");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	void testAlteraPesquisaValorInvalido() {
		try {
			pesqC.alteraPesquisa(
					pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
							"computacao, homofobia"),
					"ABcDx", "computacao, poo");
			fail("");
		} catch (RuntimeException RTE) {
		}
	}
}