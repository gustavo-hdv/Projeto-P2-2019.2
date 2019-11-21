package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import comparators.*;
import entidades.*;

/**
 * Representacao de um Controle, que e responsavel por manipular os Collections,
 * e guardar alguns metodos do programa que sejam referentes a Classe Pesquisa.
 */
public class PesquisaController {

	/**
	 * Map responsavel por guardar as pesquisas cadastradas. Essas pesquisas
	 * estao associadas ao seu codigo.
	 */
	protected Map<String, Pesquisa> pesquisas;

	/**
	 * Map responsavel por registrar as pesquisas que foram desativadas . Essas
	 * pesquisas estao associadas ao seu codigo.
	 */
	private Map<String, String> desativadas; 

	/**
	 * Map responsavel por guardar um codigo associado a um ArrayList, o tamanho
	 * desse ArrayList eh equivalente a quantidade de vezes que esse codigo com
	 * essas 3 letras ja foram usados.
	 */
	private Map<String, Integer> codigos;
	
	private Comparator<AtividadeMetodologica> estrategia;

	/**
	 * Constroi um Controle da Pesquisa e inicializa os HashMap e o atributo codigo.
	 */
	public PesquisaController() {
		this.pesquisas = new LinkedHashMap<String, Pesquisa>();
		this.desativadas = new LinkedHashMap<String, String>();
		this.codigos = new LinkedHashMap<String, Integer>();
	}

