package entidades;

import java.util.Arrays;
import java.util.List;
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
	
	public static void ehDesativada(String chave, Map mapa, String msg){
		if(mapa.containsKey(chave)){
			throw new IllegalArgumentException(msg);
		}
	}

	public static void validaTipo(String tipo, String msg){
		if(!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")){
			throw new IllegalArgumentException(msg);
		}
	}
	
	public static void validaCampoDeInteresse(String campoDeInteresse) {
		if (campoDeInteresse.length() > 255) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		List<String> camposDeInteresse = Arrays.asList(campoDeInteresse.split(","));
		for (int i = 0; i < camposDeInteresse.size(); i++) {
			if (camposDeInteresse.get(i).length() < 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
		for (int i = 0; i < campoDeInteresse.length(); i++) {
			if (campoDeInteresse.length() - campoDeInteresse.replaceAll(",", "").length() > 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
	}
	
	public static void validaData(String data) {
		List<String> listaData = Arrays.asList(data.split("/"));
		if (listaData.size() != 3) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		} else if (listaData.get(0).length() != 2) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		} else if (listaData.get(1).length() != 2) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		} else if (listaData.get(2).length() != 4) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		}
		int dia = Integer.parseInt(listaData.get(0));
		int mes = Integer.parseInt(listaData.get(1));
		if (dia < 00 || dia > 31) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		} else if (mes < 00 || mes > 12) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		}
	}
	
	public static void validaSemestre(int semestre) {
		if (semestre < 1 || semestre > 4) {
			throw new IllegalArgumentException("Atributo semestre com formato invalido.");
		}
	}
	
	public static void validaIEA(double IEA) {
		if (IEA < 0 || IEA > 10) {
			throw new IllegalArgumentException("Atributo IEA com formato invalido.");
		}
	}
}
