package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.Disciplina;

public class FrameAdicionaDisciplina extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboEscolheGrade;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JCheckBox chckbxObrigatoria;
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
	public ActionListener criaDisciplina(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				
				Disciplina a = new Disciplina(txtNome.getText(),txtDescricao.getText(),chckbxObrigatoria.isSelected());
				
				MainFrame.disciplinas.add(a);
				
				//System.out.println(MainFrame.disciplinas.size());
				
				//SerializaDisciplina.SerealizarDisciplina("disciplinas", MainFrame.disciplinas);
				dispose();
			}
		};
	}

	public FrameAdicionaDisciplina() {
		setTitle("Adicionar Disciplina");
		setBounds(100, 100, 365, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(Color.DARK_GRAY);
		lblNome.setBounds(10, 23, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(88, 20, 254, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setForeground(Color.DARK_GRAY);
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setBounds(10, 54, 68, 14);
		contentPane.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(88, 51, 254, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		chckbxObrigatoria = new JCheckBox("Obrigat\u00F3ria");
		chckbxObrigatoria.setSelected(true);
		chckbxObrigatoria.setForeground(Color.DARK_GRAY);
		chckbxObrigatoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxObrigatoria.setBounds(253, 78, 89, 23);
		
		contentPane.add(chckbxObrigatoria);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(236, 111, 106, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(criaDisciplina());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(137, 111, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(cancelar());
		
		setResizable(false);
		setVisible(true);
	}
}
