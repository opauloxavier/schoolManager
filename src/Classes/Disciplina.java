package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable{

	private String nome;
	private String descricao;
	private boolean obrigatoria;
	public ArrayList<OfertaDisciplina> ofertaDisciplina = new ArrayList<OfertaDisciplina>(); 
	public PreRequisito requisitos = new PreRequisito();
		
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isObrigatoria() {
		return obrigatoria;
	}
	public void setObrigatoria(boolean obrigatoria) {
		this.obrigatoria = obrigatoria;
	}
	
	public Disciplina(String nome,String descricao,boolean obrigatoria){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setObrigatoria(obrigatoria);
	}
}
