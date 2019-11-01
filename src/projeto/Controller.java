package projeto;

public class Controller {
	private PesquisadorController pesquisadorC;
	private ControllerAtividadesMetodologicas ativividadesC;
	private PesquisaController pesquisaC;

	public Controller() {
		this.pesquisadorC = new PesquisadorController();
		this.ativividadesC = new ControllerAtividadesMetodologicas();
		this.pesquisaC = new PesquisaController();
	}

	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		pesquisadorC.cadastraPesquisador(nome, funcao, biografia, email, foto);
	}
	
	public void desativaPesquisador(String email) {
		pesquisadorC.desativaPesquisador(email);
	}

	public void ativaPesquisador(String email) {
		pesquisadorC.ativaPesquisador(email);
	}
	
	public void alteraPesquisador(String email, String atributo, String novoValor) {
		pesquisadorC.alteraPesquisador(email, atributo, novoValor);
	}

	public String exibePesquisador(String email) {
		return pesquisadorC.exibePesquisador(email);
	}

	public boolean pesquisadorEhAtivo(String email) {
		return pesquisadorC.pesquisadorEhAtivo(email);
	}

	public String cadastraPesquisa(String descricao, String campoDeInteresse) {
		return pesquisaC.cadastraPesquisa(descricao, campoDeInteresse);
	}

	/**
	 * Metodo que altera os conteudos: Descricao ou Campo.
	 * 
	 * @param codigo               eh o codigo que identifica a Pesquisa.
	 * @param conteudoASerAlterado eh o conteudo a ser alterado.
	 * @param novoConteudo         eh o novo conteudo que vai ficar no lugar do
	 *                             antigo.
	 */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		pesquisaC.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
	}

	/**
	 * Metodo que encerra uma Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @param motivo eh o motivo pelo qual o usuario quer encerrar a Pesquisa.
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		pesquisaC.encerraPesquisa(codigo, motivo);
	}

	/**
	 * Metodo que ativa a Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		pesquisaC.ativaPesquisa(codigo);
	}

	/**
	 * Metodo que exibe a representacao textual da Pesquisa em forma de String.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return a representacao textual da Pesquisa em forma de String.
	 */
	public String exibePesquisa(String codigo) {
		return pesquisaC.exibePesquisa(codigo);
	}

	/**
	 * Metodo que retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		return pesquisaC.pesquisaEhAtiva(codigo);
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
		return ativividadesC.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
	}

	/**
	 * Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		ativividadesC.apagaAtividade(codigo);
	}

	/**
	 * Cadastra um item para uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * @param item   (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		ativividadesC.cadastraItem(codigo, item);
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
		return ativividadesC.exibeAtividade(codigo);
	}

	/**
	 * Exibe a quantidade de itens pendentes dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		return ativividadesC.contaItensPendentes(codigo);
	}

	/**
	 * Exibe a quantidade de itens realizados dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		return ativividadesC.contaItensRealizados(codigo);
	}
	
}
