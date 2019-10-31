package projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPesquisadorController {

	private PesquisadorController controlePesquisador;
	
	public testPesquisadorController() {
		this.controlePesquisador = new PesquisadorController();
	}
	
	@Test
	public void testaCadastraPesquisadorFotoNula() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", null);
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}	
	
	@Test
	public void testaCadastraPesquisadorEmailNulo() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", null, "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorBiografiaNula() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", null, "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorFuncaoNula() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", null, "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorNomeNulo() {
		try {
			controlePesquisador.cadastraPesquisador(null, "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorNomeVazio() {
				try {
			controlePesquisador.cadastraPesquisador("", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorFuncaoVazia() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorBiografiaVazia() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorEmailVazia() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "", "https://fallen");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaCadastraPesquisadorFotoVazia() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaExibePesquisadorEmailVazio() {
		try {
			controlePesquisador.exibePesquisador("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaExibePesquisadorEmailNulo() {
		try {
			controlePesquisador.exibePesquisador(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaExibePesquisador() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		assertEquals("Gabriel (Cientista) - estuda as donzelas - gabriel12@gmail12 - http", controlePesquisador.exibePesquisador("gabriel12@gmail12"));
	}
	
	@Test
	public void testaAlteraPesquisadorEmailVazio() {
		try {
			controlePesquisador.alteraPesquisador("", "atributo", "novoValor");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaAlteraPesquisadorAtributoVazio() {
		try {
			controlePesquisador.alteraPesquisador("email", "", "novoValor");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaAlteraPesquisadorNovoValorVazio() {
		try {
			controlePesquisador.alteraPesquisador("email", "atributo", "");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaAlteraPesquisadorEmailNulo() {
		try {
			controlePesquisador.alteraPesquisador(null, "atributo", "novoValor");
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaAlteraPesquisadorAtributoNulo() {
		try {
			controlePesquisador.alteraPesquisador("email", null, "novoValor");
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaAlteraPesquisadorNovoValorNulo() {
		try {
			controlePesquisador.alteraPesquisador("email", "atributo", null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaAlteraPesquisador() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.alteraPesquisador("gabriel12@gmail12", "NOME", "godBIELZIN");
		assertEquals("godBIELZIN (Cientista) - estuda as donzelas - gabriel12@gmail12 - http", controlePesquisador.exibePesquisador("gabriel12@gmail12"));
	}
	
	@Test
	public void testaDesativaPesquisadorEmailNulo() {
		try {
			controlePesquisador.desativaPesquisador(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaDesativaPesquisadorEmailVazio() {
		try {
			controlePesquisador.desativaPesquisador("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
		
		}
	}
	
	@Test
	public void testaDesativaPesquisador() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.desativaPesquisador("gabriel12@gmail12");
		assertEquals(false, controlePesquisador.pesquisadorEhAtivo("gabriel12@gmail12"));
	}
	
	@Test
	public void testaAtivaPesquisadorEmailNulo() {
		try {
			controlePesquisador.ativaPesquisador(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaAtivaPesquisadorEmailVazio() {
		try {
			controlePesquisador.ativaPesquisador("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
		
		}
	}
	
	@Test
	public void testaAtivaPesquisador() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.desativaPesquisador("gabriel12@gmail12");
		controlePesquisador.ativaPesquisador("gabriel12@gmail12");
		assertEquals(true, controlePesquisador.pesquisadorEhAtivo("gabriel12@gmail12"));
	}
	
	@Test
	public void testaPesquisadorEhAtivoEmailNulo() {
		try {
			controlePesquisador.pesquisadorEhAtivo(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaPesquisadorEhAtivoEmailVazio() {
		try {
			controlePesquisador.pesquisadorEhAtivo("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
		
		}
	}
	
	@Test
	public void testaPesquisadorEhAtivo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		assertEquals(true, controlePesquisador.pesquisadorEhAtivo("gabriel12@gmail12"));
	}
}


