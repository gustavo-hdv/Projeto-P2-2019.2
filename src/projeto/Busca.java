package projeto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Busca {
	private List<Buscador> buscadores;
	private List<String> resultados;
	private String termo;
	
	public Busca(PesquisadorController pesquisadorC, PesquisaController pesquisaC, AtividadeController atividadesC, ObjetivoController objetivoC, ProblemaController problemaC, String termo) {
		this.buscadores = new ArrayList<>();
		this.buscadores.add(pesquisadorC);
		//this.buscadores.add(pesquisaC);
		//this.buscadores.add(atividadesC);
		this.buscadores.add(objetivoC);
		this.buscadores.add(problemaC);
		this.termo = termo;
		this.resultados = getMensagens();
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
		Collections.sort(mensagens, Collections.reverseOrder());
		return mensagens;
	}
	
	public int contaResultadosBusca() {
		return resultados.size();
	}
	
	@Override
	public String toString() {
		String res = join(this.resultados);
		return res;
	}
}
