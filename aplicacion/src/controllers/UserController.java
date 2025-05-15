package controllers;

import models.UserModel;
import models.User;
import views.UserView;

import java.util.ArrayList;

public class UserController {

	UserModel modelo;
	
	public UserController () {
		
		modelo = new UserModel();
	}
	
	public ArrayList<User> mandarDatos(){
		ArrayList<User> listaUsuarios = modelo.get();
		
		return listaUsuarios;
	}
}