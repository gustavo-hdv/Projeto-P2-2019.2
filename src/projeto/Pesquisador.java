package projeto;

import java.util.ArrayList;
import java.util.HashMap;

public class Pesquisador {
	private String nome;
	private String funcao;
	private String biografia;
	private String email;
	private String foto;
	private boolean status;
	
	/**
	 * GABRIEL
	 * @return
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
		String msg = String.format("%s (%s) - %s - %s - %s", this.nome, this.funcao, this.biografia, this.email, this.foto);
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
	
	/**
	 * GABRIEL
	 */
	public void associaPesquisa(String codigoPesquisa, Pesquisa pesquisa) {
		pesquisasAssociadas.put(codigoPesquisa, pesquisa);
	}
	
	/**
	 * GABRIEL
	 */
	public void desassociaPesqusia(String codigoPesquisa) {
		pesquisasAssociadas.remove(codigoPesquisa);
	}
	
}
