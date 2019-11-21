package comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Entidade responsavel por comparar duas mensagens de representacao de busca.
 * 
 * @author Carlos Ribeiro
 */
public class BuscaComparator implements Comparator<String>, Serializable {

	/**
	 * Compara duas mensagens de representacao de busca.
	 * 
	 * A comparacao respeita a seguinte ordem:
	 * 
	 * 1. Pesquisa(Descricao) < Pesquisa(Campo de interesse) < Pesquisador <
	 * Problema < Objetivo < Atividade(Descricao) < Atividade(Descricao de Risco)
	 * 
	 * 2.(Desempate) Ordem anti-lexicografica.
	 */
	@Override
	public int compare(String mensagem1, String mensagem2) {
		HashSet<String> codigos = new HashSet<>();
		codigos.add("P");
		codigos.add("A");
		codigos.add("O");
		String codigo1 = mensagem1.split(":")[0];
		String codigo2 = mensagem2.split(":")[0];

		int num1 = 0;
		int num2 = 0;

		if (codigo1.length() <= 4) {
			num1 = Integer.parseInt(codigo1.substring(codigo1.length() - 1, codigo1.length()));
		}
		if (codigo2.length() <= 4) {
			num2 = Integer.parseInt(codigo2.substring(codigo2.length() - 1, codigo2.length()));
		}

		codigo1 = codigo1.substring(0, codigo1.length() - 1);
		codigo2 = codigo2.substring(0, codigo2.length() - 1);

		if ((codigos.contains(codigo1) && codigos.contains(codigo2))
				|| (codigo1.contains("@") && (codigo2.contains("@")))) {
			return mensagem2.compareTo(mensagem1);
		}

		if (codigo1.length() == 3) {
			if (codigo2.length() == 3) {
				return num2 - num1;
			}
			if (codigos.contains(codigo2) || (codigo2.contains("@"))) {
				return -1;
			}
		}
		return 0;
	}
}
