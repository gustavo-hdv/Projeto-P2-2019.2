package projeto;

public class qtdVezesIdPesquisaUsado {

	protected int contador;

	public qtdVezesIdPesquisaUsado(int contador) {
			this.contador = contador;
	}

	public void somaMaisUmQuantiadadeEsteCodigoFoiUsado() {
		this.contador += 1;
	}
	
	public int qtdVezesIdPesquisaFoiUsado() {
		return this.contador;
	}
	
}
