package projeto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testAtividadeMetodologica {

    @Test
    void constructAtividadeBasico(){
        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        } catch (Exception e) {
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void constructAtividadeParametrosNulos(){
        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica(null, "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }

        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", null, "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }

        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void constructAtividadeParametrosVazios(){
        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("  ", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }

        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "     ", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }

        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "        ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void constructAtividadeRiscoInvalido(){
        try {
            AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "AAAA", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemBasico() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try{
            atividadeMetodologica.cadastraItem("Dados reunidos da pesquisa reunidos com sucesso.");
        }catch (Exception e){
            fail("Nao era esperado excecao");
        }
    }

    @Test
    void cadastraItemNulo() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeMetodologica.cadastraItem(null);
            fail("Era esperado excecao");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void cadastraItemVazio() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeMetodologica.cadastraItem("  ");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void cadastraItemRepetido() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        try {
            atividadeMetodologica.cadastraItem("Dados reunidos da pesquisa reunidos com sucesso.");
            atividadeMetodologica.cadastraItem("Dados reunidos da pesquisa reunidos com sucesso.");
            fail("Era esperado excecao");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void contaItensPendentes() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertEquals(atividadeMetodologica.contaItensPendentes(), 0);

        atividadeMetodologica.cadastraItem("Dados reunidos da pesquisa reunidos com sucesso.");
        assertEquals(atividadeMetodologica.contaItensPendentes(), 1);
    }

    @Test
    void contaItensRealizados() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");
        assertEquals(atividadeMetodologica.contaItensRealizados(), 0);

        atividadeMetodologica.cadastraItem("Dados reunidos da pesquisa reunidos com sucesso.");
        assertEquals(atividadeMetodologica.contaItensRealizados(), 0);
    }

    @Test
    void exibeAtividadeSemItem() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        assertEquals(atividadeMetodologica.exibeAtividade(), "Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.)");
    }

    @Test
    void exibeAtividadeComUmItem() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        atividadeMetodologica.cadastraItem("Dados reunidos da pesquisa reunidos com sucesso.");

        assertEquals("Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.) | PENDENTE - Dados reunidos da pesquisa reunidos com sucesso.", atividadeMetodologica.exibeAtividade());
    }

    @Test
    void exibeAtividadeComMaisDeUmItem() {
        AtividadeMetodologica atividadeMetodologica = new AtividadeMetodologica("Organizar dados da pesquisa.", "MEDIO", "Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.");

        atividadeMetodologica.cadastraItem("Dados reunidos da pesquisa reunidos com sucesso.");
        atividadeMetodologica.cadastraItem("Dados colocados na planilha.");

        assertEquals("Organizar dados da pesquisa. (MEDIO - Caso não seja feita a organização, irá dificultar o desenvolvimento da pesquisa.) | PENDENTE - Dados reunidos da pesquisa reunidos com sucesso. | PENDENTE - Dados colocados na planilha.", atividadeMetodologica.exibeAtividade());
    }
}