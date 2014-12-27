package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class FrameProfessoresAptos extends JFrame {


	private JPanel contentPane;
	private JTable table;
	
	private JComboBox<String> comboDisciplina;

	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	

	
	public ActionListener atualizar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int k = 0;
				
				for(int i = 0; i < MainFrame.professores.size(); i++){
					
					table.setValueAt(" ",i,0);
					table.setValueAt(" ",i,1);
				}
				
				for(int i=0;i<MainFrame.professores.size();i++){
					
					for(int j = 0; j < MainFrame.professores.get(i).ministraDisciplina.disciplinasHabilitadas.size(); j++){
						
						if(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).getNome().equals(MainFrame.professores.get(i).ministraDisciplina.disciplinasHabilitadas.get(j).getNome())){

							table.setValueAt( MainFrame.professores.get(i).getNome(),k,0);
							table.setValueAt( MainFrame.professores.get(i).getCpf(),k,1);
							k++;
						}
					}
				//	table.setValueAt( MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).getNome(),i,0);
				//	table.setValueAt( MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).getDescricao(),i,1);
					
				}
			}
		};
	}
	
	
	public FrameProfessoresAptos() {
		setBounds(100, 100, 356, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboDisciplina = new JComboBox<String>();
		comboDisciplina.setBounds(10, 36, 198, 20);
		contentPane.add(comboDisciplina);
		
		JLabel lblDisciplina = new JLabel("Escolha a Disciplina");
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplina.setForeground(Color.DARK_GRAY);
		lblDisciplina.setBounds(10, 11, 169, 14);
		contentPane.add(lblDisciplina);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(218, 35, 102, 21);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(atualizar());
		
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table = new JTable(MainFrame.professores.size(),2);
		scroll.setBounds(10, 75, 310, 266);
		contentPane.add(scroll);
		scroll.setViewportView(table);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(220, 361, 100, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		table.getColumnModel().getColumn(0).setHeaderValue("Nome");
		table.getColumnModel().getColumn(1).setHeaderValue("CPF");
		
				
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{
			comboDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
		}	
		this.setResizable(false);	
		setVisible(true);
	}
}
