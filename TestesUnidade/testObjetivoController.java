import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import projeto.ObjetivoController;

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
			objetivoController.apagarObjetivo("O1");
		} catch (Exception e) {
			fail("Nao era esperado excecao");
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			objetivoController.apagarObjetivo(" ");
			fail("Era esperado excecao");
		} catch (Exception e) {

		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			objetivoController.apagarObjetivo(null);
			fail("Era esperado excecao");
		} catch (Exception e) {

		}
	}
	
	@Test
	void objetivoToString() {
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			assertEquals(objetivoController.exibeObjetivo("O1"), "O1 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			objetivoController.apagarObjetivo("O1");
			objetivoController.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 3, 4);
			assertEquals(objetivoController.exibeObjetivo("O2"), "O2 - ESPECIFICO - Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas. - 7");
		} catch (Exception e) {
			fail("Nao espera esperado excecao");
		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			assertEquals(objetivoController.exibeObjetivo("O11"), "O1 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException e) {

		}
		try {
			objetivoController.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
			assertEquals(objetivoController.exibeObjetivo(null), "O1 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
			fail("Era esperado excecao");
		} catch (NullPointerException e) {

		}
	}
}
