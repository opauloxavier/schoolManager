package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.Professor;
import Classes.Sexo;
import Classes.Titulo;
import Serializacao.SerializaDataBase;
import dataBase.DataBase;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtNome;
	private JLabel lblSistemaDeLogin;
	private JLabel lblErro;
	private DataBase db = new DataBase();
	private JButton btnCancelar;

	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
						
			}
		};
	}
	
	public ActionListener autenticaSenha(){
		
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
							
				for(int i =0;i<db.getProfessores().size();i++){
					if( txtNome.getText().compareTo(db.getProfessores().get(i).getNome()) + txtPassword.getText().compareTo(db.getProfessores().get(i).getSenha()) == 0){
						MainFrame.privilegios=0;
						System.out.println(MainFrame.indexLogin);
						MainFrame frame = new MainFrame();
						
						dispose();
						break;
				}
					
					else if(txtNome.getText().compareTo(db.getCoordenadores().get(i).getNome()) + txtPassword.getText().compareTo(db.getCoordenadores().get(i).getSenha())==0)
					{
						MainFrame.privilegios=1;
						MainFrame.indexLogin=i;
						MainFrame frame = new MainFrame();
						//System.out.println(MainFrame.login);
						
						dispose();
						break;
					}
					
					else if((txtNome.getText().compareTo("admin"))==0&&(txtPassword.getText().compareTo("admin"))==0){
						MainFrame.privilegios=1;
						MainFrame frame = new MainFrame();
						MainFrame.indexLogin=i;
						//System.out.println(MainFrame.login);
						
						dispose();
						break;
					}
					
					else{
						
						lblErro.setVisible(true);
					}
				}
								
			}
		};

	}
	
	public FrameLogin() {	
		
		db = SerializaDataBase.DesserializarDataBase("dataBase");
		Professor a=new Professor("paulo","1231",Sexo.MASCULINO,Titulo.ESPECIALIZACAO,"123");
		db.getProfessores().add(a);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Login");
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(83, 98, 176, 20);
		contentPane.add(txtPassword);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(25, 70, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.DARK_GRAY);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(27, 101, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(184, 154, 75, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(autenticaSenha());
		
		txtNome = new JTextField();
		txtNome.setBounds(83, 67, 176, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblSistemaDeLogin = new JLabel("Sistema de Login");
		lblSistemaDeLogin.setForeground(Color.DARK_GRAY);
		lblSistemaDeLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSistemaDeLogin.setBounds(101, 21, 127, 20);
		contentPane.add(lblSistemaDeLogin);
		
		lblErro = new JLabel("Usuario e/ou senha invalidos");
		lblErro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblErro.setForeground(Color.RED);
		lblErro.setBounds(93, 129, 166, 14);
		contentPane.add(lblErro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(83, 154, 91, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(cancelar());
		this.setResizable(false);	
		lblErro.setVisible(false);
		this.setVisible(true);
	}
}
