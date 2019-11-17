package junitest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.Controller;

class testUS9 {

	private Controller controle = new Controller();

	@Test
	public void defineProximaAtividadeIdPrecedenteVazio() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.defineProximaAtividade("", "A2");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void defineProximaAtividadeIdSubsequenteVazio() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.defineProximaAtividade("A1", "");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void defineProximaAtividadeIdPrecedenteNulo() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.defineProximaAtividade(null, "A2");
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void defineProximaAtividadeIdSubsequenteNulo() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.defineProximaAtividade("A1", null);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void defineProximaAtividade() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		controle.defineProximaAtividade("A1", "A2");
		controle.defineProximaAtividade("A2", "A3");
	}
	
	@Test
	public void tiraProximaAtividadeidPrecedenteVazio() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.tiraProximaAtividade("");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void tiraProximaAtividadeidPrecedenteNulo() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.tiraProximaAtividade(null);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void tiraProximaAtividadeidPrecedente() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		controle.tiraProximaAtividade("A1");
		controle.tiraProximaAtividade("A2");
	}
	
	@Test
	public void contaProximosidPrecedenteVazio() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.contaProximos("");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}

	@Test
	public void contaProximosidPrecedenteNulo() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.contaProximos(null);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void contaProximosidPrecedente() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		controle.contaProximos("A1");
	}
	
	@Test
	public void pegaProximoidAtividadeVazio() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.pegaProximo("", 2);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void pegaProximoidAtividadeNulo() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.pegaProximo(null, 2);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void pegaProximoEnesimaAtividadeMenorQueZero() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.pegaProximo("A1", -5);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void pegaProximoEnesimaAtividadeMenorIgualAZero() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.pegaProximo("A1", 0);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void pegaProximo() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		controle.pegaProximo("A1", 2);
	}
	
	@Test
	public void pegaMaiorRiscoAtividadesIdAtividadeVazio() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.pegaMaiorRiscoAtividades("");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void pegaMaiorRiscoAtividadesIdAtividadeNulo() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		try {
			controle.pegaMaiorRiscoAtividades(null);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void pegaMaiorRiscoAtividadesIdAtividade() {
		controle.cadastraPesquisa("Estuda as atividades agricolas.", "Plantio, Fazenda.");
		controle.cadastraAtividade("Plantio de um grao de feijao em um algodao.", "ALTO", "Por se tratar de uma vida, o risco e extremamente elevado.");
		controle.cadastraAtividade("Plantio de um grao de milho.", "MEDIO", "Por ser um grao de milho, que eh mais resistente, nao tem muito perigo");
		controle.cadastraAtividade("Plantio de um grao de pe de tambor.", "BAIXO", "Por se tratar de um grao muito resistente.");
		controle.cadastraAtividade("Plantio de um grao de laranja.", "ALTO", "Por se tratar de um grao que precisa de muita umidade.");
		controle.cadastraAtividade("Plantio de um grao de bananeira", "MEDIO", "Por se tratar de um grao que se adpta relativamente facil ao terreno.");
		controle.pegaMaiorRiscoAtividades("A1");
	}
}
