package projeto;

public class Controller {
	private PesquisadorController pesqC;
	private ControllerAtividadesMetodologicas ativC;

	public Controller() {
		this.pesqC = new PesquisadorController();
		this.ativC = new ControllerAtividadesMetodologicas();
	}

	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		pesqC.cadastraPesquisador(nome, funcao, biografia, email, foto);
	}
	
	public void desativaPesquisador(String email) {
		pesqC.desativaPesquisador(email);
	}

	public void ativaPesquisador(String email) {
		pesqC.ativaPesquisador(email);
	}
	
	public void alteraPesquisador(String email, String atributo, String novoValor) {
		pesqC.alteraPesquisador(email, atributo, novoValor);
	}

	public String exibePesquisador(String email) {
		return pesqC.exibePesquisador(email);
	}

	public boolean pesquisadorEhAtivo(String email) {
		return pesqC.pesquisadorEhAtivo(email);
	}

	/**
	 * Cadastra uma atividade com descricao, nivel de risco e uma descricao de risco
	 * 
	 * @param descricao      (descricao da atividade) (String)
	 * @param nivelRisco     (nivel de risco da atividade) (String)
	 * @param descricaoRisco (descricao de risco da atividade) (String)
	 * 
	 * @return codigo da atividade, estilo: "A + posicao"
	 */
	public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco) {
		return ativC.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
	}

	/**
	 * Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		ativC.apagaAtividade(codigo);
	}

	/**
	 * Cadastra um item para uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * @param item   (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		ativC.cadastraItem(codigo, item);
	}

	/**
	 * Exibe uma atividade no estilo: DESCRIÇÃO (NIVEL_RISCO - DESC_RISCO) |
	 * REALIZADO - ITEM1 | REALIZADO - ITEM2 | PENDENTE - ITEM3
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return representacao de uma ativdade (String)
	 */
	public String exibeAtividade(String codigo) {
		return ativC.exibeAtividade(codigo);
	}

	/**
	 * Exibe a quantidade de itens pendentes dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		return ativC.contaItensPendentes(codigo);
	}

	/**
	 * Exibe a quantidade de itens realizados dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		return ativC.contaItensRealizados(codigo);
	}
	
}
