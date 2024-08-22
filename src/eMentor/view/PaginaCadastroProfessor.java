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

import eMentor.Controle;
import eMentor.ControleSQL;
import eMentor.Professor;

public class PaginaCadastroProfessor extends JFrame {

	static Controle controle;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_1_nascimento;
	private JTextField textField_2_cpf;
	private JTextField textField_3_telefone;
	private JTextField textField_4_admissao;
	private JTextField textField_5_salariobruto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PaginaCadastroProfessor frame = new PaginaCadastroProfessor(controle);
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
	public PaginaCadastroProfessor(Controle controle) {
		PaginaCadastroProfessor.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(21, 48, 103, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento: ");
		lblNewLabel_1.setBounds(21, 89, 103, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF: ");
		lblNewLabel_2.setBounds(21, 127, 103, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone: ");
		lblNewLabel_3.setBounds(21, 163, 103, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Data Admissao: ");
		lblNewLabel_4.setBounds(21, 207, 103, 14);
		contentPane.add(lblNewLabel_4);

		textField_name = new JTextField();
		textField_name.setBounds(138, 45, 345, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);

		textField_1_nascimento = new JTextField();
		textField_1_nascimento.setBounds(138, 86, 345, 20);
		contentPane.add(textField_1_nascimento);
		textField_1_nascimento.setColumns(10);

		textField_2_cpf = new JTextField();
		textField_2_cpf.setBounds(138, 124, 345, 20);
		contentPane.add(textField_2_cpf);
		textField_2_cpf.setColumns(10);

		textField_3_telefone = new JTextField();
		textField_3_telefone.setBounds(138, 160, 345, 20);
		contentPane.add(textField_3_telefone);
		textField_3_telefone.setColumns(10);

		textField_4_admissao = new JTextField();
		textField_4_admissao.setBounds(138, 204, 345, 20);
		contentPane.add(textField_4_admissao);
		textField_4_admissao.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Salario Bruto");
		lblNewLabel_5.setBounds(21, 248, 103, 14);
		contentPane.add(lblNewLabel_5);

		textField_5_salariobruto = new JTextField();
		textField_5_salariobruto.setBounds(138, 245, 345, 20);
		contentPane.add(textField_5_salariobruto);
		textField_5_salariobruto.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Professor professor = new Professor();
				professor.setNome(textField_name.getText());
				professor.setDataNascimento(textField_1_nascimento.getText());
				professor.setCPF(Long.parseLong(textField_2_cpf.getText()));
				professor.setTelefone(textField_3_telefone.getText());
				professor.setDataAdimissao(textField_4_admissao.getText());
				professor.setSalarioBruto(Double.parseDouble(textField_5_salariobruto.getText()));


				ControleSQL csql = new ControleSQL();
				csql.insereDadosProfessorNoMySQL(textField_name.getText(), Long.parseLong(textField_2_cpf.getText())
						,textField_3_telefone.getText()
						, textField_1_nascimento.getText(),Double.parseDouble(textField_5_salariobruto.getText())
						, textField_4_admissao.getText());


				//Banco em memoria
				/*if(controle.salvarProfessor(professor)) {
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar");
				}*/

			}
		});
		btnNewButton.setBounds(350, 311, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(449, 311, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
