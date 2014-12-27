package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FrameCreditos extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
	public FrameCreditos() {
		setTitle("Creditos");
		setBounds(100, 100, 313, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCriadoPor = new JLabel("Criado por:");
		lblCriadoPor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCriadoPor.setForeground(Color.DARK_GRAY);
		lblCriadoPor.setBounds(10, 85, 156, 14);
		contentPane.add(lblCriadoPor);
		
		JLabel lblPauloRobertoXavier = new JLabel("Paulo Roberto Xavier");
		lblPauloRobertoXavier.setForeground(Color.DARK_GRAY);
		lblPauloRobertoXavier.setBounds(10, 110, 156, 14);
		contentPane.add(lblPauloRobertoXavier);
		
		JLabel lblGabrielSegobia = new JLabel("Gabriel Segobia");
		lblGabrielSegobia.setForeground(Color.DARK_GRAY);
		lblGabrielSegobia.setBounds(10, 135, 118, 14);
		contentPane.add(lblGabrielSegobia);
		
		JLabel lblSistemaDeProfessores = new JLabel("Sistema de Professores - ");
		lblSistemaDeProfessores.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSistemaDeProfessores.setForeground(Color.DARK_GRAY);
		lblSistemaDeProfessores.setBounds(46, 36, 136, 14);
		contentPane.add(lblSistemaDeProfessores);
		
		JLabel lblBetaVersao = new JLabel("Beta - Versao 0.1");
		lblBetaVersao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBetaVersao.setForeground(Color.DARK_GRAY);
		lblBetaVersao.setBounds(162, 36, 102, 14);
		contentPane.add(lblBetaVersao);
		
		JLabel lblUltimaAtualizacao = new JLabel("Ultima Atualizacao:");
		lblUltimaAtualizacao.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblUltimaAtualizacao.setForeground(Color.DARK_GRAY);
		lblUltimaAtualizacao.setBounds(10, 321, 118, 14);
		contentPane.add(lblUltimaAtualizacao);
		
		JLabel label = new JLabel("24/07/14");
		label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label.setForeground(Color.DARK_GRAY);
		label.setBounds(120, 321, 46, 14);
		contentPane.add(label);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(197, 312, 93, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		JLabel lblAtividadeAcademica = new JLabel("Atividade Academica - Computacao 2");
		lblAtividadeAcademica.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAtividadeAcademica.setForeground(Color.DARK_GRAY);
		lblAtividadeAcademica.setBounds(36, 11, 232, 14);
		contentPane.add(lblAtividadeAcademica);
		
		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProfessor.setForeground(Color.DARK_GRAY);
		lblProfessor.setBounds(10, 189, 76, 14);
		contentPane.add(lblProfessor);
		
		JLabel lblFellipeDuarte = new JLabel("Fellipe Duarte");
		lblFellipeDuarte.setForeground(Color.DARK_GRAY);
		lblFellipeDuarte.setBounds(10, 214, 102, 14);
		contentPane.add(lblFellipeDuarte);
		
		JLabel lblMatricula = new JLabel("2013785184");
		lblMatricula.setForeground(Color.DARK_GRAY);
		lblMatricula.setBounds(138, 110, 125, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblMatricula_1 = new JLabel("2013785079");
		lblMatricula_1.setForeground(Color.DARK_GRAY);
		lblMatricula_1.setBounds(138, 135, 121, 14);
		contentPane.add(lblMatricula_1);
		
		JLabel lblAgradecimentos = new JLabel("Agradecimentos");
		lblAgradecimentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAgradecimentos.setForeground(Color.DARK_GRAY);
		lblAgradecimentos.setBounds(10, 260, 102, 14);
		contentPane.add(lblAgradecimentos);
		
		JLabel lblDouglas = new JLabel("Douglas Oliveira");
		lblDouglas.setForeground(Color.DARK_GRAY);
		lblDouglas.setBounds(10, 285, 136, 14);
		contentPane.add(lblDouglas);
		this.setResizable(false);	
		setVisible(true);
	}
}
