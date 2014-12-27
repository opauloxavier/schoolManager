package Classes;

import java.io.Serializable;


public class OfertaDisciplina implements Serializable{

	private int ano;
	private int periodo;
	private Disciplina disciplina;
	private AlocacaoHorario listaAlocaHorario = new AlocacaoHorario();
		
	public AlocacaoHorario getListaAlocaHorario() {
		return listaAlocaHorario;
	}
	public void setListaAlocaHorario(AlocacaoHorario listaAlocaHorario) {
		this.listaAlocaHorario = listaAlocaHorario;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public OfertaDisciplina(int ano,int periodo){
		this.ano=ano;
		this.periodo=periodo;
	}
	
	public OfertaDisciplina(int ano, int periodo, Disciplina disciplina){
		this.ano = ano;
		this.periodo = periodo;
		this.disciplina = disciplina;
		//this.listaAlocaHorario.get(index)
	}
	
	public OfertaDisciplina(int ano, int periodo, Disciplina disciplina,DiaSemana dia,Turno turno){
		this.ano = ano;
		this.periodo = periodo;
		this.disciplina = disciplina;
		//this.listaAlocaHorario.get(index)
	}
}
