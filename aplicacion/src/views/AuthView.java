package views;

import javax.swing.*;

import controllers.AuthController;

import java.awt.Color;
import java.awt.Font;

//aqui vendra toda la interfaz y alguna q otra logica

public class AuthView extends JFrame {
	
	//variables necesarias para funcionar
    private JTextField campoCorreo;
    private JPasswordField campoContrasena;
    private JButton botonIS;
    public AuthController controlador;

    public AuthView(AuthController controlador) {
        this.controlador = controlador;
    	
    	//configurcion de JFrame 
        setSize(500, 600);
        setTitle("X");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      //crear panel
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(Color.white);
        panelLogin.setLayout(null);

        // Etiqueta de título
        JLabel titulo = new JLabel("Iniciar sesión");
        titulo.setBounds(145, 60, 250, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 35));
        panelLogin.add(titulo);

        // label de correo
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(50, 160, 100, 25);
        panelLogin.add(lblCorreo);
        
        // Campo de correo
        campoCorreo = new JTextField();
        campoCorreo.setBounds(150, 160, 250, 25);
        campoCorreo.setToolTipText("Ingrese su correo");
        panelLogin.add(campoCorreo);

        // label de contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(50, 210, 100, 25);
        panelLogin.add(lblContrasena);

        // Campo de contraseña
        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(150, 210, 250, 25);
        campoContrasena.setEchoChar('*');
        campoContrasena.setToolTipText("Ingrese su contraseña");
        panelLogin.add(campoContrasena);

        // CheckBox de recordar contraseña
        JCheckBox chkRecordarContrasena = new JCheckBox("Recordar contraseña");
        chkRecordarContrasena.setBounds(170, 270, 150, 25);
        chkRecordarContrasena.setBackground(Color.WHITE);
        panelLogin.add(chkRecordarContrasena);

        // Boton de inicio de sesion
        botonIS = new JButton("Iniciar sesión");
        botonIS.setBounds(130, 330, 220, 47);
        botonIS.setBackground(Color.black);
        botonIS.setForeground(Color.white);
        botonIS.setFocusPainted(false);
        botonIS.setBorderPainted(false); 
        panelLogin.add(botonIS);
        botonIS.addActionListener(e -> {
        	String correo = getCorreo();
            String contraseña = getContraseña();
            
            if (correo.isEmpty() && contraseña.isEmpty() ) {//campos estan vacios
            	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                return;
            }
            if (correo.isEmpty() ) {//campo correo esta vacio
            	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                return;
            }
            if(contraseña.isEmpty()){//campo contraseña esta vacio
            	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,2));
                return;
            }   
            if(controlador.verificarCuenta(correo, contraseña)) {
            	//aqui mandaria al usuario a su cuenta
            }

            else {
            	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.red,2));
            	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.red,2));
            	
                return;
                
            }
            });
        
        
                
        
        //boton crear cuenta
        JButton botonCrearCuenta = new JButton("¿No tiene una cuenta? Cree una");
        botonCrearCuenta.setBounds(130, 400, 220, 47);
        botonCrearCuenta.setBackground(Color.white);
        botonCrearCuenta.setForeground(Color.BLACK);
        botonCrearCuenta.setFocusPainted(false);  
        botonCrearCuenta.setBorderPainted(false); 
        panelLogin.add(botonCrearCuenta);
        botonCrearCuenta.addActionListener(e -> {
            RegisterView ventanaRegistro = new RegisterView(controlador);
            ventanaRegistro.setVisible(true);
            dispose();
        });
        
        add(panelLogin);
    }

    public String getCorreo() {
        return campoCorreo.getText();
    }

    public String getContraseña() {
        return new String(campoContrasena.getPassword());
    }

    
    
}
