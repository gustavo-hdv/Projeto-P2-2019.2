package projeto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Busca {
	private List<Buscador> buscadores;
	private List<Buscavel> buscados;
	private String termo;
	
	public Busca(PesquisadorController pesquisadorC, PesquisaController pesquisaC, AtividadeController atividadesC, ObjetivoController objetivoC, ProblemaController problemaC, String termo) {
		this.buscadores = new ArrayList<>();
		this.buscadores.add(pesquisadorC);
		//this.buscadores.add(pesquisaC);
		this.buscadores.add(atividadesC);
		this.buscadores.add(objetivoC);
		this.buscadores.add(problemaC);
		this.buscados = new ArrayList<>();
		this.termo = termo;
	}
	
	private ArrayList<Buscavel> getEntidades() {
		ArrayList<Buscavel> buscados = new ArrayList<>();
		for (Buscador buscador : buscadores) {
			Collection<Buscavel> achados = buscador.busca(this.termo);
			for (Buscavel buscado : achados) {
				buscados.add(buscado);
			}
		}
		return buscados;
	}
	
	@Override
	public String toString() {
		String msg = "";
		boolean aux = true;
		ArrayList<Buscavel> buscados = getEntidades();
		for (Buscavel buscado : buscados) {
			if (aux) {
				msg += buscado.exibeRepresentacaoBusca();
				aux = false;
			} else {
				msg += " | " + buscado.exibeRepresentacaoBusca();
			}
		}
		return msg;
	}
}
