package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Classes.DiaSemana;
import Classes.Turno;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class FrameTrocarSala extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboDisciplinaOfertada;
	private JTextField txtPeriodo;
	private JTextField txtAno;
	private JTextField txtDia;
	private JTextField txtTurno;
	private JComboBox<String> comboSala;
	private JLabel lblNot;
	private JButton btnAlterarLab;
	private JComboBox<String> comboLaboratorio;
	private JLabel lblAdd;
	
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
				
				txtAno.setText(Integer.toString(MainFrame.ofertas.get(comboDisciplinaOfertada.getSelectedIndex()).getAno()));
				txtPeriodo.setText(Integer.toString(MainFrame.ofertas.get(comboDisciplinaOfertada.getSelectedIndex()).getPeriodo()));
			
				txtDia.setText(""+MainFrame.ofertas.get(comboDisciplinaOfertada.getSelectedIndex()).getListaAlocaHorario().getHorario().getDia()+"");
				txtTurno.setText(""+MainFrame.ofertas.get(comboDisciplinaOfertada.getSelectedIndex()).getListaAlocaHorario().getHorario().getTurno()+"");
			}
		};
	}
	
	public ActionListener alterar(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				boolean ok = false;
				
				for(int i = 0; i < MainFrame.salas.size(); i++){
					
					if(MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getNumero() == MainFrame.salas.get(comboSala.getSelectedIndex()).getNumero()){
						if(MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getBloco() == MainFrame.salas.get(comboSala.getSelectedIndex()).getBloco()){
							if(MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getAndar() == MainFrame.salas.get(comboSala.getSelectedIndex()).getAndar()){
								ok = true;
					}
							}
				}
					}
				
				if(ok == false){
					MainFrame.ofertas.get(comboDisciplinaOfertada.getSelectedIndex()).getListaAlocaHorario().setSala(MainFrame.salas.get(comboSala.getSelectedIndex()));	
					lblAdd.setVisible(true);
					lblNot.setVisible(false);
				}
				else{
					lblNot.setVisible(true);
					lblAdd.setVisible(false);
				}
			}
		};
	}
	
	public ActionListener alterarLaboratorio(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				boolean ok = false;
				
				for(int i = 0; i < MainFrame.laboratorios.size(); i++){
					
					if(MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getNumero() == MainFrame.laboratorios.get(comboSala.getSelectedIndex()).getNumero()){
						if(MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getBloco() == MainFrame.laboratorios.get(comboSala.getSelectedIndex()).getBloco()){
							if(MainFrame.ofertas.get(i).getListaAlocaHorario().getSala().getAndar() == MainFrame.laboratorios.get(comboSala.getSelectedIndex()).getAndar()){
								ok = true;
					}
							}
				}
					}
				
				if(ok == false){
					MainFrame.ofertas.get(comboDisciplinaOfertada.getSelectedIndex()).getListaAlocaHorario().setSala(MainFrame.laboratorios.get(comboSala.getSelectedIndex()));	
					lblAdd.setVisible(true);
					lblNot.setVisible(false);
				}
				else{
					lblNot.setVisible(true);
					lblAdd.setVisible(false);
				}
			}
		};
	}
	
	public FrameTrocarSala() {

		setBounds(100, 100, 450, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboDisciplinaOfertada = new JComboBox<String>();
		comboDisciplinaOfertada.setBounds(10, 41, 299, 20);
		contentPane.add(comboDisciplinaOfertada);
		
		JLabel lblDisciplinaOfertada = new JLabel("Disciplina Ofertada");
		lblDisciplinaOfertada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplinaOfertada.setForeground(Color.DARK_GRAY);
		lblDisciplinaOfertada.setBounds(10, 16, 151, 14);
		contentPane.add(lblDisciplinaOfertada);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setForeground(Color.DARK_GRAY);
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDia.setBounds(201, 209, 46, 14);
		contentPane.add(lblDia);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setForeground(Color.DARK_GRAY);
		lblTurno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTurno.setBounds(314, 209, 46, 14);
		contentPane.add(lblTurno);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(326, 40, 101, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnConcluido = new JButton("Concluido");
		btnConcluido.setBounds(315, 280, 112, 23);
		contentPane.add(btnConcluido);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(106, 228, 62, 20);
		contentPane.add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(12, 228, 62, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setForeground(Color.DARK_GRAY);
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(10, 209, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setForeground(Color.DARK_GRAY);
		lblPeriodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeriodo.setBounds(106, 209, 46, 14);
		contentPane.add(lblPeriodo);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(326, 99, 101, 23);
		contentPane.add(btnAlterar);
		
		comboSala = new JComboBox<String>();
		comboSala.setBounds(10, 101, 299, 20);
		contentPane.add(comboSala);
		
		JLabel lblSalas = new JLabel("Salas");
		lblSalas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalas.setForeground(Color.DARK_GRAY);
		lblSalas.setBounds(10, 76, 62, 14);
		contentPane.add(lblSalas);
		
		btnAtualizar.addActionListener(atualizar());
		btnConcluido.addActionListener(cancelar());
		btnAlterar.addActionListener(alterar());
		
		
		comboLaboratorio = new JComboBox<String>();
		comboLaboratorio.setBounds(10, 167, 299, 20);
		contentPane.add(comboLaboratorio);
		
		for(int i=0;i<MainFrame.ofertas.size(); i++)
		{
			comboDisciplinaOfertada.addItem(" "+MainFrame.ofertas.get(i).getDisciplina().getNome()+" / Ano: "+MainFrame.ofertas.get(i).getAno()+" / Ano: "+MainFrame.ofertas.get(i).getPeriodo()+" ");
		}
		
		for(int i=0;i<MainFrame.salas.size(); i++)
		{
			comboSala.addItem("Sala: "+MainFrame.salas.get(i).getNumero()+" / Bloco: "+MainFrame.salas.get(i).getBloco()+" / Andar: "+MainFrame.salas.get(i).getAndar()+"");
		}
		
		for(int i=0;i<MainFrame.laboratorios.size(); i++)
		{
			comboLaboratorio.addItem("Sala: "+MainFrame.laboratorios.get(i).getNumero()+" / Bloco: "+MainFrame.laboratorios.get(i).getBloco()+" / Andar: "+MainFrame.laboratorios.get(i).getAndar()+"");
		}
		
		txtAno.setEditable(false);
		txtPeriodo.setEditable(false);

		
		txtDia = new JTextField();
		txtDia.setBounds(201, 228, 82, 20);
		contentPane.add(txtDia);
		txtDia.setColumns(10);
		txtDia.setEditable(false);

		
		txtTurno = new JTextField();
		txtTurno.setBounds(314, 228, 82, 20);
		contentPane.add(txtTurno);
		txtTurno.setColumns(10);
		
		txtTurno.setEditable(false);
		
		lblNot = new JLabel("Nao foi possivel efetuar a troca.");
		lblNot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNot.setForeground(Color.RED);
		lblNot.setBounds(106, 259, 239, 14);
		contentPane.add(lblNot);

		
		JLabel lblLaboratorios = new JLabel("Laboratorios");
		lblLaboratorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLaboratorios.setForeground(Color.DARK_GRAY);
		lblLaboratorios.setBounds(10, 142, 95, 14);
		contentPane.add(lblLaboratorios);
		
		btnAlterarLab = new JButton("Alterar");
		btnAlterarLab.setBounds(324, 166, 100, 23);
		contentPane.add(btnAlterarLab);
		btnAlterarLab.addActionListener(alterarLaboratorio());
		
		lblAdd = new JLabel("Troca efetuada com sucesso.");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdd.setForeground(new Color(0, 128, 0));
		lblAdd.setBounds(106, 259, 203, 14);
		contentPane.add(lblAdd);
		
		this.setResizable(false);	
		lblAdd.setVisible(false);
		lblNot.setVisible(false);
		setVisible(true);
	}
}
