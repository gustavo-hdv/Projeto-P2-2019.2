package projeto;

/**
 * Representacao da quantidade de vezes que determinado codigo de letras (3 primeiras letras), 
 * ja foram usadas para identificar uma pesquisa.
 */
public class qtdVezesIdPesquisaUsado {

	/**
	 * Contador que conta quantas vezes as 3 primeiras letras ja foram usadas para identificar uma pesquisa.
	 */
	private int contador;

	/**
	 * Constroi um objeto que guarda a quantidade de vezes que as 3 primeiras letras ja 
	 * foram usadas para identificar uma pesquisa.
	 * 
	 * @param retorna a quantidade de vezes que as 3 primeiras letras ja 
	 * foram usadas para identificar uma pesquisa.
	 */
	public qtdVezesIdPesquisaUsado(int contador) {
			this.contador = contador;
	}

	/**
	 * Metodo que soma mais um(1) ao contador, chamado quando esse codigo de letras for usado.
	 */
	public void somaMaisUmQuantiadadeEsteCodigoFoiUsado() {
		this.contador += 1;
	}
	
	/**
	 * Metodo que retorna a representacao em forma de inteiro, da quantidade de vezes que codigo de letras foi usado.
	 * 
	 * @return
	 */
	public int qtdVezesIdPesquisaFoiUsado() {
		return this.contador;
	}
	
}
