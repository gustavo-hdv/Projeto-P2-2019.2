package projeto;

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

	/** Associa um problema para a pesquisa 
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
	
	/** Desassocia um problema da a pesquisa 
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param idProblema identificador do problema
	 * 
	 * @return boolean (true para desassociado com sucesso, false para nao desassociado)
	 */
	public boolean desassociaProblema(String idPesquisa, String idProblema) {
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(idProblema, "Campo idProblema nao pode ser nulo ou vazio.");
		Validador.isRegistered(idPesquisa, pesquisaC.pesquisas, "Pesquisa nao encontrada.");
		Validador.isRegistered(idProblema, probC.problemas, "Problema nao encontrado.");
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisaC.desassociaProblema(idPesquisa, probC.getProblema(idProblema));
	}
	
	/** Associa um objetivo para a pesquisa 
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
	
	/** Desassocia um objetivo para a pesquisa 
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param idObjetivo identificador do objetivo
	 * 
	 * @return boolean (true para desassociado com sucesso, false para nao desassociado)
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
     * Cadastra um novo objetivo.
     * Adiciona um objeto do tipo Objetivo no mapa de objetivos.

     * @param tipo tipo do objetivo
     * @param descricao descrição do objetivo
     * @param aderencia aderência do objetivo
     * @param viabilidade viabilidade do objetivo
     */
    public void cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade){
    	objC.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
    }

    /**
     * Retorna a String que representa o objetivo existente na chave passada por parâmetro.
     *
     * @param codigo o código e chave do objetivo no mapa
     * @return a representação em String do objetivo pesquisado
     */
    public String exibeObjetivo(String codigo){
    	return objC.exibeObjetivo(codigo);
    }

    /**
     * Remove um objetivo do mapa de objetivos.
     *
     * @param codigo código do objetivo a ser removido
     */
    public void apagarObjetivo(String codigo){
    	objC.apagarObjetivo(codigo);
    }
	
	/**
     * Cadastra um novo problema.
     * Adiciona um objeto do tipo Problema no mapa de problemas.
     
     * @param descricao descrição do problema
     * @param viabilidade viabilidade do problema
     */
    public void cadastraProblema(String descricao, int viabilidade) {
    	probC.cadastraProblema(descricao, viabilidade);
    }
    
    /**
     * Retorna a String que representa o problema existente na chave passada por parâmetro.
     *
     * @param codigo o código e chave do problema no mapa
     * @return a representação em String do problema pesquisado
     */
    public String exibeProblema(String codigo) {
    	return probC.exibeProblema(codigo);
    }
    
    /**
     * Remove um problema do mapa de problemas.
     *
     * @param codigo código do problema a ser removido
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
	 * Exibe uma atividade no estilo: DESCRIÇÃO (NIVEL_RISCO - DESC_RISCO) |
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
		return null;
	}

	public int contaResultadosBusca(String termo) {
		Validador.validaString(termo, "Campo termo nao pode ser nulo ou vazio.");
		return 0;	
	}
	
	/**
	 * GABRIEL
	 */
	public boolean associaPesquisador(String codigoPesquisa, String emailPesquisador) {
		pesquisadorC.buscaPesquisador(emailPesquisador).associaPesquisa(codigoPesquisa, pesquisaC.buscaPesquisa(codigoPesquisa));
		return true;
	}
	
	/**
	 * GABRIEL
	 */
	public void desassociaPesquisador(String codigoPesquisa, String emailPesquisador) {
		pesquisadorC.buscaPesquisador(emailPesquisador).desassociaPesqusia(codigoPesquisa);
	}
	
	public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
		pesquisadorC.buscaPesquisador(email);
	}

	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade){
	    return this.pesquisaC.getPesquisa(codigoPesquisa).associaAtividade(codigoAtividade, this.atividadesC.getAtividade(codigoAtividade));
    }

    public boolean desassociaAtiviade(String codigoPesquisa, String codigoAtividade){
	    return this.pesquisaC.getPesquisa(codigoPesquisa).desassociaAtividade(codigoAtividade);
    }
}
