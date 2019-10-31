import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testObjetivoController {
	
	private ObjetivoController objetivoController = new ObjetivoController();
	
	@Test
	void constructObjetivo() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
	}
	
	@Test
	void constructObjetivoNull() {
		try {
			objetivoController.cadastraObjetivo(null, "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			fail("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", null, 4, 2);
			fail("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	void constructObjetivoEmpty() {
		try {
			objetivoController.cadastraObjetivo(" ", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 4, 2);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", " ", 4, 2);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void constructObjetivoAderencia() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 6, 1);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 0, 1);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void constructObjetivoViabilidade() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 0);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 6);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void removeObjetivo() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			objetivoController.apagaObjetivo("O1");
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			objetivoController.apagaObjetivo(" ");
			fail("Era esperado excecao");
		} catch (Exception e) {

		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			objetivoController.apagaObjetivo(null);
			fail("Era esperado excecao");
		} catch (Exception e) {

		}
	}
	
	@Test
	void objetivoToString() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			assertEquals(objetivoController.get("O1").exibeObjetivo(), "O1 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}
	
	@Test
	void objetivoToString_1() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			objetivoController.apagaObjetivo("O1");
			objetivoController.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 3, 4);
			assertEquals(objetivoController.get("O2").exibeObjetivo(), "O2 - ESPECIFICO - Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas. - 7");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
	}
	
	@Test
	void objetivoToString_2() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			assertEquals(objetivoController.get("O11").exibeObjetivo(), "O1 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {

		}
	}
	
	@Test
	void objetivoToString_3() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			assertEquals(objetivoController.get(null).exibeObjetivo(), "O1 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
			fail("Era esperado excecao");
		} catch (NullPointerException e) {

		}
	}
}
