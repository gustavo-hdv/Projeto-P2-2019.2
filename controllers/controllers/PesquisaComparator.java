package controllers;

import java.util.Comparator;

import projeto.Pesquisa;

/** Comparador de pesquisas com associações a problemas de maior ID aparecem primeiro.
 *  Depois, aparecem as pesquisas sem problemas associados (da pesquisa com maior ID até a pesquisa para a de menor ID)
 *  (ORDEM: PROBLEMA).
 */
class CompararProblema implements Comparator<Pesquisa> {
	
	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		if (!(arg1.getProblema() == null | arg0.getProblema() == null || arg1.getProblema().getCodigo() == null | arg0.getProblema().getCodigo() == null)) {
			return arg1.getProblema().getCodigo().compareTo(arg0.getProblema().getCodigo());
		}
		if (arg0.quantidadeObjetivos() < arg1.quantidadeObjetivos()) {
			return 1;
		}
		if (arg0.quantidadeObjetivos() > arg1.quantidadeObjetivos()) {
			return -1;
		}
		if (arg1.quantidadeObjetivos() == arg0.quantidadeObjetivos() && !(arg1.getObjetivoIdMaior() == null | arg0.getObjetivoIdMaior() == null)) {
			return arg1.getObjetivoIdMaior().compareTo(arg0.getObjetivoIdMaior());
		}
		if (!(arg1.getCodigo() == null | arg0.getCodigo() == null)) {
			return arg1.getCodigo().compareTo(arg0.getCodigo());
		}
		return arg0.toString().compareTo(arg1.toString());
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
		if (arg1.quantidadeObjetivos() == arg0.quantidadeObjetivos() && !(arg1.getObjetivoIdMaior() == null | arg0.getObjetivoIdMaior() == null)) {
			return arg1.getObjetivoIdMaior().compareTo(arg0.getObjetivoIdMaior());
		}
		if (!(arg1.getCodigo() == null | arg0.getCodigo() == null)) {
			return arg1.getCodigo().compareTo(arg0.getCodigo());
		}
		return arg0.toString().compareTo(arg1.toString());
	}
}

/** Comparador de pesquisas do maior ID para o de menor ID
 *  (ORDEM: PESQUISA).
 */
class CompararPesquisas implements Comparator<Pesquisa> {

	@Override
	public int compare(Pesquisa arg0, Pesquisa arg1) {
		if (!(arg1.getCodigo() == null | arg0.getCodigo() == null)) {
			return arg1.getCodigo().compareTo(arg0.getCodigo());
		}
		return arg0.toString().compareTo(arg1.toString());
	}
	
}

/** Comparador de Pesquisa */
public class PesquisaComparator {
	
}
