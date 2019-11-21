package entidades;

/**
 * Representacao de um Aluno.
 */
public class Aluno extends Especificacao {

	/**
	 * O semestre que o aluno esta cursando.
	 */
	protected int semestre;
	
	/**
	 * O IEA do aluno.
	 */
	protected double IEA;

	/**
	 * Constroi um Aluno, a partir do seu nome, funcao, biografia, email, foto, semestre e o IEA.
	 * 
	 * @param nome eh o nome do aluno.
	 * @param funcao eh a funcao, que eh aluno.
	 * @param biografia eh a biografia do aluno.
	 * @param email eh o email do aluno.
	 * @param foto eh a foto do aluno.
	 * @param semestre eh o semestre do aluno.
	 * @param IEA eh o IEA do aluno.
	 */
	public Aluno(String nome, String funcao, String biografia, String email, String foto, int semestre, double IEA) {
		super(nome, funcao, biografia, email, foto);
		this.semestre = semestre;
		this.IEA = IEA;
	}

	/**
	 * Metodo que retorna o semestre que o Aluno esta cursando.
	 * 
	 * @return retorna o semestre que o Aluno esta cursando.
	 */
	public int getSemestre() {
		return semestre;
	}

	/**
	 * Metodo que retorna o IEA do aluno.
	 * 
	 * @return retorna o IEA do aluno.
	 */
	public double getIEA() {
		return IEA;
	}

	/**
	 * Metodo que altera o semestre que o aluno esta cusando.
	 * 
	 * @param semestre eh o semestre que o aluno esta cursando.
	 */
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	/**
	 * Metodo que altera o IEA do aluno.
	 * 
	 * @param iEA eh o IEA do aluno.
	 */
	public void setIEA(double iEA) {
		this.IEA = iEA;
	}

	/**
	 * Metodo que retorna a representacao em foram de String do Aluno.
	 * Segue o formato: NOME (ALUNO) - BIOGRAFIA - EMAIL - FOTO - NUM.SEMESTRE SEMESTRE - IEA.
	 * 
	 * @return retorna a representacao em foram de String do Aluno.
	 */
	@Override
	public String toString() {
		return this.nome + " ("+ this.funcao + ")" + " - " + this.biografia + " - " + this.email + " - " + this.foto + " - "
				+ this.semestre + "o SEMESTRE" + " - " + this.IEA;
	}

}