package projeto;

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

public class Busca {
	private List<Buscador> buscadores;
	private List<String> resultados;
	private String termo;
	private PesquisaController pesquisaC;
	private AtividadeController atividadesC;
	
	public Busca(PesquisadorController pesquisadorC, PesquisaController pesquisaC, AtividadeController atividadesC, ObjetivoController objetivoC, ProblemaController problemaC, String termo) {
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
		if (resultados.size() == 0) throw new RuntimeException("Nenhum resultado encontrado");
	}
	
	private void validaIndice(int indice) {
		if (resultados.size() <= indice) throw new IllegalArgumentException("Entidade nao encontrada.");
		if (indice < 0) throw new IllegalArgumentException("Numero do resultado nao pode ser negativo");
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
	
	public int contaResultadosBusca() {
		validaResultados(resultados);
		return resultados.size();
	}
	
	@Override
	public String toString() {
		String res = join(this.resultados);
		return res;
	}
	
	public String getResultado(int indice) {
		validaIndice(indice);
		return this.resultados.get(indice-1);
	}
}
