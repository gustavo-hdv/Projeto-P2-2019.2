package projeto;

/** 
 * Representacao de uma atividade metodologica
 */

import java.util.List;
import java.util.ArrayList;

public class AtividadeMetodologica {

	/** Descricao */
	private String descricao;
	/** Nivel de risco */
	private String nivelRisco;
	/** Descricao do risco */
	private String descricaoRisco;
	/** Codigo de identificacao da atividade metodologica */
	private String codigo;
	/** Duracao de execucao da atividade */
	private int duracaoExecucao;
	/** Lista de resultados com os itens cadastrados */
	private List<Item> resultados;
	/** Lista dos resultados obtidos com descricao */
	private List<Resultado> resultadosObtidos;

	/**
	 * Eh a atividade Subsequente a essa.
	 */
	private String subsequente;

	/**
	 * Construtor da atividade metodologica com descricao, nivel de risco e uma
	 * descricao de risco
	 * 
	 * @param descricao      (descricao da atividade) (String)
	 * @param nivelRisco     (nivel de risco da atividade) (String)
	 * @param descricaoRisco (descricao de risco da atividade) (String)
	 */
	public AtividadeMetodologica(String descricao, String nivelRisco, String descricaoRisco, String codigo) {
		Validador.validaString(descricao, "Campo Descricao nao pode ser nulo ou vazio.");
		Validador.validaString(nivelRisco, "Campo nivelRisco nao pode ser nulo ou vazio.");
		Validador.validaString(descricaoRisco, "Campo descricaoRisco nao pode ser nulo ou vazio.");
		if (!(nivelRisco.equalsIgnoreCase("BAIXO") || nivelRisco.equalsIgnoreCase("MEDIO")
				|| nivelRisco.equalsIgnoreCase("ALTO"))) {
			throw new IllegalArgumentException("Valor invalido do nivel do risco.");
		}

		this.descricao = descricao;
		this.nivelRisco = nivelRisco;
		this.descricaoRisco = descricaoRisco;
		this.codigo = codigo;
		this.duracaoExecucao = 0;
		this.resultados = new ArrayList<Item>();
		this.resultadosObtidos = new ArrayList<Resultado>();
		this.subsequente = "";
	}

	/**
	 * Cadastra um item para a atividade
	 * 
	 * @param item (descricao do item) (String)
	 */
	public void cadastraItem(String item) {
		Validador.validaString(item, "Item nao pode ser nulo ou vazio.");

		Item itemObject = new Item(item);
		if (resultados.contains(itemObject)) {
			throw new IllegalArgumentException("Item ja cadastrado");
		}
		this.resultados.add(itemObject);
	}

	/**
	 * Exibe a quantidade de itens pendentes dos resultados
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes() {
		int itensPendentes = 0;
		for (Item item : resultados) {
			if (item.exibeEstado().equals("PENDENTE")) {
				itensPendentes += 1;
			}
		}
		return itensPendentes;
	}

	/**
	 * Exibe a quantidade de itens realizados dos resultados de um atividade
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados() {
		int itensRealizados = 0;
		for (Item item : resultados) {
			if (item.exibeEstado().equals("REALIZADO")) {
				itensRealizados += 1;
			}
		}
		return itensRealizados;
	}

	/**
	 * Exibe a atividade no estilo: DESCRICAO (NIVEL_RISCO - DESC_RISCO) | REALIZADO
	 * - ITEM1 | REALIZADO - ITEM2 | PENDENTE - ITEM3
	 * 
	 * @return representacao de uma ativdade (String)
	 */
	public String exibeAtividade() {
		String toString = this.descricao + " (" + this.nivelRisco + " - " + this.descricaoRisco + ")";
		if (resultados.size() == 0) {
			return toString;
		}
		toString += " | ";
		for (int i = 0; i < resultados.size(); i++) {
			if (i != 0)
				toString += " | ";
			toString += resultados.get(i).exibeItem();
		}
		return toString;
	}

	/**
	 * Exibe a atividade no estilo: DESCRICAO (NIVEL_RISCO - DESC_RISCO)
	 * 
	 * @return representacao de uma atividade
	 */
	public String toString() {
		return this.descricao + " (" + this.nivelRisco + " - " + this.descricaoRisco + ")";
	}

