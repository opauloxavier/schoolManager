package Classes;

import java.io.Serializable;

public enum Titulo implements Serializable {
	ESPECIALIZACAO("Especializacao"),MESTRADO("Mestrado"),DOUTORADO("Doutorado");
	
	String valor;
	
	Titulo(String valor){
		this.valor=valor;
	}
	
	public String getValor(){
		return this.valor;
	}
}
