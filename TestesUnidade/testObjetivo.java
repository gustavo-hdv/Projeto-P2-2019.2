import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testObjetivo {
	
	@Test
	void constructObjetivo() {
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void constructObjetivoNull() {
		try {
			Objetivo testObjetivo = new Objetivo(null, "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			fail("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", null, 4, 2);
			fail("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	void constructObjetivoEmpty() {
		try {
			Objetivo testObjetivo = new Objetivo(" ", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 4, 2);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", " ", 4, 2);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void constructObjetivoAderencia() {
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 6, 1);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 0, 1);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void constructObjetivoViabilidade() {
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 0);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 6);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void objetivoToString() {
		try {
			Objetivo testObjetivo = new Objetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			assertEquals(testObjetivo.exibeObjetivo(), "GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}
}
