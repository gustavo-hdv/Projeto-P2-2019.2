package entidades;

/**
 * Representacao de um Problema.
 */
public class Problema implements Buscavel {
    /**
     * Codigo. Corresponde ao codigo do problema.
     */
    private String codigo;
    /**
     * Descricao. Corresponde a descricao do problema.
     */
    private String descricao;
    /**
     * Viabilidade. Corresponde a viabilidade do problema.
     */
    private int viabilidade;

    /**
     * Constroi um problema a partir do seu codigo, da sua descricao e da sua viabilidade.
     *

     * @param codigo codigo do problema
     * @param descricao a descricao do problema
     * @param viabilidade a viabilidade do problema
     */
    public Problema(String codigo, String descricao, int viabilidade){
        Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validador.validaString(descricao, "Campo descricao nao pode ser nulo ou vazio.");
        Validador.validaValores(viabilidade, "Valor invalido de viabilidade.");

        this.codigo = codigo;
        this.descricao = descricao;
        this.viabilidade = viabilidade;
    }

    /**
     * Retorna o codigo do problema.
     *
     * @return uma String representando o codigo do problema.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**

     * Retorna a String que representa o Problema.
     *
     * @return uma String representando o Problema no formato "Codigo - Descricao - Viabilidade".
     */
    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao + " - " + this.viabilidade;
    }

	@Override
	public boolean contemTermo(String termo) {
		if (this.descricao.contains(termo)) return true;
		return false;
	}

	@Override
	public String exibeRepresentacaoBusca() {
		return String.format("%s: %s", this.codigo, this.descricao);
	}
}
