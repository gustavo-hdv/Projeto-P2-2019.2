package projeto;

import java.util.Map;

public class Validador {
	public static void validaString(String atributo, String msg) {
		if (atributo == null) {
			throw new NullPointerException(msg);
		} else if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
	}

	public static void validaValores(int valor, String msg){
		if(valor < 1 || valor > 5){
			throw new IllegalArgumentException(msg);
		}
	}

	public static void validaValoresNegativos(int valor, String msg){
		if(valor <= 0){
			throw new IllegalArgumentException(msg);
		}
	}

	public static void isRegistered(String chave, Map mapa, String msg){
		if(!mapa.containsKey(chave)){
			throw new IllegalArgumentException(msg);
		}
	}

	public static void validaTipo(String tipo, String msg){
		if(!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")){
			throw new IllegalArgumentException(msg);
		}
	}
}
