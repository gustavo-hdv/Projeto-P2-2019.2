package entidades;

import java.io.Serializable;

public class Resultado implements Serializable {

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
