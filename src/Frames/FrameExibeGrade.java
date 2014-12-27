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

public class FrameExibeGrade extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	
	public FrameExibeGrade() {
		setTitle("Exibir Grades");
		setBounds(100, 100, 464, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table = new JTable(MainFrame.grade.size(),2);
		scroll.setBounds(10, 35, 424, 319);
		contentPane.add(scroll);
		scroll.setViewportView(table);
		
		JLabel lblGradesCurriculares = new JLabel("Grades Curriculares");
		lblGradesCurriculares.setForeground(Color.DARK_GRAY);
		lblGradesCurriculares.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGradesCurriculares.setBounds(137, 11, 151, 14);
		contentPane.add(lblGradesCurriculares);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(329, 365, 105, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
	
		table.getColumnModel().getColumn(0).setHeaderValue("Nome do Curso");
		table.getColumnModel().getColumn(1).setHeaderValue("Disciplinas");
		
		
		for(int i=0;i<MainFrame.grade.size();i++){
			table.setValueAt(MainFrame.grade.get(i).getNomeCurso(),i,0);
			table.setValueAt(MainFrame.grade.get(i).disciplinasCurso.size(),i,1);
		}
		this.setResizable(false);	
		setVisible(true);
	}
}
