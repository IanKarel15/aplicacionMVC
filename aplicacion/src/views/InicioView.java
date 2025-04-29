package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.AuthController;

public class InicioView extends JFrame {

	public AuthController controlador;
	
	public InicioView(AuthController controlador) {
	        this.controlador = controlador;
	        
	      //configurcion de JFrame 
	        setSize(500, 600);
	        setTitle("X");
	        setLocationRelativeTo(null);
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      //crear panel registro
	        JPanel panelCuenta = new JPanel ();
	        panelCuenta.setBackground(Color.WHITE);
	        panelCuenta.setLayout(null);
	        add(panelCuenta);
	}

}
