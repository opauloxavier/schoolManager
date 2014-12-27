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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FrameEditaDisciplina extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboDisciplina;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JLabel lblEmpty;

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
				
				
				txtNome.setText(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).getNome());
				txtDescricao.setText(MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).getDescricao());
				
			}
		};
	}
	
	
	
	public ActionListener alterar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int ok=0;
				
				//if(txtNome.getText()=="" || txtDescricao.getText()==""){
				//	ok=1;
				//}
				
				if(ok==0){
				MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).setNome(txtNome.getText());	
				MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()).setDescricao(txtDescricao.getText());
				//SerializaDisciplina.SerealizarDisciplina("disciplinas", MainFrame.disciplinas);
				}
				
				else if(ok==1){
					lblEmpty.setVisible(true);
				}
				
				comboDisciplina.removeAllItems();
				for(int i=0;i<MainFrame.disciplinas.size();i++)
				{
					comboDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
				}	
				
			}
		};
	}

	
	public FrameEditaDisciplina() {
		setTitle("Editar Disciplina");
		setBounds(100, 100, 358, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setForeground(Color.DARK_GRAY);
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplina.setBounds(10, 22, 91, 14);
		contentPane.add(lblDisciplina);
		
		comboDisciplina = new JComboBox<String>();
		comboDisciplina.setBounds(10, 44, 218, 20);
		contentPane.add(comboDisciplina);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(Color.DARK_GRAY);
		lblNome.setBounds(10, 88, 86, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 113, 218, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 169, 218, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setForeground(Color.DARK_GRAY);
		lblDescricao.setBounds(10, 144, 86, 14);
		contentPane.add(lblDescricao);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(238, 43, 89, 21);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(atualizar());
		
		JButton btnAlterar= new JButton("Alterar");
		btnAlterar.setBounds(238, 113, 89, 21);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(alterar());
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(221, 239, 106, 23);
		contentPane.add(btnConcluido);
		
		lblEmpty = new JLabel("Acao invalida. Preencha os campos.");
		lblEmpty.setForeground(Color.RED);
		lblEmpty.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmpty.setBounds(54, 203, 250, 14);
		contentPane.add(lblEmpty);
		btnConcluido.addActionListener(cancelar());
		
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{
			comboDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
		}	
		this.setResizable(false);	
		lblEmpty.setVisible(false);
		setVisible(true);
	}
}
