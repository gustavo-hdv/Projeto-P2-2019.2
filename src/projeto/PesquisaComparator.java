package projeto;

import java.util.Comparator;

/** Comparador de pesquisas com associações a problemas de maior ID aparecem primeiro.
 *  Depois, aparecem as pesquisas sem problemas associados (da pesquisa com maior ID até a pesquisa para a de menor ID)
 *  (ORDEM: PROBLEMA).
 */
class CompararProblema implements Comparator<Pesquisa> {
	
	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		if (arg1.getProblema() != null && arg0.getProblema() != null) {
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

/** Comparador de pesquisas com mais objetivos associados.
 *  Em caso de empate, lista primeiro a pesquisa com objetivo de maior ID.
 *  Para as pesquisas sem objetivos, lista da pesquisa de maior ID para a de menor ID
 *  (ORDEM: OBJETIVOS).
 */
class CompararObjetivos implements Comparator<Pesquisa> {

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

/** Comparador de pesquisas do maior ID para o de menor ID
 *  (ORDEM: PESQUISA).
 */
class CompararPesquisas implements Comparator<Pesquisa> {

	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		return arg1.getCodigo().compareTo(arg0.getCodigo());
	}
	
}

/** Comparador de Pesquisa */
public class PesquisaComparator {
	
}
