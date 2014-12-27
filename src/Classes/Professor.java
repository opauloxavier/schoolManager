package Classes;

import java.io.Serializable;
import java.util.ArrayList;


public class Professor implements Serializable{
	private String nome;
	private String cpf;
	private Titulo titulo;
	private Sexo sexo;
	private String senha;
	public Habilitado ministraDisciplina = new Habilitado();
	private ArrayList<OfertaDisciplina> ofertasAceitas = new ArrayList<OfertaDisciplina>();

	public ArrayList<OfertaDisciplina> getOfertasAceitas() {
		return ofertasAceitas;
	}
	public void setOfertasAceitas(OfertaDisciplina ofertasAceitas) {
		this.ofertasAceitas.add(ofertasAceitas);
	}
	
	public Habilitado getMinistraDisciplina() {
		return ministraDisciplina;
	}
	public void setMinistraDisciplina(Habilitado ministraDisciplina) {
		this.ministraDisciplina = ministraDisciplina;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Titulo getTitulo() {
		return titulo;
	}
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}
	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Professor(String nome,String cpf,Sexo sexo, Titulo titulo,String senha){
		
		this.setCpf(cpf);
		this.setNome(nome);
		this.setTitulo(titulo);
		this.setSenha(senha);
		this.setSexo(sexo);
	}
	
}
