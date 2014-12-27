package Classes;

import java.io.Serializable;

public class Horario implements Serializable{
	
	private DiaSemana dia;
	private Turno turno;
	
	public DiaSemana getDia() {
		return dia;
	}
	public void setDia(DiaSemana dia) {
		this.dia = dia;
	}
	
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public Horario(){
		//EBA
	}
	public Horario(DiaSemana dia,Turno turno){
		this.setTurno(turno);
		this.setDia(dia);
		
	}
}
