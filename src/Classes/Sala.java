package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable{
	private int numero;
	private int bloco;
	private int andar;
	private int capacidade;
	public ArrayList<AlocacaoHorario> horariosSala = new ArrayList<AlocacaoHorario>();
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getBloco() {
		return bloco;
	}
	public void setBloco(int bloco) {
		this.bloco = bloco;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public Sala(){
		
	}

	public Sala(int numero,int bloco,int andar, int capacidade){
		this.setAndar(andar);
		this.setNumero(numero);
		this.setBloco(bloco);
		this.setCapacidade(capacidade);
	}
}
