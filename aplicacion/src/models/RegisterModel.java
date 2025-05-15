package models;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class RegisterModel {

	
	
	public void añadirCuenta(String nombre,String apellidos,String empresa,String ambito,String cargo,String usuario, String contrasena, String correo )  {
    	
    	
    	try {
    		BufferedWriter escritor = new BufferedWriter(new FileWriter("src/files/users.txt", true));
    		
    		String cuenta = nombre + "," + apellidos + "," + empresa + "," + ambito + "," + cargo + "," + usuario + "," + contrasena + "," + correo;
    			
    		escritor.write(cuenta);
    		escritor.newLine();
    		escritor.flush();
    		
    		escritor.close();	
    	}catch(Exception e){
    		System.out.println("error"+e.getMessage());
    	}
    	
    	
    	
    }
	
	
}
