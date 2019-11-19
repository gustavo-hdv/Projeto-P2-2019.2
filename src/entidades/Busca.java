package entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import comparators.BuscaComparator;
import controllers.AtividadeController;
import controllers.ObjetivoController;
import controllers.PesquisaController;
import controllers.PesquisadorController;
import controllers.ProblemaController;

/**
 * Entidade que representa a busca por um termo no sistema.
 * 
 * @author Carlos Ribeiro
 */
public class Busca {
	/**
	 * Entidades responsaveis por vasculhar o sistema.
	 */
	private List<Buscador> buscadores;

	/**
	 * Entidades encontradas apos uma busca no sistema.
	 */
	private List<String> resultados;

	/**
	 * Termo a ser buscado no sistema.
	 */
	private String termo;

	/**
	 * Entidade responsavel por vasculhar pesquisas.
	 */
	private PesquisaController pesquisaC;

	/**
	 * Entidade responsavel por vasculhar atividades.
	 */
	private AtividadeController atividadesC;

	/**
	 * Cria a entidade que representa a busca por um termo no sistema. Cada busca
	 * recebe as entidades que ira usar para vasculhar o sistema e o faz no momento
	 * em que eh instanciada.
	 * 
	 * @param pesquisadorC O controlador de pesquisadores.
	 * @param pesquisaC    O controlador de pesquisas.
	 * @param atividadesC  O controlador de atividades.
	 * @param objetivoC    O controlador de objetivos.
	 * @param problemaC    O controlador de problemas.
	 * @param termo        O termo a ser buscado no sistema.
	 */
	public Busca(PesquisadorController pesquisadorC, PesquisaController pesquisaC, AtividadeController atividadesC,
			ObjetivoController objetivoC, ProblemaController problemaC, String termo) {
		this.buscadores = new ArrayList<>();
		this.buscadores.add(pesquisadorC);
		this.buscadores.add(objetivoC);
		this.buscadores.add(problemaC);
		this.pesquisaC = pesquisaC;
		this.atividadesC = atividadesC;
		this.termo = termo;
		this.resultados = getMensagens();
	}

	private void validaResultados(List<String> resultados) {
		if (resultados.size() == 0)
			throw new RuntimeException("Nenhum resultado encontrado");
	}

	private void validaIndice(int indice) {
		if (resultados.size() <= indice)
			throw new IllegalArgumentException("Entidade nao encontrada.");
		if (indice < 0)
			throw new IllegalArgumentException("Numero do resultado nao pode ser negativo");
	}

	private static String join(List<String> mensagens) {
		String msg = "";
		boolean first = true;
		for (String mensagem : mensagens) {
			if (first) {
				msg += mensagem;
				first = false;
			} else {
				msg += " | " + mensagem;
			}
		}
		return msg;
	}

	private ArrayList<String> getMensagens() {
		ArrayList<String> mensagens = new ArrayList<>();
		for (Buscador buscador : buscadores) {
			Collection<Buscavel> achados = buscador.busca(this.termo);
			for (Buscavel buscado : achados) {
				mensagens.add(buscado.exibeRepresentacaoBusca());
			}
		}
		for (String mensagem : pesquisaC.busca(this.termo)) {
			if (mensagem.contains(this.termo)) {
				mensagens.add(mensagem);
			}
		}
		for (String mensagem : atividadesC.busca(this.termo)) {
			if (mensagem.contains(this.termo)) {
				mensagens.add(mensagem);
			}
		}
		BuscaComparator comparador = new BuscaComparator();
		Collections.sort(mensagens, comparador);
		return mensagens;
	}

	/**
	 * Conta quantos resultados uma busca obteve.
	 * 
	 * @return O numero de resultados.
	 */
	public int contaResultadosBusca() {
		validaResultados(resultados);
		return resultados.size();
	}

	/**
	 * Retorna uma representacao em String das entidades encontradas na busca.
	 */
	@Override
	public String toString() {
		String res = join(this.resultados);
		return res;
	}

	/**
	 * Retorna o resultado associado a um indice na busca.
	 * 
	 * @param indice O indice do resultado.
	 */
	public String getResultado(int indice) {
		validaIndice(indice);
		return this.resultados.get(indice - 1);
	}
}
