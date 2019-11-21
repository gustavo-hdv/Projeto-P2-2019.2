package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import entidades.*;

/**
 * Representacao de um Controller dos Problemas.
 */
public class ProblemaController implements Buscador {
    /**
     * Problemas. Corresponde ao mapa de problemas.
     */
    protected Map<String, Problema> problemas;
    /**
     * Posicao. Corresponde a posicao do proximo problema na lista (mapa) de problemas a ser usada no codigo do problema.
     */
    private int posicao;

    /**
     * Constroi um controller para problemas.
     */
    public ProblemaController(){
        this.problemas = new LinkedHashMap<String, Problema>();
        this.posicao = 1;
    }

    /**

     * Cadastra um novo problema.
     * Adiciona um objeto do tipo Problema no mapa de problemas.
     
     * @param descricao descricao do problema
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
     * @param codigo o codigo e chave do problema no mapa
     * @return a representacao em String do problema pesquisado
     */
    public String exibeProblema(String codigo){
        Validador.validaString(codigo, "Campo codigo nao pode ser nulo ou vazio.");
        Validador.isRegistered(codigo, this.problemas, "Problema nao encontrado");

        return this.problemas.get(codigo).toString();
    }

    /**
     * Remove um problema do mapa de problemas.
     *
     * @param codigo codigo do problema a ser removido
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

    /**
     * Salva todos os atributos.
     */
    public void salvaDados(){
        Persistencia.salvar(this.problemas, "problemaController", "problemas");
        Persistencia.salvar(this.posicao, "problemaController", "posicao");
    }

    /**
     * Carrega todos os atributos.
     */
    public void carregaDados(){
        this.problemas = (LinkedHashMap<String, Problema>) Persistencia.carregar("problemaController", "problemas");
        this.posicao = (int) Persistencia.carregar("problemaController", "posicao");
    }
}
