package projeto;

/** 
 * Representacao de um controlador de atividades metodologicas
 */

import java.util.HashMap;
import java.util.Map;

public class ControllerAtividadesMetodologicas {
	
	/** Mapa de atividades metodologicas por um codigo ("A" + posicao) */
	private Map<String, AtividadeMetodologica> atividadesMetodologicas;
	/** Numero para gerar o codigo de uma atividade */
	private int contagem;
	
	/** Construtor de uma atividade metodologica */
	public ControllerAtividadesMetodologicas() {
		this.atividadesMetodologicas = new HashMap<String, AtividadeMetodologica>();
		this.contagem = 0;
	}
	
	/** Cadastra uma atividade com descricao, nivel de risco e uma descricao de risco no mapa de atividades
	 * 
	 * @param descricao (descricao da atividade) (String) 
	 * @param nivelRisco (nivel de risco da atividade) (String)
	 * @param descricaoRisco (descricao de risco da atividade) (String)
	 * 
	 * @return codigo da atividade, estilo: "A + posicao"
	 */
	public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco) {
		if (descricao == null) { throw new NullPointerException("Campo Descricao nao pode ser nulo ou vazio."); }
		if (descricao.trim().equals("")) { throw new IllegalArgumentException("Campo Descricao nao pode ser nulo ou vazio."); }
		
		if (nivelRisco == null) { throw new NullPointerException("Campo nivelRisco nao pode ser nulo ou vazio."); }
		if (nivelRisco.trim().equals("")) { throw new IllegalArgumentException("Campo nivelRisco nao pode ser nulo ou vazio."); }
		if (!(nivelRisco.equalsIgnoreCase("BAIXO") || nivelRisco.equalsIgnoreCase("MEDIO") || nivelRisco.equalsIgnoreCase("ALTO"))) { throw new IllegalArgumentException("Valor invalido do nivel do risco."); }
		
		if (descricaoRisco == null) { throw new NullPointerException("Campo descricaoRisco nao pode ser nulo ou vazio."); }
		if (descricaoRisco.trim().equals("")) { throw new IllegalArgumentException("Campo descricaoRisco nao pode ser nulo ou vazio."); }
		
		String codigo = "A" + (++this.contagem);
		this.atividadesMetodologicas.put(codigo, new AtividadeMetodologica(descricao, nivelRisco, descricaoRisco));
		return codigo;
	}
	
	/** Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		if (codigo == null) { throw new NullPointerException("Campo codigo nao pode ser nulo ou vazio."); }
		if (codigo.trim().equals("")) { throw new IllegalArgumentException("Campo codigo nao pode ser nulo ou vazio."); }
		if (!atividadesMetodologicas.containsKey(codigo)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
		
		this.atividadesMetodologicas.remove(codigo);
	}
	
	/** Cadastra um item para uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * @param item (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		if (codigo == null) { throw new NullPointerException("Campo codigo nao pode ser nulo ou vazio."); }
		if (codigo.trim().equals("")) { throw new IllegalArgumentException("Campo codigo nao pode ser nulo ou vazio."); }
		if (!atividadesMetodologicas.containsKey(codigo)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
		
		if (item.equals(null)) { throw new NullPointerException("Item nao pode ser nulo ou vazio."); }
		if (item.trim().equals("")) { throw new IllegalArgumentException("Item nao pode ser nulo ou vazio."); }
		
		this.atividadesMetodologicas.get(codigo).cadastraItem(item);
		
	}
	
	/** Exibe uma atividade no estilo:
	 *  DESCRIÇÃO (NIVEL_RISCO - DESC_RISCO) | REALIZADO - ITEM1 | REALIZADO - ITEM2 | PENDENTE - ITEM3
	 *  
	 *  @param codigo da atividade (String)
	 *  
	 *  @return representacao de uma ativdade (String)
	 */
	public String exibeAtividade(String codigo) {
		if (codigo == null) { throw new NullPointerException("Campo codigo nao pode ser nulo ou vazio."); }
		if (codigo.trim().equals("")) { throw new IllegalArgumentException("Campo codigo nao pode ser nulo ou vazio."); }
		if (!atividadesMetodologicas.containsKey(codigo)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
	
		return atividadesMetodologicas.get(codigo).exibeAtividade();
	}
	
	/** Exibe a quantidade de itens pendentes dos resultados de um atividade
	 *  
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		if (codigo == null) { throw new NullPointerException("Campo codigo nao pode ser nulo ou vazio."); }
		if (codigo.trim().equals("")) { throw new IllegalArgumentException("Campo codigo nao pode ser nulo ou vazio."); }
		
		if (!this.atividadesMetodologicas.containsKey(codigo)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
		
		return this.atividadesMetodologicas.get(codigo).contaItensPendentes();
	}
	
	/** Exibe a quantidade de itens realizados dos resultados de um atividade
	 *  
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		if (codigo == null) { throw new NullPointerException("Campo codigo nao pode ser nulo ou vazio."); }
		if (codigo.trim().equals("")) { throw new IllegalArgumentException("Campo codigo nao pode ser nulo ou vazio."); }
		
		if (!this.atividadesMetodologicas.containsKey(codigo)) { throw new IllegalArgumentException("Atividade nao encontrada"); }
		
		return this.atividadesMetodologicas.get(codigo).contaItensRealizados();
	}
}
