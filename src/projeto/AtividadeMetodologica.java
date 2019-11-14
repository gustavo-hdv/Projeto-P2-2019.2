package projeto;

/** 
 * Representacao de uma atividade metodologica
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

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
}
