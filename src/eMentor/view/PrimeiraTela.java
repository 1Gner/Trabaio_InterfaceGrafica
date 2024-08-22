package eMentor.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eMentor.Controle;

public class PrimeiraTela extends JFrame {

	Controle controle = new Controle();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PrimeiraTela frame = new PrimeiraTela();
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
	public PrimeiraTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Cadastrar Alunos");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PaginaCadastroAluno  pgcaluno = new PaginaCadastroAluno(controle);
				pgcaluno.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(66, 100, 141, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cadastrar Professores");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PaginaCadastroProfessor pgcprofessor = new PaginaCadastroProfessor(controle);
				pgcprofessor.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(301, 100, 141, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Ver Alunos");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PaginaTabelaAluno pgtaluno = new PaginaTabelaAluno(controle);
				pgtaluno.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(66, 166, 141, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Ver Professores");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PaginaTabelaProfessor pgtprofessor = new PaginaTabelaProfessor(controle);
				pgtprofessor.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(301, 166, 141, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton = new JButton("Alterar Aluno");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AlterarAluno al = new AlterarAluno(controle);
				al.setVisible(true);

			}
		});
		btnNewButton.setBounds(66, 236, 141, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_5 = new JButton("Alterar Professor");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AlterarProfessor alprofe = new AlterarProfessor(controle);
				alprofe.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(301, 236, 141, 23);
		contentPane.add(btnNewButton_5);
	}
}
