package entidades;

/**
 * Representacao de um Pesquisador Externo.
 *  
 */
public class Externo extends Especificacao{

	/**
	 * Controi um Pesquisador Externo.
	 * 
	 * @param nome nome do Pesquisador Externo.
	 * @param funcao funcao do Pesquisador Externo.
	 * @param biografia biografia do Pesquisador Externo.
	 * @param email email do Pesquisador Externo.
	 * @param foto foto do Pesquisador Externo.
	 */
	public Externo(String nome, String funcao, String biografia, String email, String foto) {
		super(nome, funcao, biografia, email, foto);
	}

	/**
	 * Metodo que retorna a representacao em forma de String do Pesquisador Externo.
	 * Segue o formato: NOME (FUNCAO) - BIOGRAFIA - EMAIL - FOTO.
	 * 
	 * @return retorna a representacao em forma de String do Pesquisador Externo.
	 */
	@Override
	public String toString() {
		String msg = String.format("%s (%s) - %s - %s - %s", this.nome, this.funcao, this.biografia, this.email, this.foto);
		return msg;
	}
	
}
