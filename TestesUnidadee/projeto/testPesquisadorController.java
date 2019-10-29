package projeto;

import static org.junit.jupiter.api.Assertions.*;
import projeto.PesquisadorControleer;

import org.junit.jupiter.api.Test;

class testPesquisadorController {

	private PesquisadorController controlePesquisador = new PesquisadorController();
	
	@Test
	public void testaValidaEmail() {
		try {
			controlePesquisador.validaEmail("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.validaEmail(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.validaEmail("gabriel");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.validaEmail("@menezes");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaValidaFoto() {
		try {
			controlePesquisador.validaFoto("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.validaFoto();
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.validaFoto("www.gabrielLindao");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	public void testaCadastraPesquisador() {
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", null);
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", null, "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", null, "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", null, "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador(null, "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "", "https://fallen");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.cadastraPesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaExibePesquisador() {
		try {
			controlePesquisador.exibePesquisador("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.exibePesquisador();
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		assertEquals("Gabriel (Cientista) - estuda as donzelas - gabriel12@gmail12 - http", controlePesquisador.exibePesquisador("gabriel12@gmail12"));
	}
	
	@Test
	public void testaAlteraPesquisador() {
		try {
			controlePesquisador.alteraPesquisador("", "atributo", "novoValor");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.alteraPesquisador("email", "", "novoValor");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.alteraPesquisador("email", "atributo", "");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
		
		try {
			controlePesquisador.alteraPesquisador(null, "atributo", "novoValor");
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.alteraPesquisador("email", null, "novoValor");
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.alteraPesquisador("email", "atributo", null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.alteraPesquisador("gabriel12@gmail12", "NOME", "godBIELZIN");
		assertEquals("godBIELZIN (Cientista) - estuda as donzelas - gabriel12@gmail12 - http", controlePesquisador.exibePesquisador("gabriel12@gmail12"));
	}
	
	@Test
	public void testaDesativaPesquisador() {
		try {
			controlePesquisador.desativaPesquisador(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.desativaPesquisador("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
		
		}
		
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.desativaPesquisador("gabriel12@gmail12");
		assertEquals(false, controlePesquisador.pesquisadorEhAtivo("gabriel12@gmail12"));
	}
	
	@Test
	public void testaAtivaPesquisador() {
		try {
			controlePesquisador.ativaesquisador(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.ativaPesquisador("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
		
		}
		
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.desativaPesquisador("gabriel12@gmail12");
		controlePesquisador.ativaPesquisador("gabriel12@gmail12");
		assertEquals(true, controlePesquisador.pesquisadorEhAtivo("gabriel12@gmail12"));
	}
	
	@Test
	public void testaPesquisadorEhAtivo() {
		try {
			controlePesquisador.pesqusiadorEhAtivo(null);
			fail ("Era esperado excecao");
		} catch (NullPointerException e) {
			
		}
		
		try {
			controlePesquisador.pesquisadorEhAtivo("");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
		
		}
		
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		assertEquals(true, controlePesquisador.pesquisadorEhAtivo("gabriel12@gmail12"));
	}
}


