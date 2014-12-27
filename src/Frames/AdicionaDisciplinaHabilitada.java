package Frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;


import java.awt.Insets;

public class AdicionaDisciplinaHabilitada extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboDisciplina;
	private JComboBox<String> comboProfessor;
	private JLabel lblNot;
	private JLabel lblAdd;
	private JLabel lblRemove;
	private JLabel lblNotRemove;
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	
	public ActionListener adicionaHabilitacao(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int ok=0;
				
				for(int i=0;i<MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.size();i++){
					if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).getNome().equals(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).getNome())==true){
						ok=1;
					}
				}
				
				if(ok==1){
					lblNot.setVisible(true);
					lblAdd.setVisible(false);
					lblRemove.setVisible(false);
					lblNotRemove.setVisible(false);
				}
				
				if(ok==0){
					MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.add(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()));
					//SerializaProfessor.SerealizarProfessor("professores", MainFrame.professores);
					lblAdd.setVisible(true);
					lblNot.setVisible(false);
					lblRemove.setVisible(false);
					lblNotRemove.setVisible(false);
				}
							
				
						
			}
		};
	}
	
	public ActionListener removeHabilitacao(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int ok=0;
				
				for(int i=0;i<MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.size();i++){
					if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).getNome().equals(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).getNome())==true){
						ok=1;
					}
				}
				
				if(ok==1){
					MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.remove(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()));
					lblAdd.setVisible(false);
					lblNot.setVisible(false);
					lblRemove.setVisible(true);
					lblNotRemove.setVisible(false);
				}
				
				if(ok==0){
					lblAdd.setVisible(false);
					lblNot.setVisible(false);
					lblRemove.setVisible(false);
					lblNotRemove.setVisible(true);
				}
							
				
						
			}
		};
	}
	
	
	
	
	public AdicionaDisciplinaHabilitada() {
		setTitle("Adicionar Disciplina Habilitada");
		setBounds(100, 100, 350, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboProfessor = new JComboBox<String>();
		comboProfessor.setBounds(10, 40, 312, 23);
		contentPane.add(comboProfessor);
		
		comboDisciplina = new JComboBox<String>();
		comboDisciplina.setBounds(10, 121, 249, 23);
		contentPane.add(comboDisciplina);
		
		JLabel lblEscolhaOProfessor = new JLabel("Escolha o Professor");
		lblEscolhaOProfessor.setForeground(Color.DARK_GRAY);
		lblEscolhaOProfessor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaOProfessor.setBounds(10, 15, 169, 14);
		contentPane.add(lblEscolhaOProfessor);
		
		JLabel lblEscolhaADisciplina = new JLabel("Escolha a Disciplina");
		lblEscolhaADisciplina.setForeground(Color.DARK_GRAY);
		lblEscolhaADisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaADisciplina.setBounds(10, 96, 249, 14);
		contentPane.add(lblEscolhaADisciplina);
		
		JButton button = new JButton("+");
		button.setMargin(new Insets(2, 2, 2, 2));
		button.setBounds(265, 121, 27, 23);
		contentPane.add(button);
		button.addActionListener(adicionaHabilitacao());
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(222, 211, 100, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener( cancelar());
		
		lblAdd = new JLabel("Habilita\u00E7\u00E3o Adicionada com Sucesso.");
		lblAdd.setForeground(new Color(0, 100, 0));
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdd.setBounds(29, 166, 230, 14);
		contentPane.add(lblAdd);
		
		lblNot = new JLabel("Professor j\u00E1 possui essa Habilita\u00E7\u00E3o.");
		lblNot.setForeground(Color.RED);
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setBounds(34, 166, 209, 14);
		contentPane.add(lblNot);
		
		JButton button_1 = new JButton("-");
		button_1.setMargin(new Insets(2, 2, 2, 2));
		button_1.setBounds(295, 121, 27, 23);
		contentPane.add(button_1);
		button_1.addActionListener(removeHabilitacao());
		
		lblRemove = new JLabel("Removida com Sucesso.");
		lblRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRemove.setForeground(new Color(0, 128, 0));
		lblRemove.setBounds(45, 166, 198, 14);
		contentPane.add(lblRemove);
		
		lblNotRemove = new JLabel("Disciplina n\u00E3o encontrada.");
		lblNotRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotRemove.setForeground(new Color(255, 0, 0));
		lblNotRemove.setBounds(45, 166, 198, 14);
		contentPane.add(lblNotRemove);
		
		for(int i=0;i<MainFrame.professores.size();i++)
		{
			comboProfessor.addItem(MainFrame.professores.get(i).getNome());
		}
		
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{
			comboDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
		}
		
		
		setResizable(false);
		setVisible(true);
		lblAdd.setVisible(false);
		lblNot.setVisible(false);
		lblRemove.setVisible(false);
		lblNotRemove.setVisible(false);
	}
}
