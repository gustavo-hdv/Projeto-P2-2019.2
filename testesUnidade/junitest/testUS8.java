package junitest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controllers.Controller;

class testUS8 {

	Controller C = new Controller();

	@BeforeEach
	public void cadastraEntidades() {
		C.cadastraAtividade("**Organizar dados da pesquisa.", "MEDIO",
				"Caso nao seja feita a organizacao, irao dificultar o desenvolvimento da pesquisa.");
		C.cadastraAtividade("**Monitoramento de chats dos alunos de computacao do primeiro periodo.", "BAIXO",
				"Por se tratar de apenas um monitoramento, o risco nao e elevado.");

		C.cadastraPesquisa("**Autoavaliacao na Disciplina de Programacao Orientada a Objeto.", "computacao, poo");
		C.cadastraPesquisa("Alienacao Parental e o Sistema de Justica Brasileiro.",
				"**psicologia, sistema juridico, alienacao parental, brasil");

		C.cadastraPesquisador("Carlos", "Aluno", "nao sei programacao dinamica**", "zapzap@zap.com",
				"http://shafou.com");
		C.cadastraPesquisador("eanes", "professor", "IsSo TEm APlIcaCoEs eM PROcEsSaMEntO De imAgEns",
				"eanes@computacao", "https://deeplearning.com");

		C.cadastraObjetivo("GERAL",
				"Diminuir a frequencia de mensagens ** homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				5, 1);
		C.cadastraObjetivo("ESPECIFICO",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				5, 4);

		C.cadastraProblema(
				"O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		C.cadastraProblema("**superlotacao nos laboratorios de computacao", 1);

	}

	@Test
	public void testBuscaVazio() {
		try {
			C.busca("");
			fail("O campo termo nao deve ser nulo ou vazio");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	public void testBuscaInvalido() {
		try {
			C.busca(" ");
			fail("O campo termo nao deve ser nulo ou vazio");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	public void testBuscaNulo() {
		try {
			C.busca(null);
			fail("O campo termo nao deve ser nulo ou vazio");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	public void testBusca() {
		assertEquals(
				"COM1: **Autoavaliacao na Disciplina de Programacao Orientada a Objeto. | **P1: Alienacao Parental e o Sistema de Justica Brasileiro. | **P1: **psicologia, sistema juridico, alienacao parental, brasil | zapzap@zap.com: nao sei programacao dinamica** | P2: **superlotacao nos laboratorios de computacao | O1: Diminuir a frequencia de mensagens ** homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. | A2: **Monitoramento de chats dos alunos de computacao do primeiro periodo. | A1: **Organizar dados da pesquisa.",
				C.busca("**"));
	}

	@Test
	public void testBuscaIndiceNulo() {
		try {
			C.busca("**", 0);
			fail("O indice nao deve ser negativo ou nulo");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	public void testBuscaIndiceNegativo() {
		try {
			C.busca("**", -5);
			fail("O indice nao deve ser negativo ou nulo");
		} catch (RuntimeException RTE) {
		}
	}

	@Test
	public void testBuscaIndice() {
		assertEquals("zapzap@zap.com: nao sei programacao dinamica**", C.busca("**", 4));
	}
	
	@Test
	public void testContaResultadosBusca() {
		assertEquals(8, C.contaResultadosBusca("**"));
	}
}
