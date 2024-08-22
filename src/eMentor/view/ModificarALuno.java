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

public class ModificarALuno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_1_data;
	private JTextField textField_2_cpf;
	private JTextField textField_3_telefone;
	private JTextField textField_4_matricula;
	private JTextField textField_5_periodo;
	static Controle controle;
	private static Long matricula;
	private static String nome;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ModificarALuno frame = new ModificarALuno(controle, nome, matricula);
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
	public ModificarALuno(Controle controle,String nome,Long matricula) {
		ModificarALuno.controle =controle;
		ModificarALuno.nome = nome;
		ModificarALuno.matricula = matricula;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblNewLabel = new JLabel("Nome Aluno:");
		lblNewLabel.setBounds(21, 31, 96, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento: ");
		lblNewLabel_1.setBounds(21, 68, 106, 14);
		contentPane.add(lblNewLabel_1);



		JLabel lblNewLabel_2 = new JLabel("CPF: ");
		lblNewLabel_2.setBounds(21, 108, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefone: ");
		lblNewLabel_3.setBounds(21, 151, 96, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Matricula: ");
		lblNewLabel_4.setBounds(21, 192, 96, 14);
		contentPane.add(lblNewLabel_4);


		JLabel lblNewLabel_5 = new JLabel("Periodo: ");
		lblNewLabel_5.setBounds(21, 231, 96, 14);
		contentPane.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("Excluir aluno");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ControleSQL csql = new ControleSQL();
				csql.deleteAlunoSQL(matricula);
				dispose();



				//Dados em memoria
				/*if(controle.removerAluno(cpf)) {
					JOptionPane.showMessageDialog(null, "Atualizado");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar");
					dispose();
				}*/
			}
		});
		btnNewButton.setBounds(37, 372, 119, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Alterar Aluno");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				ControleSQL csql= new ControleSQL();
				csql.atualizaDadosNoMySQL(Long.parseLong(textField_4_matricula.getText())
						, Integer.parseInt(textField_5_periodo.getText())
						, textField_nome.getText()
						, textField_1_data.getText()
						, Long.parseLong(textField_2_cpf.getText())
						, textField_3_telefone.getText()
						,matricula,
						nome);
				dispose();




				/*if(
						controle.Alteraraluno(cpf
								,nome
								,textField_nome.getText().trim()
								,textField_1_data.getText().trim()
								,Long.parseLong(textField_2_cpf.getText().trim())
								,textField_3_telefone.getText().trim()
								,Long.parseLong(textField_4_matricula.getText().trim())
								,Integer.parseInt(textField_5_periodo.getText().trim()))) {

					JOptionPane.showMessageDialog(null, "Atualizado");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar");
					dispose();
				}*/

			}
		});
		btnNewButton_1.setBounds(353, 372, 119, 23);
		contentPane.add(btnNewButton_1);

		textField_nome = new JTextField();
		textField_nome.setBounds(148, 31, 319, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);

		textField_1_data = new JTextField();
		textField_1_data.setBounds(148, 65, 319, 20);
		contentPane.add(textField_1_data);
		textField_1_data.setColumns(10);

		textField_2_cpf = new JTextField();
		textField_2_cpf.setBounds(148, 105, 319, 20);
		contentPane.add(textField_2_cpf);
		textField_2_cpf.setColumns(10);

		textField_3_telefone = new JTextField();
		textField_3_telefone.setBounds(148, 148, 319, 20);
		contentPane.add(textField_3_telefone);
		textField_3_telefone.setColumns(10);

		textField_4_matricula = new JTextField();
		textField_4_matricula.setBounds(148, 189, 319, 20);
		contentPane.add(textField_4_matricula);
		textField_4_matricula.setColumns(10);

		textField_5_periodo = new JTextField();
		textField_5_periodo.setBounds(148, 228, 319, 20);
		contentPane.add(textField_5_periodo);
		textField_5_periodo.setColumns(10);

		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(506, 372, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
