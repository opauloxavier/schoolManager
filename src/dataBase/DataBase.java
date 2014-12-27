package dataBase;

import java.io.Serializable;
import java.util.ArrayList;

import Classes.AlocacaoHorario;
import Classes.Coordenador;
import Classes.Disciplina;
import Classes.GradeCurricular;
import Classes.GradeHorario;
import Classes.Laboratorio;
import Classes.OfertaDisciplina;
import Classes.Professor;
import Classes.Sala;
import Frames.MainFrame;
import Serializacao.SerializaDataBase;

public class DataBase implements Serializable{
	
	private GradeHorario gradeHorario = new GradeHorario(); 
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Coordenador> coordenadores = new ArrayList<Coordenador>();
	private ArrayList<GradeCurricular> grade = new ArrayList<GradeCurricular>();
	private ArrayList<Laboratorio> laboratorios =new ArrayList<Laboratorio>();
	private ArrayList<OfertaDisciplina> ofertas = new ArrayList<OfertaDisciplina>();
	private ArrayList<AlocacaoHorario> alocacoes = new ArrayList<AlocacaoHorario>();
	private ArrayList<Sala> salas = new ArrayList<Sala>();
	
	public GradeHorario getGradeHorario() {
		return gradeHorario;
	}
	public void setGradeHorario(GradeHorario gradeHorario) {
		this.gradeHorario = gradeHorario;
	}
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public ArrayList<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}
	public ArrayList<Coordenador> getCoordenadores() {
		return coordenadores;
	}
	public void setCoordenadores(ArrayList<Coordenador> coordenadores) {
		this.coordenadores = coordenadores;
	}
	public ArrayList<GradeCurricular> getGrade() {
		return grade;
	}
	public void setGrade(ArrayList<GradeCurricular> grade) {
		this.grade = grade;
	}
	public ArrayList<Laboratorio> getLaboratorios() {
		return laboratorios;
	}
	public void setLaboratorios(ArrayList<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
	public ArrayList<OfertaDisciplina> getOfertas() {
		return ofertas;
	}
	public void setOfertas(ArrayList<OfertaDisciplina> ofertas) {
		this.ofertas = ofertas;
	}
	public ArrayList<AlocacaoHorario> getAlocacoes() {
		return alocacoes;
	}
	public void setAlocacoes(ArrayList<AlocacaoHorario> alocacoes) {
		this.alocacoes = alocacoes;
	}
	public ArrayList<Sala> getSalas() {
		return salas;
	}
	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}
	
	public void atualizaDados(){
		
		this.setGrade(MainFrame.grade);
		this.setAlocacoes(MainFrame.alocacoes);
		this.setCoordenadores(MainFrame.coordenadores);
		this.setDisciplinas(MainFrame.disciplinas);
		this.setGradeHorario(MainFrame.gradeHorario);
		this.setLaboratorios(MainFrame.laboratorios);
		this.setOfertas(MainFrame.ofertas);
		this.setProfessores(MainFrame.professores);
		this.setSalas(MainFrame.salas);
	}
	
	public void updateFrame(){
		
		SerializaDataBase.DesserializarDataBase("dataBase");
		MainFrame.alocacoes = this.getAlocacoes();
		MainFrame.coordenadores = this.getCoordenadores();
		MainFrame.disciplinas = this.getDisciplinas();
		MainFrame.grade = this.getGrade();
		MainFrame.gradeHorario = this.getGradeHorario();
		MainFrame.laboratorios = this.getLaboratorios();
		MainFrame.ofertas = this.getOfertas();
		MainFrame.professores = this.getProfessores();
		MainFrame.salas = this.getSalas();
	}
}
