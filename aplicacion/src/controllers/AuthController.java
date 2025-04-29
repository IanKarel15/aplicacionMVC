package controllers;

import java.io.IOException;

import models.AuthModel;
import views.AuthView;

//aqui va el controlador donde sera el intermediario entre el view y el modelo


public class AuthController {
    private AuthModel model;
    private AuthView view;

    //el constructor ocupa un objeto de tipo view y uno de model para hacer uso de sus metodos
    public AuthController(AuthModel model) {
        this.model = model;
        this.view = new AuthView(this);
        this.view.setVisible(true);
    }
    
    //metodo que verifica si las contraseñas son correctas haciendo una consulta de la base de datos
    
    public boolean verificarCuenta(String correoV, String contraseñaV) {
        return model.verificarContraseñas(correoV, contraseñaV);
    }
    
    public void registrarUsuario(String nombre,String apellidos,String empresa,String ambito,String cargo,String usuario, String contrasena, String correo) {
       
        model.añadirCuenta(nombre, apellidos, empresa, ambito, cargo, usuario, contrasena, correo);
    }
}
