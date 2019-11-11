package projeto;

import java.util.Comparator;
import java.util.HashSet;

public class BuscaComparator implements Comparator<String> {

	@Override
	public int compare(String mensagem1, String mensagem2) {
		HashSet<String> codigos = new HashSet<>();
		codigos.add("P");
		codigos.add("A");
		codigos.add("O");
		String codigo1 = mensagem1.split(":")[0];
		String codigo2 = mensagem2.split(":")[0];
		
		if (codigo1.length() <= 4) {
			int num1 = Integer.parseInt(codigo1.substring(codigo1.length() - 1, codigo1.length()));
		}
		if (codigo2.length() <= 4) {
			int num2 = Integer.parseInt(codigo2.substring(codigo1.length() - 1, codigo1.length()));
		}
		codigo1 = codigo1.substring(0, codigo1.length() - 1);
		codigo2 = codigo2.substring(0, codigo2.length() - 1);

		if (codigos.contains(codigo1) && codigos.contains(codigo2)) {
			return mensagem2.compareTo(mensagem1);
		}

		if (codigo1.isEmpty() && codigo1.isEmpty()) {
			return mensagem2.compareTo(mensagem1);
		}
		return 0;
	}
}
