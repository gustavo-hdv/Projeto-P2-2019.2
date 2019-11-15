package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import projeto.Buscador;
import projeto.Buscavel;
import projeto.Problema;
import projeto.Validador;

/**
 * Laboratório de Programação 2 - Projeto
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

/**

 * Representação de um Controller dos Problemas.
 *

 * @author Marcos Silva

 */
public class ProblemaController implements Buscador {
    /**
     * Problemas. Corresponde ao mapa de problemas.
     */
    protected Map<String, Problema> problemas;
    /**
     * Posição. Corresponde a posição do próximo problema na lista (mapa) de problemas a ser usada no código do problema.
     */
    private int posicao;

    /**
     * Constrói um controller para problemas.
     */
    public ProblemaController(){
        this.problemas = new LinkedHashMap<String, Problema>();
        this.posicao = 1;
    }

    /**

     * Cadastra um novo problema.
     * Adiciona um objeto do tipo Problema no mapa de problemas.
     
     * @param descricao descrição do problema
     * @param viabilidade viabilidade do problema
     *
     */
    public void cadastraProblema(String descricao, int viabilidade){
        Validador.validaString(descricao, "Campo descricao nao pode ser nulo ou vazio.");
        Validador.validaValores(viabilidade, "Valor invalido de viabilidade.");

        String codigo = "P" + this.posicao;
        this.problemas.put(codigo, new Problema(codigo, descricao, viabilidade));
        this.posicao += 1;
    }

    /**
     * Retorna a String que representa o problema existente na chave passada por parâmetro.
     *
     * @param codigo o código e chave do problema no mapa
     * @return a representação em String do problema pesquisado
     */
    public String exibeProblema(String codigo){
        Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validador.isRegistered(codigo, this.problemas, "Problema nao encontrado");

        return this.problemas.get(codigo).toString();
    }

    /**
     * Remove um problema do mapa de problemas.
     *
     * @param codigo código do problema a ser removido
     */
    public void apagarProblema(String codigo){
        Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validador.isRegistered(codigo, this.problemas, "Problema nao encontrado");

        this.problemas.remove(codigo);
    }
    
    /** 
     * Retorna um problema pelo id
     * 
     * @param idProblema chave do mapa de problemas
     * 
     * @return Problema
     */
    public Problema getProblema(String idProblema) {
    	Validador.validaString(idProblema, "Campo idProblema nao pode ser nulo ou vazio.");
    	Validador.isRegistered(idProblema, this.problemas, "Problema nao encontrado.");
    	
    	return problemas.get(idProblema);
    }
	@Override
	public Collection<Buscavel> busca(String termo) {
		ArrayList<Buscavel> achados = new ArrayList<>();
		for (Buscavel problema : this.problemas.values()) {
			if (problema.contemTermo(termo)) achados.add(problema);
		}
		return achados;
	}
}
