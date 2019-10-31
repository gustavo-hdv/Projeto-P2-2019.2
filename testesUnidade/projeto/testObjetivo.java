package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import projeto.Objetivo;

public class testObjetivo {

    @Test
    void constructObjetivoBasico() {
        try {
            Objetivo testObjetivo = new Objetivo("O1", "GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 1);
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void constructObjetivoNull() {
        try {
            Objetivo testObjetivo = new Objetivo("O1", null, "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
        try {
            Objetivo testObjetivo = new Objetivo("O2", "GERAL", null, 4, 2);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void constructObjetivoEmpty() {
        try {
            Objetivo testObjetivo = new Objetivo("O1", " ", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 4, 2);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
        try {
            Objetivo testObjetivo = new Objetivo("O2", "GERAL", " ", 4, 2);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void constructObjetivoAderencia() {
        try {
            Objetivo testObjetivo = new Objetivo("O1", "GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 6, 1);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
        try {
            Objetivo testObjetivo = new Objetivo("O2", "GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 0, 1);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void constructObjetivoViabilidade() {
        try {
            Objetivo testObjetivo = new Objetivo("O1", "GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 0);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
        try {
            Objetivo testObjetivo = new Objetivo("O2", "GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 5, 6);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void objetivoToString() {
        try {
            Objetivo testObjetivo = new Objetivo("O1", "GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 1, 5);
            assertEquals(testObjetivo.toString(), "O1 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6");
        } catch (Exception e) {
            fail("Nao espera esperado excecao");
        }
    }
}
