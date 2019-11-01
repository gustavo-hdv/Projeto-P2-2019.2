package projeto;

import java.util.HashMap;
import java.util.Map;

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
public class ProblemaController {
    /**
     * Problemas. Corresponde ao mapa de problemas.
     */
    private Map<String, Problema> problemas;
    /**
     * Posição. Corresponde a posição do próximo problema na lista (mapa) de problemas a ser usada no código do problema.
     */
    private int posicao;

    /**
     * Constrói um controller para problemas.
     */
    public ProblemaController(){
        this.problemas = new HashMap<>();
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

}
