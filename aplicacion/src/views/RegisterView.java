package views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.AuthController;
import controllers.RegisterController;

public class RegisterView  extends JFrame{
	
	public RegisterController controlador;
	public AuthController controlador2;
	private JTextField campoNombre, campoApellidos, campoEmpresa, campoCargo, campoUsuario, campoCorreo;
    private JComboBox<String> comboAmbito;
    private JPasswordField campoContrasena, campoRepetirContrasena;

	public RegisterView(RegisterController controlador) {
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
        lblCrearC.setFont(new Font("Tahoma", Font.PLAIN, 35));
        panelRegistro.add(lblCrearC);

     // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 80, 100, 25);
        panelRegistro.add(lblNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(200, 80, 220, 25);
        panelRegistro.add(campoNombre);

        // Apellidos
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(50, 120, 100, 25);
        panelRegistro.add(lblApellidos);

        campoApellidos = new JTextField();
        campoApellidos.setBounds(200, 120, 220, 25);
        panelRegistro.add(campoApellidos);

        // Empresa
        JLabel lblEmpresa = new JLabel("Empresa:");
        lblEmpresa.setBounds(50, 160, 100, 25);
        panelRegistro.add(lblEmpresa);

        campoEmpresa = new JTextField();
        campoEmpresa.setBounds(200, 160, 220, 25);
        panelRegistro.add(campoEmpresa);

        // Ámbito
        JLabel lblAmbito = new JLabel("Ámbito:");
        lblAmbito.setBounds(50, 200, 100, 25);
        panelRegistro.add(lblAmbito);

        String[] ambitos = { "Tecnología", "Salud", "Educación", "Comercio", "Otro" };
        comboAmbito = new JComboBox<>(ambitos);
        comboAmbito.setBounds(200, 200, 220, 25);
        panelRegistro.add(comboAmbito);

        // Cargo
        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(50, 240, 100, 25);
        panelRegistro.add(lblCargo);

        campoCargo = new JTextField();
        campoCargo.setBounds(200, 240, 220, 25);
        panelRegistro.add(campoCargo);

        // Usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 280, 100, 25);
        panelRegistro.add(lblUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(200, 280, 220, 25);
        panelRegistro.add(campoUsuario);

        // Contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(50, 320, 100, 25);
        panelRegistro.add(lblContrasena);

        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(200, 320, 220, 25);
        panelRegistro.add(campoContrasena);

        // Repetir Contraseña
        JLabel lblRepetirContrasena = new JLabel("Repetir contraseña:");
        lblRepetirContrasena.setBounds(50, 360, 140, 25);
        panelRegistro.add(lblRepetirContrasena);

        campoRepetirContrasena = new JPasswordField();
        campoRepetirContrasena.setBounds(200, 360, 220, 25);
        panelRegistro.add(campoRepetirContrasena);

        // Correo
        JLabel lblCorreo = new JLabel("Correo electrónico:");
        lblCorreo.setBounds(50, 400, 150, 25);
        panelRegistro.add(lblCorreo);

        campoCorreo = new JTextField();
        campoCorreo.setBounds(200, 400, 220, 25);
        panelRegistro.add(campoCorreo);
        
        //Boton crear cuenta
        JButton botonCrearCuenta = new JButton("Crear cuenta");
        botonCrearCuenta.setBounds(125, 465, 230, 47);
        botonCrearCuenta.setBackground(Color.black);
        botonCrearCuenta.setFocusPainted(false);  
        botonCrearCuenta.setBorderPainted(false); 
        botonCrearCuenta.setFont(new Font("Tahoma", Font.PLAIN, 17));
        botonCrearCuenta.setForeground(Color.white);
        panelRegistro.add(botonCrearCuenta);
        
        botonCrearCuenta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String nombre = campoNombre.getText().trim();
                String apellidos = campoApellidos.getText().trim();
                String empresa = campoEmpresa.getText().trim();
                String ambito = (String) comboAmbito.getSelectedItem();
                String cargo = campoCargo.getText().trim();
                String usuario = campoUsuario.getText().trim();
                String contrasena = new String(campoContrasena.getPassword()).trim();
                String repetirContrasena = new String(campoRepetirContrasena.getPassword()).trim();
                String correo = campoCorreo.getText().trim();

                if (nombre.isEmpty() || apellidos.isEmpty() || empresa.isEmpty() || cargo.isEmpty()
                        || usuario.isEmpty() || contrasena.isEmpty() || repetirContrasena.isEmpty()
                        || correo.isEmpty()) {
                    error.setText("Rellena todos los campos");
                    error.setBounds(170, 530, 200, 20);
                    return;
                }

                if (!contrasena.equals(repetirContrasena)) {
                    error.setText("Las contraseñas no coinciden");
                    error.setBounds(170, 530, 250, 20);
                    return;
                }

                else {
                	
					controlador.registrarUsuario(nombre, apellidos, empresa, ambito, cargo, usuario, contrasena, correo);
					JOptionPane.showMessageDialog(null, "Cuenta creada con exito", "Cuenta creada con exito", JOptionPane.OK_OPTION);
                    InicioView ventanaCuenta = new InicioView(controlador2);
                    ventanaCuenta.setVisible(true);
                    dispose();
                }
                
                
                
            }
        });
        
      //cambiar alerta
       error.setText("");
  
       //pintar panel
        revalidate();
        repaint(); 
        add(panelRegistro);
	}

}
