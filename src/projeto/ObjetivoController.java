package projeto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    private Map<String, Objetivo> objetivos;
    /**
     * Posição. Corresponde a posição do próximo objetivo na lista (mapa) de objetivos a ser usada no código do objetivo.
     */
    private int posicao;

    /**
     * Constrói um controller para objetivos.
     */
    public ObjetivoController(){
        this.objetivos = new HashMap<>();
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
		// TODO Auto-generated method stub
		return null;
	}

}
