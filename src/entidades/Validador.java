package entidades;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Validador {
	
	/**
	 * Metodo que valida um atributo String, se ela dor vazia ou nula
	 * joga um IIllegalArgumentException com a mensagem passada.
	 * 
	 * @param atributo eh a String a ser avaliada.
	 * @param msg eh a mensagem que vai ser jogada na Excecao.
	 */
	public static void validaString(String atributo, String msg) {
		if (atributo == null) {
			throw new NullPointerException(msg);
		} else if (atributo.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Metodo que valida valores inteiros, se ele for menor que 1 ou maior 
	 * que 5 eh jogqado um IllegalArgumentException com a mesagem passada.
	 * 
	 * @param valor eh o valor int a ser avaliado.
	 * @param msg eh a mensaem que vai ser jogada na Excecao.
	 */
	public static void validaValores(int valor, String msg){
		if(valor < 1 || valor > 5){
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Metodo que valida se valores inteiros sao negativos/iguais a zero ou nao.
	 * Se o valor passado for negativo ou igual a zero, entao ej jogado um
	 * IllegalArgumentException com a mensagem passada.
	 * 
	 * @param valor eh o valor int que sera avaliado.
	 * @param msg eh a mensagem que vai ser jogada na Exception.
	 */
	public static void validaValoresNegativos(int valor, String msg){
		if(valor <= 0){
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Metodo que valida se determinada chave esta cadastrada no Map passado.
	 * Se a chave nao estiver cadastrada ele joga um IllegalArgumentException
	 * com a mensagem passada.
	 * 
	 * @param chave eh a chave a ser avaliada.
	 * @param mapa eh o mapa que sera utilizado para validacao.
	 * @param msg msg eh a mensagem que vai ser jogada na Exception.
	 */
	public static void isRegistered(String chave, Map mapa, String msg){
		if(!mapa.containsKey(chave)){
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Metodo que valida se determinada pesquisa eh desativada.
	 * Se ela for, retorna um IllegalArgumentException com a msg passada.
	 * 
	 * @param chave eh a chave que identifica a pesquisa a ser avaliada.
	 * @param mapa eh o mapa a ser passado, que sera o mapa: "desativadas".
	 * @param msg msg eh a mensagem que vai ser jogada na Exception.
	 */
	public static void ehDesativada(String chave, Map mapa, String msg){
		if(mapa.containsKey(chave)){
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Metodo que valida o tipo, se ele nao for nem do tipo: "GERAL", nem do 
	 * tipo "ESPECIFICO", ele joga um IllegalArgumentException com a menssagen
	 * passada.
	 * 
	 * @param tipo eh o tipo a ser avaliado.
	 * @param msg msg eh a mensagem que vai ser jogada na Exception.
	 */
	public static void validaTipo(String tipo, String msg){
		if(!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")){
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Metodo de validacao que valida o Campo de Interesse, se ele tiver mais do que 255 palavras, tiver mais de 4 topicos,
	 * ou se cada topico tiver menos de 3 letras, ele joga um IllegalArgumentException dizendo que o formato do campo de interesse 
	 * eh invalido.
	 * 
	 * @param campoDeInteresse eh o campo de interesse da Pesquisa.
	 */
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
	
	/**
	 * Metodo que valida a Data, se ela nao for no formato: "DD/MM/AAAA",
	 * em que os dias do mes sso pode de 1 ate 31, e os meses de 1 a 12,
	 * ele joga um IllegalArgumentException dizendo que o atributo data 
	 * esta com formato invalido.
	 * 
	 * @param data eh a data que o Professor foi contratado.
	 */
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
	
	/**
	 * Metodo que valida o semestre, ele tem que ser entre 1 e 4,
	 * se nao eh jogado um IllegalArgumentException dizendo que
	 * o atributo semestre esta com formato invalido.
	 * 
	 * @param semestre eh o semestre que o aluno esta cursando.
	 */
	public static void validaSemestre(int semestre) {
		if (semestre < 1 || semestre > 4) {
			throw new IllegalArgumentException("Atributo semestre com formato invalido.");
		}
	}
	
	/**
	 * Metodo que valida o IEA, ele tem que ser entre 0 e 10,
	 * se nao ele joga um IllegalArgumentException, dizendo que
	 * o atributo IEA esta com formato invalido.
	 * 
	 * @param IEA eh o IEA do aluno.
	 **/
	public static void validaIEA(double IEA) {
		if (IEA < 0 || IEA > 10) {
			throw new IllegalArgumentException("Atributo IEA com formato invalido.");
		}
	}
}
