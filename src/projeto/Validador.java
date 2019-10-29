package projeto;

public class Validador {
	public void validaString(String atributo, String msg) {
		if (atributo == null) {
			throw new NullPointerException(msg);
		} else if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
	}
}
