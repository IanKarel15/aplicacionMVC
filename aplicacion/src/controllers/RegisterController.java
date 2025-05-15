package controllers;

import models.AuthModel;
import models.RegisterModel;
import views.AuthView;
import views.RegisterView;

public class RegisterController {
	
	private RegisterModel model;
    private RegisterView view;

    //el constructor ocupa un objeto de tipo view y uno de model para hacer uso de sus metodos
    public RegisterController(RegisterModel model) {
        this.model = model;
        this.view = new RegisterView(this);
        this.view.setVisible(true);
    }
	
	public void registrarUsuario(String nombre,String apellidos,String empresa,String ambito,String cargo,String usuario, String contrasena, String correo) {
	       
        model.añadirCuenta(nombre, apellidos, empresa, ambito, cargo, usuario, contrasena, correo);
    }

}
