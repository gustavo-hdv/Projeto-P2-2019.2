package comparators;

import java.io.Serializable;
import java.util.Comparator;

import entidades.Pesquisa;

/** Comparador de pesquisas do maior ID para o de menor ID
 *  (ORDEM: PESQUISA).
 */
public class ComparadorPesquisaCodigo implements Comparator<Pesquisa>, Serializable {

	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		return arg1.getCodigo().compareTo(arg0.getCodigo());
	}
	
}
