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

	
	/** Construtor da atividade metodologica com descricao, nivel de risco e uma descricao de risco 
	 * 
	 * @param descricao (descricao da atividade) (String) 
	 * @param nivelRisco (nivel de risco da atividade) (String)
	 * @param descricaoRisco (descricao de risco da atividade) (String)
	 */
	public AtividadeMetodologica(String descricao, String nivelRisco, String descricaoRisco) {	
		if (descricao.equals(null)) { throw new NullPointerException("Campo Descricao nao pode ser nulo ou vazio."); }
		if (descricao.trim().equals("")) { throw new IllegalArgumentException("Campo Descricao nao pode ser nulo ou vazio."); }
		
		if (nivelRisco.equals(null)) { throw new NullPointerException("Campo nivelRisco nao pode ser nulo ou vazio."); }
		if (nivelRisco.trim().equals("")) { throw new IllegalArgumentException("Campo nivelRisco nao pode ser nulo ou vazio."); }
		if (!(nivelRisco.equalsIgnoreCase("BAIXO") || nivelRisco.equalsIgnoreCase("MEDIO") || nivelRisco.equalsIgnoreCase("ALTO"))) { throw new IllegalArgumentException("Valor invalido do nivel do risco."); }
		
		if (descricaoRisco.equals(null)) { throw new NullPointerException("Campo descricaoRisco nao pode ser nulo ou vazio."); }
		if (descricaoRisco.trim().equals("")) { throw new IllegalArgumentException("Campo descricaoRisco nao pode ser nulo ou vazio."); }
		
		this.descricao = descricao;
		this.nivelRisco = nivelRisco;
		this.descricaoRisco = descricaoRisco;
		this.resultados = new ArrayList<Item>();
	}
	
	/** Cadastra um item para a atividade
	 * 
	 * @param item (descricao do item) (String)
	 */
	public void cadastraItem(String item) {
		if (item.equals(null)) { throw new NullPointerException("Item nao pode ser nulo ou vazio."); }
		if (item.trim().equals("")) { throw new IllegalArgumentException("Item nao pode ser nulo ou vazio."); }
		
		Item itemObject = new Item(item);
		if (resultados.contains(itemObject)) { throw new IllegalArgumentException("Item ja cadastrado"); }
		this.resultados.add(itemObject);
	}
	
	/** Exibe a quantidade de itens pendentes dos resultados
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
	
	/** Exibe a quantidade de itens realizados dos resultados de um atividade
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
	
	/** Exibe a atividade no estilo:
	 *  DESCRIÇÃO (NIVEL_RISCO - DESC_RISCO) | REALIZADO - ITEM1 | REALIZADO - ITEM2 | PENDENTE - ITEM3
	 *  
	 *  @return representacao de uma ativdade (String)
	 */
	public String exibeAtividade() {
		String toString = this.descricao + " (" + this.nivelRisco + " - " + this.descricaoRisco + ")";
		if (resultados.size() == 0) {
			return toString;
		}
		toString += " | "; 
		for (int i = 0; i < resultados.size(); i++) {
			if (i != 0) toString += " | ";
			toString += resultados.get(i).exibeItem();
		}
		return toString;
	}
}