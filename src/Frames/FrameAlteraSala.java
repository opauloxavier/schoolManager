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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import Classes.Laboratorio;
import Classes.Sala;

public class FrameAlteraSala extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtNumero;
	private JTextField txtBloco;
	private JTextField txtAndar;
	private JTextField txtCapacidade;
	private JRadioButton rdbtnLaboratorio;
	private JRadioButton rdbtnSala;
	private JComboBox<String> comboSala;
	private JLabel lblNoPossivel;

	
	
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
	}
	
	
	public ActionListener alterar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int ok = 1;
							
				if(rdbtnSala.isSelected()==true){
					
					for(int i = 0;i<MainFrame.salas.size();i++){
						if(MainFrame.salas.get(i).getNumero()==Integer.valueOf(txtNumero.getText())){
						
							if(MainFrame.salas.get(i).getBloco()==Integer.valueOf(txtBloco.getText())){
								
								if(MainFrame.salas.get(i).getAndar()==Integer.valueOf(txtAndar.getText())){
									lblNoPossivel.setVisible(true);
									ok=0;
									break;
								}
							}
						}
						
					}
										
					if(ok==1){
					MainFrame.salas.get(comboSala.getSelectedIndex()).setNumero(Integer.parseInt(txtNumero.getText()));
					MainFrame.salas.get(comboSala.getSelectedIndex()).setAndar(Integer.parseInt(txtAndar.getText()));
					MainFrame.salas.get(comboSala.getSelectedIndex()).setBloco(Integer.parseInt(txtBloco.getText()));				
					
					//SerializaSala.SerealizarSala("salas", MainFrame.salas);
					dispose();
					}
				}
				
				else if(rdbtnLaboratorio.isSelected()==true ){
					
					for(int i = 0;i<MainFrame.laboratorios.size();i++){
						if(MainFrame.laboratorios.get(i).getNumero()==Integer.valueOf(txtNumero.getText())){
						
							if(MainFrame.laboratorios.get(i).getBloco()==Integer.valueOf(txtBloco.getText())){
								
								if(MainFrame.laboratorios.get(i).getAndar()==Integer.valueOf(txtAndar.getText())){
									lblNoPossivel.setVisible(true);
									ok=0;
									break;
								}
							}
						}
						
					}
					
					
					if(ok==1){			
						MainFrame.laboratorios.get(comboSala.getSelectedIndex()).setNumero(Integer.parseInt(txtNumero.getText()));
						MainFrame.laboratorios.get(comboSala.getSelectedIndex()).setAndar(Integer.parseInt(txtAndar.getText()));
						MainFrame.laboratorios.get(comboSala.getSelectedIndex()).setBloco(Integer.parseInt(txtBloco.getText()));				
					
					//SerializaLaboratorio.SerealizarLaboratorio("laboratorios", MainFrame.laboratorios);
					dispose();
					}
				}
			}
		};
	}
	
	
	
	
	
	
	public ActionListener atualizar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				comboSala.removeAllItems();
				
				if(rdbtnSala.isSelected()==true){
					for(int i=0;i<MainFrame.salas.size();i++)
					{
						comboSala.addItem("Sala: "+MainFrame.salas.get(i).getNumero()+" - Bloco: "+MainFrame.salas.get(i).getBloco()+" - Andar: "+MainFrame.salas.get(i).getAndar()+"");
					}
					
					}
					
					else if(rdbtnLaboratorio.isSelected()==true){
					for(int i=0;i<MainFrame.laboratorios.size();i++)
					{
						comboSala.addItem("Sala: "+MainFrame.laboratorios.get(i).getNumero()+" - Bloco: "+MainFrame.laboratorios.get(i).getBloco()+" - Andar: "+MainFrame.laboratorios.get(i).getAndar()+"");
					}
				
					}	
			}
		};
	}
	
	
	public FrameAlteraSala() {
		setTitle("Alterar Dados das Salas");
		setBounds(100, 100, 304, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		
		JButton btnConfirmar = new JButton("OK");
		
		btnConfirmar.setBounds(202, 319, 76, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(alterar());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(105, 319, 90, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(cancelar());
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setForeground(Color.DARK_GRAY);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(6, 154, 46, 14);
		contentPane.add(lblNumero);
		
		JLabel lblBloco = new JLabel("Bloco");
		lblBloco.setForeground(Color.DARK_GRAY);
		lblBloco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloco.setBounds(6, 182, 46, 14);
		contentPane.add(lblBloco);
		
		JLabel lblAndar = new JLabel("Andar");
		lblAndar.setForeground(Color.DARK_GRAY);
		lblAndar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAndar.setBounds(6, 213, 46, 14);
		contentPane.add(lblAndar);
		
		JLabel lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setForeground(Color.DARK_GRAY);
		lblCapacidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCapacidade.setBounds(6, 244, 65, 14);
		contentPane.add(lblCapacidade);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_TAB){
					e.consume();
				}
			}
		});
		txtNumero.setBounds(83, 151, 141, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBloco = new JTextField();
		txtBloco.setBounds(83, 179, 141, 20);
		contentPane.add(txtBloco);
		txtBloco.setColumns(10);
		txtBloco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_TAB){
					e.consume();
				}
			}
		});
		
		txtAndar = new JTextField();
		txtAndar.setBounds(83, 210, 141, 20);
		contentPane.add(txtAndar);
		txtAndar.setColumns(10);
		txtAndar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_TAB){
					e.consume();
				}
			}
		});
		
		txtCapacidade = new JTextField();
		txtCapacidade.setBounds(83, 241, 141, 20);
		contentPane.add(txtCapacidade);
		txtCapacidade.setColumns(10);
		txtCapacidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_TAB){
					e.consume();
				}
			}
		});
		
		JLabel lblInsiraOsDados = new JLabel("Escolha a Sala/Laboratorio");
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInsiraOsDados.setForeground(Color.DARK_GRAY);
		lblInsiraOsDados.setBounds(7, 72, 195, 14);
		contentPane.add(lblInsiraOsDados);
		
		rdbtnLaboratorio = new JRadioButton("Laboratorio");
		rdbtnLaboratorio.setForeground(Color.DARK_GRAY);
		rdbtnLaboratorio.setBounds(74, 32, 109, 23);
		contentPane.add(rdbtnLaboratorio);
		
		rdbtnSala = new JRadioButton("Sala");
		rdbtnSala.setSelected(true);
		rdbtnSala.setForeground(Color.DARK_GRAY);
		rdbtnSala.setBounds(6, 32, 65, 23);
		contentPane.add(rdbtnSala);
		
		ButtonGroup tipoSala = new ButtonGroup();
		tipoSala.add(rdbtnSala);
		tipoSala.add(rdbtnLaboratorio);
		
		JLabel lblTipoDeSala = new JLabel("Tipo de Sala");
		lblTipoDeSala.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeSala.setForeground(Color.DARK_GRAY);
		lblTipoDeSala.setBounds(6, 11, 82, 14);
		contentPane.add(lblTipoDeSala);
		
		comboSala = new JComboBox<String>();
		comboSala.setBounds(7, 97, 271, 23);
		contentPane.add(comboSala);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(189, 32, 89, 23);
		contentPane.add(btnAtualizar);
		btnAtualizar.addActionListener(atualizar());
		
		
		lblNoPossivel = new JLabel("Nao foi possivel alocar a sala.");
		lblNoPossivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoPossivel.setForeground(Color.RED);
		lblNoPossivel.setBounds(65, 278, 175, 14);
		contentPane.add(lblNoPossivel);
		lblNoPossivel.setVisible(false);
		this.setResizable(false);	
		
	}

}
