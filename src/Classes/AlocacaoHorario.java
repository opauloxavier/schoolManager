package Classes;

import java.io.Serializable;

public class AlocacaoHorario implements Serializable{
	
	private Horario horario	= new Horario();
	private Sala sala = new Sala();
	//private OfertaDisciplina ofertaNoHorario = new OfertaDisciplina();
	
//	public OfertaDisciplina getOfertaNoHorario() {
//		return ofertaNoHorario;
//	}
//	public void setOfertaNoHorario(OfertaDisciplina ofertaNoHorario) {
//		this.ofertaNoHorario = ofertaNoHorario;
//	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	public AlocacaoHorario(){
		
	}
	public AlocacaoHorario(OfertaDisciplina ofertaDisciplina, Horario horario, Sala sala){
		
		this.horario = horario;
		this.sala=sala;
	}

}
