package projeto;

public class Aluno extends Pesquisador{

	private int semestre;
	private double IEA;
	
	public Aluno(String nome, String funcao, String biografia, String email, String foto, int semestre, double IEA) {
		super(nome, funcao, biografia, email, foto);
		this.semestre = semestre;
		this.IEA = IEA;
	}
	
	@Override
	public String toString() {
		return this.nome + "(ALUNO)" + " - " + this.biografia + "- " + this.email + " - " + this.foto + " - " + this.semestre + " SEMESTRE" + " - " + this.IEA;
	}
  
}
