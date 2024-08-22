package eMentor.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import eMentor.Controle;
import eMentor.ControleSQL;

public class AlterarAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nome;
	private JTextField textField_1_matricula;
	static Controle controle;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AlterarAluno frame = new AlterarAluno(controle);
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
	public AlterarAluno(Controle controle) {
		AlterarAluno.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_nome = new JTextField();
		textField_nome.setBounds(202, 94, 204, 20);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome do Aluno");
		lblNewLabel.setBounds(202, 69, 204, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Matricula do aluno");
		lblNewLabel_1.setBounds(202, 167, 204, 14);
		contentPane.add(lblNewLabel_1);

		textField_1_matricula = new JTextField();
		textField_1_matricula.setBounds(202, 192, 204, 20);
		contentPane.add(textField_1_matricula);
		textField_1_matricula.setColumns(10);

		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				//Banco em memoria
				/*if(controle.VerificarAluno(textField_nome.getText().trim(), Long.parseLong(textField_1_cpf.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "Aluno encontrado");
					ModificarALuno mdaluno = new ModificarALuno(controle,textField_nome.getText(),Long.parseLong(textField_1_cpf.getText()));
					mdaluno.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Aluno nao existe");
				}*/

				ControleSQL csql = new ControleSQL();
				if(csql.buscaAluno(Long.parseLong(textField_1_matricula.getText()), textField_nome.getText()  ) != null){
					ModificarALuno mdaluno = new ModificarALuno(controle,textField_nome.getText(),Long.parseLong(textField_1_matricula.getText()));
					mdaluno.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Aluno nao existe");
				}

			}


		});
		btnNewButton.setBounds(261, 288, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(477, 364, 89, 23);
		contentPane.add(btnNewButton_1);
	}


}
