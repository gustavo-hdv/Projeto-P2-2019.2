package projeto;

import easyaccept.EasyAccept;

/** 
 * Representacao de uma fachada para todas as funcionalidades do sistema
 */

public class Facade {

	private ObjetivoController objetivoController = new ObjetivoController();
	private ProblemaController problemaController = new ProblemaController();

	public static void main(String[] args) {
		args = new String[]{"projeto.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt", "TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt"};
		EasyAccept.main(args);
	}

	public void cadastraProblema(String descricao, int viabilidade){
		this.problemaController.cadastraProblema(descricao, viabilidade);
	}

	public void cadastraObjetivo(String tipo, String descricao, int aderencia, int viabilidade){
		this.objetivoController.cadastraObjetivo(tipo, descricao, aderencia, viabilidade);
	}

	public void apagarProblema(String codigo){
		this.problemaController.apagaProblema(codigo);
	}

	public void apagarObjetivo(String codigo){
		this.objetivoController.apagarObjetivo(codigo);
	}

	public String exibeProblema(String codigo){
		return this.problemaController.exibeProblema(codigo);
	}

	public String exibeObjetivo(String codigo){
		return this.objetivoController.exibeObjetivo(codigo);
	}
}