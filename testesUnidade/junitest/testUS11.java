package junitest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.Controller;

class testUS11 {

	private Controller controleGeral;
	
	public testUS11() {
		this.controleGeral = new Controller();
	}
	
	@BeforeEach
	public void iniciar() {
		controleGeral.cadastraPesquisa("Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces.", "fermentacao, cerveja"); // FER1
		controleGeral.cadastraPesquisador("Rafael Felipe Basso", "Engenherio Agronomo", "Interessado em pesquisas sobre aspectos da fermentacao", "rafaelflbp@gmail.com", "http://www.tcc.sc.usp.br/tce/disponiveis/11/110100/tce-21072015-140723/");
		controleGeral.cadastraObjetivo("GERAL", "Analisar a fermentacao", 3, 5); //O1
		controleGeral.cadastraObjetivo("ESPECIFICO", "Atividade metabolica de fungos unicelulares, anaerobicos facultativos.", 5, 5); //01
		controleGeral.cadastraProblema("Concentracao do alcool.", 4); // P1
		controleGeral.cadastraAtividade("Hidrolise durante o processo fermentativo.", "BAIXO", "Molecula de acucar e uma aglicona livre."); //A1
		controleGeral.cadastraItem("A1", "Analisar o aroma.");
		controleGeral.cadastraItem("A1", "Analisar o tipo da fermentacao");
		controleGeral.cadastraItem("A1", "Conclusoes sobre a hidrolise durante o processo fermentativo");
		
		controleGeral.associaPesquisador("FER1", "rafaelflbp@gmail.com");
		controleGeral.associaProblema("FER1", "P1");
		controleGeral.associaObjetivo("FER1", "O1");
		controleGeral.associaObjetivo("FER1", "O1");
		controleGeral.associaAtividade("FER1", "A1");
		controleGeral.executaAtividade("A1", 1, 3);
		controleGeral.executaAtividade("A1", 2, 15);
		controleGeral.cadastraResultado("A1", "Viabilizacao da exploracao do potencial das leveduras na cervejaria.");
	}
	
	@Test
	void testGravarResumo() throws IOException {
		controleGeral.gravarResumo("FER1");
		String resumoTxt = "- Pesquisa: FER1 - Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces. - fermentacao, cerveja"
				+ "	- Pesquisadores:"
				+ " 		- Rafael Felipe Basso (Engenherio Agronomo) - Interessado em pesquisas sobre aspectos da fermentacao - rafaelflbp@gmail.com - http://www.tcc.sc.usp.br/tce/disponiveis/11/110100/tce-21072015-140723/"
				+ "	- Problema:"
				+ " 		- P1 - Concentracao do alcool. - 4"
				+ "	- Objetivos: 		- O1 - GERAL - Analisar a fermentacao - 8"
				+ "	- Atividades:"
				+ " 		- Hidrolise durante o processo fermentativo. (BAIXO - Molecula de acucar e uma aglicona livre.)"
				+ "			- REALIZADO - ITEM1"
				+ "			- REALIZADO - ITEM2"
				+ "			- PENDENTE - ITEM3";
		
		FileReader arquivo = new FileReader("_FER1.txt");
		BufferedReader lerArquivo = new BufferedReader(arquivo);
		String linha = lerArquivo.readLine();
		String resumo = "";
		while (linha != null) {
			resumo += linha;
			linha = lerArquivo.readLine();
		}
		assertEquals(resumo, resumoTxt);
		arquivo.close();
	}
	
	@Test
	void testGravarResultados() throws IOException {
		controleGeral.gravarResultados("FER1");
		String resultadosTxt = "- Pesquisa: FER1 - Aspectos da fermentacao do mosto cervejeiro por leveduras nao-Saccharomyces. - fermentacao, cerveja"
				+ "	- Resultados: 		- Hidrolise durante o processo fermentativo."
				+ "			- ITEM1 - 3"
				+ "			- ITEM2 - 15"
				+ "			- Viabilizacao da exploracao do potencial das leveduras na cervejaria.";
		
		FileReader arquivo = new FileReader("FER1-Resultados.txt");
		BufferedReader lerArquivo = new BufferedReader(arquivo);
		String linha = lerArquivo.readLine();
		String resumo = "";
		while (linha != null) {
			resumo += linha;
			linha = lerArquivo.readLine();
		}
		assertEquals(resumo, resultadosTxt);
		arquivo.close();
	}

}
