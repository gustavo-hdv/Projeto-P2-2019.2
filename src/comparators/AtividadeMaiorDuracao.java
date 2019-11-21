package comparators;

import java.io.Serializable;
import java.util.Comparator;

import entidades.AtividadeMetodologica;

/**
 * Estrategia de comparacao baseada na duracao das atividades em uma pesquisa.
 * Essa estrategia so leva em consideracao atividades que tenham itens
 * pendentes. Alem disso, o desempate baseia-se na ordem de cadastro das
 * atividades.
 * 
 * @author Carlos Ribeiro
 *
 */
public class AtividadeMaiorDuracao implements Comparator<AtividadeMetodologica>, Serializable {

	/**
	 * Compara duas atividades baseado em suas duracoes dentro de uma pesquisa.
	 */
	@Override
	public int compare(AtividadeMetodologica atv1, AtividadeMetodologica atv2) {
		if (atv1.contaItensPendentes() == 0) {
			return 1;
		}
		if (atv2.contaItensPendentes() == 0) {
			return -1;
		}
		int res = atv2.getDuracao() - atv1.getDuracao();
		if (res == 0) {
			Comparator<AtividadeMetodologica> novaEstrategia = new AtividadeMaisAntiga();
			return novaEstrategia.compare(atv1, atv2);
		}
		return res;
	}
}
