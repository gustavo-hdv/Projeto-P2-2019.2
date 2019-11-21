package entidades;

import java.io.Serializable;

/**
 * Representacao da ESpecificacao daquele Pesquisador.
 */
public abstract class Especificacao implements Serializable {
	
	/**
	 * O nome do Pesquisador.
	 */
	protected String nome;
	
	/**
	 * A funcao do Pesquisador.
	 */
	protected String funcao;
	
	/**
	 * A biografia do Pesquisador.
	 */
	protected String biografia;
	
	/**
	 * O email do Pesquisador.
	 */
	protected String email;
	
	/**
	 * A foto do Pesquisador.
	 */
	protected String foto;

	/**
	 * Constroi uma especificacao do Pesquisador.
	 * 
	 * @param nome nome do Pesquisador.
	 * @param funcao funcao do Pesquisador.
	 * @param biografia biografia do Pesquisador.
	 * @param email email do Pesquisador.
	 * @param foto foto do Pesquisador.
	 */
	public Especificacao(String nome, String funcao, String biografia, String email, String foto) {
		this.nome = nome;
		this.funcao = funcao;
		this.biografia = biografia;
		this.email = email;
		this.foto = foto;
	}
	
	/**
	 * Metodo que retorna a representacao em forma de String de determinada especificacao, 
	 * pondendo ser aluno, professor ou externo.
	 */
	public abstract String toString();
}