	/**
	 * Exporta um resumo da pesquisa em arquivo de texto Representado todas as
	 * entidades de um pesquisa em ordem de cadastro. Formato do arquivo:
	 * CODIGOPESQUISA.txt
	 */
	public void gravarResumo(String codigoPesquisa) {
		Validador.validaString(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
		Validador.isRegistered(codigoPesquisa, this.pesquisas, "Pesquisa nao encontrada.");
	}

	/**
	 * Exporta os resultados da pesquisa em arquivo de texto Representado os
	 * resultados obtidos com a pesquisa. Formato do arquivo:
	 * CODIGOPESQUISA-Resultados.txt
	 */
	public void gravarResultados(String codigoPesquisa) {
		Validador.validaString(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
		Validador.isRegistered(codigoPesquisa, this.pesquisas, "Pesquisa nao encontrada.");
	}
	
	/** Representacao do resumo de uma pesquisa
	 *  Estilo: Problema: \n listagem dos problemas
	 *          Objetivos: \n listagem dos objetivos
	 *          Atividades: \n listagem das atividades
	 *          
	 *  @param codigoPesquisa id da pesquisa        
	 *  @return resumo da pesquisa
	 */
	public String exibeResumoPesquisa(String codigoPesquisa) {
		return this.pesquisas.get(codigoPesquisa).exibeResumoPesquisa();
	}
	
	/** Representacao dos resultados de uma pesquisa
	 *  Estilo: Pesquisa: codigo - descricao - campo de interesse
	 *  		  Resultados:
	 *  		  Descricao
	 *  		  Item(id) - Duracao \n ...
	 *  		  Descricao dos resultados \n ...
	 *  @param codigoPesquisa identificacao da pesquisa
	 *  @return resultados da pesquisa
	 */
	public String exibeResultadosPesquisa(String codigoPesquisa) {
		return this.pesquisas.get(codigoPesquisa).exibeResultadosPesquisa();
	}
	
	/**
	 * Metodo responsavel por cadastrar uma Pesquisa.
	 * 
	 * @param descricao        eh a descricao da Pesquisa.
	 * @param campoDeInteresse eh o campo de interesse da Pesquisa.
	 * @return a representacao do codigo da Pesquisa em String.
	 */
	public String cadastraPesquisa(String descricao, String campoDeInteresse) {
		Validador.validaString(descricao, "Descricao nao pode ser nula ou vazia.");
		Validador.validaString(campoDeInteresse, "Formato do campo de interesse invalido.");
		Validador.validaCampoDeInteresse(campoDeInteresse);
		String codigoLetras = campoDeInteresse.substring(0, 3).toUpperCase();
		String codigo;
		if (codigos.containsKey(codigoLetras)) {
			int contador = codigos.get(codigoLetras);
			contador++;
			codigos.replace(codigoLetras, contador);
			codigo = codigoLetras + codigos.get(codigoLetras).intValue();
		} else {
			codigo = codigoLetras + "1";
			codigos.put(codigoLetras, 1);
		}
		this.estrategia = new AtividadeMaisAntiga();
		pesquisas.put(codigo, new Pesquisa(codigo, descricao, campoDeInteresse));
		return codigo;
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
		Validador.isRegistered(codigo, pesquisas, "Pesquisa nao encontrada.");
		Validador.ehDesativada(codigo, desativadas, "Pesquisa desativada.");
		Validador.validaString(conteudoASerAlterado, "Conteudo a ser alterado nao pode ser vazio ou nulo.");
		if (conteudoASerAlterado.equals("DESCRICAO")) {
			Validador.validaString(novoConteudo, "Descricao nao pode ser nula ou vazia.");
		} else if (conteudoASerAlterado.equals("CAMPO")) {
			Validador.validaString(novoConteudo, "Formato do campo de interesse invalido.");
		} else {
			throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
		}
		Validador.validaCampoDeInteresse(novoConteudo);
		if (conteudoASerAlterado.equals("DESCRICAO")) {
			pesquisas.get(codigo).setDescricao(novoConteudo);
		} else if (conteudoASerAlterado.equals("CAMPO")) {
			pesquisas.get(codigo).setCampoDeInteresse(novoConteudo);
		}
	}

	/**
	 * Metodo que encerra uma Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @param motivo eh o motivo pelo qual o usuario quer encerrar a Pesquisa.
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		Validador.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		Validador.validaString(motivo, "Motivo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, pesquisas, "Pesquisa nao encontrada.");
		Validador.ehDesativada(codigo, desativadas, "Pesquisa desativada.");
		desativadas.put(codigo, motivo);
	}

	/**
	 * Metodo que ativa a Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		Validador.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, pesquisas, "Pesquisa nao encontrada.");
		if (!desativadas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa ja ativada.");
		}

		desativadas.remove(codigo);
	}

	/**
	 * Metodo que exibe a representacao textual da Pesquisa em forma de String.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return a representacao textual da Pesquisa em forma de String.
	 */
	public String exibePesquisa(String codigo) {
		Validador.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, pesquisas, "Pesquisa nao encontrada.");
		return pesquisas.get(codigo).toString();
	}

	/**
	 * Metodo que retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		Validador.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, pesquisas, "Pesquisa nao encontrada.");
		if (!this.desativadas.containsKey(codigo)) {
			return true;
		}
		return false;
	}

	/** Retorna uma pesquisa pelo codigo
	 * 
	 * @param codigoPesquisa id da pesquisa
	 * @return Objeto Pesquisa
	 */
	public Pesquisa getPesquisa(String codigoPesquisa) {
		Validador.isRegistered(codigoPesquisa, this.pesquisas, "Pesquisa nao encontrada.");
		return this.pesquisas.get(codigoPesquisa);
	}

	/**
	 * Associa um problema para a pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param problema   Um objeto problema
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaProblema(String idPesquisa, Problema problema) {
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisas.get(idPesquisa).associaProblema(problema);
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
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisas.get(idPesquisa).desassociaProblema();
	}

	/**
	 * Associa um objetivo para a pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param objetivo   Objetivo da pesquisa
	 * 
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaObjetivo(String idPesquisa, Objetivo objetivo) {
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		if (objetivo == null) {
			throw new IllegalArgumentException("Objetivo nao pode ser nulo.");
		}
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		if (this.pesquisas.get(idPesquisa).containsObjetivo(objetivo.getCodigo())) {
			return false;
		}
		for (Map.Entry<String, Pesquisa> pesquisa : this.pesquisas.entrySet()) {
			if (this.pesquisas.get(pesquisa.getKey()).containsObjetivo(objetivo.getCodigo())) {
				throw new IllegalArgumentException("Objetivo ja associado a uma pesquisa.");
			}
		}
		return this.pesquisas.get(idPesquisa).associaObjetivo(objetivo.getCodigo(), objetivo);
	}

	/**
	 * Desassocia um objetivo da pesquisa
	 * 
	 * @param idPesquisa identificador da pesquisa
	 * @param objetivo   Objetivo da pesquisa
	 * 
	 * @return boolean (true para desassociado com sucesso, false para nao
	 *         desassociado)
	 */
	public boolean desassociaObjetivo(String idPesquisa, Objetivo objetivo) {
		Validador.validaString(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		if (!pesquisaEhAtiva(idPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		return this.pesquisas.get(idPesquisa).desassociaObjetivo(objetivo.getCodigo(), objetivo);
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
		if (!(ordem.equals("PROBLEMA") | ordem.equals("OBJETIVOS") | ordem.equals("PESQUISA"))) {
			throw new IllegalArgumentException("Valor invalido da ordem");
		}

		String ordenado = "";
		List<Pesquisa> tempPesquisas = new ArrayList<Pesquisa>();
		for (Map.Entry<String, Pesquisa> pesquisas : this.pesquisas.entrySet()) {
			tempPesquisas.add(pesquisas.getValue());
		}
		
		if (ordem.equals("PROBLEMA")) {
			Collections.sort(tempPesquisas, new ComparadorPesquisaProblema());
		} else if (ordem.equals("OBJETIVOS")) {
			Collections.sort(tempPesquisas, new ComparadorPesquisaObjetivos());
		} else if (ordem.equals("PESQUISA")) {
			Collections.sort(tempPesquisas, new ComparadorPesquisaCodigo());
		}
		
		for (int i = 0; i < tempPesquisas.size(); i++) {
			if (i != 0) ordenado += " | ";
			ordenado += tempPesquisas.get(i).toString();
		}

		return ordenado;
	}

	public List<String> busca(String termo) {
		List<String> achados = new ArrayList<>();
		for (Pesquisa pesquisa : this.pesquisas.values()) {
			if (pesquisa.contemTermo(termo)) {
				for (String mensagem : pesquisa.exibeRepresentacoesBusca()) {
					achados.add(mensagem);
				}
			}
		}
		return achados;
	}

	/**
	 * Metodo que retorna uma determinada pesquisa, de acorodo com o codigo passado no parametro.
	 * 
	 * @param codigo eh o Id que identifica a pesquisa.
	 * @return retorna uma determinada pesquisa, de acorodo com o codigo passado no parametro.
	 */
	public Pesquisa buscaPesquisa(String codigo) {
		return pesquisas.get(codigo);
	}
	
	/**
	 * Define a estrategia de sugestao de atividades.
	 * 
	 * @param estrategia Uma String indicando a estrategia que deve ser utlizada.
	 */
	public void configuraEstrategia(String estrategia) {
		Validador.validaString(estrategia, "Estrategia nao pode ser nula ou vazia.");
		if (estrategia.equals("MAIS_ANTIGA")) {
			this.estrategia = new AtividadeMaisAntiga();
		} else if (estrategia.equals("MENOS_PENDENCIAS")) {
			this.estrategia = new AtividadeMenosPendencias();
		} else if (estrategia.equals("MAIOR_RISCO")) {
			this.estrategia = new AtividadeMaiorRisco();
		} else if (estrategia.equals("MAIOR_DURACAO")) {
			this.estrategia = new AtividadeMaiorDuracao();
		} else {
			throw new IllegalArgumentException("Valor invalido da estrategia");
		}
	}

	/**
	 * Sugere a proxima atividade a ser realizada em uma pesquisa.
	 * 
	 * @param codigoPesquisa O identificador da pesquisa.
	 * @return O codigo da atividade sugerida.
	 */
	public String proximaAtividade(String codigoPesquisa) {
		Validador.validaString(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
		
		if (!this.pesquisas.containsKey(codigoPesquisa)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		} else if (this.desativadas.containsKey(codigoPesquisa)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		
		Pesquisa pesquisa = this.pesquisas.get(codigoPesquisa);
		return pesquisa.proximaAtividade(this.estrategia);
	}

	/**
	 * Associa uma atividade a uma pesquisa.
	 *
	 * @param codigoPesquisa codigo da pesquisa
	 * @param codigoAtividade codigo da atividade
	 * @param atividade objeto da atividade
	 *
	 * @return boolean (true para associado com sucesso, false para nao associado)
	 */
	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade, AtividadeMetodologica atividade){
		Validador.validaString(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigoPesquisa, this.pesquisas, "Pesquisa nao encontrada.");

		if(!pesquisaEhAtiva(codigoPesquisa)){
			throw new IllegalArgumentException("Pesquisa desativada.");
		}

		if(atividade == null){
			throw new NullPointerException("Atividade nao encontrada");
		}

		return this.pesquisas.get(codigoPesquisa).associaAtividade(codigoAtividade, atividade);
	}

	/**
	 * Desassocia uma atividade a uma pesquisa.
	 *
	 * @param codigoPesquisa codigo da pesquisa
	 * @param codigoAtividade codigo da atividade
	 *
	 * @return boolean (true para desassociado com sucesso, false para nao
	 *         desassociado)
	 */
	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade){
		Validador.validaString(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigoPesquisa, this.pesquisas, "Pesquisa nao encontrada.");

		if(!pesquisaEhAtiva(codigoPesquisa)){
			throw new IllegalArgumentException("Pesquisa desativada.");
		}

		return this.pesquisas.get(codigoPesquisa).desassociaAtividade(codigoAtividade);
	}

	/**
	 * Executa uma atividade associada a pelo menos uma pesquisa.
	 *
	 * @param codigoAtividade codigo da atividade
	 * @param item posicao do item a ser executado
	 * @param duracao duracao da execucao
	 */
	public void executaAtividade(String codigoAtividade, int item, int duracao){
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.validaValoresNegativos(item, "Item nao pode ser nulo ou negativo.");
		Validador.validaValoresNegativos(duracao, "Duracao nao pode ser nula ou negativa.");

		boolean naoAssociada = true;

		for(Pesquisa pesquisa : this.pesquisas.values()){
			AtividadeMetodologica atividade = pesquisa.getAtividadeAssociada(codigoAtividade);
			if(atividade != null){
				naoAssociada = false;
				atividade.realizarItem(item, duracao);
				break;
			}
		}

		if(naoAssociada){
			throw new IllegalArgumentException("Atividade sem associacoes com pesquisas.");
		}
	}

	/**
	 * Cadastra um resultado em uma atividade.
	 *
	 * @param codigoAtividade codigo da atividade
	 * @param resultado descricao do resultado
	 *
	 * @return inteiro representando a quantidade de resultados cadastrados
	 */
	public int cadastraResultado(String codigoAtividade, String resultado){
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.validaString(resultado, "Resultado nao pode ser nulo ou vazio.");

		for(Pesquisa pesquisa : this.pesquisas.values()){
			AtividadeMetodologica atividade = pesquisa.getAtividadeAssociada(codigoAtividade);
			if(atividade != null){
				return atividade.cadastraResultado(resultado);
			}
		}

		throw new IllegalArgumentException("Atividade sem associacoes com pesquisas.");
	}

	/**
	 * Remove um resultado de uma atividade.
	 *
	 * @param codigoAtividade codigo da atividade
	 * @param numeroResultado posicao do resultado
	 *
	 * @return boolean (true para removido com sucesso, false para nao
	 *         removido)
	 */
	public boolean removeResultado(String codigoAtividade, int numeroResultado){
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.validaValoresNegativos(numeroResultado, "numeroResultado nao pode ser nulo ou negativo.");

		for(Pesquisa pesquisa : this.pesquisas.values()){
			AtividadeMetodologica atividade = pesquisa.getAtividadeAssociada(codigoAtividade);
			if(atividade != null){
				return atividade.removeResultado(numeroResultado);
			}
		}

		throw new IllegalArgumentException("Atividade sem associacoes com pesquisas.");
	}

	/**
	 * Lista todos os resultados de uma atividade.
	 *
	 * @param codigoAtividade codigo da atividade
	 *
	 * @return String representando todos os resultados
	 */
	public String listaResultados(String codigoAtividade){
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");

		for(Pesquisa pesquisa : this.pesquisas.values()){
			AtividadeMetodologica atividade = pesquisa.getAtividadeAssociada(codigoAtividade);

			if(atividade != null){
				return atividade.listaResultados();
			}
		}

		throw new IllegalArgumentException("Atividade sem associacoes com pesquisas.");
	}

	/**
	 * Retorna a duracao total de uma atividade.
	 *
	 * @param codigoAtividade codigo da atividade
	 *
	 * @return inteiro representando a duracao total da atividade
	 */
	public int getDuracao(String codigoAtividade){
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");

		for(Pesquisa pesquisa : this.pesquisas.values()){
			AtividadeMetodologica atividade = pesquisa.getAtividadeAssociada(codigoAtividade);

			if(atividade != null){
				return atividade.getDuracao();
			}
		}

		throw new IllegalArgumentException("Atividade sem associacoes com pesquisas.");
	}

	/**
	 * Salva todos os atributos.
	 */
	public void salvaDados(){
		Persistencia.salvar(this.pesquisas, "pesquisaController", "pesquisas");
		Persistencia.salvar(this.codigos, "pesquisaController", "codigos");
		Persistencia.salvar(this.desativadas, "pesquisaController", "desativadas");
		Persistencia.salvar(this.estrategia, "pesquisaController", "estrategia");
	}

	/**
	 * Carrega todos os atributos.
	 */
	public void carregaDados(){
		this.pesquisas = (LinkedHashMap<String, Pesquisa>) Persistencia.carregar("pesquisaController", "pesquisas");
		this.codigos = (LinkedHashMap<String, Integer>) Persistencia.carregar("pesquisaController", "codigos");
		this.desativadas = (LinkedHashMap<String, String>) Persistencia.carregar("pesquisaController", "desativadas");
		this.estrategia = (Comparator<AtividadeMetodologica>) Persistencia.carregar("pesquisaController", "estrategia");
	}
}
