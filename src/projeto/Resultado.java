package projeto;

/**
 * Laboratório de Programação 2 - Projeto
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public class Resultado {

    private String descricao;

    public Resultado(String descricao){
        Validador.validaString(descricao, "Resultado nao pode ser nulo ou vazio.");
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