	/**
	 * Exibe os itens dos resultados da atividade Estilo: " - Estado do item -
	 * Descricao do item" \n ...
	 * 
	 * @return representacao de todos os itens dos resultados
	 */
	public String exibeItensEstado() {
		String resumoItens = "";
		for (int i = 0; i < this.resultados.size(); i++) {
			resumoItens += "\t\t\t- " + this.resultados.get(i).exibeEstado() + " - ITEM" + (i + 1);
			if (i != this.resultados.size()) {
				resumoItens += System.lineSeparator();
			}
		}
		return resumoItens;
	}

	/**
	 * Exibe os itens dos resultados da atividade e a duracao Estilo: ITEM(id) -
	 * Duracao \n ...
	 * 
	 * @return representacao de todos os itens dos resultados
	 */
	public String exibeItensDuracao() {
		String itensDuracao = "";
		for (int i = 0; i < this.resultados.size(); i++) {
			itensDuracao += "\t\t\t- " + "ITEM" + (i + 1) + " - " + ((int) Math.ceil((float) this.duracaoExecucao / (float) this.resultados.size()));
			if (i != this.resultados.size()) {
				itensDuracao += System.lineSeparator();
			}
		}
		return itensDuracao;
	}

	/**
	 * Exibe a descricao da atividade
	 * 
	 * @return descricao da atividade
	 */
	public String exibeDescricao() {
		return this.descricao;
	}

	/**
	 * Exibe os resultados obtidos da atividade Estilo: descricao dos resultados
	 * obtidoss \n ...
	 * 
	 * @return representacao dos resultados obtidos
	 */
	public String exibeResultados() {
		String resultados = "";
		for (int i = 0; i < this.resultadosObtidos.size(); i++) {
			resultados += "\t\t\t- " + this.resultadosObtidos.get(i).toString();
			if (i != this.resultadosObtidos.size()) {
				resultados += System.lineSeparator();
			}
		}
		return resultados;
	}

	public boolean contemTermo(String termo) {
		if ((this.descricao.contains(termo)) || (this.descricaoRisco.contains(termo)))
			return true;
		return false;
	}

	public List<String> exibeRepresentacoesBusca() {
		List<String> mensagens = new ArrayList<>();
		mensagens.add(String.format("%s: %s", this.codigo, this.descricao));
		mensagens.add(String.format("%s: %s", this.codigo, this.descricaoRisco));
		return mensagens;
	}

	public void registrarDuracao(int duracao) {
		Validador.validaValoresNegativos(duracao, "Duracao nao pode ser nula ou negativa.");
		this.duracaoExecucao += duracao;
	}

	public void realizarItem(int posItem) {
		Validador.validaValoresNegativos(posItem, "Item nao pode ser nulo ou negativo.");

		if (posItem > this.resultados.size()) {
			throw new IndexOutOfBoundsException("Item nao encontrado.");
		}

		Item item = this.resultados.get(posItem - 1);

		if (item.exibeEstado().equals("REALIZADO")) {
			throw new IllegalArgumentException("Item ja executado.");
		}

		item.alteraEstado();
	}

	public int cadastraResultado(String resultado) {
		Validador.validaString(resultado, "Resultado nao pode ser nulo ou vazio.");

		this.resultadosObtidos.add(new Resultado(resultado));

		return this.resultadosObtidos.size();
	}

	public boolean removeResultado(int numeroResultado) {
		Validador.validaValoresNegativos(numeroResultado, "numeroResultado nao pode ser nulo ou negativo.");

		if (numeroResultado > this.resultadosObtidos.size()) {
			throw new IndexOutOfBoundsException("Resultado nao encontrado.");
		}

		this.resultadosObtidos.remove(numeroResultado - 1);

		return true;
	}

	public String listaResultados() {
		String str = "";

		for (Resultado resultado : this.resultadosObtidos) {
			str += resultado.toString() + " | ";
		}

		int index = str.trim().lastIndexOf("|");

		if (index == -1) {
			return str.trim();
		}

		return str.trim().substring(0, index - 1);
	}

	public int getDuracao() {
		return this.duracaoExecucao;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getRisco() {
		return this.nivelRisco;
	}

	/**
	 * GABRIEL
	 */
	public void defineProximaAtividade(String idSubsequente) {
		this.subsequente = idSubsequente;
	}

	/**
	 * GABRIEL
	 */
	public void tiraProximaAtividade() {
		this.subsequente = "";
	}

	/**
	 * GABRIEL
	 * 
	 * @return
	 */
	public String getSubsequente() {
		return subsequente;
	}

}
