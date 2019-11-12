package projeto;

public class Externo extends Especificacao{

	public Externo(String nome, String funcao, String biografia, String email, String foto) {
		super(nome, funcao, biografia, email, foto);
	}

	@Override
	public String toString() {
		String msg = String.format("%s (%s) - %s - %s - %s", this.nome, this.funcao, this.biografia, this.email, this.foto);
		return msg;
	}
	
}
