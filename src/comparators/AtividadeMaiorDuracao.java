package comparators;

import java.util.Comparator;
import projeto.AtividadeMetodologica;

public class AtividadeMaiorDuracao implements Comparator<AtividadeMetodologica> {

	@Override
	public int compare(AtividadeMetodologica atv1, AtividadeMetodologica atv2) {
		return atv2.getDuracao() - atv1.getDuracao();
	}

}
