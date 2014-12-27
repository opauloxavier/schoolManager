package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.Sexo;
import Classes.Titulo;

public class FrameAlteraProfessor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	private JTextField txtNome;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JLabel lblTitulo;
	private JRadioButton rdbDoutorado;
	private JRadioButton rdbMestrado;
	private JRadioButton rdbEspecializacao;
	private JLabel lblSexo;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFeminino;
	private JButton btnCriar;
	private JButton btnCancelar;
	private JComboBox<String> comboProfessor;
	private JButton btnAlterarDados;
	private JLabel lblDisciplinasLecionveis;
	private JLabel lblAdd;
	private JLabel lblAdd_1;
	

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
				
				
				txtNome.setText(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getNome());
				txtCpf.setText(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getCpf());
				
				if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getSexo()==Sexo.MASCULINO){
					rdbMasculino.setSelected(true);
					
				}
				
				else if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getSexo()==Sexo.FEMININO){
					rdbFeminino.setSelected(true);
				}
				
				
				if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getTitulo()==Titulo.ESPECIALIZACAO){
					rdbEspecializacao.setSelected(true);
					
				}
				
				else if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getTitulo()==Titulo.MESTRADO){
					rdbMestrado.setSelected(true);
				}
				
				else if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).getTitulo()==Titulo.DOUTORADO){
					rdbDoutorado.setSelected(true);
				}
				
				
				//Tabela
				
				for(int i=0;i<MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.size();i++){
					table.setValueAt( MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).getNome(),i,0);
					table.setValueAt( MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).getDescricao(),i,1);
					
					if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).isObrigatoria()==true){
						table.setValueAt( "Obrigatoria",i,2);
					}
					
					else if(MainFrame.professores.get(comboProfessor.getSelectedIndex()).ministraDisciplina.disciplinasHabilitadas.get(i).isObrigatoria()==false){
						table.setValueAt("Nao Obrigatoria",i,2);
					}
					}
		
				
				
			}
		};
	}
	
	public ActionListener alterar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.professores.get(comboProfessor.getSelectedIndex()).setNome(txtNome.getText());
				
				if(rdbMasculino.isSelected()==true){
					MainFrame.professores.get(comboProfessor.getSelectedIndex()).setSexo(Sexo.MASCULINO);
					
				}
				
				else if(rdbFeminino.isSelected()==true){
					MainFrame.professores.get(comboProfessor.getSelectedIndex()).setSexo(Sexo.FEMININO);
				}
				
				if(rdbEspecializacao.isSelected()==true){
					MainFrame.professores.get(comboProfessor.getSelectedIndex()).setTitulo(Titulo.ESPECIALIZACAO);
				}
				
				else if(rdbMestrado.isSelected()==true){
					MainFrame.professores.get(comboProfessor.getSelectedIndex()).setTitulo(Titulo.MESTRADO);
				}
				
				else if(rdbDoutorado.isSelected()==true){
					MainFrame.professores.get(comboProfessor.getSelectedIndex()).setTitulo(Titulo.DOUTORADO);
				}
				
				comboProfessor.removeAllItems();
				
				for(int i=0;i<MainFrame.professores.size();i++)
				{
					comboProfessor.addItem(MainFrame.professores.get(i).getNome());
				}
				//SerializaProfessor.SerealizarProfessor("professores", MainFrame.professores);
				atualizar();
				lblAdd.setVisible(true);
			}
		};
	}
	
	
	
	
	public FrameAlteraProfessor() {
				
		setTitle("Exibir Professores");
		setBounds(100, 100, 518, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(376, 561, 105, 23);
		contentPane.add(btnConcluido);
		btnConcluido.addActionListener(cancelar());
		
		JScrollPane scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table = new JTable(30,3);
		scroll.setBounds(12, 337, 469, 204);
		contentPane.add(scroll);
		scroll.setViewportView(table);
		
		comboProfessor = new JComboBox<String>();
		comboProfessor.setBounds(12, 31, 370, 23);
		contentPane.add(comboProfessor);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(392, 31, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(atualizar());
		
		JLabel lblEscolhaOProfessor = new JLabel("Escolha o Professor");
		lblEscolhaOProfessor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaOProfessor.setForeground(Color.DARK_GRAY);
		lblEscolhaOProfessor.setBounds(116, 11, 135, 14);
		contentPane.add(lblEscolhaOProfessor);
			

		txtNome = new JTextField();
		txtNome.setBounds(55, 78, 292, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome"+ "");
		lblNome.setForeground(Color.DARK_GRAY);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(12, 81, 46, 14);
		contentPane.add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setForeground(Color.DARK_GRAY);
		lblCpf.setBounds(12, 112, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(55, 109, 292, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_TAB){
					e.consume();
				}
			}
		});
		
		txtCpf.setEditable(false);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitulo.setBounds(55, 148, 46, 14);
		contentPane.add(lblTitulo);
		
			
		rdbEspecializacao = new JRadioButton("Especializacao");
		rdbEspecializacao.setBounds(55, 169, 115, 23);
		contentPane.add(rdbEspecializacao);
		
		rdbMestrado = new JRadioButton("Mestrado");
		rdbMestrado.setBounds(55, 195, 109, 23);
		contentPane.add(rdbMestrado);
		
		rdbDoutorado = new JRadioButton("Doutorado");
		rdbDoutorado.setBounds(55, 221, 109, 23);
		contentPane.add(rdbDoutorado);
		
		ButtonGroup titulo = new ButtonGroup();
		titulo.add(rdbEspecializacao);
		titulo.add(rdbMestrado);
		titulo.add(rdbDoutorado);
		
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setForeground(Color.DARK_GRAY);
		lblSexo.setBounds(273, 148, 46, 14);
		contentPane.add(lblSexo);
		
	
		rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setBounds(273, 169, 109, 23);
		contentPane.add(rdbMasculino);
		
		rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setBounds(273, 195, 109, 23);
		contentPane.add(rdbFeminino);
		
		ButtonGroup sexo= new ButtonGroup();
		sexo.add(rdbMasculino);
		sexo.add(rdbFeminino);
		
		ButtonGroup tipoProfessor = new ButtonGroup();
		
		btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setBounds(366, 77, 115, 21);
		contentPane.add(btnAlterarDados);
		btnAlterarDados.addActionListener(alterar());
		
		lblDisciplinasLecionveis = new JLabel("Disciplinas Lecion\u00E1veis");
		lblDisciplinasLecionveis.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplinasLecionveis.setForeground(Color.DARK_GRAY);
		lblDisciplinasLecionveis.setBounds(151, 312, 200, 14);
		contentPane.add(lblDisciplinasLecionveis);
		
		lblAdd = new JLabel("Dados do professor alterados com Sucesso");
		lblAdd.setForeground(new Color(0, 128, 0));
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdd.setBounds(114, 257, 268, 14);
		contentPane.add(lblAdd);
		
		lblAdd.setVisible(false);
		
		table.getColumnModel().getColumn(0).setHeaderValue("Nome");
		table.getColumnModel().getColumn(1).setHeaderValue("Descri��o");
		table.getColumnModel().getColumn(2).setHeaderValue("Obrigatoriedade");
		
		//for(int i=0;i<professores.size();i++){
		//professores.get(i).setNome(table.getValueAt(i,ColunaDoNome));
		//}
		
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		for(int i=0;i<MainFrame.professores.size();i++)
		{
			comboProfessor.addItem(MainFrame.professores.get(i).getNome());
		}
		this.setResizable(false);	
		this.setVisible(true);
	}
}
