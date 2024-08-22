package eMentor;

public class Aluno extends Pessoa {
	
	
	private Long Matricula;
	private int Periodo;
	
	
	
	

	
	public Aluno(String nome, String dataNascimento, Long cPF2, String telefone, Long matricula, int periodo) {
		super(nome, dataNascimento, cPF2, telefone);
		Matricula = matricula;
		Periodo = periodo;
	}
	
	
	
	public Aluno() {
	}



	public Long getMatricula() {
		return Matricula;
	}
	public void setMatricula(Long matricula) {
		Matricula = matricula;
	}
	public int getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(int periodo) {
		Periodo = periodo;
	}

	@Override
	public String toString() {
		return "Aluno [Matricula=" + Matricula + ", Periodo=" + Periodo + "]";
	}
	

	
	
}
