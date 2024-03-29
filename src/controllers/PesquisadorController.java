package controllers;

import java.io.File;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entidades.*;

/** Representacao de um contrador de pesquisadores */

public class PesquisadorController implements Buscador {

	private Map<String, Pesquisador> pesquisadores;

	public PesquisadorController() {
		this.pesquisadores = new LinkedHashMap<String, Pesquisador>();
	}

	/**
	 * Faz a validacao do email de um pesquisador segundo as instrucoes da
	 * especificao.
	 * 
	 * @param email O email a ser validado.
	 */
	private void validaEmail(String email) {
		if ((email.startsWith("@")) || (email.endsWith("@"))) {
			throw new IllegalArgumentException("Formato de email invalido.");
		} else if (!email.contains("@")) {
			throw new IllegalArgumentException("Formato de email invalido.");
		}
	}

	/**
	 * Faz a validacao da foto de um pesquisador segundo as instrucoes da
	 * especificao.
	 * 
	 * @param foto A foto a ser validada.
	 */
	private void validaFoto(String foto) {
		if ((!foto.startsWith("http://")) && (!foto.startsWith("https://"))) {
			throw new IllegalArgumentException("Formato de foto invalido.");
		}
	}

	/**
	 * Cria e armazena um pesquisador baseado em seu nome, funcao, biografia, email
	 * e foto. O pesquisador eh armazenado em um mapa que mapeia cada email para o
	 * seu respectivo pesquisador.
	 * 
	 * @param nome      O nome do pesquisador.
	 * @param funcao    A funcao do pesquisador.
	 * @param biografia A biografia do pesquisador.
	 * @param email     O email do pesquisador.
	 * @param foto      O link para a foto do pesquisador.
	 */
	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		Validador.validaString(nome, "Campo nome nao pode ser nulo ou vazio.");
		Validador.validaString(funcao, "Campo funcao nao pode ser nulo ou vazio.");
		Validador.validaString(biografia, "Campo biografia nao pode ser nulo ou vazio.");
		Validador.validaString(email, "Campo email nao pode ser nulo ou vazio.");
		Validador.validaString(foto, "Campo fotoURL nao pode ser nulo ou vazio.");
		validaEmail(email);
		validaFoto(foto);

