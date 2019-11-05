package projeto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testAtividadeController {

    private AtividadeController atividadeController = new AtividadeController();

    @Test
    void cadastraAtividadeBasico() {
        try {
            atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void cadastraAtividadeParametrosNulos() {
        try {
            atividadeController.cadastraAtividade(null, "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }

        try {
            atividadeController.cadastraAtividade("Organizar dados da pesquisa.", null, "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }

        try {
            atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void cadastraAtividadeParametrosVazios() {
        try {
            atividadeController.cadastraAtividade("   ", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }

        try {
            atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "      ", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }

        try {
            atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "       ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraAtividadeRiscoInvalido() {
        try {
            atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "AAAAA", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void apagaAtividadeBasico() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.apagaAtividade("A1");
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void apagaAtividadeCodigoNulo() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.apagaAtividade(null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void apagaAtividadeCodigoVazio() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.apagaAtividade("   ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void apagaAtividadeCodigoInexistente() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.apagaAtividade("A2");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemBasico() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.cadastraItem("A1", "Dados colocados na planilha.");
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void cadastraItemCodigoAtividadeNulo() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.cadastraItem(null, "Dados colocados na planilha.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void cadastraItemCodigoAtividadeVazio() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.cadastraItem("   ", "Dados colocados na planilha.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemCodigoAtividadeInexistente() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.cadastraItem("A2", "Dados colocados na planilha.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemNulo() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.cadastraItem("A1", null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void cadastraItemVazio() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.cadastraItem("A1", "   ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemRepetido() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }


    @Test
    void exibeAtividadeCodigoNulo() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.exibeAtividade(null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void exibeAtividadeCodigoVazio() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.exibeAtividade("   ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void exibeAtividadeCodigoInexistente() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeController.exibeAtividade("A2");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void exibeAtividadeSemItem() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        assertEquals(atividadeController.exibeAtividade("A1"), "Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.)");
    }

    @Test
    void exibeAtividadeComUmItem() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");

        assertEquals("Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.) | PENDENTE - Dados reunidos da pesquisa reunidos com sucesso.", atividadeController.exibeAtividade("A1"));
    }

    @Test
    void exibeAtividadeComMaisDeUmItem() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
        atividadeController.cadastraItem("A1", "Dados colocados na planilha.");

        assertEquals("Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.) | PENDENTE - Dados reunidos da pesquisa reunidos com sucesso. | PENDENTE - Dados colocados na planilha.", atividadeController.exibeAtividade("A1"));
    }

    @Test
    void verificaOrdemCodigosAtividades() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        assertEquals(atividadeController.exibeAtividade("A1"), "Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.)");

        atividadeController.cadastraAtividade("Pesquisar opinião da população.", "MEDIO", "Parte crucial da pesquisa.");

        assertEquals(atividadeController.exibeAtividade("A2"), "Pesquisar opinião da população. (MEDIO - Parte crucial da pesquisa.)");
    }

    @Test
    void contaItensPendentes() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertEquals(atividadeController.contaItensPendentes("A1"), 0);

        atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
        assertEquals(atividadeController.contaItensPendentes("A1"), 1);
    }

    @Test
    void contaItensPendentesCodigoNulo() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(atividadeController.contaItensPendentes(null), 0);

            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(atividadeController.contaItensPendentes(null), 1);
            fail("Era espera excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void contaItensPendentesCodigoVazio() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(atividadeController.contaItensPendentes("   "), 0);

            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(atividadeController.contaItensPendentes("     "), 1);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void contaItensPendentesCodigoInexistente() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(atividadeController.contaItensPendentes("A2"), 0);

            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(atividadeController.contaItensPendentes("A2"), 1);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void contaItensRealizados() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertEquals(atividadeController.contaItensRealizados("A1"), 0);

        atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
        assertEquals(atividadeController.contaItensRealizados("A1"), 0);
    }

    @Test
    void contaItensRealizadosCodigoNulo() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(atividadeController.contaItensRealizados(null), 0);

            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(atividadeController.contaItensRealizados(null), 0);
            fail("Era espera excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void contaItensRealizadosCodigoVazio() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(atividadeController.contaItensRealizados("   "), 0);

            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(atividadeController.contaItensRealizados("     "), 0);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void contaItensRealizadosCodigoInexistente() {
        atividadeController.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(atividadeController.contaItensRealizados("A2"), 0);

            atividadeController.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(atividadeController.contaItensRealizados("A2"), 0);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }
}