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

public class AlterarProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_professor;
	private JTextField textField_1_cpf;
	static Controle controle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AlterarProfessor frame = new AlterarProfessor(controle);
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
	public AlterarProfessor(Controle controle) {
		AlterarProfessor.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome do Professor");
		lblNewLabel.setBounds(200, 76, 192, 14);
		contentPane.add(lblNewLabel);

		textField_professor = new JTextField();
		textField_professor.setBounds(200, 97, 205, 20);
		contentPane.add(textField_professor);
		textField_professor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CPF do Professor");
		lblNewLabel_1.setBounds(200, 171, 205, 14);
		contentPane.add(lblNewLabel_1);

		textField_1_cpf = new JTextField();
		textField_1_cpf.setBounds(200, 196, 205, 20);
		contentPane.add(textField_1_cpf);
		textField_1_cpf.setColumns(10);

		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ControleSQL csql = new ControleSQL();

				if(csql.buscaProfessor(Long.parseLong(textField_1_cpf.getText()),textField_professor.getText()) != null) {
					JOptionPane.showMessageDialog(null, "Professor encontrado");
					ModificarProfessor mdpro = new  ModificarProfessor(controle
							,textField_professor.getText()
							,Long.parseLong(textField_1_cpf.getText()));
					mdpro.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Professor nao existe");
				}


				/*if(controle.VerificarProfessor(textField_professor.getText(), Long.parseLong(textField_1_cpf.getText()))) {
					JOptionPane.showMessageDialog(null, "Professor encontrado");
					ModificarProfessor mdpro = new  ModificarProfessor(controle
							,textField_professor.getText()
							,Long.parseLong(textField_1_cpf.getText()));
					mdpro.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Professor nao existe");
				}*/
			}
		});
		btnNewButton.setBounds(266, 290, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(550, 396, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
