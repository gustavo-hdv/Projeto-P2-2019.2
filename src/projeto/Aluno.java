package projeto;

public class Aluno extends Especificacao {

	protected int semestre;
	protected double IEA;

	public Aluno(String nome, String funcao, String biografia, String email, String foto, int semestre, double IEA) {
		super(nome, funcao, biografia, email, foto);
		this.semestre = semestre;
		this.IEA = IEA;
	}

	public int getSemestre() {
		return semestre;
	}

	public double getIEA() {
		return IEA;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public void setIEA(double iEA) {
		this.IEA = iEA;
	}

	@Override
	public String toString() {
		return this.nome + " ("+ this.funcao + ")" + " - " + this.biografia + " - " + this.email + " - " + this.foto + " - "
				+ this.semestre + "o SEMESTRE" + " - " + this.IEA;
	}

}