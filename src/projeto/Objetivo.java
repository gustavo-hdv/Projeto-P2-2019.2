package projeto;

/**
 * Laboratório de Programação 2 - Projeto
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um Objetivo.

 * @author Marcos Silva

 */

public class Objetivo {
    /**
     * Código. Corresponde ao código do objetivo.
     */
    private String codigo;
    /**
     * Tipo. Corresponde ao tipo do objetivo. Pode ser GERAL ou ESPECIFICO.
     */
    private String tipo;
    /**
     * Descrição. Corresponde a descrição do objetivo.
     */
    private String descricao;
    /**
     * Valor. Corresponde ao valor do objetivo. É a soma da aderência e da viabilidade.
     */
    private int valor;

    /**
     * Constrói um objetivo a partir do seu código, do seu tipo, da sua descrição, da sua aderencia e da sua viabilidade.
     *

     * @param codigo código do objetivo
     * @param tipo tipo do objetivo
     * @param descricao a descrição do objetivo
     * @param aderencia a aderência do objetivo
     * @param viabilidade a viabilidade do objetivo
     */
    public Objetivo(String codigo, String tipo, String descricao, int aderencia, int viabilidade){
        Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validador.validaString(tipo, "Campo tipo nao pode ser nulo ou vazio.");
        Validador.validaTipo(tipo, "Valor invalido de tipo.");
        Validador.validaString(descricao, "Campo descricao nao pode ser nulo ou vazio.");
        Validador.validaValores(aderencia, "Valor invalido de aderencia");
        Validador.validaValores(viabilidade, "Valor invalido de viabilidade.");

        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = aderencia + viabilidade;
    }

    /**

     * Retorna o código do objetivo.

     *
     * @return uma String representando o código do objetivo.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**

     * Retorna a String que representa o Objetivo.

     *
     * @return uma String representando o Objetivo no formato "Código - Tipo - Descrição - Valor".
     */
    @Override
    public String toString() {
        return this.codigo + " - " + this.tipo + " - " + this.descricao + " - " + this.valor;
    }
}