		Pesquisador pesquisador = new Pesquisador(nome, funcao, biografia, email, foto);
		this.pesquisadores.put(email, pesquisador);
	}

	/**
	 * Retorna uma representacao em String de um pesquisador. A representacao segue
	 * o modelo: "NOME (FUNCAO) - BIOGRAFIA - EMAIL - FOTO"
	 */
	public String exibePesquisador(String email) {

		Validador.validaString(email, "Campo email nao pode ser nulo ou vazio.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = pesquisadores.get(email);
		return pesquisador.toString();
	}

	/**
	 * Substitui o valor de um atributo de um pesquisador por um novo valor. O
	 * pesquisador eh acessado por seu email.
	 * 
	 * @param atributo  O atributo a ser substituido, em letras maiusculas.
	 * @param novoValor O valor a ser colocado no lugar do anterior.
	 */
	public void alteraPesquisador(String email, String atributo, String novoValor) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		Validador.validaString(atributo, "Atributo nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}

		Pesquisador pesquisador = this.pesquisadores.get(email);

		if (atributo.equals("EMAIL")) {
			Validador.validaString(novoValor, "Campo email nao pode ser nulo ou vazio.");
			validaEmail(novoValor);

			pesquisadores.remove(email);
			pesquisador.alteraPesquisador(atributo, novoValor);
			pesquisadores.put(novoValor, pesquisador);
		} else {
			pesquisador.alteraPesquisador(atributo, novoValor);
		}
	}

	/**
	 * Desativa o pesquisador.
	 */
	public void desativaPesquisador(String email) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = this.pesquisadores.get(email);
		pesquisador.desativaPesquisador();
	}

	/**
	 * Ativa o pesquisador.
	 */
	public void ativaPesquisador(String email) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = pesquisadores.get(email);
		pesquisador.ativaPesquisador();
	}

	/**
	 * Consulta o status de ativacao do pesquisador.
	 * 
	 * @return o status de ativacao do pesquisador.
	 */
	public boolean pesquisadorEhAtivo(String email) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = this.pesquisadores.get(email);
		return pesquisador.pesquisadorEhAtivo();
	}

	@Override
	public Collection<Buscavel> busca(String termo) {
		ArrayList<Buscavel> achados = new ArrayList<>();
		for (Buscavel pesquisador : this.pesquisadores.values()) {
			if (pesquisador.contemTermo(termo))
				achados.add(pesquisador);
		}
		return achados;
	}

	/**
	 * Metodo que associa um Pesquisador a uma determinada pesquisa. Retorna um
	 * valor booleano, True se o Pesquisador conseguiu ser associado e False caso
	 * nao.
	 * 
	 * @param idPesquisa       eh a chave que identifica a pesquisa.
	 * @param emailPesquisador eh o email do Pesquisador.
	 * @param pesquisa         eh a Pesquisa.
	 * @return um valor booleano.
	 */
	public boolean associaPesquisador(String idPesquisa, String emailPesquisador, Pesquisa pesquisa) {
		return pesquisadores.get(emailPesquisador).associaPesquisa(idPesquisa, pesquisa);
	}

	/**
	 * Metodo que desassocia um Pesquisador a uma determinada Pesquisa.
	 * 
	 * @param idPesquisa       eh a cgave que identifica a pesquisa.
	 * @param emailPesquisador eh o email do Pesquisador.
	 * @return um valor Booleano.
	 */
	public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
		return pesquisadores.get(emailPesquisador).desassociaPesquisa(idPesquisa);
	}

	/**
	 * Metodo que cadastra a ESpecialidade do Pesquisador como um Professor.
	 * 
	 * @param email    eh o email do Pesquisador.
	 * @param formacao eh a formacao do Pesquisador como um Professor.
	 * @param unidade  eh a unidade do do Pesquisador como um Professor.
	 * @param data     eh a data que aquele Pesquisador, como um Professor, foi
	 *                 contratado.
	 */
	public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
		Validador.validaString(email, "Campo email nao pode ser nulo ou vazio.");
		Validador.validaString(formacao, "Campo formacao nao pode ser nulo ou vazio.");
		Validador.validaString(unidade, "Campo unidade nao pode ser nulo ou vazio.");
		Validador.validaString(data, "Campo data nao pode ser nulo ou vazio.");
		Validador.isRegistered(email, pesquisadores, "Pesquisadora nao encontrada.");
		if (!pesquisadores.get(email).getFuncao().toUpperCase().equals("PROFESSOR")) {
			throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
		}
		Validador.validaData(data);
		String nome = pesquisadores.get(email).getNome();
		String funcao = pesquisadores.get(email).getFuncao();
		String biografia = pesquisadores.get(email).getBiografia();
		String foto = pesquisadores.get(email).getFoto();
		pesquisadores.get(email).cadastraEspecialidadeProfessor(nome, funcao, biografia, email, foto, formacao, unidade,
				data);
	}

	/**
	 * Metodo que cadastra a ESpecialidade do Pesquisador como um Aluno.
	 * 
	 * @param email    eh o email do Pesqusiador como um Aluno.
	 * @param semestre eh o semestre em que o Pesquisador, como um Aluno, está
	 *                 cursando.
	 * @param IEA      eh o IEA daquele Pesquisador, como um ALuno.
	 */
	public void cadastraEspecialidadeAluno(String email, int semestre, double IEA) {
		Validador.validaString(email, "Campo email nao pode ser nulo ou vazio.");
		Validador.validaSemestre(semestre);
		Validador.validaIEA(IEA);
		Validador.isRegistered(email, pesquisadores, "Pesquisadora nao encontrada.");
		if (!pesquisadores.get(email).getFuncao().toUpperCase().equals("ESTUDANTE")) {
			throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
		}
		String nome = pesquisadores.get(email).getNome();
		String funcao = pesquisadores.get(email).getFuncao();
		String biografia = pesquisadores.get(email).getBiografia();
		String foto = pesquisadores.get(email).getFoto();
		pesquisadores.get(email).cadastraEspecialidadeAluno(nome, funcao, biografia, email, foto, semestre, IEA);
	}

	/**
	 * Metodo responsavel por listar todos os pesquisadores de uma determinada
	 * Funcao.
	 * 
	 * @param tipo eh a funcao.
	 * @return retorna a respresentacao em forma de String dos pesquisadores que tem
	 *         aquela determinada funcao.
	 */
	public String listaPesquisadores(String tipo) {
		String msg = "";
		Validador.validaString(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		if (!tipo.toUpperCase().equals("PROFESSOR") && !tipo.toUpperCase().equals("ESTUDANTE")
				&& !tipo.toUpperCase().equals("EXTERNO")) {
			throw new IllegalArgumentException(String.format("Tipo %s inexistente.", tipo));
		}
		for (Pesquisador pesquisador : pesquisadores.values()) {
			if (pesquisador.getFuncao().toUpperCase().equals(tipo)) {
				msg += pesquisador.toString() + " | ";
			}
		}
		return msg.substring(0, msg.length() - 3);
	}

	/**
	 * Exibe os pesquisadores que estao associados a uma determinada pesquisa
	 * Estilo: nome (funcao) - biografia - email - foto \n ...
	 * 
	 * @param codigoPesquisa id da pesquisa
	 * @return representacao dos pesquisados com a pesquisa associada
	 */
	public String exibePesquisadoresAssociados(String codigoPesquisa) {
		String pesquisadoresAssociados = "";
		for (Map.Entry<String, Pesquisador> pesquisador : this.pesquisadores.entrySet()) {
			if (pesquisador.getValue().contemPesquisaAssociada(codigoPesquisa)) {
				pesquisadoresAssociados += "\t\t- " + pesquisador.getValue().toString() + System.lineSeparator();
			}
		}
		return pesquisadoresAssociados;
	}

	/**
	 * Salva todos os atributos.
	 */
	public void salvaDados(){
		Persistencia.salvar(this.pesquisadores, "pesquisadorController", "pesquisadores");
	}

	/**
	 * Carrega todos os atributos.
	 */
	public void carregaDados(){
		this.pesquisadores = (LinkedHashMap<String, Pesquisador>) Persistencia.carregar("pesquisadorController", "pesquisadores");
	}
}
