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

public class ModificarProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_1_data;
	private JTextField textField_2_cpf;
	private JTextField textField_3_telefone;
	private JTextField textField_4_dataa;
	private JTextField textField_5_salario;
	static Controle controle;
	static String nome;
	static Long Cpf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ModificarProfessor frame = new ModificarProfessor(controle, nome, Cpf);
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
	public ModificarProfessor(Controle controle, String nome, Long Cpf) {
		ModificarProfessor.controle = controle;
		ModificarProfessor.nome = nome;
		ModificarProfessor.Cpf = Cpf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(38, 67, 158, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data nascimento");
		lblNewLabel_1.setBounds(38, 120, 140, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(38, 159, 120, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setBounds(38, 204, 140, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Data Admissao");
		lblNewLabel_4.setBounds(38, 253, 140, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Salario Bruto");
		lblNewLabel_5.setBounds(38, 309, 108, 14);
		contentPane.add(lblNewLabel_5);

		textField_nome = new JTextField();
		textField_nome.setBounds(150, 64, 314, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);

		textField_1_data = new JTextField();
		textField_1_data.setBounds(150, 117, 314, 20);
		contentPane.add(textField_1_data);
		textField_1_data.setColumns(10);

		textField_2_cpf = new JTextField();
		textField_2_cpf.setBounds(150, 156, 314, 20);
		contentPane.add(textField_2_cpf);
		textField_2_cpf.setColumns(10);

		textField_3_telefone = new JTextField();
		textField_3_telefone.setBounds(150, 201, 314, 20);
		contentPane.add(textField_3_telefone);
		textField_3_telefone.setColumns(10);

		textField_4_dataa = new JTextField();
		textField_4_dataa.setBounds(150, 250, 314, 20);
		contentPane.add(textField_4_dataa);
		textField_4_dataa.setColumns(10);

		textField_5_salario = new JTextField();
		textField_5_salario.setBounds(150, 306, 314, 20);
		contentPane.add(textField_5_salario);
		textField_5_salario.setColumns(10);

		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(554, 400, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Deletar");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControleSQL csql = new ControleSQL();
				csql.deleteProfessorSQL(Cpf);;
				dispose();



				/*if(controle.removerProfessor(Cpf)){
					JOptionPane.showMessageDialog(null, "Atualizado");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao remover");
				}*/
			}
		});
		btnNewButton_1.setBounds(38, 400, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Salvar");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControleSQL csql = new ControleSQL();
				csql.atualizaDadosProfessorMySQL(Double.parseDouble(textField_5_salario.getText())
						, textField_4_dataa.getText()
						, textField_nome.getText()
						, textField_1_data.getText()
						, Long.parseLong(textField_2_cpf.getText())
						, textField_3_telefone.getText()
						, Cpf
						, nome);
				dispose();








				/*if(controle.AlterarProfessor(Cpf
						, nome
						, textField_nome.getText()
						, textField_1_data.getText()
						, Long.parseLong(textField_2_cpf.getText())
						, textField_3_telefone.getText()
						, textField_4_dataa.getText()
						, Double.parseDouble(textField_5_salario.getText()))) {
					JOptionPane.showMessageDialog(null, "Atualizado");
					dispose();



				}else {
					JOptionPane.showMessageDialog(null, "Error ao Atualizar");
				}*/

			}
		});
		btnNewButton_2.setBounds(455, 400, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
