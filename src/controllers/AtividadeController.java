package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import comparators.*;
import projeto.*;

/** 
 * Representacao de um controlador de atividades metodologicas
 */

public class AtividadeController {

	/** Mapa de atividades metodologicas por um codigo ("A" + posicao) */
	private Map<String, AtividadeMetodologica> atividadesMetodologicas;
	/** Numero para gerar o codigo de uma atividade */
	private int contagem;
	
	private Estrategia estrategia;

	/** Construtor de uma atividade metodologica */
	public AtividadeController() {
		this.atividadesMetodologicas = new LinkedHashMap<String, AtividadeMetodologica>();
		this.contagem = 0;
	}

	/**
	 * Cadastra uma atividade com descricao, nivel de risco e uma descricao de risco
	 * no mapa de atividades
	 * 
	 * @param descricao      (descricao da atividade) (String)
	 * @param nivelRisco     (nivel de risco da atividade) (String)
	 * @param descricaoRisco (descricao de risco da atividade) (String)
	 * 
	 * @return codigo da atividade, estilo: "A + posicao"
	 */
	public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco) {
		Validador.validaString(descricao, "Campo Descricao nao pode ser nulo ou vazio.");
		Validador.validaString(nivelRisco, "Campo nivelRisco nao pode ser nulo ou vazio.");
		Validador.validaString(descricaoRisco, "Campo descricaoRisco nao pode ser nulo ou vazio.");
		if (!(nivelRisco.equalsIgnoreCase("BAIXO") || nivelRisco.equalsIgnoreCase("MEDIO")
				|| nivelRisco.equalsIgnoreCase("ALTO"))) {
			throw new IllegalArgumentException("Valor invalido do nivel do risco.");
		}

		String codigo = "A" + (++this.contagem);
		this.atividadesMetodologicas.put(codigo,
				new AtividadeMetodologica(descricao, nivelRisco, descricaoRisco, codigo));
		return codigo;
	}

	/**
	 * Apaga uma atividade pelo codigo
	 * 
	 * @param codigo da atividade (String)
	 */
	public void apagaAtividade(String codigo) {
		Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, atividadesMetodologicas, "Atividade nao encontrada");

		this.atividadesMetodologicas.remove(codigo);
	}

	/**
	 * Cadastra um item para uma atividade
	 * 
	 * @param codigo da atividade (String)
	 * @param item   (descricao do item) (String)
	 */
	public void cadastraItem(String codigo, String item) {
		Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		Validador.validaString(item, "Item nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, atividadesMetodologicas, "Atividade nao encontrada");

		this.atividadesMetodologicas.get(codigo).cadastraItem(item);

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
		Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, atividadesMetodologicas, "Atividade nao encontrada");

		return atividadesMetodologicas.get(codigo).exibeAtividade();
	}

	/**
	 * Exibe a quantidade de itens pendentes dos resultados de um atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens pendentes (int)
	 */
	public int contaItensPendentes(String codigo) {
		Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, atividadesMetodologicas, "Atividade nao encontrada");

		return this.atividadesMetodologicas.get(codigo).contaItensPendentes();
	}

	/**
	 * Exibe a quantidade de itens realizados dos resultados de um atividade
	 * 
	 * @param codigo da atividade (String)
	 * 
	 * @return quantidade de itens realizados (int)
	 */
	public int contaItensRealizados(String codigo) {
		Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		Validador.isRegistered(codigo, atividadesMetodologicas, "Atividade nao encontrada");

		return this.atividadesMetodologicas.get(codigo).contaItensRealizados();
	}

	public AtividadeMetodologica getAtividade(String codigoAtividade) {
		return this.atividadesMetodologicas.get(codigoAtividade);
	}

	public List<String> busca(String termo) {
		List<String> achados = new ArrayList<>();
		for (AtividadeMetodologica atividades : this.atividadesMetodologicas.values()) {
			if (atividades.contemTermo(termo)) {
				for (String mensagem : atividades.exibeRepresentacoesBusca()) {
					achados.add(mensagem);
				}
			}
		}
		return achados;
	}

}
