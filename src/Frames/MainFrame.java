package Frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import ActionListeners.AdicionarGradeAction;
import ActionListeners.AdicionarHabilitacaoAction;
import ActionListeners.AlteraProfessorAction;
import ActionListeners.CreditosAction;
import ActionListeners.CriaOfertaAction;
import ActionListeners.DefineProfessorAction;
import ActionListeners.EditaDisciplinaAction;
import ActionListeners.EditarSalaAction;
import ActionListeners.ExibeDisciplinaAction;
import ActionListeners.ExibeGradeAction;
import ActionListeners.ExibeOfertaAction;
import ActionListeners.ExibeProfessorAptoAction;
import ActionListeners.ExibeProfessoresAction;
import ActionListeners.ExibeSalasAction;
import ActionListeners.NovaDisciplinaAction;
import ActionListeners.NovaGradeCurricularAction;
import ActionListeners.NovaSalaAction;
import ActionListeners.NovoProfessorAction;
import ActionListeners.PreRequisitosAction;
import ActionListeners.SairAction;
import ActionListeners.TrocarSalaAction;
import Classes.AlocacaoHorario;
import Classes.Coordenador;
import Classes.DiaSemana;
import Classes.Disciplina;
import Classes.GradeCurricular;
import Classes.GradeHorario;
import Classes.Horario;
import Classes.Laboratorio;
import Classes.OfertaDisciplina;
import Classes.Professor;
import Classes.Sala;
import Classes.Turno;
import Serializacao.SerializaDataBase;
import dataBase.DataBase;
import javax.swing.JLabel;
import java.awt.Font;


public class MainFrame extends JFrame implements Serializable{

	private JPanel contentPane;
	private JPasswordField passwordField;
	public static GradeHorario gradeHorario = new GradeHorario(); 
	public static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	public static ArrayList<Professor> professores = new ArrayList<Professor>();
	public static ArrayList<Coordenador> coordenadores = new ArrayList<Coordenador>();
	public static ArrayList<GradeCurricular> grade = new ArrayList<GradeCurricular>();
	public static ArrayList<Laboratorio> laboratorios =new ArrayList<Laboratorio>();
	public static ArrayList<OfertaDisciplina> ofertas = new ArrayList<OfertaDisciplina>();
	public static ArrayList<AlocacaoHorario> alocacoes = new ArrayList<AlocacaoHorario>();
	public static ArrayList<Sala> salas = new ArrayList<Sala>();
	
	public DataBase db = new DataBase();
	
