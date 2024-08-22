package eMentor.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import eMentor.Aluno;
import eMentor.Controle;
import eMentor.ControleSQL;

public class PaginaCadastroAluno extends JFrame {

	static Controle controle;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_aluno;
	private JTextField textField_1_nascimento;
	private JTextField textField_2_cpf;
	private JTextField textField_3_telefone;
	private JTextField textField_4_matricula;
	private JTextField textField_5_periodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PaginaCadastroAluno frame = new PaginaCadastroAluno(controle);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}





	/**
	 * Create the frame.
	 */
	public PaginaCadastroAluno(Controle controle) {
		PaginaCadastroAluno.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_aluno = new JTextField();
		textField_aluno.setBounds(137, 31, 259, 20);
		contentPane.add(textField_aluno);
		textField_aluno.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome Aluno:");
		lblNewLabel.setBounds(21, 31, 96, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento: ");
		lblNewLabel_1.setBounds(21, 68, 106, 14);
		contentPane.add(lblNewLabel_1);

		textField_1_nascimento = new JTextField();
		textField_1_nascimento.setBounds(137, 62, 259, 20);
		contentPane.add(textField_1_nascimento);
		textField_1_nascimento.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("CPF: ");
		lblNewLabel_2.setBounds(21, 108, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone: ");
		lblNewLabel_3.setBounds(21, 151, 96, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Matricula: ");
		lblNewLabel_4.setBounds(21, 192, 96, 14);
		contentPane.add(lblNewLabel_4);

		textField_2_cpf = new JTextField();
		textField_2_cpf.setBounds(137, 105, 259, 20);
		contentPane.add(textField_2_cpf);
		textField_2_cpf.setColumns(10);

		textField_3_telefone = new JTextField();
		textField_3_telefone.setBounds(137, 148, 259, 20);
		contentPane.add(textField_3_telefone);
		textField_3_telefone.setColumns(10);

		textField_4_matricula = new JTextField();
		textField_4_matricula.setBounds(137, 189, 259, 20);
		contentPane.add(textField_4_matricula);
		textField_4_matricula.setColumns(10);

		textField_5_periodo = new JTextField();
		textField_5_periodo.setBounds(137, 228, 259, 20);
		contentPane.add(textField_5_periodo);
		textField_5_periodo.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Periodo: ");
		lblNewLabel_5.setBounds(21, 231, 96, 14);
		contentPane.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();

				aluno.setNome(textField_aluno.getText().trim());
				aluno.setDataNascimento(textField_1_nascimento.getText().trim());
				aluno.setCPF(Long.parseLong(textField_2_cpf.getText().trim()));
				aluno.setTelefone(textField_3_telefone.getText().trim());
				aluno.setMatricula(Long.parseLong(textField_4_matricula.getText().trim()));
				aluno.setPeriodo(Integer.parseInt(textField_5_periodo.getText().trim()));


				if(controle.salvarAluno(aluno)) {

					ControleSQL csql = new ControleSQL();
					csql.insereDadosAlunoNoMySQL(textField_aluno.getText()
							, Long.parseLong(textField_2_cpf.getText())
							, textField_3_telefone.getText()
							, textField_1_nascimento.getText()
							, Long.parseLong(textField_4_matricula.getText())
							, Integer.parseInt(textField_5_periodo.getText()));

					dispose();

				}else {
					dispose();
				}
			}
		});
		btnNewButton.setBounds(321, 287, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(420, 287, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
