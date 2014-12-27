package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.Disciplina;


public class FramePreRequisito extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboEscolheDisciplina;
	private JComboBox<String> comboEscolhePre;
	private JLabel lblAdd;
	private JLabel lblNot;
	private JLabel lblAlready;
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	
	
	public ActionListener adicionaPreRequisito(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int ok = 0;
				
				
				if(comboEscolheDisciplina.getSelectedIndex()==comboEscolhePre.getSelectedIndex()) {
				
					lblAlready.setVisible(false);
					lblNot.setVisible(true);
					lblAdd.setVisible(false);
				}
				
				
				else if(MainFrame.disciplinas.get(comboEscolheDisciplina.getSelectedIndex()).getNome().compareTo(MainFrame.disciplinas.get(comboEscolhePre.getSelectedIndex()).getNome())!=0){
					
					if(MainFrame.disciplinas.get(comboEscolheDisciplina.getSelectedIndex()).getNome().equals(MainFrame.disciplinas.get(comboEscolhePre.getSelectedIndex()).getNome())==false){
						
						for(int i=0;i<MainFrame.disciplinas.get(comboEscolheDisciplina.getSelectedIndex()).requisitos.preRequisitos.size();i++){
							if(MainFrame.disciplinas.get(comboEscolheDisciplina.getSelectedIndex()).requisitos.preRequisitos.get(i).getNome().equals(MainFrame.disciplinas.get(comboEscolhePre.getSelectedIndex()).getNome())==true){
							ok = 1;
							}
							
						}

						if(ok == 1){
							
							lblAlready.setVisible(true);
							lblNot.setVisible(false);
							lblAdd.setVisible(false);
						}
						else if(ok == 0){
							MainFrame.disciplinas.get(comboEscolheDisciplina.getSelectedIndex()).requisitos.preRequisitos.add( MainFrame.disciplinas.get(comboEscolhePre.getSelectedIndex()));
							//SerializaDisciplina.SerealizarDisciplina("disciplinas", MainFrame.disciplinas);
							lblAlready.setVisible(false);
							lblNot.setVisible(false);
							lblAdd.setVisible(true);
				
						}
				}
					
			}
				};
			
		};
	};
	
	
	
	public FramePreRequisito() {
		setTitle("Adicionar Pré-Requisitos");
		setBounds(100, 100, 302, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboEscolheDisciplina = new JComboBox<String>();
		comboEscolheDisciplina.setBounds(10, 36, 235, 20);
		contentPane.add(comboEscolheDisciplina);
		
		
		JLabel lblEscolhaADisciplina = new JLabel("Escolha a Disciplina");
		lblEscolhaADisciplina.setForeground(Color.DARK_GRAY);
		lblEscolhaADisciplina.setBounds(10, 11, 122, 14);
		contentPane.add(lblEscolhaADisciplina);
		
		JLabel lblSelecioneOPrerequisito = new JLabel("Selecione o pre-requisito");
		lblSelecioneOPrerequisito.setForeground(Color.DARK_GRAY);
		lblSelecioneOPrerequisito.setBounds(10, 75, 142, 14);
		contentPane.add(lblSelecioneOPrerequisito);
			
		
		comboEscolhePre = new JComboBox<String>();
		comboEscolhePre.setBounds(10, 100, 235, 20);
		contentPane.add(comboEscolhePre);
		
		JButton btnAdicionarPrerequisito = new JButton("+");
		btnAdicionarPrerequisito.setMargin(new Insets(2, 2, 3, 2));
		btnAdicionarPrerequisito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarPrerequisito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdicionarPrerequisito.setBounds(255, 100, 20, 20);
		
		btnAdicionarPrerequisito.addActionListener(adicionaPreRequisito());
		
		contentPane.add(btnAdicionarPrerequisito);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setBounds(186, 161, 89, 23);
		contentPane.add(btnConcluir);
		btnConcluir.addActionListener(cancelar());
		
		lblNot = new JLabel("Açao Invalida");
		lblNot.setForeground(Color.RED);
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setBounds(95, 133, 95, 14);
		contentPane.add(lblNot);
		
		lblAdd = new JLabel("Pre-Requisito Adicionado com sucesso.");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdd.setForeground(new Color(0, 128, 0));
		lblAdd.setBounds(10, 133, 265, 14);
		contentPane.add(lblAdd);
		
		lblAlready = new JLabel("Pre-Requisito ja definido");
		lblAlready.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlready.setForeground(new Color(255, 165, 0));
		lblAlready.setBounds(65, 133, 224, 14);
		contentPane.add(lblAlready);
		
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{
			comboEscolheDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
		}
			
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{	
				comboEscolhePre.addItem(MainFrame.disciplinas.get(i).getNome());
		}
		
		
		setVisible(true);
		this.setResizable(false);	
		lblAdd.setVisible(false);
		lblNot.setVisible(false);
		lblAlready.setVisible(false);
	}
}
