package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import projeto.Problema;

class testProblema {

    @Test
    void constructProblemaBasico() {
        try {
            Problema testProblema = new Problema("P1", "O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void constructProblemaNull() {
        try {
            Problema testProblema = new Problema("P1", null, 3);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void constructProblemaEmpty() {
        try {
            Problema testProblema = new Problema("P1", " ", 4);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void constructProblemaViabilidade() {
        try {
            Problema testProblema = new Problema("P1", "A problematica do aprendizado dos conceitos de programacao orientada a objeto", 0);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
        try {
            Problema testProblema = new Problema("P2", "A problematica do aprendizado dos conceitos de programacao orientada a objeto", 6);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void problemaToString() {
        try {
            Problema testProblema = new Problema("P1", "A dificuldade da predicao do sistema eleitoral brasileiro", 5);
            assertEquals(testProblema.toString(), "P1 - A dificuldade da predicao do sistema eleitoral brasileiro - 5");
        } catch (Exception e) {
            fail("Nao espera esperado excecao");
        }
    }
}