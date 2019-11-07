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
		this.buscadores.add(pesquisaC);
		this.buscadores.add(atividadesC);
		this.buscadores.add(objetivoC);
		this.buscadores.add(pesquisadorC);
		this.buscadores.add(pesquisadorC);
		this.termo = termo;
	}
	
	@Override
	public String toString() {
		for (Buscador buscador : buscadores) {
			Collection<Buscavel> achados = buscador.busca(this.termo);
			for (Buscavel buscado : achados) {
				buscados.add(buscado);
			}
		}
		return null;
	}
}
