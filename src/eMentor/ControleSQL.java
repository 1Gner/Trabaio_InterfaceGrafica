package eMentor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControleSQL {

	private final String caminho = "localhost";
	private final String porta = "3306";
	private final String nome = "ementor";
	private final String usuario = "root";
	private final String senha = "admin";
	private final String FusoHorario = "?useTimezone=true&serverTimezone=UTC";
	private final String URL ="jdbc:mysql://"+caminho+":"+porta+"/"+nome+FusoHorario;



	public Connection realizaConexaoMySQL(){
		try{
			return DriverManager.getConnection(URL,usuario,senha);

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}


	public void desconectaMySQL(Connection conexao){
		try{
			if (conexao != null) {
				conexao.close();
			}

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
	}

	public void insereDadosAlunoNoMySQL(String nome, long CPF, String Telefone,String Data, long matricula, int periodo){
		Connection conexao = realizaConexaoMySQL();

		String sql_aluno = "insert into aluno (Nome,Data,CPF,Telefone,matricula,periodo) values (?,?,?,?,?,?)";

		try{
			PreparedStatement Atuador_aluno = conexao.prepareStatement(sql_aluno);


			Atuador_aluno.setString(1, nome);
			Atuador_aluno.setString(2, Data);
			Atuador_aluno.setLong(3, CPF);
			Atuador_aluno.setString(4, Telefone);
			Atuador_aluno.setLong(5, matricula);
			Atuador_aluno.setLong(6, periodo);
			Atuador_aluno.execute();

			JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso","Salvar",JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public Aluno buscaAluno(Long matricula,String nome){
		Connection conexao = realizaConexaoMySQL();
		Aluno Academico  = new Aluno();
		Academico=null;

		try{
			String sql_selecao_aluno = "SELECT *FROM aluno WHERE matricula="+ matricula +" and nome="+nome+";";
			PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
			ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery();


			while(ResultadoSelecao.next()){

				Aluno ObjetoAluno = new Aluno();

				ObjetoAluno.CPF = ResultadoSelecao.getLong("CPF");
				ObjetoAluno.Nome = ResultadoSelecao.getString("Nome");
				ObjetoAluno.DataNascimento = ResultadoSelecao.getString("Data");
				ObjetoAluno.Telefone = ResultadoSelecao.getString("Telefone");
				ObjetoAluno.setMatricula(ResultadoSelecao.getLong("Matricula"));
				ObjetoAluno.setPeriodo(ResultadoSelecao.getInt("Periodo"));

				Academico=ObjetoAluno;

			}
			ResultadoSelecao.close();
			atuador_selecao_aluno.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public ArrayList<Aluno> recuperaDadosDoMySQL(){
		Connection conexao = realizaConexaoMySQL();
		ArrayList<Aluno> Academico = new ArrayList<Aluno>();

		try{
			String sql_selecao_aluno = "SELECT *FROM  aluno ;";
			PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
			ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery();

			while(ResultadoSelecao.next()){
				Aluno ObjetoAluno = new Aluno();

				ObjetoAluno.CPF = ResultadoSelecao.getLong("CPF");
				ObjetoAluno.Nome = ResultadoSelecao.getString("Nome");
				ObjetoAluno.DataNascimento = ResultadoSelecao.getString("Data");
				ObjetoAluno.Telefone = ResultadoSelecao.getString("Telefone");
				ObjetoAluno.setMatricula(ResultadoSelecao.getLong("Matricula"));
				ObjetoAluno.setPeriodo(ResultadoSelecao.getInt("Periodo"));

				Academico.add(ObjetoAluno);

			}
			ResultadoSelecao.close();
			atuador_selecao_aluno.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public void atualizaDadosNoMySQL(Long matricula, int periodo,String nome,String data,Long cpf,String telefone,Long oldMatricula, String oldNome){
		Connection conexao = realizaConexaoMySQL();
		String sql ="UPDATE aluno set nome="+nome+",data="+data+""
				+ ",cpf="+cpf+",telefone="+telefone+",periodo="+periodo+",matricula="+matricula+" WHERE matricula="+oldMatricula+" and nome="+oldNome+";";


		try{
			PreparedStatement Atuador = conexao.prepareStatement(sql);


			Atuador.execute();

			JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso","Salvar",JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public void deleteAlunoSQL(Long matricula) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "DELETE FROM aluno WHERE matricula="+matricula+";";

		try{
			PreparedStatement Atuador = conexao.prepareStatement(sql);


			Atuador.execute();

			JOptionPane.showMessageDialog(null,"Dados removidos","Salvar",JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}


	public void insereDadosProfessorNoMySQL(String nome, long CPF, String Telefone,String Data, Double salario, String dataA){
		Connection conexao = realizaConexaoMySQL();

		String sql_professor = "insert into professor (Nome,Data,CPF,Telefone,dataA,salario) values (?,?,?,?,?,?)";

		try{
			PreparedStatement Atuador_professor= conexao.prepareStatement(sql_professor);


			Atuador_professor.setString(1, nome);
			Atuador_professor.setString(2, Data);
			Atuador_professor.setLong(3, CPF);
			Atuador_professor.setString(4, Telefone);
			Atuador_professor.setDouble(5, salario);
			Atuador_professor.setString(6, dataA);
			Atuador_professor.execute();

			JOptionPane.showMessageDialog(null,"Cadastro Realizado com Sucesso","Salvar",JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public Professor buscaProfessor(Long cpf,String nome){
		Connection conexao = realizaConexaoMySQL();
		Professor Academico  = new Professor();
		Academico=null;

		try{
			String sql_selecao_professor = "SELECT *FROM professor WHERE cpf="+ cpf +" and nome="+nome+";";
			PreparedStatement atuador_selecao_professor = conexao.prepareStatement(sql_selecao_professor);
			ResultSet ResultadoSelecao = atuador_selecao_professor.executeQuery();


			while(ResultadoSelecao.next()){

				Professor Objetoprofessor = new Professor();

				Objetoprofessor.CPF = ResultadoSelecao.getLong("CPF");
				Objetoprofessor.Nome = ResultadoSelecao.getString("Nome");
				Objetoprofessor.DataNascimento = ResultadoSelecao.getString("Data");
				Objetoprofessor.Telefone = ResultadoSelecao.getString("Telefone");
				Objetoprofessor.setSalarioBruto(ResultadoSelecao.getDouble("salario"));
				Objetoprofessor.setDataAdimissao(ResultadoSelecao.getString("dataA"));

				Academico=Objetoprofessor;

			}
			ResultadoSelecao.close();
			atuador_selecao_professor.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public ArrayList<Professor> recuperaDadosProfessorMySQL(){
		Connection conexao = realizaConexaoMySQL();
		ArrayList<Professor> Academico = new ArrayList<Professor>();

		try{
			String sql_selecao_professor = "SELECT *FROM  professor ;";
			PreparedStatement atuador_selecao_professor = conexao.prepareStatement(sql_selecao_professor);
			ResultSet ResultadoSelecao = atuador_selecao_professor.executeQuery();

			while(ResultadoSelecao.next()){
				Professor ObjetoProfessor = new Professor();

				ObjetoProfessor.CPF = ResultadoSelecao.getLong("CPF");
				ObjetoProfessor.Nome = ResultadoSelecao.getString("Nome");
				ObjetoProfessor.DataNascimento = ResultadoSelecao.getString("Data");
				ObjetoProfessor.Telefone = ResultadoSelecao.getString("Telefone");
				ObjetoProfessor.setSalarioBruto(ResultadoSelecao.getDouble("salario"));
				ObjetoProfessor.setDataAdimissao(ResultadoSelecao.getString("dataA"));

				Academico.add(ObjetoProfessor);

			}
			ResultadoSelecao.close();
			atuador_selecao_professor.close();

		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
		return Academico;
	}

	public void atualizaDadosProfessorMySQL(Double salario, String dataA,String nome,String data,Long cpf,String telefone,Long oldcpf, String oldNome){
		Connection conexao = realizaConexaoMySQL();
		String sql ="UPDATE professor set nome="+nome+",data="+data+""
				+ ",cpf="+cpf+",telefone="+telefone+",salario="+salario+",dataA="+dataA+" WHERE cpf="+oldcpf+" and nome="+oldNome+";";


		try{
			PreparedStatement Atuador = conexao.prepareStatement(sql);


			Atuador.execute();

			JOptionPane.showMessageDialog(null,"Dados Atualizados com Sucesso","Salvar",JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}

	public void deleteProfessorSQL(Long cpf) {
		Connection conexao = realizaConexaoMySQL();
		String sql = "DELETE FROM professor WHERE cpf="+cpf+";";

		try{
			PreparedStatement Atuador = conexao.prepareStatement(sql);


			Atuador.execute();

			JOptionPane.showMessageDialog(null,"Dados removidos","Salvar",JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);

		}
		desconectaMySQL(conexao);
	}








}
