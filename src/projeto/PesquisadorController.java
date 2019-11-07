package projeto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PesquisadorController implements Buscador {
	private Map<String, Pesquisador> pesquisadores;

	public PesquisadorController() {
		this.pesquisadores = new HashMap<>();
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

	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		Validador.validaString(nome, "Campo nome nao pode ser nulo ou vazio.");
		Validador.validaString(funcao, "Campo funcao nao pode ser nulo ou vazio.");
		Validador.validaString(biografia, "Campo biografia nao pode ser nulo ou vazio.");
		Validador.validaString(email, "Campo email nao pode ser nulo ou vazio.");
		Validador.validaString(foto, "Campo fotoURL nao pode ser nulo ou vazio.");
		validaEmail(email);
		validaFoto(foto);

		Pesquisador pesquisador = new Pesquisador(nome, funcao, biografia, email, foto);
		this.pesquisadores.put(email, pesquisador);
	}

	public String exibePesquisador(String email) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = pesquisadores.get(email);
		return pesquisador.toString();
	}

	public void alteraPesquisador(String email, String atributo, String novoValor) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		Validador.validaString(atributo, "Atributo nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}

		Pesquisador pesquisador = this.pesquisadores.get(email);

		if (atributo.equals("EMAIL")) {
			Validador.validaString(novoValor, "Campo email nao pode ser nulo ou vazio.");
			validaEmail(novoValor);

			pesquisadores.remove(email);
			pesquisador.alteraPesquisador(atributo, novoValor);
			pesquisadores.put(novoValor, pesquisador);
		} else {
			pesquisador.alteraPesquisador(atributo, novoValor);
		}
	}

	public void desativaPesquisador(String email) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = this.pesquisadores.get(email);
		pesquisador.desativaPesquisador();
	}

	public void ativaPesquisador(String email) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = pesquisadores.get(email);
		pesquisador.ativaPesquisador();
	}

	public boolean pesquisadorEhAtivo(String email) {
		Validador.validaString(email, "Email nao pode ser vazio ou nulo.");
		if (!pesquisadores.containsKey(email)) {
			throw new IllegalArgumentException("Pesquisador nao encontrado");
		}
		Pesquisador pesquisador = this.pesquisadores.get(email);
		return pesquisador.pesquisadorEhAtivo();
	}

	@Override
	public Collection<Buscavel> busca(String termo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * GABRIEL
	 */
	public Pesquisador buscaPesquisador(String email) {
		return pesquisadores.get(email);
	}

}