	public static int privilegios = 0;
	public static int indexLogin;
	
//	public Horario a1 = new Horario(DiaSemana.SEGUNDA,Turno.MANHA_1);
//	public Horario b1 = new Horario(DiaSemana.SEGUNDA,Turno.MANHA_2);
//	public Horario c1 = new Horario(DiaSemana.SEGUNDA,Turno.TARDE_1);
//	public Horario d1 = new Horario(DiaSemana.SEGUNDA,Turno.TARDE_2);
//	public Horario e1 = new Horario(DiaSemana.SEGUNDA,Turno.NOITE_1);
//	public Horario f1 = new Horario(DiaSemana.SEGUNDA,Turno.NOITE_2);
//	
//	public Horario g1 = new Horario(DiaSemana.TERCA,Turno.MANHA_1);
//	public Horario h1 = new Horario(DiaSemana.TERCA,Turno.MANHA_2);
//	public Horario i1 = new Horario(DiaSemana.TERCA,Turno.TARDE_1);
//	public Horario j = new Horario(DiaSemana.TERCA,Turno.TARDE_2);
//	public Horario k = new Horario(DiaSemana.TERCA,Turno.NOITE_1);
//	public Horario l = new Horario(DiaSemana.TERCA,Turno.NOITE_2);
//	
//	public Horario m = new Horario(DiaSemana.QUARTA,Turno.MANHA_1);
//	public Horario n = new Horario(DiaSemana.QUARTA,Turno.MANHA_2);
//	public Horario o = new Horario(DiaSemana.QUARTA,Turno.TARDE_1);
//	public Horario p = new Horario(DiaSemana.QUARTA,Turno.TARDE_2);
//	public Horario q = new Horario(DiaSemana.QUARTA,Turno.NOITE_1);
//	public Horario r = new Horario(DiaSemana.QUARTA,Turno.NOITE_2);
//	
//	public Horario s = new Horario(DiaSemana.QUINTA,Turno.MANHA_1);
//	public Horario t = new Horario(DiaSemana.QUINTA,Turno.MANHA_2);
//	public Horario u = new Horario(DiaSemana.QUINTA,Turno.TARDE_1);
//	public Horario v = new Horario(DiaSemana.QUINTA,Turno.TARDE_2);
//	public Horario x1 = new Horario(DiaSemana.QUINTA,Turno.NOITE_1);
//	public Horario z1 = new Horario(DiaSemana.QUINTA,Turno.NOITE_2);
//	
//	public Horario a2 = new Horario(DiaSemana.SEXTA,Turno.MANHA_1);
//	public Horario b2 = new Horario(DiaSemana.SEXTA,Turno.MANHA_2);
//	public Horario c2 = new Horario(DiaSemana.SEXTA,Turno.TARDE_1);
//	public Horario d2 = new Horario(DiaSemana.SEXTA,Turno.TARDE_2);
//	public Horario e2 = new Horario(DiaSemana.SEXTA,Turno.NOITE_1);
//	public Horario f2 = new Horario(DiaSemana.SEXTA,Turno.NOITE_2);
//	
//	public Horario g2 = new Horario(DiaSemana.SABADO,Turno.MANHA_1);
//	public Horario h2 = new Horario(DiaSemana.SABADO,Turno.MANHA_2);
//	public Horario i2 = new Horario(DiaSemana.SABADO,Turno.TARDE_1);
//	public Horario j2 = new Horario(DiaSemana.SABADO,Turno.TARDE_2);
//	public Horario k2 = new Horario(DiaSemana.SABADO,Turno.NOITE_1);
//	public Horario l2 = new Horario(DiaSemana.SABADO,Turno.NOITE_2);


	WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            int confirm = JOptionPane.showOptionDialog(null, "Deseja salvar os dados?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
            	SerializaDataBase.SerealizarDataBase("dataBase", db);
            	System.exit(0);
            }
            
