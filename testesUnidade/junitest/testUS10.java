package junitest;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import controllers.Controller;

public class testUS10 {

	private Controller C;

	@BeforeEach
	public void criaEAssociaAtividadesEPesquisa() {
		C = new Controller();
		C.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.",
				"computacao, homofobia");
		C.cadastraAtividade("Monitoramento de chats dos alunos de computacao do primeiro periodo.", "BAIXO",
				"Por se tratar de apenas um monitoramento, o risco nao e elevado.");
		C.cadastraAtividade(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao.",
				"MEDIO",
				"Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja.");
		C.cadastraAtividade(
				"Analise das intencoes de votos de diversas pesquisas para comparar com a analise das avaliacao de modelos preditivos nas eleicoes brasileiras.",
				"BAIXO", "Sem grandes riscos, apenas analise de dados.");
		C.associaAtividade("COM1", "A1");
		C.associaAtividade("COM1", "A2");
		C.associaAtividade("COM1", "A3");
	}

	@Test
	public void testProximaAtividadeSemPendentes() {
		try {
			C.proximaAtividade("COM1");
			fail();
		} catch (RuntimeException RTE) {
		}
	}
	
	@Test
	public void testProximaAtividadeMaisAntiga() {
		C.cadastraItem("A1", "Busca por provas que a netflix esta se auto sabotando cancelando seus melhores shows");
		C.cadastraItem("A2", "Escutar Evolve");
		C.cadastraItem("A3", "Analisar as redes socias dos individuos ativos nos eventos dessa discurssao");
		assertEquals("A1", C.proximaAtividade("COM1"));

		C.configuraEstrategia("MAIS_ANTIGA");
		assertEquals("A1", C.proximaAtividade("COM1"));
	}

	@Test
	public void testProximaAtividadeMenosPendencias() {
		C.configuraEstrategia("MENOS_PENDENCIAS");
		C.cadastraItem("A1", "Busca por provas que a netflix esta se auto sabotando cancelando seus melhores shows");
		C.cadastraItem("A1", "Escutar Night Visions");
		C.cadastraItem("A1", "Escutar Smoke + Mirrors");
		C.cadastraItem("A1", "Escutar Evolve");
		C.cadastraItem("A2", "Escutar Origins");
		C.cadastraItem("A2", "Comparacao com outras bandas de rock");
		C.cadastraItem("A2", "Alunos de computacao atrapalhando atividades em campo dos alunos de arq/urb.");
		C.cadastraItem("A2", "Indiretas no twitter.");
		C.cadastraItem("A3", "Analisar as redes socias dos individuos ativos nos eventos dessa discurssao");

		assertEquals("A3", C.proximaAtividade("COM1"));

		C.desassociaAtividade("COM1", "A3");
		assertEquals("A1", C.proximaAtividade("COM1"));
	}

	@Test
	public void testProximaAtividadeMaiorRisco() {
		C.cadastraItem("A1", "Busca por provas que a netflix esta se auto sabotando cancelando seus melhores shows");
		C.cadastraItem("A2", "Escutar Evolve");
		C.cadastraItem("A3", "Analisar as redes socias dos individuos ativos nos eventos dessa discurssao");

		C.configuraEstrategia("MAIOR_RISCO");
		assertEquals("A2", C.proximaAtividade("COM1"));

		C.desassociaAtividade("COM1", "A2");
		assertEquals("A1", C.proximaAtividade("COM1"));
	}
	
	/*@Test
	public void testProximaAtividadeMaiorDuracao() {
		C.configuraEstrategia("MAIOR_DURACAO");
		C.cadastraItem("A1", "Busca por provas que a netflix esta se auto sabotando cancelando seus melhores shows");
		C.cadastraItem("A2", "Comparacao com outras bandas de rock");
		C.cadastraItem("A2", "Alunos de computacao atrapalhando atividades em campo dos alunos de arq/urb.");
		C.cadastraItem("A3", "Analisar as redes socias dos individuos ativos nos eventos dessa discurssao");

		C.executaAtividade("A1", 1, 10);
		C.executaAtividade("A2", 1, 4);
		C.executaAtividade("A2", 2, 5);
		C.executaAtividade("A3", 1, 1);
		
		assertEquals("A1", C.proximaAtividade("COM1"));
	}*/
}
