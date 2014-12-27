package Classes;

public class Coordenador extends Professor{

	public void AlteraNome(String a,Professor professor){
		professor.setNome(a);
	}
	
	public void AlteraTitulo(String a,Professor professor){
		
		//if()
		professor.setTitulo(Titulo.ESPECIALIZACAO);
		professor.setTitulo(Titulo.MESTRADO);
		professor.setTitulo(Titulo.DOUTORADO);
	}
	
	public void AlteraSexo(String a,Professor professor){
		//if()
		professor.setSexo(Sexo.MASCULINO);
		professor.setSexo(Sexo.FEMININO);
	}
	
	public Coordenador(String nome, String cpf,Sexo sexo,Titulo titulo,String senha){
		super(nome,cpf,sexo,titulo,senha);
	}
	
}
