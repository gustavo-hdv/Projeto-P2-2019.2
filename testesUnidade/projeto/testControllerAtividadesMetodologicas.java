package projeto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */
class testControllerAtividadesMetodologicas {

    private ControllerAtividadesMetodologicas controllerAtividadesMetodologicas = new ControllerAtividadesMetodologicas();

    @Test
    void cadastraAtividadeBasico() {
        try {
            controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void cadastraAtividadeParametrosNulos() {
        try {
            controllerAtividadesMetodologicas.cadastraAtividade(null, "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }

        try {
            controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", null, "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }

        try {
            controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void cadastraAtividadeParametrosVazios() {
        try {
            controllerAtividadesMetodologicas.cadastraAtividade("   ", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }

        try {
            controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "      ", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }

        try {
            controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "       ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraAtividadeRiscoInvalido() {
        try {
            controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "AAAAA", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void apagaAtividadeBasico() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.apagaAtividade("A1");
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void apagaAtividadeCodigoNulo() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.apagaAtividade(null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void apagaAtividadeCodigoVazio() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.apagaAtividade("   ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void apagaAtividadeCodigoInexistente() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.apagaAtividade("A2");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemBasico() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados colocados na planilha.");
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void cadastraItemCodigoAtividadeNulo() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.cadastraItem(null, "Dados colocados na planilha.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void cadastraItemCodigoAtividadeVazio() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.cadastraItem("   ", "Dados colocados na planilha.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemCodigoAtividadeInexistente() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.cadastraItem("A2", "Dados colocados na planilha.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemNulo() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.cadastraItem("A1", null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void cadastraItemVazio() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.cadastraItem("A1", "   ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemRepetido() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }


    @Test
    void exibeAtividadeCodigoNulo() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.exibeAtividade(null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void exibeAtividadeCodigoVazio() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.exibeAtividade("   ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void exibeAtividadeCodigoInexistente() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            controllerAtividadesMetodologicas.exibeAtividade("A2");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void exibeAtividadeSemItem() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        assertEquals(controllerAtividadesMetodologicas.exibeAtividade("A1"), "Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.)");
    }

    @Test
    void exibeAtividadeComUmItem() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");

        assertEquals("Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.) | PENDENTE - Dados reunidos da pesquisa reunidos com sucesso.", controllerAtividadesMetodologicas.exibeAtividade("A1"));
    }

    @Test
    void exibeAtividadeComMaisDeUmItem() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
        controllerAtividadesMetodologicas.cadastraItem("A1", "Dados colocados na planilha.");

        assertEquals("Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.) | PENDENTE - Dados reunidos da pesquisa reunidos com sucesso. | PENDENTE - Dados colocados na planilha.", controllerAtividadesMetodologicas.exibeAtividade("A1"));
    }

    @Test
    void verificaOrdemCodigosAtividades() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        assertEquals(controllerAtividadesMetodologicas.exibeAtividade("A1"), "Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.)");

        controllerAtividadesMetodologicas.cadastraAtividade("Pesquisar opinião da população.", "MEDIO", "Parte crucial da pesquisa.");

        assertEquals(controllerAtividadesMetodologicas.exibeAtividade("A2"), "Pesquisar opinião da população. (MEDIO - Parte crucial da pesquisa.)");
    }

    @Test
    void contaItensPendentes() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertEquals(controllerAtividadesMetodologicas.contaItensPendentes("A1"), 0);

        controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
        assertEquals(controllerAtividadesMetodologicas.contaItensPendentes("A1"), 1);
    }

    @Test
    void contaItensPendentesCodigoNulo() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(controllerAtividadesMetodologicas.contaItensPendentes(null), 0);

            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(controllerAtividadesMetodologicas.contaItensPendentes(null), 1);
            fail("Era espera excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void contaItensPendentesCodigoVazio() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(controllerAtividadesMetodologicas.contaItensPendentes("   "), 0);

            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(controllerAtividadesMetodologicas.contaItensPendentes("     "), 1);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void contaItensPendentesCodigoInexistente() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(controllerAtividadesMetodologicas.contaItensPendentes("A2"), 0);

            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(controllerAtividadesMetodologicas.contaItensPendentes("A2"), 1);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void contaItensRealizados() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertEquals(controllerAtividadesMetodologicas.contaItensRealizados("A1"), 0);

        controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
        assertEquals(controllerAtividadesMetodologicas.contaItensRealizados("A1"), 0);
    }

    @Test
    void contaItensRealizadosCodigoNulo() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(controllerAtividadesMetodologicas.contaItensRealizados(null), 0);

            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(controllerAtividadesMetodologicas.contaItensRealizados(null), 0);
            fail("Era espera excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void contaItensRealizadosCodigoVazio() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(controllerAtividadesMetodologicas.contaItensRealizados("   "), 0);

            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(controllerAtividadesMetodologicas.contaItensRealizados("     "), 0);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void contaItensRealizadosCodigoInexistente() {
        controllerAtividadesMetodologicas.cadastraAtividade("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            assertEquals(controllerAtividadesMetodologicas.contaItensRealizados("A2"), 0);

            controllerAtividadesMetodologicas.cadastraItem("A1", "Dados reunidos da pesquisa reunidos com sucesso.");
            assertEquals(controllerAtividadesMetodologicas.contaItensRealizados("A2"), 0);
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }
}