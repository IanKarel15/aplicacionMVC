package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AuthModel {
	
	// aqui va toda la logica o donde se haran las consultas a la base de datos
	
    //metodo para verificar contraseñas 
    public boolean verificarContraseñas(String correoV, String contraseñaV ) {
    	
    	FileReader archivo;
    	BufferedReader lector;
    	
    	try {
    		
    		archivo = new FileReader ("src/files/users.txt");
    		if (archivo.ready()) {
    			lector = new BufferedReader (archivo);
    			String cadena;
    			while((cadena = lector.readLine()) !=null ) {
    				String [] partes = cadena.split(",");
    				
    				String correo = partes [1];
    				String contraseña = partes [4];
    				
    				if(correo.equals(correoV) && contraseña.equals(contraseñaV)) {
    					lector.close();
    					return true;
    				}
    			}
    			lector.close();
    		}
    		else {
    			System.out.println("El archivo aun no puede ser leido");
    		}
    	}catch(Exception e){
    		System.out.println("error"+e.getMessage());
    		
    	}
    	return false;
    	
    }
    
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
