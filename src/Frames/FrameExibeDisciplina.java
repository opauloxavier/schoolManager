package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class FrameExibeDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField txtObrigatorio;
	private JTextField txtDescricao;
	private JTable table;
	private JComboBox<String> comboDisciplina;
	private JLabel lblObrigatoriedade;
	
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
				
				for(int i = 0; i < 20; i++){
					
					table.setValueAt(" ",i,0);
				}
				
				txtDescricao.setText(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).getDescricao());
				
				if(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).isObrigatoria() == true){
					
					txtObrigatorio.setText("Obrigatoria");
				}
				else if(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).isObrigatoria() == false){
					
					txtObrigatorio.setText("Nao Obrigatoria");
				}
				
				for(int i = 0; i < MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).requisitos.preRequisitos.size(); i++){
					
					table.setValueAt( MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).requisitos.preRequisitos.get(i).getNome(),i,0);
				}				
			}
		};
	}

	public FrameExibeDisciplina() {
		
		setTitle("Exibir Pre-Requisitos");
		setBounds(100, 100, 387, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboDisciplina = new JComboBox<String>();
		comboDisciplina.setBounds(12, 33, 217, 24);
		contentPane.add(comboDisciplina);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplina.setForeground(Color.DARK_GRAY);
		lblDisciplina.setBounds(12, 12, 70, 15);
		contentPane.add(lblDisciplina);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setForeground(Color.DARK_GRAY);
		lblDescricao.setBounds(12, 69, 90, 15);
		contentPane.add(lblDescricao);
		
		txtObrigatorio = new JTextField();
		txtObrigatorio.setBounds(12, 160, 168, 19);
		contentPane.add(txtObrigatorio);
		txtObrigatorio.setColumns(10);
		txtObrigatorio.setEditable(false);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(12, 96, 346, 19);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		txtDescricao.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table = new JTable(20,1);
		scroll.setBounds(12, 207, 346, 191);
		contentPane.add(scroll);
		scroll.setViewportView(table);
		
		table.getColumnModel().getColumn(0).setHeaderValue("Pre-Requisitos");
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(241, 423, 117, 25);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(241, 33, 117, 25);
		contentPane.add(btnAtualizar);
		
		lblObrigatoriedade = new JLabel("Obrigatoriedade");
		lblObrigatoriedade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObrigatoriedade.setForeground(Color.DARK_GRAY);
		lblObrigatoriedade.setBounds(12, 135, 126, 14);
		contentPane.add(lblObrigatoriedade);
		btnAtualizar.addActionListener(atualizar());
		
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{
			comboDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
		}	
		this.setResizable(false);	
		setVisible(true);
	}
}
