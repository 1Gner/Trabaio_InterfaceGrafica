package eMentor;

public class Pessoa {
	protected String Nome;
	protected String DataNascimento;
	protected Long CPF;
	protected String Telefone;
	
	
	
	public Pessoa(String nome, String dataNascimento, Long cPF2, String telefone) {
		super();
		Nome = nome;
		DataNascimento = dataNascimento;
		CPF = cPF2;
		Telefone = telefone;
	}
	
	
	
	public Pessoa() {
		super();
	}



	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	public void imprimir() {
		
	}
	
	
}
