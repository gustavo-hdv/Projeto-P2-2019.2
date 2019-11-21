package junitest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.Controller;

class testUS7 {

    private Controller controleGeral;

    public testUS7() {
        this.controleGeral = new Controller();
    }

    @Test
    void associaPesquisaAtividade() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertTrue(controleGeral.associaAtividade("COM1", "A1"));
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void associaPesquisaNullAtividade() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controleGeral.associaAtividade(null, "A1");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void associaPesquisaEmptyAtividade() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controleGeral.associaAtividade(" ", "A1");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void associaPesquisaAtividadeNull() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controleGeral.associaAtividade("COM1", null);
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void associaPesquisaAtividadeEmpty() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controleGeral.associaAtividade("COM1", " ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void desassociaAtividade() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertTrue(controleGeral.associaAtividade("COM1", "A1"));
        try {
            assertTrue(controleGeral.desassociaAtividade("COM1", "A1"));
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void desassociaAtividadeNull() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        assertTrue(controleGeral.associaAtividade("COM1", "A1"));
        try {
            controleGeral.desassociaAtividade(null, "A1");
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void desassociaAtividadeEmpty() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertTrue(controleGeral.associaAtividade("COM1", "A1"));
        try {
            controleGeral.desassociaAtividade(" ", "A1");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    void executaAtividade() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        controleGeral.cadastraItem("A1", "Fazer base de dados.");

        controleGeral.associaAtividade("COM1", "A1");

        controleGeral.executaAtividade("A1", 1, 10);

        try {
            assertEquals(controleGeral.contaItensRealizados("A1"), 1);
            assertEquals(controleGeral.getDuracao("A1"), 10);
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void executaAtividadeNull() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        controleGeral.cadastraItem("A1", "Fazer base de dados.");

        controleGeral.associaAtividade("COM1", "A1");

        try {
            controleGeral.executaAtividade(null, 1, 10);
            fail("Era esperado excecao");
        } catch (NullPointerException npe) {
        }
    }

    @Test
    void executaAtividadeEmpty() {
        controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        controleGeral.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        controleGeral.cadastraItem("A1", "Fazer base de dados.");

        controleGeral.associaAtividade("COM1", "A1");

        try {
            controleGeral.executaAtividade(" ", 1, 10);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException iae) {
        }
    }
}