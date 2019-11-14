package projeto;

/**
 * Representacao de um Professor.
 */
public class Professor extends Especificacao {

	/**
	 * A formacao do Professor.
	 */
	protected String formacao;
	
	/**
	 * A unidade do professor.
	 */
	protected String unidade;
	
	/**
	 * A data em que o professor foi cadastrado.
	 */
	protected String data;

	/**
	 * Controi um professor
	 * 
	 * @param nome eh o nome do professor.
	 * @param funcao eh a funcao, que eh professor.
	 * @param biografia eh a biografia do professor.
	 * @param email eh o email do professor.
	 * @param foto eh a foto do professor.
	 * @param formacao eh a formcao do professor.
	 * @param unidade eh a unidade do professor.
	 * @param data eh a data em que o professor foi contratado.
	 */
	public Professor(String nome, String funcao, String biografia, String email, String foto, String formacao,
			String unidade, String data) {
		super(nome, funcao, biografia, email, foto);
		this.formacao = formacao;
		this.unidade = unidade;
		this.data = data;
	}

	/**
	 * Metodo que retorna a formacao do professor.
	 * 
	 * @return retorna a formacao do professor.
	 */
	public String getFormacao() {
		return formacao;
	}

	/**
	 * Metodo que retorna a Unidade do professor.
	 * 
	 * @return retorna a Unidade do professor.
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * Metodo que retorna a data em que o professor foi contratado.
	 * 
	 * @return retorna a data em que o professor foi contratado.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Metodo que altera a formacao do professor.
	 * 
	 * @param formacao eh a formacao do professor.
	 */
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	/**
	 * Metodo que altera a unidade do professor.
	 *  
	 * @param unidade eh a unidade do professor.
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	/**
	 * Metodo que altera a data em que o professor foi contratado.
	 * 
	 * @param data a data em que o professor foi contratado.
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Metodo que retorna a representacao em forma de String do professor.
	 * Segue o formato: NOME (FUNÇÃO) - BIOGRAFIA - EMAIL - FOTO - FORMCAO - UNIDADE - DATA.
	 * 
	 * @return retorna a representacao em forma de String do professor.
	 */
	@Override
	public String toString() {
		return this.nome + " (" + this.funcao + ") - " + this.biografia + " - " + this.email + " - " + this.foto + " - "
				+ this.formacao + " - " + this.unidade + " - " + this.data;
	}
}