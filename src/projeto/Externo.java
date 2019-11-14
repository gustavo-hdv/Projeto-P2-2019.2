package projeto;

/**
 * Representacao de um Pesquisador Externo.
 *  
 */
public class Externo extends Especificacao{

	/**
	 * Controi um Pesquisador Externo.
	 * 
	 * @param nome eh o nome do Pesquisador Externo.
	 * @param funcao eh a funcao do Pesquisador Externo.
	 * @param biografia eh a biografia do Pesquisador Externo.
	 * @param email eh o email do do Pesquisador Externo.
	 * @param foto eh a foto do do Pesquisador Externo.
	 */
	public Externo(String nome, String funcao, String biografia, String email, String foto) {
		super(nome, funcao, biografia, email, foto);
	}

	/**
	 * Metodo que retorna a representacao em forma de String do Pesquisador Externo.
	 * Segue o formato: NOME (FUNÇÃO) - BIOGRAFIA - EMAIL - FOTO.
	 * 
	 * @return retorna a representacao em forma de String do Pesquisador Externo.
	 */
	@Override
	public String toString() {
		String msg = String.format("%s (%s) - %s - %s - %s", this.nome, this.funcao, this.biografia, this.email, this.foto);
		return msg;
	}
	
}
