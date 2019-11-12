package projeto;

public abstract class Especificacao{
	
	protected String nome;
	protected String funcao;
	protected String biografia;
	protected String email;
	protected String foto;

	public Especificacao(String nome, String funcao, String biografia, String email, String foto) {
		this.nome = nome;
		this.funcao = funcao;
		this.biografia = biografia;
		this.email = email;
		this.foto = foto;
	}
}