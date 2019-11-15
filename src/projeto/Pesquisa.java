package projeto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Representacao de uma pesquisa cientifica, segue o metodo
 * cientifico para a construcao de um novo entendimento, compreensao ou
 * processo.
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
	 * Mapa de atividades associadas.
	 */
	private Map<String, AtividadeMetodologica> atividadesAssociadas;


	/**
	 * Objetivos da Pesquisa.
	 */
	private Map<String, Objetivo> objetivos;

	/**
	 * Constroi uma Pesquisa, a partir do seu codigo, descricao e campo de
	 * interesse.
	 * 
	 * @param codigo           codigo que identifica a Pesquisa.
	 * @param descricao        descricao da Pesquisa.
	 * @param campoDeInteresse campo de interesse da Pesquisa.
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
		this.atividadesAssociadas = new LinkedHashMap<String, AtividadeMetodologica>();
		this.problema = null;
		this.objetivos = new LinkedHashMap<String, Objetivo>();
	}
	
	/** Representacao do resumo de uma pesquisa
	 *  Estilo: Problema: \n listagem dos problemas
	 *          Objetivos: \n listagem dos objetivos
	 *          Atividades: \n listagem das atividades
	 *          
	 *  @return resumo da pesquisa
	 */
	public String exibeResumoPesquisa() {
		String problema = "\t- Problema: " + System.lineSeparator();
		problema += (this.problema == null)?"":"\t\t" + this.problema.toString() + System.lineSeparator();
		String objetivos = "\t- Objetivos: " + System.lineSeparator();
		objetivos += exibeObjetivos();
		String atividades = "\t- Atividades: " + System.lineSeparator();
		atividades += exibeAtividades();
		
		return problema + objetivos + atividades;
	}
	
	/** Exibe as atividades da pesquisa 
	 * 
	 * @return atividades da pesquisa
	 */
	private String exibeAtividades() {
		String resumoAtividades = "";
		for (Map.Entry<String, AtividadeMetodologica> atividades : this.atividadesAssociadas.entrySet()) {
			resumoAtividades += "\t\t- " + atividades.getValue().toString() + System.lineSeparator();
			resumoAtividades += atividades.getValue().exibeItensEstado();
		}
		return resumoAtividades;
	}
	
	/** Exibe os resultados da pesquisa 
	 * 
	 * @return resultados da pesquisa
	 */
	public String exibeResultadosPesquisa() {
		String resultadosAtividades = "";
		for (Map.Entry<String, AtividadeMetodologica> atividades : this.atividadesAssociadas.entrySet()) {
			resultadosAtividades += "\t\t- " + atividades.getValue().toString() + System.lineSeparator();
			resultadosAtividades += atividades.getValue().exibeItensDuracao();
			resultadosAtividades += atividades.getValue().exibeResultados();
		}
		return resultadosAtividades;
	}
	
	/** Exibe os objetivos da pesquisa
	 * 
	 * @return objetivos da pesquisa
	 */
	private String exibeObjetivos() {
		String resumoObjetivos = "";
		for (Map.Entry<String, Objetivo> objetivos : this.objetivos.entrySet()) {
			resumoObjetivos += "\t\t" + objetivos.getValue().toString() + System.lineSeparator();
		}
		return resumoObjetivos;
	}

	/**
	 * Associa um problema para a pesquisa
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
		if (!this.problema.equals(problema)) {
			throw new IllegalArgumentException("Pesquisa ja associada a um problema.");
		}
		return false;
	}

	/**
	 * Desassocia um problema da a pesquisa
	 * 
	 * @param problema Um objeto problema
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean desassociaProblema() {
		if (this.problema == null) {
			return false;
		}
		this.problema = null;
		return true;
	}

	/**
	 * Associa um objetivo para a pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param objetivo   Objetivo da pesquisa
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaObjetivo(String idObjetivo, Objetivo objetivo) {
		Validador.validaString(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		if (objetivo == null) {
			throw new IllegalArgumentException("Objetivo nao pode ser nulo.");
		}
		if (!this.objetivos.containsKey(idObjetivo) || this.objetivos.get(idObjetivo) == null) {
			this.objetivos.put(idObjetivo, objetivo);
			return true;
		}
		return false;
	}

	/**
	 * Desassocia um objetivo da pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param objetivo   Objetivo da pesquisa
	 * 
	 * @return boolean (true para desassociado com sucesso, false para nao
	 *         desassociado)
	 */
	public boolean desassociaObjetivo(String idObjetivo, Objetivo objetivo) {
		Validador.validaString(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		if (!this.objetivos.containsKey(idObjetivo)) {
			return false;
		}
		if (!this.objetivos.get(idObjetivo).equals(objetivo)) {
			return false;
		}
		this.objetivos.remove(idObjetivo);
		return true;
	}

	/**
	 * Verifica se a pesquisa possui determinado objetivo
	 * 
	 * @param idObjetivo identificar o objetivo
	 * @param objetivo   objeto a ser verificado
	 * 
	 * @return boolean (possui ou nao possui o objetivo)
	 */
	public boolean containsObjetivo(String idObjetivo) {
		Validador.validaString(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		return this.objetivos.containsKey(idObjetivo);
	}

	/**
	 * Metodo Set que altera a descricao da Pesquisa.
	 * 
	 * @param descricao descricao da Pesquisa.
	 */
	public void setDescricao(String descricao) {
		Validador.validaString(descricao, "Descricao nao pode ser nula ou vazia.");
		this.descricao = descricao;
	}

	/**
	 * Metodo Set que altera o campo de interesse da Pesquisa.
	 * 
	 * @param campoDeInteresse campo de interesse da pesquisa.
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

	public boolean associaAtividade(String codigoAtividade, AtividadeMetodologica atividade) {
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if(atividade == null){
			throw new NullPointerException("Atividade nao encontrada");
		}

		if (this.atividadesAssociadas.containsKey(codigoAtividade)) {
			return false;
		}

		this.atividadesAssociadas.put(codigoAtividade, atividade);

		return true;
	}

	public boolean desassociaAtividade(String codigoAtividade) {
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");

		if (!this.atividadesAssociadas.containsKey(codigoAtividade)) {
			return false;
		}

		this.atividadesAssociadas.remove(codigoAtividade);

		return true;
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
	 * @return um valor booleano indicando se os objetos são iguais ou não, mediante
	 *         o seus codigos.
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

	public boolean contemTermo(String termo) {
		if ((this.descricao.contains(termo)) || (this.campoDeInteresse.contains(termo)))
			return true;
		return false;
	}

	public List<String> exibeRepresentacoesBusca() {
		List<String> mensagens = new ArrayList<>();
		mensagens.add(String.format("%s: %s", this.codigo, this.descricao));
		mensagens.add(String.format("%s: %s", this.codigo, this.campoDeInteresse));
		return mensagens;
	}

	/** Retorna o codigo da pesquisa 
	 * 
	 * @return codigo da pesquisa
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/** Retorna o problema da pesquisa
	 * 
	 * @return problema da pesquisa (objeto Problema)
	 */
	public Problema getProblema() {
		return this.problema;
	}

	public String getObjetivoIdMaior() {
		if (this.objetivos.size() == 0) {
			return null;
		}
		String maiorID = null;
		for (Map.Entry<String, Objetivo> CodigoObjetivo : this.objetivos.entrySet()) {
			if (maiorID.compareTo(CodigoObjetivo.getValue().getCodigo()) == -1) {
				maiorID = CodigoObjetivo.getValue().getCodigo();
			}
		}
		return maiorID;
	}

	public int quantidadeObjetivos() {
		return this.objetivos.size();
	}

	public String proximaAtividade(Estrategia estrategia) {
		return estrategia.sugestao(this.atividadesAssociadas.values());
	}

	public AtividadeMetodologica getAtividadeAssociada(String codigoAtividade) {
		return this.atividadesAssociadas.get(codigoAtividade);
	}
}
