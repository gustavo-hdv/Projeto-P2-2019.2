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
	/** Lista de resultados com os itens cadastrados */
	private List<Item> resultados;

	private String codigo;

	private int duracaoExecucao;

	private List<Resultado> resultadosObtidos;

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
		this.resultados = new ArrayList<>();
		this.codigo = codigo;
		this.duracaoExecucao = 0;
		this.resultadosObtidos = new ArrayList<>();
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
	 * Exibe a atividade no estilo: DESCRIÇÃO (NIVEL_RISCO - DESC_RISCO) | REALIZADO
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
	
	/** Exibe a atividade no estilo:
	 *  DESCRIÇÃO (NIVEL_RISCO - DESC_RISCO)
	 *  
	 *  @return representacao de uma atividade
	 */
	public String toString() {
		return this.descricao + " (" + this.nivelRisco + " - " + this.descricaoRisco + ")";
	}
	
	public String exibeItens() {
		String resumoItens = "";
		for(Item itens : this.resultados) {
			resumoItens += "\t\t\t-" + itens.exibeItem() + System.lineSeparator();
		}
		return resumoItens;
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

	public void registrarDuracao(int duracao){
		Validador.validaValoresNegativos(duracao, "Duracao nao pode ser nula ou negativa.");
		this.duracaoExecucao += duracao;
	}

	public void realizarItem(int posItem){
		Validador.validaValoresNegativos(posItem, "Item nao pode ser nulo ou negativo.");

		if(posItem > this.resultados.size()){
			throw new IndexOutOfBoundsException("Item nao encontrado.");
		}

		Item item = this.resultados.get(posItem-1);

		if(item.exibeEstado().equals("REALIZADO")){
			throw new IllegalArgumentException("Item ja executado.");
		}

		item.alteraEstado();
	}

	public int cadastraResultado(String resultado){
		Validador.validaString(resultado, "Resultado nao pode ser nulo ou vazio.");

		this.resultadosObtidos.add(new Resultado(resultado));

		return this.resultadosObtidos.size();
	}

	public boolean removeResultado(int numeroResultado){
		Validador.validaValoresNegativos(numeroResultado, "numeroResultado nao pode ser nulo ou negativo.");

		if(numeroResultado > this.resultadosObtidos.size()){
			throw new IndexOutOfBoundsException("Resultado nao encontrado.");
		}

		this.resultadosObtidos.remove(numeroResultado-1);

		return true;
	}

	public String listaResultados(){
		String str = "";

		for(Resultado resultado : this.resultadosObtidos){
			str += resultado.toString() + " | ";
		}

		int index  = str.trim().lastIndexOf("|");

		if(index == -1){
			return str.trim();
		}

		return str.trim().substring(0, index-1);
	}

	public int getDuracao() {
		return this.duracaoExecucao;
	}
}
