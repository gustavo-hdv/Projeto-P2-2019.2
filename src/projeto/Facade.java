package projeto;

import easyaccept.EasyAccept;

/**
 * Representacao de uma fachada para todas as funcionalidades do sistema
 */
public class Facade {
	private Controller controller;

	/**
	 * Inicializa um Controle de Pesquisa, para poder chamar os metodos que
	 * manipulam as Pesquisas.
	 */
	PesquisaController pesquisaControle;
	/** Controlador das atividades metodologicas */
	private ControllerAtividadesMetodologicas controllerAtividadesMetodologicas;

	public Facade() {
		this.controller = new Controller();
		this.pesquisaControle = new PesquisaController();
		this.controllerAtividadesMetodologicas = new ControllerAtividadesMetodologicas();
	}

	/** Testes de aceitacao */
	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt",
				"TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt" };
		EasyAccept.main(args);
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
		return this.controllerAtividadesMetodologicas.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
	}

	/**
	 * Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		this.controllerAtividadesMetodologicas.apagaAtividade(codigo);
	}

	/**
	 * Cadastra um item para uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * @param item   (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		this.controllerAtividadesMetodologicas.cadastraItem(codigo, item);
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
		return this.controllerAtividadesMetodologicas.exibeAtividade(codigo);
	}

	/**
	 * Exibe a quantidade de itens pendentes dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		return this.controllerAtividadesMetodologicas.contaItensPendentes(codigo);
	}

	/**
	 * Exibe a quantidade de itens realizados dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		return this.controllerAtividadesMetodologicas.contaItensRealizados(codigo);
	}

	/**
	 * Metodo responsavel por cadastrar uma Pesquisa.
	 * 
	 * @param descricao        eh a descricao da Pesquisa.
	 * @param campoDeInteresse eh o campo de interesse da Pesquisa.
	 * @return a representacao do codigo da Pesquisa em String.
	 */
	public String cadastraPesquisa(String descricao, String campoDeInteresse) {
		return pesquisaControle.cadastraPesquisa(descricao, campoDeInteresse);
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
		pesquisaControle.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
	}

	/**
	 * Metodo que encerra uma Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @param motivo eh o motivo pelo qual o usuario quer encerrar a Pesquisa.
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		pesquisaControle.encerraPesquisa(codigo, motivo);
	}

	/**
	 * Metodo que ativa a Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		pesquisaControle.ativaPesquisa(codigo);
	}

	/**
	 * Metodo que exibe a representacao textual da Pesquisa em forma de String.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return a representacao textual da Pesquisa em forma de String.
	 */
	public String exibePesquisa(String codigo) {
		return pesquisaControle.exibePesquisa(codigo);
	}

	/**
	 * Metodo que retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		return pesquisaControle.pesquisaEhAtiva(codigo);
	}

	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		controller.cadastraPesquisador(nome, funcao, biografia, email, foto);
	}

	public void alteraPesquisador(String email, String atributo, String novoValor) {
		controller.alteraPesquisador(email, atributo, novoValor);
	}

	public void desativaPesquisador(String email) {
		controller.desativaPesquisador(email);
	}

	public void ativaPesquisador(String email) {
		controller.ativaPesquisador(email);
	}

	public String exibePesquisador(String email) {
		return controller.exibePesquisador(email);
	}

	public boolean pesquisadorEhAtivo(String email) {
		return controller.pesquisadorEhAtivo(email);
	}
}
