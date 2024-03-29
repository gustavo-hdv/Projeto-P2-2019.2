package comparators;

import java.io.Serializable;
import java.util.Comparator;

import entidades.Pesquisa;

/** Comparador de pesquisas com associações a problemas de maior ID aparecem primeiro.
 *  Depois, aparecem as pesquisas sem problemas associados (da pesquisa com maior ID até a pesquisa para a de menor ID)
 *  (ORDEM: PROBLEMA).
 */
public class ComparadorPesquisaProblema implements Comparator<Pesquisa>, Serializable {
	
	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		if (arg1.getProblema() != null && arg0.getProblema() != null) {
			if (arg1.getProblema().getCodigo().equals(arg0.getProblema().getCodigo())) {
				return arg1.getCodigo().compareTo(arg0.getCodigo());
			}
			return arg1.getProblema().getCodigo().compareTo(arg0.getProblema().getCodigo());
		}
		if (arg1.getProblema() == null && arg0.getProblema() != null) {
			return -1;
		}
		if (arg1.getProblema() != null && arg0.getProblema() == null) {
			return 1;
		}
		return arg1.getCodigo().compareTo(arg0.getCodigo());
	}
}
