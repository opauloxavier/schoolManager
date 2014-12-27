package Serializacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dataBase.DataBase;

public class SerializaDataBase {
	
	
	
	public static void SerealizarDataBase(String arq, DataBase dataBase) {  
        
		dataBase.atualizaDados();
		
		FileOutputStream fos;  
        ObjectOutputStream oos;  
          
        try {  
            fos = new FileOutputStream(arq);  
            oos = new ObjectOutputStream(fos);  
            oos.writeObject(dataBase);
            
            
            oos.close();
            //fos.close();
            
            
        } catch (IOException e) {  
              
            e.printStackTrace();  
        }  
        
    }  
      
    public static DataBase DesserializarDataBase(String arq) {  
          
        InputStream is;  
        ObjectInputStream ois;  
        DataBase dataBase = null;  
        try {  
            is = new FileInputStream(arq);  
            ois = new ObjectInputStream(is);  
            dataBase =  (DataBase) ois.readObject();
            
            //ois.close();
            is.close();
            
            
            return dataBase;  
              
        } catch (IOException e) {  
              
            e.printStackTrace();  
        }catch (ClassNotFoundException e) {  
              
            e.printStackTrace();  
                  
        }
		return null;  
	
}	
	
	
}
