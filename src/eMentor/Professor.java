package eMentor;

public class Professor extends Pessoa  {

	private String DataAdimissao;
	private Double SalarioBruto;



	public Professor(String nome, String dataNascimento, Long cPF, String telefone, String dataAdimissao,
			Double salarioBruto) {
		super(nome, dataNascimento, cPF, telefone);
		DataAdimissao = dataAdimissao;
		SalarioBruto = salarioBruto;
	}



	public Professor() {
		super();
	}



	public String getDataAdimissao() {
		return DataAdimissao;
	}
	public void setDataAdimissao(String dataAdimissao) {
		DataAdimissao = dataAdimissao;
	}
	public Double getSalarioBruto() {
		return SalarioBruto;
	}
	public void setSalarioBruto(Double salarioBruto) {
		SalarioBruto = salarioBruto;
	}

	public void Imprimir() {

	}

	public Double calcularSalarioLiquido() {
		Double salario = this.SalarioBruto;
		Double inss =  (salario * 0.14);
		if(salario >= 5000) {
			Double irpf = (salario * 0.225);
			salario = salario - irpf;
		}
		salario = salario - inss;
		return salario;

	}

}
