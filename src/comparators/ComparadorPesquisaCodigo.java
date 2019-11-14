package comparators;

import java.util.Comparator;

import projeto.Pesquisa;

/** Comparador de pesquisas do maior ID para o de menor ID
 *  (ORDEM: PESQUISA).
 */
public class ComparadorPesquisaCodigo implements Comparator<Pesquisa> {

	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		return arg1.getCodigo().compareTo(arg0.getCodigo());
	}
	
}
