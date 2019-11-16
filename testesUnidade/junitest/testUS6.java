package junitest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.Controller;
import controllers.PesquisaController;
import controllers.PesquisadorController;

class testUS6 {

	private Controller controleGeral;
	private PesquisadorController controlePesquisador;
	private PesquisaController controlePesquisa;
	
	public testUS6() {
		this.controlePesquisador = new PesquisadorController();
		this.controlePesquisa = new PesquisaController();
		this.controleGeral = new Controller();
	}
	
	@Test
	public void testaAssociaPesquisadorIdPesquisaVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		try {
			controleGeral.associaPesquisador("", "gabriel12@gmail12");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IAE) {
		}
	}
	
	@Test
	public void testaAssociaPesquisadorEmailPesquisadorVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		try {
			controleGeral.associaPesquisador("NAR1", "");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IAE) {
		}
	}
	
	@Test
	public void testaAssociaPesquisadoridPesquisaNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		try {
			controleGeral.associaPesquisador(null, "gabriel12@gmail12");
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}

	@Test
	public void testaAssociaPesquisadorEmailPesquisadorNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		try {
			controleGeral.associaPesquisador("NAR1", null);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaAssociaPesquisador() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		controlePesquisador.associaPesquisador("NAR1", "gabriel12@gmail12", controlePesquisa.buscaPesquisa("NAR1"));
	}
	
	@Test
	public void testaDesassociaPesquisadorIdPesquisaVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		controlePesquisador.associaPesquisador("NAR1", "gabriel12@gmail12", controlePesquisa.buscaPesquisa("NAR1"));
		try {
			controleGeral.desassociaPesquisador("", "gabriel12@gmail12");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaDesassociaPesquisadorEmailPesquisadorVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		controlePesquisador.associaPesquisador("NAR1", "gabriel12@gmail12", controlePesquisa.buscaPesquisa("NAR1"));
		try {
			controleGeral.desassociaPesquisador("NAR1", "");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaDesassociaPesquisadorIdPesquisaNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		controlePesquisador.associaPesquisador("NAR1", "gabriel12@gmail12", controlePesquisa.buscaPesquisa("NAR1"));
		try {
			controleGeral.desassociaPesquisador(null, "gabriel12@gmail12");
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaDesassociaPesquisadorEmailPesquisadorNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		controlePesquisador.associaPesquisador("NAR1", "gabriel12@gmail12", controlePesquisa.buscaPesquisa("NAR1"));
		try {
			controlePesquisador.desassociaPesquisador("NAR1", null);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaDesassociaPesquisador() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Ciencista", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisa.cadastraPesquisa("Eh um estudo sobre o universo de Naruto", "Naruto, Sasuke");
		controlePesquisador.associaPesquisador("NAR1", "gabriel12@gmail12", controlePesquisa.buscaPesquisa("NAR1"));
		controlePesquisador.desassociaPesquisador("NAR1", "gabriel12@gmail12");
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessor() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessorEmailVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor("", "Doutorado", "DCE", "17/03/2001");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessorFormacaoVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "", "DCE", "17/03/2001");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessorUnidadeVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "", "17/03/2001");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessorDataVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "");
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessorEmailNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor(null, "Doutorado", "DCE", "17/03/2001");
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}

	@Test
	public void testaCadastraEspecialidadeProfessorFormcaoNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", null, "DCE", "17/03/2001");
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessorUnidadeNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", null, "17/03/2001");
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeProfessorDataNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", null);
			fail("Era esperado excecao");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeAluno() {
		controlePesquisador.cadastraPesquisador("Gabriel", "estudante", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeAluno("gabriel12@gmail12", 4, 9.5);
	}
	
	@Test
	public void testaCadastraEspecialidadeAlunoEmailVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeAluno("", 4, 9.5);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeAlunoSemestreMenorQueZero() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeAluno("gabriel12@gmail12", -9, 9.5);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeAlunoSemestreMaiorQueQuatro() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeAluno("gabriel12@gmail12", 5, 9.5);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeAlunoIEAMenorQueZero() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeAluno("gabriel12@gmail12", 2, -10);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaCadastraEspecialidadeAlunoIEAMaiorQueZero() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		try {
			controlePesquisador.cadastraEspecialidadeAluno("gabriel12@gmail12", 2, 12);
			fail("Era esperado excecao");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaListaPesquisadores() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraPesquisador("Chicken Jo", "Professor", "estuda as donzelas", "chicken10@gmail12", "http://bielzin");
		controlePesquisador.listaPesquisadores("PROFESSOR");
	}
	
	@Test
	public void testaListaPesquisadoresTipoVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraPesquisador("Chicken Jo", "Professor", "estuda as donzelas", "chicken10@gmail12", "http://bielzin");
		try {
			controlePesquisador.listaPesquisadores("");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaListaPesquisadoresTipoNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraPesquisador("Chicken Jo", "Professor", "estuda as donzelas", "chicken10@gmail12", "http://bielzin");
		try {
			controlePesquisador.listaPesquisadores(null);
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaAlteraPesquisadorProfessor() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		controlePesquisador.alteraPesquisador("gabriel12@gmail12", "FORMACAO", "Mestrado");
		controlePesquisador.alteraPesquisador("gabriel12@gmail12", "UNIDADE", "CAESI");
		controlePesquisador.alteraPesquisador("gabriel12@gmail12", "DATA", "19/09/2001");
	}
	
	@Test
	public void testaAlteraPesquisadorAluno() {
		controlePesquisador.cadastraPesquisador("Gabriel", "estudante", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeAluno("gabriel12@gmail12", 3, 9.9);
		controlePesquisador.alteraPesquisador("gabriel12@gmail12", "SEMESTRE", "1");
		controlePesquisador.alteraPesquisador("gabriel12@gmail12", "IEA", "10.0");
	}
	
	@Test
	public void testaAlteraPesquisadorEmailVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.alteraPesquisador("", "Doutorado", "Mestrado");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaAlteraPesquisadorAtributoVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.alteraPesquisador("gabriel12@gmail12", "", "Mestrado");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaAlteraPesquisadorNovoValorVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.alteraPesquisador("gabriel12@gmail12", "Doutorado", "");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaAlteraPesquisadorEmailNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.alteraPesquisador(null, "Doutorado", "Mestrado");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaAlteraPesquisadorAtributoNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.alteraPesquisador("gabriel12@gmail12", null, "Mestrado");
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaAlteraPesquisadorNovoValorNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.alteraPesquisador("gabriel12@gmail12", "FORMACAO", null);
		} catch (NullPointerException NPE) {
		}
	}
	
	@Test
	public void testaExibePesquisador() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		controlePesquisador.exibePesquisador("gabriel12@gmail12");
		}
	
	@Test
	public void testaExibePesquisadorEmailVazio() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.exibePesquisador("");
		} catch (IllegalArgumentException IEA) {
		}
	}
	
	@Test
	public void testaExibePesquisadorEmailNulo() {
		controlePesquisador.cadastraPesquisador("Gabriel", "Professor", "estuda as donzelas", "gabriel12@gmail12", "http://bielzin");
		controlePesquisador.cadastraEspecialidadeProfessor("gabriel12@gmail12", "Doutorado", "DCE", "17/03/2001");
		try {
			controlePesquisador.exibePesquisador(null);
		} catch (NullPointerException NPE) {
		}
	}
}
