package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.GradeCurricular;

public class FrameAdicionaGradeCurricular extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel lblNot;

	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
	public ActionListener adicionaGrade(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int ok=0;
				
							
				for(int i =0;i<MainFrame.grade.size();i++){
				
					if(MainFrame.grade.get(i).getNomeCurso().equals(txtNome.getText())==true){
						ok=1;
						break;
					}
					
				}
				
				
				
				
				if(ok==0){
				GradeCurricular a = new GradeCurricular(txtNome.getText());
				MainFrame.grade.add(a);
				
				//SerializaGradeCurricular.SerealizarGradeCurricular("gradeCurricular", MainFrame.grade);
				dispose();
				}
				
				if(ok==1){
					lblNot.setVisible(true);
				}
				
			}
		};
	}


	public FrameAdicionaGradeCurricular() {
		setTitle("Cadastro de Grade Curricular");
		setBounds(100, 100, 347, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(Color.DARK_GRAY);
		lblNome.setBounds(10, 29, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 26, 259, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120, 78, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(cancelar());
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(217, 78, 108, 23);
		contentPane.add(btnConfirmar);
		
		lblNot = new JLabel("Grade com mesmo nome ja existe.");
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setForeground(Color.RED);
		lblNot.setBounds(80, 50, 240, 14);
		contentPane.add(lblNot);
		btnConfirmar.addActionListener(adicionaGrade());
		
		lblNot.setVisible(false);
		setVisible(true);
		setResizable(false);
	}

}