            else{
            	System.exit(0);
            }
        }
    };
	public JMenu mnArquivo;
	public JMenu mnEditar;
	public JMenu mnExibir;
	public JMenu mnAjuda;
	public JMenuItem mntmSalas;
	public JMenuItem mntmExibeProfessores;
	public JMenuItem mntmExibeDisciplina;
	public JMenuItem mntmProfessoresAptos;
	public JMenuItem mntmGradesCurriculares;
	public JMenuItem mntmOfertasDeDisciplinas;
	public JMenuItem mntmProfessores;
	public JMenuItem mntmDadosSalas;
	public JMenuItem mntmDadosDisciplinas;
	public JMenuItem mntmDisciplinasHabilitadas;
	public JMenuItem mntmPrerequisitosDisciplinas;
	public JMenuItem mntmDisciplinasDaGrade;
	public JMenuItem mntmDefineProfessor;
	public JMenuItem mntmTrocarSala;
	public JMenuItem mntmNovo;
	public JMenuItem mntmNovaDisciplina;
	public JMenuItem mntmNovaGradeCurricular;
	public JMenuItem mntmNovaSala;
	public JMenuItem mntmSalvar;
	public JMenuItem mntmSair;
	public JMenuItem mntmCreditos;
	
	
	public MainFrame() {
		db = SerializaDataBase.DesserializarDataBase("dataBase");
		db.updateFrame();
		setTitle("Sistema de Professores vBeta0.1");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(exitListener);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo Professor");
		mntmNovo.addActionListener(NovoProfessorAction.getAction());
		mnArquivo.add(mntmNovo);
		
	
		
		mntmNovaDisciplina = new JMenuItem("Nova Disciplina");
		mntmNovaDisciplina.addActionListener(NovaDisciplinaAction.getAction());
		mnArquivo.add(mntmNovaDisciplina);
		
		
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(SairAction.getAction());
		
		mntmNovaGradeCurricular = new JMenuItem("Nova Grade Curricular");
		mnArquivo.add(mntmNovaGradeCurricular);
		
		mntmNovaSala = new JMenuItem("Nova Sala/Laboratorio");
		mnArquivo.add(mntmNovaSala);
		mntmNovaSala.addActionListener(NovaSalaAction.getSalaAction());
		
		JMenuItem mntmNovaOfertaDe = new JMenuItem("Nova Oferta de Disciplina");
		mnArquivo.add(mntmNovaOfertaDe);
		
		mntmSalvar = new JMenuItem("Salvar");
		mnArquivo.add(mntmSalvar);
		mntmSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
	
				SerializaDataBase.SerealizarDataBase("dataBase", db);
			}
		});
		
		mnArquivo.add(mntmSair);
		mntmNovaOfertaDe.addActionListener(CriaOfertaAction.getCriarOfertaAction());
		mntmNovaGradeCurricular.addActionListener(NovaGradeCurricularAction.getAction());
		
		mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		
		mntmProfessores = new JMenuItem("Dados Professores");
		mnEditar.add(mntmProfessores);
		mntmProfessores.addActionListener(AlteraProfessorAction.getAlteraProfessor());
		
		mntmDadosSalas = new JMenuItem("Dados Salas");
		mnEditar.add(mntmDadosSalas);
		mntmDadosSalas.addActionListener(EditarSalaAction.getEditarSalaAction());
		
		mntmDadosDisciplinas = new JMenuItem("Dados Disciplinas");
		mnEditar.add(mntmDadosDisciplinas);
		mntmDadosDisciplinas.addActionListener(EditaDisciplinaAction.getEditaDisciplinaAction());
		
		mntmPrerequisitosDisciplinas = new JMenuItem("Pre-Requisitos Disciplinas");
		mnEditar.add(mntmPrerequisitosDisciplinas);
		
		mntmDisciplinasDaGrade = new JMenuItem("Disciplinas da Grade Curricular");
		mnEditar.add(mntmDisciplinasDaGrade);
		
		mntmDisciplinasHabilitadas = new JMenuItem("Disciplinas Habilitadas");
		mnEditar.add(mntmDisciplinasHabilitadas);
		
		mntmDefineProfessor = new JMenuItem("Especificar Professor");
		mnEditar.add(mntmDefineProfessor);
		
		mntmTrocarSala = new JMenuItem("Especificar Sala");
		mnEditar.add(mntmTrocarSala);
		mntmTrocarSala.addActionListener(TrocarSalaAction.getTrocarSalaAction());
		
		mntmDisciplinasDaGrade.addActionListener(AdicionarGradeAction.getAlteraProfessor());
		mntmDisciplinasHabilitadas.addActionListener(AdicionarHabilitacaoAction.getAdicionaAlteracao());
		mntmDefineProfessor.addActionListener(DefineProfessorAction.getDefinirProfessorAction());
		
		mntmPrerequisitosDisciplinas.addActionListener(PreRequisitosAction.getAction());
		
		mnExibir = new JMenu("Exibir");
		menuBar.add(mnExibir);
		
		mntmSalas = new JMenuItem("Salas");
		mnExibir.add(mntmSalas);
		mntmSalas.addActionListener(ExibeSalasAction.getExibeSalas());
		
		mntmExibeProfessores = new JMenuItem("Professores");
		mnExibir.add(mntmExibeProfessores);
		mntmExibeProfessores.addActionListener(ExibeProfessoresAction.getExibeProfessores());
		
		mntmProfessoresAptos = new JMenuItem("Professores Habilitados");
		mntmProfessoresAptos.addActionListener(ExibeProfessorAptoAction.getExibeProfessorAptoAction());
		mnExibir.add(mntmProfessoresAptos);
		
		mntmExibeDisciplina = new JMenuItem("Disciplinas/Pre-Requisitos");
		mntmExibeDisciplina.addActionListener(ExibeDisciplinaAction.getExibeDisciplinaAction());
		mnExibir.add(mntmExibeDisciplina);
		
		mntmGradesCurriculares = new JMenuItem("Grades Curriculares");
		mnExibir.add(mntmGradesCurriculares);
		
		mntmOfertasDeDisciplinas = new JMenuItem("Ofertas de Disciplinas");
		mnExibir.add(mntmOfertasDeDisciplinas);
		mntmOfertasDeDisciplinas.addActionListener(ExibeOfertaAction.getExibeOfertaAction());
		mntmGradesCurriculares.addActionListener(ExibeGradeAction.getExibeGradeAction());
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmCreditos = new JMenuItem("Creditos");
		mnAjuda.add(mntmCreditos);
		mntmCreditos.addActionListener(CreditosAction.getCreditosAction());
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		if(MainFrame.privilegios==0){
			mntmNovo.setEnabled(false);
			mntmNovaDisciplina.setEnabled(false);
			mntmNovaGradeCurricular.setEnabled(false);
			mntmNovaSala.setEnabled(false);
			mntmNovaOfertaDe.setEnabled(false);
			mntmProfessores.setEnabled(false);
			mntmDadosSalas.setEnabled(false);
			mntmDadosDisciplinas.setEnabled(false);
			mntmPrerequisitosDisciplinas.setEnabled(false);
			mntmDisciplinasDaGrade.setEnabled(false);
			mntmDisciplinasHabilitadas.setEnabled(false);
			mntmDefineProfessor.setEnabled(false);
			mntmTrocarSala.setEnabled(false);
			mntmExibeProfessores.setEnabled(false);
			mntmProfessoresAptos.setEnabled(false);
			mntmSalvar.setEnabled(false);
			
			
		}

