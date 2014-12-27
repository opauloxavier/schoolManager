package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;


import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameDefineProfessor extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboProfessor;
	private JComboBox<String> comboOferta;
	private JLabel lblNot;


	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
	public ActionListener adicionar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//int ok=0;
				
//				for(int i=0;i<MainFrame.professores.get(comboProfessor.getSelectedIndex()).getOfertasAceitas().size();i++){
//					if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getOfertasAceitas().get(i).equals(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getOfertasAceitas().get(i))){
//						System.out.println("REPETIU");
//						ok=1;
//					}
//				
//				}
				//se nao contem oferta no professor
				if(! MainFrame.professores.get(comboProfessor.getSelectedIndex()).getOfertasAceitas().contains(MainFrame.ofertas.get(comboOferta.getSelectedIndex()))){	
					//if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getOfertasAceitas().size()<3){	
						//System.out.println("1");	
						MainFrame.professores.get(comboProfessor.getSelectedIndex()).setOfertasAceitas(MainFrame.ofertas.get(comboOferta.getSelectedIndex()));							
						
					//}
					
					//SerializaProfessor.SerealizarProfessor("professores", MainFrame.professores);
					//SerializaOfertaDisciplina.SerealizarOfertaDisciplina("ofertas", MainFrame.ofertas);
					//SerializaAlocacaoHorario.SerealizarAlocacaoHorario("alocaHorario", MainFrame.alocacoes);
			
					lblNot.setVisible(false);
				}
					//ok = 1;
				
//				
//				if(ok==0){
//				
//					if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getOfertasAceitas().size()<3){	
//				
//						MainFrame.professores.get(comboProfessor.getSelectedIndex()).setOfertasAceitas(MainFrame.ofertas.get(comboOferta.getSelectedIndex()));
//				
//						System.out.println("FUNCIONA ESTA MERDA");
//				
//					}
//				}
				
				
				else {
					lblNot.setVisible(true);
					
				}
			}
		};
	}
	
	
	public FrameDefineProfessor() {
		setTitle("Define Professor");
		setBounds(100, 100, 426, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboOferta = new JComboBox<String>();
		comboOferta.setBounds(10, 41, 382, 20);
		contentPane.add(comboOferta);
		
		JLabel lblEscolhaAOferta = new JLabel("Escolha a Oferta");
		lblEscolhaAOferta.setForeground(Color.DARK_GRAY);
		lblEscolhaAOferta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaAOferta.setBounds(10, 11, 149, 14);
		contentPane.add(lblEscolhaAOferta);
		
		comboProfessor = new JComboBox<String>();
		comboProfessor.setBounds(10, 146, 349, 20);
		contentPane.add(comboProfessor);
		
		JLabel lblEscolhaOProfessor = new JLabel("Escolha o Professor");
		lblEscolhaOProfessor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaOProfessor.setForeground(Color.DARK_GRAY);
		lblEscolhaOProfessor.setBounds(10, 121, 223, 14);
		contentPane.add(lblEscolhaOProfessor);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(289, 198, 103, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		JButton button = new JButton("+");
		button.setMargin(new Insets(2, 2, 2, 2));
		button.setBounds(369, 146, 23, 20);
		contentPane.add(button);
		
		lblNot = new JLabel("A\u00E7ao Invalida");
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setForeground(Color.RED);
		lblNot.setBounds(125, 181, 132, 14);
		contentPane.add(lblNot);
		button.addActionListener(adicionar());
		lblNot.setVisible(false);
		setVisible(true);
		this.setResizable(false);	
		for(int i=0;i<MainFrame.ofertas.size();i++)
		{
			comboOferta.addItem(""+MainFrame.ofertas.get(i).getDisciplina().getNome()+
					" - "+MainFrame.ofertas.get(i).getListaAlocaHorario().getHorario().getTurno()+" - "+MainFrame.ofertas.get(i).getListaAlocaHorario().getHorario().getDia()+""
							+" - "+MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getNumero()+" - "+MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getAndar()+"");
		}
		
		for(int i=0;i<MainFrame.professores.size();i++)
		{
			comboProfessor.addItem(MainFrame.professores.get(i).getNome());
		}	
	}
}
