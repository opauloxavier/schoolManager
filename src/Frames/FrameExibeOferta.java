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

public class FrameExibeOferta extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
	public FrameExibeOferta() {
		setTitle("Ofertas de Disciplinas");
		setBounds(100, 100, 710, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table = new JTable(20,10);
		scroll.setBounds(10, 37, 674, 296);
		contentPane.add(scroll);
		scroll.setViewportView(table);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(579, 352, 105, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		JLabel lblListaDasOfertas = new JLabel("Lista das Ofertas de Disciplinas");
		lblListaDasOfertas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDasOfertas.setForeground(Color.DARK_GRAY);
		lblListaDasOfertas.setBounds(221, 11, 202, 14);
		contentPane.add(lblListaDasOfertas);
		
		table.getColumnModel().getColumn(0).setHeaderValue("Nome");
		table.getColumnModel().getColumn(1).setHeaderValue("Obrigatoria");
		table.getColumnModel().getColumn(2).setHeaderValue("Ano");
		table.getColumnModel().getColumn(3).setHeaderValue("Periodo");
		table.getColumnModel().getColumn(4).setHeaderValue("Dia");
		table.getColumnModel().getColumn(5).setHeaderValue("Turno");
		table.getColumnModel().getColumn(6).setHeaderValue("Sala");
		table.getColumnModel().getColumn(7).setHeaderValue("Bloco");
		table.getColumnModel().getColumn(8).setHeaderValue("Capacidade");
		table.getColumnModel().getColumn(9).setHeaderValue("Professor");
		
		for(int i=0;i<MainFrame.ofertas.size();i++){
				table.setValueAt( MainFrame.ofertas.get(i).getDisciplina().getNome(),i,0);
				
				if(MainFrame.ofertas.get(i).getDisciplina().isObrigatoria())
				table.setValueAt("Sim" ,i,1);
				else
				table.setValueAt("Nao" ,i,1);	
				
				table.setValueAt( MainFrame.ofertas.get(i).getAno(),i,2);
				table.setValueAt( MainFrame.ofertas.get(i).getPeriodo(),i,3);
				table.setValueAt( MainFrame.ofertas.get(i).getListaAlocaHorario().getHorario().getDia(),i,4);
				table.setValueAt( MainFrame.ofertas.get(i).getListaAlocaHorario().getHorario().getTurno(),i,5);
				table.setValueAt( MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getNumero(),i,6);
				table.setValueAt( MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getBloco(),i,7);
				table.setValueAt( MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getCapacidade(),i,8);
				
				for(int j=0;j<MainFrame.professores.size();j++){
				if(MainFrame.professores.get(j).getOfertasAceitas().contains(MainFrame.ofertas.get(i)))
					table.setValueAt(MainFrame.professores.get(j).getNome(), i, 9);
				}
		
		this.setResizable(false);	
		setVisible(true);
	}
	}
	}
