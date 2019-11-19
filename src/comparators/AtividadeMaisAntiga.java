package comparators;

import java.util.Comparator;

import entidades.AtividadeMetodologica;

/**
 * Estrategia de comparacao baseada na ordem de cadastro das atividades em uma
 * pesquisa. Essa estrategia so leva em consideracao atividades que tenham itens
 * pendentes.
 * 
 * @author Carlos Ribeiro
 *
 */
public class AtividadeMaisAntiga implements Comparator<AtividadeMetodologica> {

	/**
	 * Compara duas atividades baseado em sua ordem de cadastro dentro de uma
	 * pesquisa.
	 */
	@Override
	public int compare(AtividadeMetodologica atv1, AtividadeMetodologica atv2) {
		if (atv1.contaItensPendentes() == 0)
			return 1;
		if (atv2.contaItensPendentes() == 0)
			return -1;
		String codigo1 = atv1.getCodigo();
		String codigo2 = atv2.getCodigo();
		return Integer.parseInt(codigo1.substring(1, codigo1.length()))
				- Integer.parseInt(codigo2.substring(1, codigo2.length()));
	}
}