package Classes;

import java.io.Serializable;

public enum Sexo implements Serializable{
	MASCULINO("M"),FEMININO("F");
	
	String valor;
	
	Sexo(String valor){
		this.valor=valor;
	}
	
	public String getValor(){
		return this.valor;
	}
	
}
