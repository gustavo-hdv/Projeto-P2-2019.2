package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		args = new String[] { "controllers.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt", "TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt",
				"TestesAceitacao/use_case_5.txt", "TestesAceitacao/use_case_6.txt", "TestesAceitacao/use_case_7.txt", "TestesAceitacao/use_case_8.txt", "TestesAceitacao/use_case_9.txt", 
				"TestesAceitacao/use_case_10.txt", "TestesAceitacao/use_case_11.txt"};
		/*
		args = new String[] { "controllers.Facade", "TestesAceitacao/use_case_12SALVAR.txt"};
		args = new String[] { "controllers.Facade", "TestesAceitacao/use_case_12CARREGAR.txt"};
		 */
		EasyAccept.main(args);
	}

	public void salvar(){
		this.controller.salvar();
	}

	public void carregar(){
		this.controller.carregar();
	}

	/**
	 * Exporta um resumo da pesquisa em arquivo de texto Representado todas as
	 * entidades de um pesquisa em ordem de cadastro
	 * 
	 * @throws IOException
	 */
	public void gravarResumo(String codigoPesquisa) throws IOException {
		this.controller.gravarResumo(codigoPesquisa);
	}

	/**
	 * Exporta os resultados da pesquisa em arquivo de texto Representado os
	 * resultados obtidos com a pesquisa
	 * 
	 * @throws IOException
	 */
	public void gravarResultados(String codigoPesquisa) throws IOException {
		this.controller.gravarResultados(codigoPesquisa);
	}

	/**
	 * Lista as pesquisas em determinada ordem Estilo: CODIGO - Descricao - Campo de
	 * interesse
	 * 
	 * @param ordem descreve o tipo da listagem das pesquisas
	 * @return CODIGO - Descricao - Campo de interesse | CODIGO - Descricao - Campo
	 *         de interesse | ...
	 */
	public String listaPesquisas(String ordem) {
		return this.controller.listaPesquisas(ordem);
	}

	/**
	 * Associa um problema para a pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param idProblema identificador do problema
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaProblema(String idPesquisa, String idProblema) {
		return this.controller.associaProblema(idPesquisa, idProblema);
	}

	/**
	 * Desassocia um problema da a pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * 
	 * @return boolean (true para desassociado com sucesso, false para nao
	 *         desassociado)
	 */
	public boolean desassociaProblema(String idPesquisa) {
		return this.controller.desassociaProblema(idPesquisa);
	}

	/**
	 * Associa um objetivo para a pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param idObjetivo identificador do objetivo
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
		return this.controller.associaObjetivo(idPesquisa, idObjetivo);
	}

	/**
	 * Desassocia um objetivo para a pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param idObjetivo identificador do objetivo
	 * 
	 * @return boolean (true para desassociado com sucesso, false para nao
	 *         desassociado)
	 */
	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
		return this.controller.desassociaObjetivo(idPesquisa, idObjetivo);
	}

	/**
	 * Cadastra um novo objetivo. Adiciona um objeto do tipo Objetivo no mapa de
	 * objetivos.
	 * 
	 * @param tipo        tipo do objetivo
	 * @param descricao   descricao do objetivo
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
	 * @param codigo o codigo e chave do objetivo no mapa
	 * @return a representacao em String do objetivo pesquisado
	 */
	public String exibeObjetivo(String codigo) {
		return controller.exibeObjetivo(codigo);
	}

	/**
	 * Remove um objetivo do mapa de objetivos.
	 *
	 * @param codigo codigo do objetivo a ser removido
	 */
	public void apagarObjetivo(String codigo) {
		controller.apagarObjetivo(codigo);
	}

	/**
	 * Cadastra um novo problema. Adiciona um objeto do tipo Problema no mapa de
	 * problemas.
	 * 
	 * @param descricao   descricao do problema
	 * @param viabilidade viabilidade do problema
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		controller.cadastraProblema(descricao, viabilidade);
	}

	/**
	 * Retorna a String que representa o problema existente na chave passada por
	 * parâmetro.
	 *
	 * @param codigo o codigo e chave do problema no mapa
	 * @return a representacao em String do problema pesquisado
	 */
	public String exibeProblema(String codigo) {
		return controller.exibeProblema(codigo);
	}

	/**
	 * Remove um problema do mapa de problemas.
	 *
	 * @param codigo codigo do problema a ser removido
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
	 * Exibe uma atividade no estilo: DESCRICAO (NIVEL_RISCO - DESC_RISCO) |
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

	/**
	 * Metodo que associa um Pesquisador a uma determinada pesquisa. Retorna um
	 * valor booleano, True se o Pesquisador conseguiu ser associado e False caso
	 * nao.
	 * 
	 * @param idPesquisa       eh a chave que identifica a pesquisa.
	 * @param emailPesquisador eh o email do Pesquisador.
	 * @return um valor booleano.
	 */
	public boolean associaPesquisador(String idPesquisa, String emailPesquisador) {
		return controller.associaPesquisador(idPesquisa, emailPesquisador);
	}

	/**
	 * Metodo que desassocia um Pesquisador a uma determinada Pesquisa.
	 * 
	 * @param idPesquisa       eh a cgave que identifica a pesquisa.
	 * @param emailPesquisador eh o email do Pesquisador.
	 * @return um valor Booleano.
	 */
	public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
		return controller.desassociaPesquisador(idPesquisa, emailPesquisador);
	}

	/**
	 * Metodo que cadastra a ESpecialidade do Pesquisador como um Professor.
	 * 
	 * @param email    eh o email do Pesquisador.
	 * @param formacao eh a formacao do Pesquisador como um Professor.
	 * @param unidade  eh a unidade do do Pesquisador como um Professor.
	 * @param data     eh a data que aquele Pesquisador, como um Professor, foi
	 *                 contratado.
	 */
	public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
		controller.cadastraEspecialidadeProfessor(email, formacao, unidade, data);
	}

	/**
	 * Metodo que cadastra a ESpecialidade do Pesquisador como um Aluno.
	 * 
	 * @param email    eh o email do Pesqusiador como um Aluno.
	 * @param semestre eh o semestre em que o Pesquisador, como um Aluno, está
	 *                 cursando.
	 * @param IEA      eh o IEA daquele Pesquisador, como um ALuno.
	 */
	public void cadastraEspecialidadeAluno(String email, int semestre, double IEA) {
		controller.cadastraEspecialidadeAluno(email, semestre, IEA);
	}

	/**
	 * Metodo responsavel por listar todos os pesquisadores de uma determinada
	 * Funcao.
	 * 
	 * @param tipo eh a funcao.
	 * @return retorna a respresentacao em forma de String dos pesquisadores que tem
	 *         aquela determinada funcao.
	 */
	public String listaPesquisadores(String tipo) {
		return controller.listaPesquisadores(tipo);
	}

	/**
	 * Define a estrategia de sugestao de atividades.
	 * 
	 * @param estrategia Uma String indicando a estrategia que deve ser utlizada.
	 */
	public void configuraEstrategia(String estrategia) {
		controller.configuraEstrategia(estrategia);
	}

	/**
	 * Sugere a proxima atividade a ser realizada em uma pesquisa.
	 * 
	 * @param codigoPesquisa O identificador da pesquisa.
	 * @return O codigo da atividade sugerida. 
	 */
	public String proximaAtividade(String codigoPesquisa) {
		return controller.proximaAtividade(codigoPesquisa);
	}

	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
		return this.controller.associaAtividade(codigoPesquisa, codigoAtividade);
	}

	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
		return this.controller.desassociaAtividade(codigoPesquisa, codigoAtividade);
	}

	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		this.controller.executaAtividade(codigoAtividade, item, duracao);
	}

	public int cadastraResultado(String codigoAtividade, String resultado) {
		return this.controller.cadastraResultado(codigoAtividade, resultado);
	}

	public boolean removeResultado(String codigoAtividade, int numeroResultado) {
		return this.controller.removeResultado(codigoAtividade, numeroResultado);
	}

	public String listaResultados(String codigoAtividade) {
		return this.controller.listaResultados(codigoAtividade);
	}

	public int getDuracao(String codigoAtividade) {
		return this.controller.getDuracao(codigoAtividade);
	}

	/**
	 * Metodo responsavel por definir uma atividade(subsequente) recomendavel a ser executada depois de determinada atividade(precedente).
	 * 
	 * @param idPrecedente eh o ID que identifica a atividade Precedente.
	 * @param idSubsequente eh o ID que identifica a atividade Subsequente.
	 */
	public void defineProximaAtividade(String idPrecedente, String idSubsequente) {
		this.controller.defineProximaAtividade(idPrecedente, idSubsequente);
	}

	/**
	 * Metodo responsavel tirar um subsequente de determinada atividade.
	 * 
	 * @param idPrecedente eh o ID da pesquisa que tera seu subsequente retirado.
	 */
	public void tiraProximaAtividade(String idPrecedente) {
		this.controller.tiraProximaAtividade(idPrecedente);
	}

	/**
	 * Metodo que conta quantos atividades estao sendo recomendadas depois de determinada atividade.
	 * 
	 * @param idPrecedente eh o ID da atividade que será passada como ponto de partida para se contar quantas atividades vem depois.
	 * @return retorna a quantidade de atividades que vem depois da atividade passada.
	 */
	public int contaProximos(String idPrecedente) {
		return this.controller.contaProximos(idPrecedente);
	}

	/**
	 * Metodo que retorna o ID da atividade que ocupa a posicao passada, dentro da corrrente de atividades asossiadas,
	 * contando a partir da atividade passada como parametro.
	 * 
	 * @param idAtividade eh o ID da atividade que é utilizada como ponto de partida.
	 * @param enesimaAtividade eh a posicao da atividade que ele deseja saber.
	 * @return retorna o ID da atividade que ocupa a posicao passada.
	 */
	public String pegaProximo(String idAtividade, int enesimaAtividade) {
		return this.controller.pegaProximo(idAtividade, enesimaAtividade);
	}

	/**
	 * Metodo que retorna a ultima atividade com o maior risco, dentro da corrente de cadeias associadas,
	 * a partir de determinada atividade.
	 * 
	 * @param idAtividade eh o ID de uma atividade, que serve como o ponto inicial de partida.
	 * @return retorna o ID da ultima pesquisa que tiver o maior risco. 
	 */
	public String pegaMaiorRiscoAtividades(String idAtividade) {
		return this.controller.pegaMaiorRiscoAtividades(idAtividade);
	}

}
