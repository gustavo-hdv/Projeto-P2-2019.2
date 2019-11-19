package entidades;

/**
 * Representacao de um Objetivo.
 */

public class Objetivo implements Buscavel {
    /**
     * Codigo. Corresponde ao codigo do objetivo.
     */
    private String codigo;
    /**
     * Tipo. Corresponde ao tipo do objetivo. Pode ser GERAL ou ESPECIFICO.
     */
    private String tipo;
    /**
     * Descricao. Corresponde a descricao do objetivo.
     */
    private String descricao;
    /**
     * Valor. Corresponde ao valor do objetivo. É a soma da aderência e da viabilidade.
     */
    private int valor;

    /**
     * Constroi um objetivo a partir do seu codigo, do seu tipo, da sua descricao, da sua aderencia e da sua viabilidade.
     *
     * @param codigo codigo do objetivo
     * @param tipo tipo do objetivo
     * @param descricao a descricao do objetivo
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
     * Retorna o codigo do objetivo.
     *
     * @return uma String representando o codigo do objetivo.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Retorna a String que representa o Objetivo.
     *
     * @return uma String representando o Objetivo no formato "Codigo - Tipo - Descricao - Valor".
     */
    @Override
    public String toString() {
        return this.codigo + " - " + this.tipo + " - " + this.descricao + " - " + this.valor;
    }
    
    public boolean contemTermo(String termo) {
		if (this.descricao.contains(termo)) return true;
		return false;
	}
    
    public String exibeRepresentacaoBusca() {
		return String.format("%s: %s", this.codigo, this.descricao);
	}
}
