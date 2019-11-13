package projeto;

import java.util.Comparator;

/** Comparador de pesquisas do maior ID para o de menor ID
 *  (ORDEM: PESQUISA).
 */
public class CompararPesquisas implements Comparator<Pesquisa> {

	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		return arg1.getCodigo().compareTo(arg0.getCodigo());
	}
	
}
