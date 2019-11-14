package projeto;

/**
 * Representacao de um item com descricao e estado(PENDENTE ou REALIZADO)
 */

public class Item {

	/** Descricao */
	private String descricao;
	/** Estado do item (PENDENTE ou REALIZADO) */
	private String estado;

	/**
	 * Construtor de um item Inicia com o estado: "PENDENTE"
	 * 
	 * @param descricao do item (String)
	 */
	public Item(String descricao) {
		Validador.validaString(descricao, "Item nao pode ser nulo ou vazio.");

		this.descricao = descricao;
		this.estado = "PENDENTE";
	}

	/**
	 * Exibe o estado do item
	 * 
	 * @return estado do item (String)
	 */
	public String exibeEstado() {
		return this.estado;
	}

	/** Altera o estado do item para: "REALIZADO" */
	public void alteraEstado() {
		this.estado = "REALIZADO";
	}

	/**
	 * Exibe o item\n Estilo: "Estado do item - Descricao do item"
	 * 
	 * @return Representacao do item (String)
	 */
	public String exibeItem() {
		return this.estado + " - " + this.descricao;
	}

	/** hashCode para a descricao */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	/** equals para a descricao */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

}
