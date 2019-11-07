package projeto;

import java.util.Arrays;
import java.util.List;

/**
 * Representacao de uma pesquisa científica, que eh aquela que segue o metodo
 * cientifico para a construcao de um novo entendimento, compreensao ou
 * processo.
 * 
 * @author Gabriel Menezes Cabral - 119110372
 *
 */
public class Pesquisa {

	/**
	 * Codigo que identifica uma Pesquisa.
	 */
	private String codigo;

	/**
	 * Descricao de uma Pesquisa.
	 */
	private String descricao;

	/**
	 * Campo de Interesse de uma Pesquisa.
	 */
	private String campoDeInteresse;

	/**
	 * Problema da Pesquisa.
	 */
	private Problema problema;
	
	/**
	 * Constroi uma Pesquisa, a partir do seu codigo, descricao e campo de
	 * interesse.
	 * 
	 * @param codigo           eh o codigo que identifica a Pesquisa.
	 * @param descricao        eh a descricao da Pesquisa.
	 * @param campoDeInteresse eh o campo de interesse da Pesquisa.
	 */
	public Pesquisa(String codigo, String descricao, String campoDeInteresse) {
		Validador.validaString(codigo, "Codigo nao pode ser nula ou vazia.");
		Validador.validaString(descricao, "Descricao nao pode ser nula ou vazia.");
		Validador.validaString(campoDeInteresse, "Formato do campo de interesse invalido");
		if (campoDeInteresse.length() > 255) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		if (descricao.length() > 255) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		if (campoDeInteresse.length() < 3) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		for (int i = 0; i < campoDeInteresse.length(); i++) {
			if (campoDeInteresse.length() - campoDeInteresse.replaceAll(",", "").length() > 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
		List<String> camposDeInteresse = Arrays.asList(campoDeInteresse.split(","));
		for (int i = 0; i < camposDeInteresse.size(); i++) {
			if (camposDeInteresse.get(i).length() < 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
		this.codigo = codigo;
		this.descricao = descricao;
		this.campoDeInteresse = campoDeInteresse;
		this.problema = null;
	}

	/** Associa um problema para a pesquisa 
	 * 
	 * @param problema Um objeto problema 
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaProblema(Problema problema) {
		if (problema == null) {
			return false;
		}
		if (this.problema == null) {
			this.problema = problema;
			return true;
		}
		if (this.problema.equals(problema)) {
			return false;
		} else {
			throw new IllegalArgumentException("Pesquisa ja associada a um problema.");
		}
	}
	
	/** Desassocia um problema da a pesquisa 
	 * 
	 * @param problema Um objeto problema 
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean desassociaProblema(Problema problema) {
		if (problema == null) {
			return false;
		}
		if (this.problema == null) {
			return false;
		}
		if (!this.problema.equals(problema)) {
			return false;
		}
		this.problema = null;
		return true;
	}
	
	/**
	 * Metodo Set que altera a descricao da Pesquisa.
	 * 
	 * @param descricao eh a descricao da Pesquisa.
	 */
	public void setDescricao(String descricao) {
		Validador.validaString(descricao, "Descricao nao pode ser nula ou vazia.");
		this.descricao = descricao;
	}

	/**
	 * Metodo Set que altera o campo de interesse da Pesquisa.
	 * 
	 * @param campoDeInteresse eh o campo de interesse da pesquisa.
	 */
	public void setCampoDeInteresse(String campoDeInteresse) {
		Validador.validaString(campoDeInteresse, "Formato do campo de interesse invalido.");
		if (campoDeInteresse.length() > 255) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		if (campoDeInteresse.contains(", ,")) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		if (campoDeInteresse.length() < 3) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		for (int i = 0; i < campoDeInteresse.length(); i++) {
			if (campoDeInteresse.length() - campoDeInteresse.replaceAll(",", "").length() > 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
		if (campoDeInteresse.contains(",,")) {
			throw new IllegalArgumentException("Formato de campo de interesse invalido.");
		}
		this.campoDeInteresse = campoDeInteresse;
	}

	/**
	 * Gera um inteiro que representa o hashCode da pesquisa a partir do seu codigo.
	 * 
	 * @return o inteiro que representa o HashCode da Pesquisa.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * Metodo Equals que compara um objeto com outro a partir do seu codigo.
	 * 
	 * @param obj eh o objeto a ser comparado.
	 * @return um valor booleano indicando se os objetos são iguais ou não,
	 *         mediante o seus codigos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pesquisa other = (Pesquisa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/**
	 * Retorna a String que representa uma Pesquisa. A representacao segue o formato
	 * "CODIGO - DESCRICAO - CAMPO DE INTERESSE".
	 * 
	 * @return String que representa a Pesquisa.
	 */
	@Override
	public String toString() {
		return this.codigo + " - " + this.descricao + " - " + this.campoDeInteresse;
	}

}
