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

public class FrameExibeSalas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblListaDeSalas;
	private JButton btnConcluido;

	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	
	
	
	public FrameExibeSalas() {
		setTitle("Lista de Salas e Laboratorios");
		setBounds(100, 100, 472, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table = new JTable(MainFrame.salas.size()+MainFrame.laboratorios.size(),5);
		scroll.setBounds(15, 36, 424, 374);
		contentPane.add(scroll);
		scroll.setViewportView(table);
		
		lblListaDeSalas = new JLabel("Lista de Salas e Laboratorios");
		lblListaDeSalas.setForeground(Color.DARK_GRAY);
		lblListaDeSalas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeSalas.setBounds(126, 11, 193, 14);
		contentPane.add(lblListaDeSalas);
		
		btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(332, 425, 107, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		table.getColumnModel().getColumn(0).setHeaderValue("Numero");
		table.getColumnModel().getColumn(1).setHeaderValue("Bloco");
		table.getColumnModel().getColumn(2).setHeaderValue("Andar");
		table.getColumnModel().getColumn(3).setHeaderValue("Capacidade");
		table.getColumnModel().getColumn(4).setHeaderValue("Tipo");
				
		for(int i=0;i<MainFrame.salas.size();i++){
			table.setValueAt( MainFrame.salas.get(i).getNumero(),i,0);
			table.setValueAt( MainFrame.salas.get(i).getBloco(),i,1);
			table.setValueAt( MainFrame.salas.get(i).getAndar(),i,2);
			table.setValueAt( MainFrame.salas.get(i).getCapacidade(),i,3);
			table.setValueAt( "SALA" ,i,4);
		}
		
		for(int i=0;i<MainFrame.laboratorios.size();i++){
			table.setValueAt( MainFrame.laboratorios.get(i).getNumero(),i+MainFrame.salas.size(),0);
			table.setValueAt( MainFrame.laboratorios.get(i).getBloco(),i+MainFrame.salas.size(),1);
			table.setValueAt( MainFrame.laboratorios.get(i).getAndar(),i+MainFrame.salas.size(),2);
			table.setValueAt( MainFrame.laboratorios.get(i).getCapacidade(),i+MainFrame.salas.size(),3);
			table.setValueAt("LAB",i+MainFrame.salas.size(),4);
		}
		this.setResizable(false);	
		setVisible(true);
	}

}
