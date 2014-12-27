package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class FrameExibeProfessores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblListaDeProfessores;

	
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	
	public FrameExibeProfessores() {
		
		setBounds(100, 100, 469, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table = new JTable(MainFrame.professores.size(),4);
		scroll.setBounds(15, 36, 424, 374);
		contentPane.add(scroll);
		scroll.setViewportView(table);
		
		lblListaDeProfessores = new JLabel("Lista de Professores");
		lblListaDeProfessores.setForeground(Color.DARK_GRAY);
		lblListaDeProfessores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeProfessores.setBounds(173, 10, 193, 14);
		contentPane.add(lblListaDeProfessores);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(322, 422, 117, 25);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		
		table.getColumnModel().getColumn(0).setHeaderValue("Nome");
		table.getColumnModel().getColumn(1).setHeaderValue("CPF");
		table.getColumnModel().getColumn(2).setHeaderValue("Sexo");
		table.getColumnModel().getColumn(3).setHeaderValue("Titulo");
		
		
		
		for(int i=0;i<MainFrame.professores.size();i++){
			table.setValueAt( MainFrame.professores.get(i).getNome(),i,0);
			table.setValueAt( MainFrame.professores.get(i).getCpf(),i,1);
			table.setValueAt( MainFrame.professores.get(i).getSexo(),i,2);
			table.setValueAt( MainFrame.professores.get(i).getTitulo(),i,3);
		}
		
		this.setResizable(false);	
		setVisible(true);
		
		
	}
}
