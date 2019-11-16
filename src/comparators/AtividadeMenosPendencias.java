package comparators;

import java.util.Comparator;
import projeto.AtividadeMetodologica;

public class AtividadeMenosPendencias implements Comparator<AtividadeMetodologica> {

	@Override
	public int compare(AtividadeMetodologica atv1, AtividadeMetodologica atv2) {
		int res = atv1.contaItensPendentes() - atv2.contaItensPendentes();
		if (atv1.contaItensPendentes() == 0) return 1;
		if (atv2.contaItensPendentes() == 0) return -1;
		if (res == 0) {
			Comparator<AtividadeMetodologica> estrategia = new AtividadeMaisAntiga();
			return estrategia.compare(atv1, atv2);
		}
		return res;
	}
}
