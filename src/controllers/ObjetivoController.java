package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import projeto.Buscador;
import projeto.Buscavel;
import projeto.Objetivo;
import projeto.Validador;

/**
 * Laboratório de Programação 2 - Projeto
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um Controller dos Objetivos.
 *

 * @author Marcos Silva

 */
public class ObjetivoController implements Buscador {
    /**
     * Objetivos. Corresponde ao mapa de objetivos.
     */
    protected Map<String, Objetivo> objetivos;
    /**
     * Posicao. Corresponde a posição do próoimo objetivo na lista (mapa) de objetivos a ser usada no codigo do objetivo.
     */
    private int posicao;

    /**
     * Constroi um controller para objetivos.
     */
    public ObjetivoController(){
        this.objetivos = new LinkedHashMap<String, Objetivo>();
        this.posicao = 1;
    }

    /**
     * Cadastra um novo objetivo.
     * Adiciona um objeto do tipo Objetivo no mapa de objetivos.

     * @param tipo tipo do objetivo
     * @param descricao descrição do objetivo
     * @param aderencia aderência do objetivo
     * @param viabilidade viabilidade do objetivo
     *
     */
    public void cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade){
        Validador.validaString(tipo, "Campo tipo nao pode ser nulo ou vazio.");
        Validador.validaTipo(tipo, "Valor invalido de tipo.");
        Validador.validaString(descricao, "Campo descricao nao pode ser nulo ou vazio.");
        Validador.validaValores(aderencia, "Valor invalido de aderencia");
        Validador.validaValores(viabilidade, "Valor invalido de viabilidade.");

        String codigo = "O" + this.posicao;
        this.objetivos.put(codigo, new Objetivo(codigo, tipo, descricao, aderencia, viabilidade));
        this.posicao += 1;
    }

    /**
     * Retorna a String que representa o objetivo existente na chave passada por parâmetro.
     *
     * @param codigo o código e chave do objetivo no mapa
     * @return a representação em String do objetivo pesquisado
     */
    public String exibeObjetivo(String codigo){
        Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validador.isRegistered(codigo, this.objetivos, "Objetivo nao encontrado");

        return this.objetivos.get(codigo).toString();
    }

    /**
     * Remove um objetivo do mapa de objetivos.
     *
     * @param codigo código do objetivo a ser removido
     */
    public void apagarObjetivo(String codigo){
        Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validador.isRegistered(codigo, this.objetivos, "Objetivo nao encontrado");
        
        this.objetivos.remove(codigo);
    }

	@Override
	public Collection<Buscavel> busca(String termo) {
		ArrayList<Buscavel> achados = new ArrayList<>();
		for (Buscavel objetivo : this.objetivos.values()) {
			if (objetivo.contemTermo(termo)) achados.add(objetivo);
		}
		return achados;
	}
	
	/** Retorna um objetivo pelo id 
	 * 
	 * @param idObjetivo chave do mapa de objetivos
	 * @return Objetivo 
	 */
	public Objetivo getObjetivo(String idObjetivo) {
		Validador.validaString(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
    	Validador.isRegistered(idObjetivo, this.objetivos, "Objetivo nao encontrado.");
    	
    	return this.objetivos.get(idObjetivo);
	}
}
