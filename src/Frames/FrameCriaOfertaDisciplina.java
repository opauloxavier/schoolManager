package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Classes.DiaSemana;
import Classes.OfertaDisciplina;
import Classes.Turno;

public class FrameCriaOfertaDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField txtAno;
	private JTextField txtPeriodo;
	private JComboBox<DiaSemana> comboDia;
	private JComboBox<String> comboDisciplina;
	private JComboBox<Turno> comboHorario;
	private JLabel lblNot;

	
	public ActionListener cancelar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
	
	public ActionListener adicionar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			int ok=0;
				
			for(int i=0;i<MainFrame.ofertas.size();i++){
					if(Integer.parseInt(txtAno.getText())==(MainFrame.ofertas.get(i).getAno())){
						
						if(Integer.parseInt(txtPeriodo.getText())==(MainFrame.ofertas.get(i).getPeriodo())){
							
							if(comboDia.getSelectedItem().equals(MainFrame.ofertas.get(i).getListaAlocaHorario().getHorario().getDia())==true){
								
								if(comboHorario.getSelectedItem().equals(MainFrame.ofertas.get(i).getListaAlocaHorario().getHorario().getTurno())==true){
									ok = 1;
								}
							}				
						}
					}
			}
			
			if(ok==0){
				OfertaDisciplina a = new OfertaDisciplina(Integer.parseInt(txtAno.getText()),Integer.parseInt(txtPeriodo.getText()),MainFrame.disciplinas.get(comboDisciplina.getSelectedIndex()));
				
				a.getListaAlocaHorario().getHorario().setTurno((Turno)comboHorario.getSelectedItem());
				a.getListaAlocaHorario().getHorario().setDia((DiaSemana)comboDia.getSelectedItem());
				
				MainFrame.ofertas.add(a);
				
				//SerializaOfertaDisciplina.SerealizarOfertaDisciplina("ofertas", MainFrame.ofertas);
				dispose();
			}
			
			else if(ok==1){
				lblNot.setVisible(true);
			}
				
			}
		};
	}
	
	
	
	public FrameCriaOfertaDisciplina() {
		setTitle("Cadastrar Oferta");
		setBounds(100, 100, 272, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboDisciplina = new JComboBox<String>();
		comboDisciplina.setBounds(10, 32, 238, 20);
		contentPane.add(comboDisciplina);
		
		JLabel lblEscolhaADisciplina = new JLabel("Escolha a disciplina");
		lblEscolhaADisciplina.setForeground(Color.DARK_GRAY);
		lblEscolhaADisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaADisciplina.setBounds(10, 11, 149, 14);
		contentPane.add(lblEscolhaADisciplina);
		
		txtAno = new JTextField();
		txtAno.setBounds(62, 71, 86, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		txtAno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_TAB){
					e.consume();
				}
			}
		});
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setForeground(Color.DARK_GRAY);
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(10, 74, 46, 14);
		contentPane.add(lblAno);
		
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setForeground(Color.DARK_GRAY);
		lblPeriodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeriodo.setBounds(10, 105, 56, 14);
		contentPane.add(lblPeriodo);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(62, 102, 86, 20);
		contentPane.add(txtPeriodo);
		txtPeriodo.setColumns(10);
		txtPeriodo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_TAB){
					e.consume();
				}
			}
		});
		
		comboHorario = new JComboBox<Turno>();
		comboHorario.setBounds(10, 231, 238, 20);
		contentPane.add(comboHorario);
		
		JLabel lblEscolhaOHorario = new JLabel("Escolha o horario");
		lblEscolhaOHorario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaOHorario.setForeground(Color.DARK_GRAY);
		lblEscolhaOHorario.setBounds(10, 206, 104, 14);
		contentPane.add(lblEscolhaOHorario);
		
		JLabel lblEscolhaODia = new JLabel("Escolha o Dia da Semana");
		lblEscolhaODia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEscolhaODia.setForeground(Color.DARK_GRAY);
		lblEscolhaODia.setBounds(10, 143, 149, 14);
		contentPane.add(lblEscolhaODia);
		
		comboDia = new JComboBox<DiaSemana>();
		comboDia.setBounds(10, 168, 238, 20);
		contentPane.add(comboDia);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(180, 300, 68, 23);
		contentPane.add(btnCriar);
		btnCriar.addActionListener(adicionar());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(78, 300, 92, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(cancelar());
		
		lblNot = new JLabel("Nao foi possivel criar.");
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setForeground(Color.RED);
		lblNot.setBounds(57, 265, 174, 14);
		contentPane.add(lblNot);
		
		for(int i=0;i<MainFrame.disciplinas.size();i++)
		{
			comboDisciplina.addItem(MainFrame.disciplinas.get(i).getNome());
		}
		
			comboDia.addItem(DiaSemana.SEGUNDA);
			comboDia.addItem(DiaSemana.TERCA);
			comboDia.addItem(DiaSemana.QUARTA);
			comboDia.addItem(DiaSemana.QUINTA);
			comboDia.addItem(DiaSemana.SEXTA);
			comboDia.addItem(DiaSemana.SABADO);
			
			comboHorario.addItem(Turno.MANHA_1);
			comboHorario.addItem(Turno.MANHA_2);
			comboHorario.addItem(Turno.TARDE_1);
			comboHorario.addItem(Turno.TARDE_2);
			comboHorario.addItem(Turno.NOITE_1);
			comboHorario.addItem(Turno.NOITE_2);
			
			

//		for(int i=0;i<MainFrame.professores.size();i++)
//		{
//			comboProfessor.addItem(MainFrame.professores.get(i).getNome());
//		}
		lblNot.setVisible(false);
		setVisible(true);
		this.setResizable(false);	
	}
}
