package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class GradeCurricular implements Serializable{
	
	private String nomeCurso;
	public ArrayList<Disciplina> disciplinasCurso;
	
	public ArrayList<Disciplina> getDisciplinasCurso() {
		return disciplinasCurso;
	}
	public void setDisciplinasCurso(ArrayList<Disciplina> disciplinasCurso) {
		this.disciplinasCurso = disciplinasCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public GradeCurricular(String nomeCurso){
		
		disciplinasCurso = new ArrayList<Disciplina>();
		this.setNomeCurso(nomeCurso);
	}
	
}
