package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class testPesquisa {

	@Test
	void testCriaPesquisa() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia");
		} catch (Exception e) {
			fail("Nao era esperado excessao");
		}
	}

	@Test
	void testCriaPesquisaCodigoNulo() {
		try {
			Pesquisa pesquisa = new Pesquisa(null,
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia");
			fail("Era esperado excessao");
		} catch (NullPointerException nPE) {
		}
	}

	@Test
	void testCriaPesquisaCodigoVazio() {
		try {
			Pesquisa pesquisa = new Pesquisa("",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia");
			fail("Era esperado excessao");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisadorDescricaoNula() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1", null, "computacao, homofobia");
			fail("Descricao nao pode ser nula ou vazia.");
		} catch (NullPointerException nPE) {
		}
	}

	@Test
	void testCriaPesquisadorDescricaoVazia() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1", "", "computacao, homofobia");
			fail("Descricao nao pode ser nula ou vazia.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisadorCampoDeInteresseNulo() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.", null);
			fail("Formato do campo de interesse invalido.");
		} catch (NullPointerException nPE) {
		}
	}

	@Test
	void testCriaPesquisadorCampoDeInteresseVazio() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "");
			fail("Formato do campo de interesse invalido.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisaDescricaoInvalida() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"receita de bolo de cenoura pela metade    \r\n" + "\r\n" + "1/2 x�cara (cha) de oleo\r\n"
							+ "3 cenouras medias raladas\r\n" + "4 ovos\r\n" + "2 xicaras (cha) de acucar\r\n"
							+ "2 e 1/2 xicaras (cha) de farinha de trigo\r\n" + "1 colher (sopa) de fermento em po\r\n"
							+ "1 colher (sopa) de manteiga\r\n" + "3 colheres (sopa) de chocolate em po",
					"computacao, homofobia");
			fail("Formato da descricao invalido.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisaCasoDeInteresseInvalido() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia, sociedade, preconceito, universidade");
			fail("Formato do campo de interesse invalido.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisaCasoDeInteresseInvalido2() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia,, universidade");
			fail("Formato do campo de interesse invalido.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisaCasoDeInteresseInvalido21() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia ,, universidade");
			fail("Formato do campo de interesse invalido.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisaCasoDeInteresseInvalido22() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia , , universidade");
			fail("Formato do campo de interesse invalido.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testCriaPesquisaCasoDeInteresseInvalido3() {
		try {
			Pesquisa pesquisa = new Pesquisa("COM1",
					"Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "ab, cd, ef");
			fail("Formato do campo de interesse invalido.");
		} catch (IllegalArgumentException iAE) {
		}
	}

	@Test
	void testToString() {
		Pesquisa pesquisa = new Pesquisa("COM1",
				"Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		assertEquals("COM1 - Homofobia em mensagens online de alunos de computacao do primeiro periodo. - computacao, homofobia", pesquisa.toString());
	}
}
