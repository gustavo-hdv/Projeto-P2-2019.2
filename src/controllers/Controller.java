package controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import projeto.Busca;
import projeto.Pesquisa;
import projeto.Validador;

public class Controller {
	private PesquisadorController pesquisadorC;
	private AtividadeController atividadesC;
	private PesquisaController pesquisaC;
	private ObjetivoController objC;
	private ProblemaController probC;

	public Controller() {
		this.pesquisadorC = new PesquisadorController();
		this.atividadesC = new AtividadeController();
		this.pesquisaC = new PesquisaController();
		this.objC = new ObjetivoController();
		this.probC = new ProblemaController();
	}

	/**
	 * Representacao do resumo de uma pesquisa Estilo: Pesquisa: codigo - descricao
	 * - campo de interesse Pesquisadores: \n listagem dos pesquisadores Problema:
	 * \n listagem dos problemas Objetivos: \n listagem dos objetivos Atividades: \n
	 * listagem das atividades
	 * 
	 * @return resumo da pesquisa
	 */
	private String getResumoPesquisa(Pesquisa pesquisa) {
		String resumo = "\"- Pesquisa: " + pesquisa.toString() + System.lineSeparator();
		resumo += "\t- Pesquisadores: " + System.lineSeparator();
		resumo += this.pesquisadorC.exibePesquisadoresAssociados(pesquisa.getCodigo());
		resumo += this.pesquisaC.exibeResumoPesquisa(pesquisa.getCodigo());
		resumo = resumo.replaceAll("[ \n]+$", "\"");
		return resumo;
	}

	/**
	 * Representacao dos resultados de uma pesquisa Estilo: Pesquisa: codigo -
	 * descricao - campo de interesse Resultados: Descricao Item(id) - Duracao \n
	 * ... Descricao dos resultados \n ...
	 */
	private String getResultadosPesquisa(Pesquisa pesquisa) {
		String resultados = "\"- Pesquisa: " + pesquisa.toString() + System.lineSeparator();
		resultados += "\t- Resultados: " + System.lineSeparator();
		resultados += this.pesquisaC.exibeResultadosPesquisa(pesquisa.getCodigo());
		resultados = resultados.replaceAll("[ \n]+$", "\"");
		return resultados;
	}

