package projeto;

public class Professor extends Pesquisador{

	private String formacao;
	private String unidade;
	private String data;
	
	public Professor(String nome, String funcao, String biografia, String email, String foto, String formacao, String unidade, String data) {
		super(nome, funcao, biografia, email, foto);
		this.formacao = formacao;
		this.unidade = unidade;
		this.data = data;
	}
	
	public String toString() {
		return this.nome + " (" + this.funcao + ") - " + this.biografia + " - " + this.email + " - " + 
	this.foto + " - " + this.formacao + " - " + this.unidade + " - " + this.data;
	}

}
