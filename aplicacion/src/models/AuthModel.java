package models;

public class AuthModel {
	
	// aqui va toda la logica o donde se haran las consultas a la base de datos
	
	//contraseñas temporales
    private String correo = "admin";
    private String password = "1234";

    //metodo para verificar si son correctas las contraseñas
    public boolean login(String correo, String password) {
        return this.correo.equals(correo) && this.password.equals(password);
    }
    
    
}
