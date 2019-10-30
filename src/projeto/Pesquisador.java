package projeto;

public class Pesquisador {
	private String nome;
	private String funcao;
	private String biografia;
	private String email;
	private String foto;
	private boolean ativado;

	public Pesquisador(String nome, String funcao, String biografia, String email, String foto) {
		this.nome = nome;
		this.funcao = funcao;
		this.biografia = biografia;
		this.email = email;
		this.foto = foto;
		this.ativado = true;
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
		Validador val = new Validador();
		if (atributo.equals("NOME")) {
			val.validaString(novoValor, "Campo nome nao pode ser nulo ou vazio.");
			this.nome = novoValor;
		} else if (atributo.equals("FUNCAO")) {
			val.validaString(novoValor, "Campo funcao nao pode ser nulo ou vazio.");
			this.funcao = novoValor;
		} else if (atributo.equals("BIOGRAFIA")) {
			val.validaString(novoValor, "Campo biografia nao pode ser nulo ou vazio.");
			this.biografia = novoValor;
		} else if (atributo.equals("FOTO")) {
			val.validaString(novoValor, "Campo fotoURL nao pode ser nulo ou vazio.");
			validaFoto(novoValor);
			this.foto = novoValor;
		} else if (atributo.equals("EMAIL")) {
			val.validaString(novoValor, "Campo email nao pode ser nulo ou vazio.");
			validaEmail(novoValor);
			this.email = novoValor;
		} else {
			throw new IllegalArgumentException("Atributo invalido.");
		}
	}
	
	public void desativaPesquisador() {
		if (!ativado) {
			throw new IllegalArgumentException("Pesquisador inativo.");
		} else {
			this.ativado = false;
		}
	}
	
	public void ativaPesquisador() {
		if (ativado) {
			throw new IllegalArgumentException("Pesquisador ja ativado.");
		} else {
			this.ativado = true;
		}
	}
	
	@Override
	public String toString() {
		String msg = String.format("%s (%s) - %s - %s - %s", this.nome, this.funcao, this.biografia, this.email, this.foto);
		return msg;
	}

	public boolean pesquisadorEhAtivo() {
		return this.ativado;
	}
}
