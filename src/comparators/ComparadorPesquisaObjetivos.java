package comparators;

import java.util.Comparator;

import projeto.Pesquisa;

/** Comparador de pesquisas com mais objetivos associados.
 *  Em caso de empate, lista primeiro a pesquisa com objetivo de maior ID.
 *  Para as pesquisas sem objetivos, lista da pesquisa de maior ID para a de menor ID
 *  (ORDEM: OBJETIVOS).
 */
public class ComparadorPesquisaObjetivos implements Comparator<Pesquisa> {

	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		if (arg0.quantidadeObjetivos() < arg1.quantidadeObjetivos()) {
			return 1;
		}
		if (arg0.quantidadeObjetivos() > arg1.quantidadeObjetivos()) {
			return -1;
		}
		if (arg1.quantidadeObjetivos() == arg0.quantidadeObjetivos()) {
			if (arg1.getObjetivoIdMaior() != null && arg0.getObjetivoIdMaior() != null) {
				if (arg1.getObjetivoIdMaior() == arg0.getObjetivoIdMaior()) {
					return arg1.getCodigo().compareTo(arg0.getCodigo());
				}
				return arg1.getObjetivoIdMaior().compareTo(arg0.getObjetivoIdMaior());
			}
			if (arg1.getObjetivoIdMaior() == null && arg0.getObjetivoIdMaior() != null) {
				return -1;
			}
			if (arg1.getObjetivoIdMaior() != null && arg0.getObjetivoIdMaior() == null) {
				return 1;
			}
		}
		return arg1.getCodigo().compareTo(arg0.getCodigo());
	}
}
