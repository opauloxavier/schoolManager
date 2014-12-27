package tools;

public abstract class ValidadorCpf {

	public static boolean validar(String cpf){
		
		if(!(cpf.length()==11)){
			return false;
		}
		
		int[] v = new int[2];
		
		v[0]=0;
		v[1]=0;
		
		System.out.println(cpf);
		for(int i=0;i<9;i++){
			int n = cpf.charAt(i)-'0';
			v[0]+=(i+1)*n;
		}
		
		v[0]=v[0]%11;
		v[0]=v[0]%10;
		
		
		for (int i=1;i<9;i++){
			int n = cpf.charAt(i)-'0';
			v[1]+=i*n;
		}
		
		v[1]+=9*v[0];
		v[1]=v[1]%11;
		
		v[1]=v[1]%10;
		
		return( v[0]== cpf.charAt(9)-'0' && v[1]==cpf.charAt(10)-'0' );
	}
	
}
