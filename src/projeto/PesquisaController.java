package projeto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação de um Controle, que é responsável por manipular os
 * Collections, e guardar alguns métodos do programa que sejam referentes a
 * Classe Pesquisa.
 * 
 * @author Gabriel Menezes Cabral - 119110372.
 *
 */
public class PesquisaController {

	/**
	 * Eh o codigo da Pesquisa.
	 */
	private String codigo;

	/**
	 * HashMap responsavel por guardar as pesquisas cadastradas. Essas pesquisas
	 * estao associadas ao seu codigo.
	 */
	private HashMap<String, Pesquisa> pesquisas;

	/**
	 * HashMap responsavel por registrar as pesquisas que foram desativadas . Essas
	 * pesquisas estao associadas ao seu codigo.
	 */
	private HashMap<String, String> desativadas;

	/**
	 * HashMap responsavel por guardar um codigo associado a um ArrayList, o tamanho
	 * desse ArrayList eh equivalente a quantidade de vezes que esse codigo com
	 * essas 3 letras ja foram usados.
	 */
	private HashMap<String, ArrayList> codigos;

	/**
	 * Constroi um Controle da Pesquisa e inicializa os HAshMap e o atributo codigo.
	 */
	public PesquisaController() {
		codigo = "";
		this.pesquisas = new HashMap<String, Pesquisa>();
		this.desativadas = new HashMap<String, String>();
		this.codigos = new HashMap<String, ArrayList>();
	}

	/**
	 * Metodo responsavel por cadastrar uma Pesquisa.
	 * 
	 * @param descricao        eh a descricao da Pesquisa.
	 * @param campoDeInteresse eh o campo de interesse da Pesquisa.
	 * @return a representacao do codigo da Pesquisa em String.
	 */
	public String cadatraPesquisa(String descricao, String campoDeInteresse) {
		Validador val = new Validador();
		val.validaString(descricao, "Descricao nao pode ser nula ou vazia.");
		val.validaString(campoDeInteresse, "Formato do campo de interesse invalido.");
		if (campoDeInteresse.length() > 255) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		if (campoDeInteresse.contains(", ,")) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		if (campoDeInteresse.length() < 3) {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}
		for (int i = 0; i < campoDeInteresse.length(); i++) {
			if (campoDeInteresse.length() - campoDeInteresse.replaceAll(",", "").length() > 3) {
				throw new IllegalArgumentException("Formato do campo de interesse invalido.");
			}
		}
		String codigoLetras = campoDeInteresse.substring(0, 3).toUpperCase();
		if (codigos.containsKey(codigoLetras)) {
			codigos.get(codigoLetras).add(1);
			codigo = codigoLetras + codigos.get(codigoLetras).size();
		} else {
			codigo = codigoLetras + "1";
			codigos.put(codigoLetras, new ArrayList<String>());
			codigos.get(codigoLetras).add(1);
		}
		pesquisas.put(codigo, new Pesquisa(codigo, descricao, campoDeInteresse));
		return codigo;
	}

	/**
	 * Metodo que altera os conteudos: Descricao ou Campo.
	 * 
	 * @param codigo               eh o codigo que identifica a Pesquisa.
	 * @param conteudoASerAlterado eh o conteudo a ser alterado.
	 * @param novoConteudo         eh o novo conteudo que vai ficar no lugar do
	 *                             antigo.
	 */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if (desativadas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		Validador val = new Validador();
		val.validaString(conteudoASerAlterado, "Conteudo a ser alterado nao pode ser vazio ou nulo.");
		if (conteudoASerAlterado.equals("DESCRICAO")) {
			val.validaString(novoConteudo, "Descricao nao pode ser nula ou vazia.");
			pesquisas.get(codigo).setDescricao(novoConteudo);
		} else if (conteudoASerAlterado.equals("CAMPO")) {
			val.validaString(novoConteudo, "Formato do campo de interesse invalido.");
			pesquisas.get(codigo).setCampoDeInteresse(novoConteudo);
		} else {
			throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
		}
	}

	/**
	 * Metodo que encerra uma Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @param motivo eh o motivo pelo qual o usuario quer encerrar a Pesquisa.
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		Validador val = new Validador();
		val.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if (desativadas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
		desativadas.put(codigo, motivo);
	}

	/**
	 * Metodo que ativa a Pesquisa.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		Validador val = new Validador();
		val.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if (!desativadas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa ja ativada.");
		}

		desativadas.remove(codigo);
	}

	/**
	 * Metodo que exibe a representacao textual da Pesquisa em forma de String.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return a representacao textual da Pesquisa em forma de String.
	 */
	public String exibePesquisa(String codigo) {
		Validador val = new Validador();
		val.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		return pesquisas.get(codigo).toString();
	}

	/**
	 * Metodo que retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 * 
	 * @param codigo eh o codigo que identifica a Pesquisa.
	 * @return retorna um valor Booleano dizendo se a Pesquisa eh ativa ou nao.
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		Validador val = new Validador();
		val.validaString(codigo, "Codigo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		if (!desativadas.containsKey(codigo)) {
			return true;
		}
		return false;
	}

}
