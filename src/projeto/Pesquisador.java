package projeto;

import java.util.ArrayList;
import java.util.HashMap;

public class Pesquisador implements Buscavel {
	protected String nome;
	protected String funcao;
	protected String biografia;
	protected String email;
	protected String foto;
	protected boolean status;

	/**
	 * Eh um atributo que guarda um objeto especificacao, que por sua vez eh responsavel por armazenar 
	 * os atributos especificos de um professor ou de um aluno, e ao mesmo tempo guarda o metodo toString() 
	 * de um professor, aluno ou externo.
	 */
	protected Especificacao especificacao;

	/**
	 * Um HashMap que guarda as pesquisas que esse Pesquisador esta associado.
	 */
	private HashMap<String, Pesquisa> pesquisasAssociadas;

	public Pesquisador(String nome, String funcao, String biografia, String email, String foto) {
		Validador.validaString(nome, "Campo nome nao pode ser nulo ou vazio.");
		Validador.validaString(funcao, "Campo funcao nao pode ser nulo ou vazio.");
		Validador.validaString(biografia, "Campo biografia nao pode ser nulo ou vazio.");
		Validador.validaString(email, "Campo email nao pode ser nulo ou vazio.");
		Validador.validaString(foto, "Campo fotoURL nao pode ser nulo ou vazio.");
		validaEmail(email);
		validaFoto(foto);

		this.nome = nome;
		this.funcao = funcao;
		this.biografia = biografia;
		this.email = email;
		this.foto = foto;
		this.status = true;
		this.pesquisasAssociadas = new HashMap<>();
	}

	private void validaEmail(String email) {
		if ((email.startsWith("@")) || (email.endsWith("@"))) {
			throw new IllegalArgumentException("Formato de email invalido.");
		} else if (!email.contains("@")) {
			throw new IllegalArgumentException("Formato de email invalido.");
		}
	}

	private void validaFoto(String foto) {
		if ((!foto.startsWith("http://")) && (!foto.startsWith("https://"))) {
			throw new IllegalArgumentException("Formato de foto invalido.");
		}
	}

	public void alteraPesquisador(String atributo, String novoValor) {
		if (atributo.equals("NOME")) {
			Validador.validaString(novoValor, "Campo nome nao pode ser nulo ou vazio.");
			this.nome = novoValor;
		} else if (atributo.equals("FUNCAO")) {
			Validador.validaString(novoValor, "Campo funcao nao pode ser nulo ou vazio.");
			this.funcao = novoValor;
		} else if (atributo.equals("BIOGRAFIA")) {
			Validador.validaString(novoValor, "Campo biografia nao pode ser nulo ou vazio.");
			this.biografia = novoValor;
		} else if (atributo.equals("FOTO")) {
			Validador.validaString(novoValor, "Campo fotoURL nao pode ser nulo ou vazio.");
			validaFoto(novoValor);
			this.foto = novoValor;
		} else if (atributo.equals("EMAIL")) {
			Validador.validaString(novoValor, "Campo email nao pode ser nulo ou vazio.");
			validaEmail(novoValor);
			this.email = novoValor;
		} else if (atributo.equals("FORMACAO")) {
			((Professor) especificacao).setFormacao(novoValor);
		} else if (atributo.equals("UNIDADE")) {
			((Professor) especificacao).setUnidade(novoValor);
		} else if (atributo.equals("DATA")) {
			((Professor) especificacao).setData(novoValor);
		} else if (atributo.equals("SEMESTRE")) {
			int novoSemestre = Integer.parseInt(novoValor);
			((Aluno) especificacao).setSemestre(novoSemestre);
		} else if (atributo.equals("IEA")) {
			double novoIEA = Double.parseDouble(novoValor);
			((Aluno) especificacao).setIEA(novoIEA);
		} else {
			throw new IllegalArgumentException("Atributo invalido.");
		}
	}

	public void desativaPesquisador() {
		if (!status) {
			throw new RuntimeException("Pesquisador inativo.");
		} else {
			this.status = false;
		}
	}

	public void ativaPesquisador() {
		if (status) {
			throw new RuntimeException("Pesquisador ja ativado.");
		} else {
			this.status = true;
		}
	}

