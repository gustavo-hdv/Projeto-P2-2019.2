package projeto;

import easyaccept.EasyAccept;

/**
 * Representacao de uma fachada para todas as funcionalidades do sistema
 */
public class Facade {
	private Controller controller;

	public Facade() {
		this.controller = new Controller();
	}

	/** Testes de aceitacao */
	public static void main(String[] args) {
		args = new String[] { "projeto.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt",
				"TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt", "TestesAceitacao/use_case_5.txt",
				"TestesAceitacao/use_case_6.txt", "TestesAceitacao/use_case_7.txt", "TestesAceitacao/use_case_8.txt" };
		EasyAccept.main(args);
	}

	/** Associa um problema para a pesquisa 
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param idProblema identificador do problema
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaProblema(String idPesquisa, String idProblema) {
		return this.controller.associaProblema(idPesquisa, idProblema);
	}
	
	/** Desassocia um problema da a pesquisa 
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param idProblema identificador do problema
	 * 
	 * @return boolean (true para desassociado com sucesso, false para nao desassociado)
	 */
	public boolean desassociaProblema(String idPesquisa, String idProblema) {
		return this.controller.desassociaProblema(idPesquisa, idProblema);
	}
	/**
	 * Cadastra um novo objetivo. Adiciona um objeto do tipo Objetivo no mapa de
	 * objetivos.
	 * 
	 * @param tipo        tipo do objetivo
	 * @param descricao   descrição do objetivo
	 * @param aderencia   aderência do objetivo
	 * @param viabilidade viabilidade do objetivo
	 */
	public void cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		controller.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
	}

	/**
	 * Retorna a String que representa o objetivo existente na chave passada por
	 * parâmetro.
	 *
	 * @param codigo o código e chave do objetivo no mapa
	 * @return a representação em String do objetivo pesquisado
	 */
	public String exibeObjetivo(String codigo) {
		return controller.exibeObjetivo(codigo);
	}

	/**
	 * Remove um objetivo do mapa de objetivos.
	 *
	 * @param codigo código do objetivo a ser removido
	 */
	public void apagarObjetivo(String codigo) {
		controller.apagarObjetivo(codigo);
	}

	/**
	 * Cadastra um novo problema. Adiciona um objeto do tipo Problema no mapa de
	 * problemas.
	 * 
	 * @param descricao   descrição do problema
	 * @param viabilidade viabilidade do problema
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		controller.cadastraProblema(descricao, viabilidade);
	}

	/**
	 * Retorna a String que representa o problema existente na chave passada por
	 * parâmetro.
	 *
	 * @param codigo o código e chave do problema no mapa
	 * @return a representação em String do problema pesquisado
	 */
	public String exibeProblema(String codigo) {
		return controller.exibeProblema(codigo);
	}

	/**
	 * Remove um problema do mapa de problemas.
	 *
	 * @param codigo código do problema a ser removido
	 */
	public void apagarProblema(String codigo) {
		controller.apagarProblema(codigo);
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
		return controller.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
	}

	/**
	 * Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		controller.apagaAtividade(codigo);
	}

	/**
	 * Cadastra um item para uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * @param item   (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		controller.cadastraItem(codigo, item);
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
		return controller.exibeAtividade(codigo);
	}

	/**
	 * Exibe a quantidade de itens pendentes dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		return controller.contaItensPendentes(codigo);
	}

	/**
	 * Exibe a quantidade de itens realizados dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		return controller.contaItensRealizados(codigo);
	}

	/**
	 * Metodo responsavel por cadastrar uma Pesquisa.
	 * 
	 * @param descricao        eh a descricao da Pesquisa.
	 * @param campoDeInteresse eh o campo de interesse da Pesquisa.
	 * @return a representacao do codigo da Pesquisa em String.
	 */
	public String cadastraPesquisa(String descricao, String campoDeInteresse) {
		return controller.cadastraPesquisa(descricao, campoDeInteresse);
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
		controller.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
	}

	/**
	 * Metodo que encerra uma Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @param motivo eh o motivo pelo qual o usuario quer encerrar a Pesquisa.
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		controller.encerraPesquisa(codigo, motivo);
	}

	/**
	 * Metodo que ativa a Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		controller.ativaPesquisa(codigo);
	}

	/**
	 * Metodo que exibe a representacao textual da Pesquisa em forma de String.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return a representacao textual da Pesquisa em forma de String.
	 */
	public String exibePesquisa(String codigo) {
		return controller.exibePesquisa(codigo);
	}

	/**
	 * Metodo que retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		return controller.pesquisaEhAtiva(codigo);
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

	public String busca(String termo) {
		return controller.busca(termo);
	}
	
	public String busca(String termo, int indiceResultado) {
		return controller.busca(termo, indiceResultado);
	}
	
	public int contaResultadosBusca(String termo) {
		return controller.contaResultadosBusca(termo);
	}
	
	public boolean associaPesquisador(String codigoPesquisa, String emailPesquisador) {
//		return controller.associaPesquisador(codigoPesquisa, emailPesquisador);
		return true;
	}
}
