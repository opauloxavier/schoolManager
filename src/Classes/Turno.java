package Classes;

import java.io.Serializable;

public enum Turno implements Serializable {
	
	MANHA_1(8,10), MANHA_2(10,12),TARDE_1(14,16),TARDE_2(16,18) ,NOITE_1(18,20),NOITE_2(20,22);

	
	int inicio;
	int fim;
	
	Turno(int inicio,int fim){
		this.inicio=inicio;
		this.fim=fim;
	}
	
	public int getInicio(){
		return this.inicio;
	}
	
	public int getFinal(){
		return this.fim;
	}
	
}
