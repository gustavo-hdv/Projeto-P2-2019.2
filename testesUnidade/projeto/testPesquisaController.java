package projeto;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testPesquisaController {

	private PesquisaController pesqC = new PesquisaController();;


	@Test
	void testCadastraPesquisa() {
		try {
			pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
					"computacao, homofobia");
		} catch (RuntimeException e) {
			fail("Nao era esperado excessao");
		}
	}

	@Test
	void testCadastraPesquisaDescricaoNula() {
		try {
			pesqC.cadastraPesquisa(null, "computacao, homofobia");
			fail("Era esperado excessao");
		} catch (NullPointerException nPE) {
		}
	}
	
	@Test
	void testCadastraPesquisaDescricaoVazia() {
		try {
			pesqC.cadastraPesquisa("", "computacao, homofobia");
			fail("Era esperado excessao");
		} catch (RuntimeException iAE) {
		}
	}
	
	@Test
	void testCadastraPesquisaCampoDeInteresseNulo() {
		try {
			pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", null);
			fail("Era esperado excessao");
		} catch (NullPointerException nPE) {
		}
	}
	
	@Test
	void testCadastraPesquisaCampoDeInteresseVazio() {
		try {
			pesqC.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "     ");
			fail("Era esperado excessao");
		} catch (RuntimeException iAE) {
		}
	}
}
