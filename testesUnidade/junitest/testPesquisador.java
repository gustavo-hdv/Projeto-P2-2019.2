package junitest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import projeto.Pesquisador;

class testPesquisador {

	@Test
	public void testaConstrutorPesquisador() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gabriel", "Cientista", "ele estuda como os macaco podem vir a se tornar superiores aos humanos", "bielzinop12@2001biel", "https://godbiel");
		} catch (Exception e) {
			fail ("Nao era esperado exexao");
		}
	}
	
	@Test
	public void testaFotoPesquisadorNulo() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", null);
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaEmailPesquisadorNulo() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", null, "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaBiografiaPesquisadorNulo() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", "Visualizador de Mangas", null, "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaFuncaoPesquisadorNulo() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", null, "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}
	
	@Test
	public void testaNomePesquisadorNulo() {
		try {
			Pesquisador pesquisador = new Pesquisador(null, "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado execao");
		} catch (NullPointerException e) {
			
		}
	}

	@Test
	public void testaNomePesquisadorVazio() {
		try {
			Pesquisador pesquisador = new Pesquisador("", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaFuncaoPesquisadorVazio() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", "", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaBiogradiaPesquisadorVazio() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", "Visualizador de Mangas", "", "1SHOT2KILL@k1ll", "https://fallen");
			fail ("Era esperado exececao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaEmailPesquisadorVazio() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "", "https://fallen");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void testaFotoPesquisadorVazio() {
		try {
			Pesquisador pesquisador = new Pesquisador("Gustavo", "Visualizador de Mangas", "ele le todos os mangas da face da terra", "1SHOT2KILL@k1ll", "");
			fail ("Era esperado excecao");
		} catch (IllegalArgumentException e) {
			
		}
	}
}
