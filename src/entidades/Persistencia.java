package entidades;

import javax.swing.*;
import java.io.*;

/**
 * Laboratório de Programação 2 - Projeto
 *
 * @author Marcos Vinícius Santos Silva - 119111008
 */

public class Persistencia {

    /**
     * Metodo que salva um objeto em um arquivo
     *
     * @param o objeto a ser salvo
     * @param nomeArquivo nome do arquivo a ser salvo
     */
    public static void salvar(Object o, String diretorio, String nomeArquivo){
        try{
            File outputPath = new File("bd" + File.separator + diretorio);
            outputPath.mkdirs();
            FileOutputStream fos = new FileOutputStream(outputPath + File.separator + nomeArquivo + ".txt");
            @SuppressWarnings("resource")
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que carrega e retorna um objeto de um arquivo
     *
     * @param nomeArquivo nome do arquivo a ser carregado
     * @return objeto que foi carregado do arquivo
     */
    public static Object carregar(String diretorio, String nomeArquivo){
        try {
            FileInputStream fis = new FileInputStream("bd" + File.separator + diretorio + File.separator + nomeArquivo + ".txt");
            @SuppressWarnings("resource")
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object object = ois.readObject();
            ois.close();

            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
