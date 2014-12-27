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



public class FrameAdicionaDisciplinaGrade extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboGrade;
	private JComboBox<String> comboDisciplina;
	private JLabel lblNot;
	private JLabel lblAdd;
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	
	public ActionListener adicionaDisciplinaGrade(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
								
						int ok = 0;
						
						for(int i=0;i<MainFrame.grade.get(comboGrade.getSelectedIndex()).disciplinasCurso.size();i++){
							
							if(MainFrame.grade.get(comboGrade.getSelectedIndex()).disciplinasCurso.get(i).getNome().equals(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).getNome())){
							ok = 1;
							break;
							}
						}
							

						if(ok == 1){
							lblNot.setVisible(true);
							lblAdd.setVisible(false);
						}
						else if(ok == 0){
							MainFrame.grade.get(comboGrade.getSelectedIndex()).disciplinasCurso.add( MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()));
							//SerializaGradeCurricular.SerealizarGradeCurricular("gradeCurricular", MainFrame.grade);
							lblNot.setVisible(false);
							lblAdd.setVisible(true);
				
						}
				}
			};
		
		}
	
	public FrameAdicionaDisciplinaGrade() {
		setTitle("Adicionar Disciplina a Grade");
		setBounds(100, 100, 305, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboGrade = new JComboBox<String>();
		comboGrade.setBounds(10, 54, 242, 20);
		contentPane.add(comboGrade);
		
		comboDisciplina = new JComboBox<String>();
		comboDisciplina.setBounds(10, 110, 242, 20);
		contentPane.add(comboDisciplina);
		
		for(int i=0;i<MainFrame.grade.size();i++)
		{
			comboGrade.addItem(MainFrame.grade.get(i).getNomeCurso());
		}
		
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{
			comboDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
		}
		
		JLabel lblEscolhaAGrade = new JLabel("Escolha a Grade Curricular");
		lblEscolhaAGrade.setForeground(Color.DARK_GRAY);
		lblEscolhaAGrade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaAGrade.setBounds(10, 29, 171, 14);
		contentPane.add(lblEscolhaAGrade);
		
		JLabel lblEscolhaADisciplina = new JLabel("Escolha a Disciplina");
		lblEscolhaADisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaADisciplina.setForeground(Color.DARK_GRAY);
		lblEscolhaADisciplina.setBounds(10, 85, 111, 14);
		contentPane.add(lblEscolhaADisciplina);
		
		JButton button = new JButton("+");
		button.setMargin(new Insets(2, 2, 2, 2));
		button.setBounds(262, 110, 23, 20);
		contentPane.add(button);
		button.addActionListener(adicionaDisciplinaGrade());
		
		lblAdd = new JLabel("Disciplina adicionada com sucesso.");
		lblAdd.setForeground(new Color(0, 128, 0));
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdd.setBounds(35, 148, 213, 14);
		contentPane.add(lblAdd);
		
		lblNot = new JLabel("Disciplina j\u00E1 est\u00E1 na Grade.");
		lblNot.setForeground(Color.RED);
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setBounds(60, 148, 171, 14);
		contentPane.add(lblNot);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(187, 190, 98, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		lblAdd.setVisible(false);
		lblNot.setVisible(false);
		setVisible(true);
		setResizable(false);
	}

}
