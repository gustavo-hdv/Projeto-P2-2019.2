package projeto;

public class Controller {
	private PesquisadorController pesqC;

	public Controller() {
		this.pesqC = new PesquisadorController();
	}

	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		pesqC.cadastraPesquisador(nome, funcao, biografia, email, foto);
	}
	
	public void desativaPesquisador(String email) {
		pesqC.desativaPesquisador(email);
	}

	public void ativaPesquisador(String email) {
		pesqC.ativaPesquisador(email);
	}
	
	public void alteraPesquisador(String email, String atributo, String novoValor) {
		pesqC.alteraPesquisador(email, atributo, novoValor);
	}

	public String exibePesquisador(String email) {
		return pesqC.exibePesquisador(email);
	}

	public boolean pesquisadorEhAtivo(String email) {
		return pesqC.pesquisadorEhAtivo(email);
	}

}
