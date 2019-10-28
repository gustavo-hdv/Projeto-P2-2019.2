package projeto;

/** 
 * Representacao de uma fachada para todas as funcionalidades do sistema
 */

import easyaccept.EasyAccept;

public class Facade {

	/** Controlador das atividades metodologicas */
	private ControllerAtividadesMetodologicas controllerAtividadesMetodologicas = new ControllerAtividadesMetodologicas();
	
	/** Testes de aceitacao */
	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt", "TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt"};
		EasyAccept.main(args);
	}
	
	/** Cadastra uma atividade com descricao, nivel de risco e uma descricao de risco 
	 * 
	 * @param descricao (descricao da atividade) (String) 
	 * @param nivelRisco (nivel de risco da atividade) (String)
	 * @param descricaoRisco (descricao de risco da atividade) (String)
	 * 
	 * @return codigo da atividade, estilo: "A + posicao"
	 */
	public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco) {
		return this.controllerAtividadesMetodologicas.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
	}
	
	/** Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		this.controllerAtividadesMetodologicas.apagaAtividade(codigo);
	}
	
	/** Cadastra um item para uma atividade 
	 * 
	 * @param codigo da atividade (String)
	 * @param item (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		this.controllerAtividadesMetodologicas.cadastraItem(codigo, item);
	}
	
	/** Exibe uma atividade no estilo:
	 *  DESCRIÇÃO (NIVEL_RISCO - DESC_RISCO) | REALIZADO - ITEM1 | REALIZADO - ITEM2 | PENDENTE - ITEM3
	 *  
	 *  @param codigo da atividade (String)
	 *  
	 *  @return representacao de uma ativdade (String)
	 */
	public String exibeAtividade(String codigo) {
		return this.controllerAtividadesMetodologicas.exibeAtividade(codigo);
	}
	
	/** Exibe a quantidade de itens pendentes dos resultados de uma atividade
	 *  
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		return this.controllerAtividadesMetodologicas.contaItensPendentes(codigo);
	}
	
	/** Exibe a quantidade de itens realizados dos resultados de uma atividade
	 *  
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		return this.controllerAtividadesMetodologicas.contaItensRealizados(codigo);
	}
	
}
