package projeto;

/**
 * Laboratório de Programação 2 - Projeto
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um Problema.

 * @author Marcos Silva

 */
public class Problema {
    /**
     * Código. Corresponde ao código do problema.
     */
    private String codigo;
    /**
     * Descrição. Corresponde a descrição do problema.
     */
    private String descricao;
    /**
     * Viabilidade. Corresponde a viabilidade do problema.
     */
    private int viabilidade;

    /**
     * Constrói um problema a partir do seu código, da sua descrição e da sua viabilidade.
     *

     * @param codigo código do problema
     * @param descricao a descrição do problema
     * @param viabilidade a viabilidade do problema
     */
    public Problema(String codigo, String descricao, int viabilidade){
        ValidadorProblemaObjetivo.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        ValidadorProblemaObjetivo.validaString(descricao, "Campo descricao nao pode ser nulo ou vazio.");
        ValidadorProblemaObjetivo.validaValores(viabilidade, "Valor invalido de viabilidade.");

        this.codigo = codigo;
        this.descricao = descricao;
        this.viabilidade = viabilidade;
    }

    /**

     * Retorna o código do problema.

     *
     * @return uma String representando o código do problema.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**

     * Retorna a String que representa o Problema.

     *
     * @return uma String representando o Problema no formato "Código - Descrição - Viabilidade".
     */
    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao + " - " + this.viabilidade;
    }
}