	@Override
	public String toString() {
		String msg = "não implementado";
		if (especificacao instanceof Professor) {
			msg = ((Professor) especificacao).toString();
		} else if (especificacao instanceof Aluno) {
			msg = ((Aluno) especificacao).toString();
		} else if (especificacao instanceof Externo) {
			msg = ((Externo) especificacao).toString();
		} else {
			msg = String.format("%s (%s) - %s - %s - %s", this.nome, this.funcao, this.biografia, this.email,
					this.foto);
		}
		return msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pesquisador other = (Pesquisador) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public boolean pesquisadorEhAtivo() {
		return this.status;
	}

	public boolean contemTermo(String termo) {
		if (this.biografia.contains(termo))
			return true;
		return false;
	}

	public String exibeRepresentacaoBusca() {
		return String.format("%s: %s", this.email, this.biografia);
	}

	/**
	 * Metodo que associa um Pesquisador a uma pesquisa.
	 * Retorna um valor booleano, True se o Pesquisador conseguiu ser associado e False caso nao.
	 * 
	 * @param idPesquisa eh a chave que identifica a pesquisa.
	 * @param pesquisa eh a Pesquisa.
	 * @return um valor booleano.
	 */
	public boolean associaPesquisa(String idPesquisa,  Pesquisa pesquisa) {
		if (pesquisasAssociadas.containsKey(idPesquisa)) {
			return false;
		} else {
			pesquisasAssociadas.put(idPesquisa, pesquisa);
		}
		return true;
	}
	
	
	/**
	 * Metodo que desassocia um Pesquisador a uma determinada Pesquisa.
	 * 
	 * @param idPesquisa eh a cgave que identifica a pesquisa.
	 * @param emailPesquisador eh o email do Pesquisador.
	 * @return um valor Booleano.
	 */
	public boolean desassociaPesqusia(String codigoPesquisa) {
		if (!pesquisasAssociadas.containsKey(codigoPesquisa)) {
			return false;
		} else {
			pesquisasAssociadas.remove(codigoPesquisa);
		}
		return true;
	}

	/**
	 * Metodo que retorna o nome do Pesquisador.
	 * 
	 * @return retorna o nome do Pesquisador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que retorna a Funcao do Pesquisador.
	 * 
	 * @return retorna a Funcao do Pesquisador.
	 */
	public String getFuncao() {
		return funcao;
	}

	/**
	 * Metodo que retorna a Biografia do Pesquisador.
	 * 
	 * @return retorna a Biografia do Pesquisador.
	 */
	public String getBiografia() {
		return biografia;
	}

	/**
	 * Metodo que retorna a foto do Pesquisador.
	 * 
	 * @return retorna a foto do Pesquisador.
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * Metodo que cadastra a Especialidade do Pesquisador como um Professor.
	 * 
	 * @param nome eh o nome do Pesquisador.
	 * @param funcao eh a Funcao do Pesquisador.
	 * @param biografia eh a biografia do Pesquisador.
	 * @param email eh o email do Pesquisador.
	 * @param foto eh a foto do Pesquisador.
	 * @param formacao eh a formacao do Pesquisador como um Professor.
	 * @param unidade eh a unidade do do Pesquisador como um Professor.
	 * @param data eh a data que aquele Pesquisador, como um Professor, foi contratado.
	 */
	public void cadastraEspecialidadeProfessor(String nome, String funcao, String biografia, String email, String foto,
			String formacao, String unidade, String data) {
		this.funcao = "professor";
		especificacao = new Professor(nome, funcao, biografia, email, foto, formacao, unidade, data);
	}
	
	/**
	 * Metodo que cadastra a ESpecialidade do Pesquisador como um Aluno.
	 * 
	 * @param nome eh o nome do Pesquisador.
	 * @param funcao eh a funcao do Pesquisador.
	 * @param biografia eh a Biografia do Pesquisador.
	 * @param email eh o email do Pesqusiador como um Aluno.
	 * @param foto eh a foto do Pesquisador.
	 * @param semestre eh o semestre em que o Pesquisador, como um Aluno, está cursando.
	 * @param IEA eh o IEA daquele Pesquisador, como um ALuno.
	 */
	public void cadastraEspecialidadeAluno(String nome, String funcao, String biografia, String email, String foto,
			int semestre, double IEA) {
		this.funcao = "estudante";
		especificacao = new Aluno(nome, funcao, biografia, email, foto, semestre, IEA);
	}
}
