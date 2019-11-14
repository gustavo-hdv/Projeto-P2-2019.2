package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparators.*;
import projeto.*;

/**
 * Representação de um Controle, que é responsável por manipular os Collections,
 * e guardar alguns métodos do programa que sejam referentes a Classe Pesquisa.
 * 
 * @author Gabriel Menezes Cabral - 119110372.
 *
 */
public class PesquisaController {

	/**
	 * Eh o codigo da Pesquisa.
	 */
	private String codigo;

	/**
	 * HashMap responsavel por guardar as pesquisas cadastradas. Essas pesquisas
	 * estao associadas ao seu codigo.
	 */
	protected HashMap<String, Pesquisa> pesquisas;

	/**
	 * HashMap responsavel por registrar as pesquisas que foram desativadas . Essas
	 * pesquisas estao associadas ao seu codigo.
	 */
	private HashMap<String, String> desativadas;

	/**
	 * HashMap responsavel por guardar um codigo associado a um ArrayList, o tamanho
	 * desse ArrayList eh equivalente a quantidade de vezes que esse codigo com
	 * essas 3 letras ja foram usados.
	 */
	private HashMap<String, qtdVezesIdPesquisaUsado> codigos;
	
	private Estrategia estrategia;

	/**
	 * Constroi um Controle da Pesquisa e inicializa os HashMap e o atributo codigo.
	 */
	public PesquisaController() {
		this.codigo = "";
		this.pesquisas = new HashMap<String, Pesquisa>();
		this.desativadas = new HashMap<String, String>();
		this.codigos = new HashMap<String, qtdVezesIdPesquisaUsado>();
	}

	/**
	 * Exporta um resumo da pesquisa em arquivo de texto Representado todas as
	 * entidades de um pesquisa em ordem de cadastro. Formato do arquivo:
	 * CODIGOPESQUISA.txt
	 */
	public void gravarResumo(String codigoPesquisa) {
		Validador.validaString(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
		Validador.isRegistered(codigoPesquisa, this.pesquisas, "Pesquisa nao encontrada.");
		Pesquisa pesquisa = this.pesquisas.get(codigoPesquisa);
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
	
	public String exibeObjetivos(String codigoPesquisa) {
		return this.pesquisas.get(codigoPesquisa).exibeObjetivos();
	}
	
	public String exibeAtividades(String codigoPesquisa) {
		return this.pesquisas.get(codigoPesquisa).exibeAtividades();
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
		if (campoDeInteresse.length() > 255) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		List<String> camposDeInteresse = Arrays.asList(campoDeInteresse.split(","));
		for (int i = 0; i < camposDeInteresse.size(); i++) {
			if (camposDeInteresse.get(i).length() < 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
		for (int i = 0; i < campoDeInteresse.length(); i++) {
			if (campoDeInteresse.length() - campoDeInteresse.replaceAll(",", "").length() > 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
		String codigoLetras = campoDeInteresse.substring(0, 3).toUpperCase();
		if (codigos.containsKey(codigoLetras)) {
			codigos.get(codigoLetras).somaMaisUmQuantiadadeEsteCodigoFoiUsado();
			codigo = codigoLetras + codigos.get(codigoLetras).qtdVezesIdPesquisaFoiUsado();
		} else {
			codigo = codigoLetras + "1";
			codigos.put(codigoLetras, new qtdVezesIdPesquisaUsado(0));
			codigos.get(codigoLetras).somaMaisUmQuantiadadeEsteCodigoFoiUsado();
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
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if (desativadas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		if (novoConteudo.length() > 255) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		Validador.validaString(conteudoASerAlterado, "Conteudo a ser alterado nao pode ser vazio ou nulo.");
		if (conteudoASerAlterado.equals("DESCRICAO")) {
			Validador.validaString(novoConteudo, "Descricao nao pode ser nula ou vazia.");
		} else if (conteudoASerAlterado.equals("CAMPO")) {
			Validador.validaString(novoConteudo, "Formato do campo de interesse invalido.");
		} else {
			throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
		}
		List<String> novoConteudoList = Arrays.asList(novoConteudo.split(","));
		for (int i = 0; i < novoConteudoList.size(); i++) {
			if (novoConteudoList.get(i).length() < 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
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
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if (desativadas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		desativadas.put(codigo, motivo);
	}

	/**
	 * Metodo que ativa a Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		Validador.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
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
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
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
		if (!this.pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if (!this.desativadas.containsKey(codigo)) {
			return true;
		}
		return false;
	}

	public Pesquisa getPesquisa(String codigoPesquisa) {
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
	 * Lista as pesquisas em determinada ordem Estilo: CÓDIGO - Descrição - Campo de
	 * interesse
	 * 
	 * @param ordem descreve o tipo da listagem das pesquisas
	 * @return CODIGO - Descricao - Campo de interesse | CODIGO - Descricao - Campo
	 *         de interesse | ...
	 */
	public String listaPesquisas(String ordem) {
		Validador.validaString(ordem, "Valor invalido da ordem");
		if (!((ordem.equals("PROBLEMA")) | ordem.equals("OBJETIVOS") | ordem.equals("PESQUISA"))) {
			throw new IllegalArgumentException("Valor invalido da ordem");
		}

		String ordenado = "";
		List<Pesquisa> tempPesquisas = new ArrayList<Pesquisa>();
		for (Map.Entry<String, Pesquisa> pesquisas : this.pesquisas.entrySet()) {
			tempPesquisas.add(pesquisas.getValue());
		}

		if (ordem.equals("PROBLEMA")) {
			Collections.sort(tempPesquisas, new ComparadorPesquisaProblema());
			for (int i = 0; i < tempPesquisas.size(); i++) {
				if (i != 0)
					ordenado += " | ";
				ordenado += tempPesquisas.get(i).toString();
			}
		} else if (ordem.equals("OBJETIVOS")) {
			Collections.sort(tempPesquisas, new ComparadorPesquisaObjetivos());
			for (int i = 0; i < tempPesquisas.size(); i++) {
				if (i != 0)
					ordenado += " | ";
				ordenado += tempPesquisas.get(i).toString();
			}
		} else if (ordem.equals("PESQUISA")) {
			Collections.sort(tempPesquisas, new ComparadorPesquisaCodigo());
			for (int i = 0; i < tempPesquisas.size(); i++) {
				if (i != 0)
					ordenado += " | ";
				ordenado += tempPesquisas.get(i).toString();
			}
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
	 * GABRIEL
	 */
	public Pesquisa buscaPesquisa(String codigo) {
		return pesquisas.get(codigo);
	}
	
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

	public String proximaAtividade(String codigoPesquisa) {
		Validador.validaString(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
		if (!this.pesquisas.containsKey(codigoPesquisa)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		Pesquisa pesquisa = this.pesquisas.get(codigoPesquisa);
		return pesquisa.proximaAtividade(this.estrategia);
	}

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

	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade){
		Validador.validaString(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		Validador.validaString(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigoPesquisa, this.pesquisas, "Pesquisa nao encontrada.");

		if(!pesquisaEhAtiva(codigoPesquisa)){
			throw new IllegalArgumentException("Pesquisa desativada.");
		}

		return this.pesquisas.get(codigoPesquisa).desassociaAtividade(codigoAtividade);
	}
}
