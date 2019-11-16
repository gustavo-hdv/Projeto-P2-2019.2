package comparators;

import java.util.Comparator;
import java.util.HashMap;

import projeto.AtividadeMetodologica;
import projeto.Estrategia;

public class AtividadeMaiorRisco implements Comparator<AtividadeMetodologica> {

	public int compare(AtividadeMetodologica atv1, AtividadeMetodologica atv2) {
		if (atv1.contaItensPendentes() == 0) return 1;
		if (atv2.contaItensPendentes() == 0) return -1;
		HashMap<String, Integer> riscos = new HashMap<>();
		riscos.put("BAIXO", 3);
		riscos.put("MEDIO", 2);
		riscos.put("ALTO", 1);
		String risco1 = atv1.getRisco();
		String risco2 = atv2.getRisco();
		if (risco1.equals(risco2)) {
			Comparator<AtividadeMetodologica> novaEstrategia = new AtividadeMaisAntiga();
			return novaEstrategia.compare(atv1, atv2);
		}
		return riscos.get(risco1) - riscos.get(risco2);
	}

}
