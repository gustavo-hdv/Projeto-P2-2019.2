package junitest;

import static org.junit.jupiter.api.Assertions.*;
import controllers.Controller;
import org.junit.jupiter.api.Test;

public class testUS12 {
    private Controller controleGeral;

    public testUS12() {
        this.controleGeral = new Controller();
    }

    @Test
    void salvar(){
        this.controleGeral.cadastraPesquisa("Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
        assertEquals(this.controleGeral.exibePesquisa("COM1"), "COM1 - Homofobia em mensagens online de alunos de computacao do primeiro periodo. - computacao, homofobia");
        this.controleGeral.salvar();
    }

    @Test
    void carregar(){
        this.controleGeral = new Controller();
        assertThrows(IllegalArgumentException.class, () -> this.controleGeral.exibePesquisa("COM1"), "Pesquisa nao encontrada.");
        this.controleGeral.carregar();
        assertEquals(this.controleGeral.exibePesquisa("COM1"), "COM1 - Homofobia em mensagens online de alunos de computacao do primeiro periodo. - computacao, homofobia");
    }
}
