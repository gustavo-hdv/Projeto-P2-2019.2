package comparators;

import java.util.Comparator;
import projeto.AtividadeMetodologica;

/**
 * Estrategia de comparacao baseada na quantidade de itens pendentes das
 * atividades em uma pesquisa. Essa estrategia so leva em consideracao
 * atividades que tenham itens pendentes. Alem disso, o desempate baseia-se na
 * ordem de cadastro das atividades.
 * 
 * @author Carlos Ribeiro
 *
 */
public class AtividadeMenosPendencias implements Comparator<AtividadeMetodologica> {

	/**
	 * Compara duas atividades baseado em suas quantidades de pendencias dentro de
	 * uma pesquisa.
	 */
	@Override
	public int compare(AtividadeMetodologica atv1, AtividadeMetodologica atv2) {
		int res = atv1.contaItensPendentes() - atv2.contaItensPendentes();
		if (atv1.contaItensPendentes() == 0)
			return 1;
		if (atv2.contaItensPendentes() == 0)
			return -1;
		if (res == 0) {
			Comparator<AtividadeMetodologica> estrategia = new AtividadeMaisAntiga();
			return estrategia.compare(atv1, atv2);
		}
		return res;
	}
}
