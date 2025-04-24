package views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.AuthController;

public class RegisterView  extends JFrame{
	
	public AuthController controlador;

	public RegisterView(AuthController controlador) {
        this.controlador = controlador;
        
      //configurcion de JFrame 
        setSize(500, 600);
        setTitle("X");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //crear panel registro
        JPanel panelRegistro = new JPanel ();
        panelRegistro.setBackground(Color.WHITE);
        panelRegistro.setLayout(null);
        
        //etiqueta de error
        JLabel error = new JLabel();
        error.setForeground(Color.RED);
        panelRegistro.add(error);
        
        //label de crear cuenta
        JLabel lblCrearC = new JLabel ("Crear cuenta");
        lblCrearC.setBounds(136, 20, 250, 40);
        lblCrearC.setFont(new Font("Arial", Font.BOLD, 35));
        panelRegistro.add(lblCrearC);

        //label de nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 100, 100, 25);
        panelRegistro.add(lblNombre);
        
        //campo para el nombre
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(130, 100, 250, 25);
        campoNombre.setToolTipText("Ingrese su nombre");
        panelRegistro.add(campoNombre);
        
        //label para la descripcion
        JLabel lblBio = new JLabel("Descripcion:");
        lblBio.setBounds(50, 150, 100, 25);
        panelRegistro.add(lblBio);
        
        //campo para la descripcion
        JTextArea campoDes = new JTextArea();
        campoDes.setBounds(130, 150, 250, 90);
        campoDes.setToolTipText("Ingrese su descripcion");
        campoDes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelRegistro.add(campoDes);
        
        //label lista de ubicaciones
        JLabel lblUbi = new JLabel("Ubicacion:");
        lblUbi.setBounds(50, 320, 100, 25);
        panelRegistro.add(lblUbi);
        
        //lista de ubicaciones
        String [] ubicaciones ={"Camino real","Progreso", "Pueblo nuevo"};
        JComboBox listaDes = new JComboBox(ubicaciones);
        listaDes.setBounds(130, 320, 250, 25);
        panelRegistro.add(listaDes);
        
        //label de sexo
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 270, 100, 25);
        panelRegistro.add(lblSexo);
        
        //crearRadioButtons del sexo
        
        //Rboton mujer
        JRadioButton btnMujer = new JRadioButton("Mujer",false);
        btnMujer.setBounds(130, 270, 70, 25);
        btnMujer.setOpaque(false);
        panelRegistro.add(btnMujer);
        
        //Rboton hombre
        JRadioButton btnHombre = new JRadioButton("Hombre",false);
        btnHombre.setBounds(210, 270, 70, 25);
        btnHombre.setOpaque(false);
        panelRegistro.add(btnHombre);
        
        //Rboton mucho 
        JRadioButton RBoton3 = new JRadioButton("Mucho xfa",false);
        RBoton3.setBounds(290, 270, 100, 25);
        RBoton3.setOpaque(false);
        panelRegistro.add(RBoton3);
        
        //Crear grupo de botones
        ButtonGroup botonesSexo = new ButtonGroup();
        botonesSexo.add(btnMujer);
        botonesSexo.add(btnHombre);
        botonesSexo.add(RBoton3);
        
        //label de TyC
        JLabel lblTyC = new JLabel("Acepta los terminos y condiciones");
        lblTyC.setBounds(140, 370, 250, 25);
        panelRegistro.add(lblTyC);
        
        //crearRadioButtonsDeTyC 
        
        //Rboton aceptar
        JRadioButton btnAceptar = new JRadioButton("Acepto los terminos",false);
        btnAceptar.setBounds(70, 410, 150, 25);
        btnAceptar.setOpaque(false);
        panelRegistro.add(btnAceptar);
        
        //Rboton no aceptar
        JRadioButton btnNoAceptar = new JRadioButton("No acepto los terminos",false);
        btnNoAceptar.setBounds(240, 410, 170, 25);
        btnNoAceptar.setOpaque(false);
        panelRegistro.add(btnNoAceptar);
        
        //Crear grupo de botones 
        ButtonGroup botonesTyC = new ButtonGroup();
        botonesTyC.add(btnAceptar);
        botonesTyC.add(btnNoAceptar);
        
        //Boton crear cuenta
        JButton botonCrearCuenta = new JButton("Crear cuenta");
        botonCrearCuenta.setBounds(140, 460, 200, 30);
        botonCrearCuenta.setForeground(Color.BLUE);
        panelRegistro.add(botonCrearCuenta);
        
        //añadirle una accion
        botonCrearCuenta.addActionListener(new ActionListener() {
        
        	@Override
        	public void actionPerformed(ActionEvent e) {

        	    String nombre = campoNombre.getText();
        	    String des = campoDes.getText();

        	    if (nombre.isEmpty() && des.isEmpty()) {
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        error.setText("Rellena los datos");
        	        error.setBounds(185, 500, 200, 20);
        	        return;
        	    } else if (nombre.isEmpty() && !des.isEmpty()) {
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	        error.setText("Rellena el nombre");
        	        error.setBounds(185, 500, 200, 20);
        	        return;
        	    } else if (des.isEmpty() && !nombre.isEmpty()) {
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	        error.setText("Rellena la descripcion");
        	        error.setBounds(175, 500, 200, 20);
        	        return;
        	    } else if (!des.isEmpty() && !nombre.isEmpty()) {
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	    }
        	    
        	    if (!btnMujer.isSelected() && !btnHombre.isSelected() && !RBoton3.isSelected()) {
        	        error.setText("Escoge tu sexo");
        	        error.setBounds(180, 500, 200, 20);
        	        return;
        	    }

        	    if (!btnNoAceptar.isSelected() && !btnAceptar.isSelected()) {
        	        error.setText("Acepta los términos y condiciones");
        	        error.setBounds(130, 500, 200, 20);
        	        return;
        	    }
        	    
        	    
        	}});
        
      //cambiar alerta
       error.setText("");
  
       //pintar panel
        revalidate();
        repaint(); 
        add(panelRegistro);
	}

}