	/**
	 * Exporta um resumo da pesquisa em arquivo de texto Representado todas as
	 * entidades de um pesquisa em ordem de cadastro. Formato do arquivo:
	 * CODIGOPESQUISA.txt Estilo: Pesquisa: codigo - descricao - campo de interesse
	 * Pesquisadores: \n listagem dos pesquisadores Problema: \n listagem dos
	 * problemas Objetivos: \n listagem dos objetivos Atividades: \n listagem das
	 * atividades
	 * 
	 * @throws IOException
	 */
	public void gravarResumo(String codigoPesquisa) throws IOException {
		Validador.validaString(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
		Validador.isRegistered(codigoPesquisa, this.pesquisaC.pesquisas, "Pesquisa nao encontrada.");
		String resumo = getResumoPesquisa(this.pesquisaC.getPesquisa(codigoPesquisa));

		File arquivo = new File(codigoPesquisa + "-temp.txt");
		FileWriter escrever = new FileWriter(arquivo, false);
		escrever.write(resumo);
		escrever.close();
	}

	/**
	 * Exporta os resultados da pesquisa em arquivo de texto Representado os
	 * resultados obtidos com a pesquisa. Formato do arquivo:
	 * CODIGOPESQUISA-Resultados.txt Estilo: Pesquisa: codigo - descricao - campo de
	 * interesse Resultados: Descricao Item(id) - Duracao \n ... Descricao dos
	 * resultados \n ...
	 * 
	 * @throws IOException
	 */
	public void gravarResultados(String codigoPesquisa) throws IOException {
		Validador.validaString(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
		Validador.isRegistered(codigoPesquisa, this.pesquisaC.pesquisas, "Pesquisa nao encontrada.");
		String resultados = getResultadosPesquisa(this.pesquisaC.getPesquisa(codigoPesquisa));

		File arquivo = new File(codigoPesquisa + "-Resultados.txt");
		FileWriter escrever = new FileWriter(arquivo, false);
		escrever.write(resultados);
		escrever.close();
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
		Validador.validaString(ordem, "Valor invalido da ordem");
		if (!(ordem.equals("PROBLEMA") || ordem.equals("OBJETIVOS") || ordem.equals("PESQUISA"))) {
			throw new IllegalArgumentException("Valor invalido da ordem");
		}
		return this.pesquisaC.listaPesquisas(ordem);
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
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(idProblema, "Campo idProblema nao pode ser nulo ou vazio.");
		Validador.isRegistered(idPesquisa, pesquisaC.pesquisas, "Pesquisa nao encontrada.");
		Validador.isRegistered(idProblema, probC.problemas, "Problema nao encontrado.");
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisaC.associaProblema(idPesquisa, probC.getProblema(idProblema));
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
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validador.isRegistered(idPesquisa, pesquisaC.pesquisas, "Pesquisa nao encontrada.");
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisaC.desassociaProblema(idPesquisa);
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
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		Validador.isRegistered(idPesquisa, this.pesquisaC.pesquisas, "Pesquisa nao encontrada.");
		Validador.isRegistered(idObjetivo, this.objC.objetivos, "Objetivo nao encontrado.");
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisaC.associaObjetivo(idPesquisa, objC.getObjetivo(idObjetivo));
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
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		Validador.isRegistered(idPesquisa, this.pesquisaC.pesquisas, "Pesquisa nao encontrada.");
		Validador.isRegistered(idObjetivo, this.objC.objetivos, "Objetivo nao encontrado.");
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisaC.desassociaObjetivo(idPesquisa, objC.getObjetivo(idObjetivo));
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
	 * Cadastra um novo objetivo. Adiciona um objeto do tipo Objetivo no mapa de
	 * objetivos.
	 * 
	 * @param tipo        tipo do objetivo
	 * @param descricao   descricao do objetivo
	 * @param aderencia   aderência do objetivo
	 * @param viabilidade viabilidade do objetivo
	 */
	public void cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		objC.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
	}

	/**
	 * Retorna a String que representa o objetivo existente na chave passada por
	 * parâmetro.
	 *
	 * @param codigo o codigo e chave do objetivo no mapa
	 * @return a representacao em String do objetivo pesquisado
	 */
	public String exibeObjetivo(String codigo) {
		return objC.exibeObjetivo(codigo);
	}

	/**
	 * Remove um objetivo do mapa de objetivos.
	 *
	 * @param codigo codigo do objetivo a ser removido
	 */
	public void apagarObjetivo(String codigo) {
		objC.apagarObjetivo(codigo);
	}

	/**
	 * Cadastra um novo problema. Adiciona um objeto do tipo Problema no mapa de
	 * problemas.
	 * 
	 * @param descricao   descricao do problema
	 * @param viabilidade viabilidade do problema
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		probC.cadastraProblema(descricao, viabilidade);
	}

	/**
	 * Retorna a String que representa o problema existente na chave passada por
	 * parâmetro.
	 *
	 * @param codigo o codigo e chave do problema no mapa
	 * @return a representacao em String do problema pesquisado
	 */
	public String exibeProblema(String codigo) {
		return probC.exibeProblema(codigo);
	}

	/**
	 * Remove um problema do mapa de problemas.
	 *
	 * @param codigo codigo do problema a ser removido
	 */
	public void apagarProblema(String codigo) {
		probC.apagarProblema(codigo);
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
		return atividadesC.cadastraAtividade(descricao, nivelRisco, descricaoRisco);
	}

	/**
	 * Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		atividadesC.apagaAtividade(codigo);
	}

	/**
	 * Cadastra um item para uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * @param item   (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		atividadesC.cadastraItem(codigo, item);
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
		return atividadesC.exibeAtividade(codigo);
	}

	/**
	 * Exibe a quantidade de itens pendentes dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		return atividadesC.contaItensPendentes(codigo);
	}

	/**
	 * Exibe a quantidade de itens realizados dos resultados de uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		return atividadesC.contaItensRealizados(codigo);
	}

	public String busca(String termo) {
		Validador.validaString(termo, "Campo termo nao pode ser nulo ou vazio.");
		Busca busca = new Busca(pesquisadorC, pesquisaC, atividadesC, objC, probC, termo);
		return busca.toString();
	}

	public String busca(String termo, int indiceResultado) {
		Validador.validaString(termo, "Campo termo nao pode ser nulo ou vazio.");
		if (indiceResultado < 0) {
			throw new IllegalArgumentException("Numero do resultado nao pode ser negativo");
		}
		Busca busca = new Busca(pesquisadorC, pesquisaC, atividadesC, objC, probC, termo);
		return busca.getResultado(indiceResultado);
	}

	public int contaResultadosBusca(String termo) {
		Validador.validaString(termo, "Campo termo nao pode ser nulo ou vazio.");
		Busca busca = new Busca(pesquisadorC, pesquisaC, atividadesC, objC, probC, termo);
		return busca.contaResultadosBusca();
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
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(emailPesquisador, "Campo emailPesquisador nao pode ser nulo ou vazio.");
		if (!pesquisaC.pesquisas.containsKey(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		} else if (!pesquisaC.pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return pesquisadorC.associaPesquisador(idPesquisa, emailPesquisador, pesquisaC.buscaPesquisa(idPesquisa));
	}

	/**
	 * Metodo que desassocia um Pesquisador a uma determinada Pesquisa.
	 * 
	 * @param idPesquisa       eh a cgave que identifica a pesquisa.
	 * @param emailPesquisador eh o email do Pesquisador.
	 * @return um valor Booleano.
	 */
	public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(emailPesquisador, "Campo emailPesquisador nao pode ser nulo ou vazio.");
		if (!pesquisaC.pesquisas.containsKey(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		} else if (!pesquisaC.pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return pesquisadorC.desassociaPesquisador(idPesquisa, emailPesquisador);
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
		pesquisadorC.cadastraEspecialidadeProfessor(email, formacao, unidade, data);
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
		pesquisadorC.cadastraEspecialidadeAluno(email, semestre, IEA);
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
		return pesquisadorC.listaPesquisadores(tipo);
	}

	/**
	 * Define a estrategia de sugestao de atividades.
	 * 
	 * @param estrategia Uma String indicando a estrategia que deve ser utlizada.
	 */
	public void configuraEstrategia(String estrategia) {
		pesquisaC.configuraEstrategia(estrategia);
	}

	/**
	 * Sugere a proxima atividade a ser realizada em uma pesquisa.
	 * 
	 * @param codigoPesquisa O identificador da pesquisa.
	 * @return O codigo da atividade sugerida. 
	 */
	public String proximaAtividade(String codigoPesquisa) {
		return pesquisaC.proximaAtividade(codigoPesquisa);
	}

	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
		Validador.validaString(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");

		if (this.atividadesC.getAtividade(codigoAtividade) == null) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}

		return this.pesquisaC.associaAtividade(codigoPesquisa, codigoAtividade,
				this.atividadesC.getAtividade(codigoAtividade));
	}

	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
		Validador.validaString(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");

		if (this.atividadesC.getAtividade(codigoAtividade) == null) {
			throw new NullPointerException("Atividade nao encontrada");
		}

		return this.pesquisaC.desassociaAtividade(codigoPesquisa, codigoAtividade);
	}

	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.validaValoresNegativos(item, "Item nao pode ser nulo ou negativo.");
		Validador.validaValoresNegativos(duracao, "Duracao nao pode ser nula ou negativa.");

		if (this.atividadesC.getAtividade(codigoAtividade) == null) {
			throw new NullPointerException("Atividade nao encontrada");
		}

		this.pesquisaC.executaAtividade(codigoAtividade, item, duracao);
	}

	public int cadastraResultado(String codigoAtividade, String resultado) {
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.validaString(resultado, "Resultado nao pode ser nulo ou vazio.");

		if (this.atividadesC.getAtividade(codigoAtividade) == null) {
			throw new NullPointerException("Atividade nao encontrada");
		}

		return this.pesquisaC.cadastraResultado(codigoAtividade, resultado);
	}

	public boolean removeResultado(String codigoAtividade, int numeroResultado) {
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.validaValoresNegativos(numeroResultado, "numeroResultado nao pode ser nulo ou negativo.");

		if (this.atividadesC.getAtividade(codigoAtividade) == null) {
			throw new NullPointerException("Atividade nao encontrada");
		}

		return this.pesquisaC.removeResultado(codigoAtividade, numeroResultado);
	}

	public String listaResultados(String codigoAtividade) {
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");

		if (this.atividadesC.getAtividade(codigoAtividade) == null) {
			throw new NullPointerException("Atividade nao encontrada");
		}

		return this.pesquisaC.listaResultados(codigoAtividade);
	}

	public int getDuracao(String codigoAtividade) {
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");

		if (this.atividadesC.getAtividade(codigoAtividade) == null) {
			throw new NullPointerException("Atividade nao encontrada");
		}

		return this.pesquisaC.getDuracao(codigoAtividade);
	}

	/**
	 * GABRIEL
	 */
	public void defineProximaAtividade(String idPrecedente, String idSubsequente) {
		atividadesC.defineProximaAtividade(idPrecedente, idSubsequente);
	}

	/**
	 * GABRIEL
	 */
	public void tiraProximaAtividade(String idPrecedente) {
		atividadesC.tiraProximaAtividade(idPrecedente);
	}

	/**
	 * GABRIEL
	 */
	public int contaProximos(String idPrecedente) {
		return atividadesC.contaProximos(idPrecedente);
	}

	/**
	 * GABRIEL
	 */
	public String pegaProximo(String idAtividade, int enesimaAtividade) {
		return atividadesC.pegaProximo(idAtividade, enesimaAtividade);
	}

	/**
	 * GABRIEL
	 */
	public String pegaMaiorRiscoAtividades(String idAtividade) {
		return atividadesC.pegaMaiorRiscoAtividades(idAtividade);
	}

}