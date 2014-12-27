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

import Classes.Laboratorio;
import Classes.Sala;

public class FrameCadastroSala extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtBloco;
	private JTextField txtAndar;
	private JTextField txtCapacidade;
	private JRadioButton rdbtnLaboratorio;
	private JRadioButton rdbtnSala;
	private JLabel lblNoPossivel;
	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
	public ActionListener adicionarSala(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
							
				if(rdbtnSala.isSelected()==true){
					
					int ok = 1;
					
					if(MainFrame.salas.size() > 0){
						
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
					}	
					
					if(MainFrame.laboratorios.size() > 0){
							
						for(int j = 0;j<MainFrame.laboratorios.size();j++){
							
							if(MainFrame.laboratorios.get(j).getNumero()==Integer.valueOf(txtNumero.getText())){
							
								if(MainFrame.laboratorios.get(j).getBloco()==Integer.valueOf(txtBloco.getText())){
									
									if(MainFrame.laboratorios.get(j).getAndar()==Integer.valueOf(txtAndar.getText())){
										lblNoPossivel.setVisible(true);
										ok=0;
										break;
									}
								}
							}
						}
					}		
					
					if(ok==1){
						
						Sala a = new Sala(Integer.parseInt(txtNumero.getText()),Integer.parseInt(txtBloco.getText()),Integer.parseInt(txtAndar.getText()), Integer.parseInt(txtCapacidade.getText()));
						MainFrame.salas.add(a);
						dispose();
					}
				
					}
				
				else if(rdbtnLaboratorio.isSelected()==true ){
					
					int ok = 1;
					
				//	if(MainFrame.salas.size() > 0){
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
				//	}	
					
					//if(MainFrame.laboratorios.size() > 0){
						for(int j = 0;j<MainFrame.salas.size();j++){
							if(MainFrame.salas.get(j).getNumero()==Integer.valueOf(txtNumero.getText())){
							
								if(MainFrame.salas.get(j).getBloco()==Integer.valueOf(txtBloco.getText())){
									
									if(MainFrame.salas.get(j).getAndar()==Integer.valueOf(txtAndar.getText())){
										lblNoPossivel.setVisible(true);
										ok=0;
										break;
									}
								}
							}
						}
				//	}
					
					if(ok==1){	
						
						Laboratorio a = new Laboratorio(Integer.parseInt(txtNumero.getText()),Integer.parseInt(txtBloco.getText()),Integer.parseInt(txtAndar.getText()), Integer.parseInt(txtCapacidade.getText()));
						MainFrame.laboratorios.add(a);
						dispose();
					}	
				}				
			}
		};
	}
	
	public FrameCadastroSala() {
		setTitle("Cadastro de Salas");
		setBounds(100, 100, 254, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirmar = new JButton("OK");
		btnConfirmar.setBounds(164, 260, 66, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(adicionarSala());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(64, 260, 90, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setForeground(Color.DARK_GRAY);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(10, 52, 46, 14);
		contentPane.add(lblNumero);
		
		JLabel lblBloco = new JLabel("Bloco");
		lblBloco.setForeground(Color.DARK_GRAY);
		lblBloco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloco.setBounds(10, 80, 46, 14);
		contentPane.add(lblBloco);
		
		JLabel lblAndar = new JLabel("Andar");
		lblAndar.setForeground(Color.DARK_GRAY);
		lblAndar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAndar.setBounds(10, 111, 46, 14);
		contentPane.add(lblAndar);
		
		JLabel lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setForeground(Color.DARK_GRAY);
		lblCapacidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCapacidade.setBounds(10, 142, 65, 14);
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
		txtNumero.setBounds(87, 49, 141, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBloco = new JTextField();
		txtBloco.setBounds(87, 77, 141, 20);
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
		txtAndar.setBounds(87, 108, 141, 20);
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
		txtCapacidade.setBounds(87, 139, 141, 20);
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
		
		JLabel lblInsiraOsDados = new JLabel("Insira os dados");
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInsiraOsDados.setForeground(Color.DARK_GRAY);
		lblInsiraOsDados.setBounds(79, 11, 114, 14);
		contentPane.add(lblInsiraOsDados);
		
		rdbtnLaboratorio = new JRadioButton("Laboratorio");
		rdbtnLaboratorio.setForeground(Color.DARK_GRAY);
		rdbtnLaboratorio.setBounds(101, 225, 109, 23);
		contentPane.add(rdbtnLaboratorio);
		
		rdbtnSala = new JRadioButton("Sala");
		rdbtnSala.setSelected(true);
		rdbtnSala.setForeground(Color.DARK_GRAY);
		rdbtnSala.setBounds(10, 225, 109, 23);
		contentPane.add(rdbtnSala);
		
		ButtonGroup tipoSala = new ButtonGroup();
		tipoSala.add(rdbtnSala);
		tipoSala.add(rdbtnLaboratorio);
		
		JLabel lblTipoDeSala = new JLabel("Tipo de Sala");
		lblTipoDeSala.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeSala.setForeground(Color.DARK_GRAY);
		lblTipoDeSala.setBounds(60, 204, 82, 14);
		contentPane.add(lblTipoDeSala);
		
		lblNoPossivel = new JLabel("Nao foi possivel alocar a sala.");
		lblNoPossivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoPossivel.setForeground(Color.RED);
		lblNoPossivel.setBounds(35, 173, 175, 14);
		contentPane.add(lblNoPossivel);
		lblNoPossivel.setVisible(false);
		
		
		btnCancelar.addActionListener(cancelar());
		this.setResizable(false);	
		setVisible(true);
	}
}
