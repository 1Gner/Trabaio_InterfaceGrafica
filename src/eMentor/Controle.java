package eMentor;

import java.util.ArrayList;

public class Controle {

	private ArrayList<Aluno> alunos = new ArrayList<>();
	private ArrayList<Professor> professores = new ArrayList<>();

	public boolean salvarAluno(Aluno a) {
		if (a != null) {
			alunos.add(a);
			return true;
		} else {
			return false;
		}

	}

	public boolean salvarProfessor(Professor p) {
		if (p != null) {
			professores.add(p);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Professor> verListaProfessor() {
		return professores;
	}

	public ArrayList<Aluno> verListaAluno() {
		return alunos;
	}

	public boolean VerificarAluno(String nome, Long Cpf) {
		for (Aluno a : alunos) {
			if (a.getNome().equals(nome) && a.getCPF().equals(Cpf)) {
				return true;
			}
		}
		return false;
	}



	public boolean Alteraraluno(Long Cpf, String nome, String NewNome, String NewData, Long NewCpf, String Newtelefone,
			Long NewMatricula, int NewPeriodo) {
		for (Aluno a : alunos) {
			if (a.getNome().equals(nome) && a.getCPF().equals(Cpf)) {
				a.setNome(NewNome);
				a.setDataNascimento(NewData);
				a.setCPF(NewCpf);
				a.setTelefone(Newtelefone);
				a.setMatricula(NewMatricula);
				a.setPeriodo(NewPeriodo);
				return true;

			}
		}
		return false;

	}

	public boolean removerAluno(Long cpf) {
		if (alunos.removeIf(aluno -> aluno.getCPF() == cpf)) {
			return true;
		}
		return false;
	}


	public boolean removerProfessor(Long cpf) {
		if (professores.removeIf(professor -> professor.getCPF() == cpf)) {
			return true;
		}
		return false;
	}

	public boolean AlterarProfessor(Long Cpf, String nome, String NewNome, String NewData, Long NewCpf, String Newtelefone,
			String NewDataA, Double Salario) {

		for (Professor p : professores) {
			if (p.getNome().equals(nome) && p.getCPF().equals(Cpf)) {
				p.setNome(NewNome);
				p.setDataNascimento(NewData);
				p.setCPF(NewCpf);
				p.setTelefone(Newtelefone);
				p.setDataAdimissao(NewDataA);
				p.setSalarioBruto(Salario);
				return true;

			}
		}
		return false;

	}

	public boolean VerificarProfessor(String nome, Long Cpf) {
		for (Professor p : professores) {
			if (p.getNome().equals(nome) && p.getCPF().equals(Cpf)) {
				return true;
			}
		}
		return false;
	}
}
