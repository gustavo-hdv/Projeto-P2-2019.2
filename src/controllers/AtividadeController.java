package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

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

	/**
	 * GABRIEL
	 */
	public void defineProximaAtividade(String idPrecedente, String idSubsequente) {
		Validador.validaString(idPrecedente, "Atividade nao pode ser nulo ou vazio.");
		Validador.validaString(idSubsequente, "Atividade nao pode ser nulo ou vazio.");
		if (!this.atividadesMetodologicas.containsKey(idPrecedente)) {
			throw new IllegalArgumentException("Atividade nao encontrada.");
		}
		if (!this.atividadesMetodologicas.containsKey(idSubsequente)) {
			throw new IllegalArgumentException("Atividade nao encontrada.");
		}
		if (!this.atividadesMetodologicas.get(idPrecedente).getSubsequente().equals("")) {
			throw new IllegalArgumentException("Atividade ja possui uma subsequente.");
		}
		if (this.verificaSeTemLoop(idPrecedente, idSubsequente)) {
			throw new IllegalArgumentException("Criacao de loops negada.");
		}
		this.atividadesMetodologicas.get(idPrecedente).defineProximaAtividade(idSubsequente);
	}

	/**
	 * GABRIEL
	 * 
	 * @param idAtividade
	 * @return
	 */
	public boolean verificaSeTemLoop(String idPrecedente, String idSubsequente) {
		String atividadeAtual = idSubsequente;
		if (this.atividadesMetodologicas.get(atividadeAtual).getSubsequente().equals(idPrecedente)) {
			return true;
		} else if (this.atividadesMetodologicas.get(atividadeAtual).getSubsequente().equals("")) {
			return false;
		} else {
			atividadeAtual = this.atividadesMetodologicas.get(atividadeAtual).getSubsequente();
			return verificaSeTemLoop(idPrecedente, atividadeAtual);
		}
	}
	
	
	/**
	 * GABRIEL
	 */
	public void tiraProximaAtividade(String idPrecedente) {
		Validador.validaString(idPrecedente, "Atividade nao pode ser nulo ou vazio.");
		if (!this.atividadesMetodologicas.containsKey(idPrecedente)) {
			throw new IllegalArgumentException("Atividade nao encontrada.");
		}
		this.atividadesMetodologicas.get(idPrecedente).tiraProximaAtividade();
	}

	/**
	 * GABRIEL
	 * 
	 * @param idPrecedente
	 * @return
	 */
	public int contaProximos(String idPrecedente) {
		Validador.validaString(idPrecedente, "Atividade nao pode ser nulo ou vazio.");
		if (!this.atividadesMetodologicas.containsKey(idPrecedente)) {
			throw new IllegalArgumentException("Atividade nao encontrada.");
		}
		String atividadeAtual = idPrecedente;
		if (this.atividadesMetodologicas.get(atividadeAtual).getSubsequente().equals("")) {
			return 0;
		}

		atividadeAtual = this.atividadesMetodologicas.get(atividadeAtual).getSubsequente();
		return contaProximos(atividadeAtual) + 1;
	}

	/**
	 * GABRIEL
	 */
	public String pegaProximo(String idAtividade, int enesimaAtividade) {
		Validador.validaString(idAtividade, "Atividade nao pode ser nulo ou vazio.");
		if (!this.atividadesMetodologicas.containsKey(idAtividade)) {
			throw new IllegalArgumentException("Atividade nao encontrada.");
		}
		if (enesimaAtividade < 0 || enesimaAtividade == 0) {
			throw new ArgumentAccessException("EnesimaAtividade nao pode ser negativa ou zero.");
		}
		int contador = 0;
		String atividadeAtual = idAtividade;
		while (true) {
			if (contador < enesimaAtividade) {
				if (!this.atividadesMetodologicas.get(atividadeAtual).getSubsequente().equals("")) {
					contador += 1;
					atividadeAtual = this.atividadesMetodologicas.get(atividadeAtual).getSubsequente();
				} else {
					throw new IllegalArgumentException("Atividade inexistente.");
				}
			} else {
				break;
			}
		}
		return atividadeAtual;
	}

	/**
	 * GABRIEL
	 */
	public String pegaMaiorRiscoAtividades(String idAtividade) {
		Validador.validaString(idAtividade, "Atividade nao pode ser nulo ou vazio.");
		if (!this.atividadesMetodologicas.containsKey(idAtividade)) {
			throw new IllegalArgumentException("Atividade nao encontrada.");
		}
		if (this.atividadesMetodologicas.get(idAtividade).getSubsequente().equals("")) {
			throw new IllegalArgumentException("Nao existe proxima atividade.");
		}
		String atividadeAtual = idAtividade;
		String maiorRisco = "BAIXO";
		String idAtividadeMaiorRisco = "";
		while (true) {
			if (!this.atividadesMetodologicas.get(atividadeAtual).getSubsequente().equals("")) {
				atividadeAtual = this.atividadesMetodologicas.get(atividadeAtual).getSubsequente();
				if (analisaMaiorRisco(this.atividadesMetodologicas.get(atividadeAtual).getRisco(), maiorRisco)) {
					idAtividadeMaiorRisco = atividadeAtual;
					maiorRisco = this.atividadesMetodologicas.get(atividadeAtual).getRisco();
				}
			} else {
				break;
			}
		}
			return idAtividadeMaiorRisco;
		}
	/**
	 * GABRIEL
	 */
	public boolean analisaMaiorRisco(String risco, String maiorRisco) {
		HashMap<String, Integer> riscos = new HashMap<>();
		riscos.put("BAIXO", 1);
		riscos.put("MEDIO", 2);
		riscos.put("ALTO", 3);
		if (riscos.get(risco) > riscos.get(maiorRisco)) {
			return true;
		} else if (riscos.get(risco) == riscos.get(maiorRisco)) {
			return true;
		} else {
			return false;
		}
	}
	
}
