package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tools.ValidadorCpf;
import Classes.Coordenador;
import Classes.Professor;
import Classes.Sexo;
import Classes.Titulo;
import javax.swing.SwingConstants;

public class FrameCadastroProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JLabel lblInsiraOsDados;
	private JLabel lblTitulo;
	private JRadioButton rdbDoutorado;
	private JRadioButton rdbMestrado;
	private JRadioButton rdbEspecializacao;
	private JLabel lblSexo;
	private JRadioButton rdbMasculino;
	private JRadioButton rdbFeminino;
	private JButton btnCriar;
	private JButton btnCancelar;
	private JRadioButton rdbProfessor;
	private JRadioButton rdbCoordenador;
	private JLabel lblCargo;
	private JLabel lblNot;
	private JLabel lblCadastrado;

	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
public  ActionListener criaProfessor(){
	return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Sexo sexo= Sexo.MASCULINO;
				Titulo titulo=Titulo.ESPECIALIZACAO;
				
				if(rdbMasculino.isSelected()==true)
					sexo=Sexo.MASCULINO;
					
				else if(rdbFeminino.isSelected()==true){
					sexo=Sexo.FEMININO;
				}
				
				
				if(rdbEspecializacao.isSelected()==true)
					titulo=Titulo.ESPECIALIZACAO;
				
				if(rdbMestrado.isSelected()==true){
					titulo=Titulo.MESTRADO;
				}
				
				if(rdbDoutorado.isSelected()==true){
					titulo=Titulo.DOUTORADO;
				}
				
				//System.out.println(titulo);
				
				if(ValidadorCpf.validar((String)txtCpf.getText())){
					
					boolean ook = false;
					
					for(int i = 0; i < MainFrame.professores.size(); i++){
						
						if(MainFrame.professores.get(i).getCpf().equals(txtCpf.getText()))
							ook = true;
					}
					
					
					if(ook == false){
					
					
					if(rdbCoordenador.isSelected()){
						Coordenador a = new Coordenador(txtNome.getText(),txtCpf.getText(),sexo,titulo,"123");
						MainFrame.coordenadores.add(a);
						//SerializaCoordenador.SerealizarCoordenador("coordenadores", MainFrame.coordenadores);
					}
					
					else if (rdbProfessor.isSelected()){
						Professor a = new Professor(txtNome.getText(),txtCpf.getText(),sexo,titulo,"123");
						MainFrame.professores.add(a);
						//SerializaProfessor.SerealizarProfessor("professores", MainFrame.professores);
					}
					dispose();
					}
					else
						lblCadastrado.setVisible(true);
						lblNot.setVisible(false);
				}
				//Teste desserialização
				//System.out.println(MainFrame.professores.size());
				
				else{
					lblNot.setVisible(true);
					lblCadastrado.setVisible(false);
				}
				
			
				//Professor a = new Professor(txtNome.getText(),txtCpf.getText(),);
				//MainFrame.professores.add(a);
				
			}
	};
}
	
	public FrameCadastroProfessor() {
		setBounds(100, 100, 349, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Cadastro de Professor");
		
		txtNome = new JTextField();
		txtNome.setBounds(53, 43, 265, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome"+ "");
		lblNome.setForeground(Color.GRAY);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 46, 46, 14);
		contentPane.add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setForeground(Color.GRAY);
		lblCpf.setBounds(10, 77, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(53, 74, 265, 20);
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
		
		
		lblInsiraOsDados = new JLabel("Insira os dados");
		lblInsiraOsDados.setForeground(Color.DARK_GRAY);
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInsiraOsDados.setBounds(144, 11, 131, 14);
		contentPane.add(lblInsiraOsDados);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(Color.GRAY);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitulo.setBounds(195, 114, 46, 14);
		contentPane.add(lblTitulo);
		
			
		rdbEspecializacao = new JRadioButton("Especializacao");
		rdbEspecializacao.setSelected(true);
		rdbEspecializacao.setBounds(195, 135, 141, 23);
		contentPane.add(rdbEspecializacao);
		
		rdbMestrado = new JRadioButton("Mestrado");
		rdbMestrado.setBounds(195, 161, 109, 23);
		contentPane.add(rdbMestrado);
		
		rdbDoutorado = new JRadioButton("Doutorado");
		rdbDoutorado.setBounds(195, 187, 109, 23);
		contentPane.add(rdbDoutorado);
		
		ButtonGroup titulo = new ButtonGroup();
		titulo.add(rdbEspecializacao);
		titulo.add(rdbMestrado);
		titulo.add(rdbDoutorado);
		
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setForeground(Color.GRAY);
		lblSexo.setBounds(10, 114, 46, 14);
		contentPane.add(lblSexo);
		
	
		rdbMasculino = new JRadioButton("Masculino");
		rdbMasculino.setSelected(true);
		rdbMasculino.setBounds(10, 135, 109, 23);
		contentPane.add(rdbMasculino);
		
		rdbFeminino = new JRadioButton("Feminino");
		rdbFeminino.setBounds(10, 161, 109, 23);
		contentPane.add(rdbFeminino);
		
		ButtonGroup sexo= new ButtonGroup();
		sexo.add(rdbMasculino);
		sexo.add(rdbFeminino);
		
		btnCriar = new JButton("Criar");
		btnCriar.setBounds(229, 296, 89, 23);
		contentPane.add(btnCriar);
		btnCriar.addActionListener(criaProfessor());
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(130, 296, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(cancelar());
		
		rdbProfessor = new JRadioButton("Professor");
		rdbProfessor.setSelected(true);
		rdbProfessor.setBounds(10, 228, 109, 23);
		contentPane.add(rdbProfessor);
		
		rdbCoordenador = new JRadioButton("Coordenador");
		rdbCoordenador.setBounds(10, 254, 109, 23);
		contentPane.add(rdbCoordenador);
		
		ButtonGroup tipoProfessor = new ButtonGroup();
		tipoProfessor.add(rdbProfessor);
		tipoProfessor.add(rdbCoordenador);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setForeground(Color.GRAY);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCargo.setBounds(10, 204, 46, 14);
		contentPane.add(lblCargo);
		
		lblNot = new JLabel("CPF Invalido.");
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setForeground(Color.RED);
		lblNot.setBounds(143, 258, 123, 14);
		contentPane.add(lblNot);
		
		lblCadastrado = new JLabel("CPF J\u00E1 Cadastrado");
		lblCadastrado.setForeground(Color.ORANGE);
		lblCadastrado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCadastrado.setBounds(144, 258, 97, 14);
		contentPane.add(lblCadastrado);
		lblNot.setVisible(false);
		lblCadastrado.setVisible(false);
		setVisible(true);
		this.setResizable(false);	
	}
}
