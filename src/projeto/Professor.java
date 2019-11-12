package projeto;

public class Professor extends Especificacao {

	protected String formacao;
	protected String unidade;
	protected String data;

	public Professor(String nome, String funcao, String biografia, String email, String foto, String formacao,
			String unidade, String data) {
		super(nome, funcao, biografia, email, foto);
		this.formacao = formacao;
		this.unidade = unidade;
		this.data = data;
	}

	public String getFormacao() {
		return formacao;
	}

	public String getUnidade() {
		return unidade;
	}

	public String getData() {
		return data;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toString() {
		return this.nome + " (" + this.funcao + ") - " + this.biografia + " - " + this.email + " - " + this.foto + " - "
				+ this.formacao + " - " + this.unidade + " - " + this.data;
	}
}