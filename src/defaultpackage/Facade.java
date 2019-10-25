package defaultpackage;

import easyaccept.EasyAccept;

public class Facade {

	/** Testes de aceitação */
	public static void main(String[] args) {
		args = new String[] { "defaultpackage.Facade", "TestesAceitacao/use_case_1.txt", "TestesAceitacao/use_case_2.txt", "TestesAceitacao/use_case_3.txt", "TestesAceitacao/use_case_4.txt"};
		EasyAccept.main(args);
	}
	
}
