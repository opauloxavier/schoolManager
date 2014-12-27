package Classes;

import java.io.Serializable;

public enum DiaSemana implements Serializable {
	SEGUNDA("Segunda"), TERCA("Terça"), QUARTA("Quarta"), QUINTA("Quinta"), SEXTA("Sexta"),SABADO("Sabado");
	
	
	String valor;
	
	public String getValor(){
		return this.valor;
	}
	
	DiaSemana (String valor){
		this.valor=valor;
	}
}