//		GradeHorario.horarios.add(a1);
//		GradeHorario.horarios.add(b1);
//		GradeHorario.horarios.add(c1);
//		GradeHorario.horarios.add(d1);
//		GradeHorario.horarios.add(e1);
//		GradeHorario.horarios.add(f1);
//		GradeHorario.horarios.add(g1);
//		GradeHorario.horarios.add(h1);
//		GradeHorario.horarios.add(i1);
//		GradeHorario.horarios.add(j);
//		GradeHorario.horarios.add(k);
//		GradeHorario.horarios.add(l);
//		GradeHorario.horarios.add(m);
//		GradeHorario.horarios.add(n);
//		GradeHorario.horarios.add(o);
//		GradeHorario.horarios.add(p);
//		GradeHorario.horarios.add(q);
//		GradeHorario.horarios.add(r);
//		GradeHorario.horarios.add(s);
//		GradeHorario.horarios.add(t);
//		GradeHorario.horarios.add(u);
//		GradeHorario.horarios.add(v);
//		GradeHorario.horarios.add(x1);
//		GradeHorario.horarios.add(z1);
//		
//		GradeHorario.horarios.add(a2);
//		GradeHorario.horarios.add(b2);
//		GradeHorario.horarios.add(c2);
//		GradeHorario.horarios.add(d2);
//		GradeHorario.horarios.add(e2);
//		GradeHorario.horarios.add(f2);
//		GradeHorario.horarios.add(g2);
//		GradeHorario.horarios.add(h2);
//		GradeHorario.horarios.add(i2);
//		GradeHorario.horarios.add(j2);
//		GradeHorario.horarios.add(k2);
//		GradeHorario.horarios.add(l2);
//		
		
		
		
		
		setVisible(true);
		setResizable(false);
	}
}
