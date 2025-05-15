package views;

import javax.swing.*;

import controllers.AuthController;
import controllers.ProductController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProductView extends JFrame {
    private JTable tabla = new JTable();
    private JButton btnActualizar = new JButton("Actualizar");
    private JButton botonAñadir = new JButton("añadir");
    private ProductController controlador;

    public ProductView() {
        super("Productos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel pnlBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBoton.add(btnActualizar);
        
        pnlBoton.add(botonAñadir);
        botonAñadir.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent accion) {
               
            	var product = javax.swing.JOptionPane.showInputDialog("¿Como se llama el articulo a agregar?");
            	
                }});  
        
        

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(10, 10));
        cp.add(new JScrollPane(tabla), BorderLayout.CENTER);
        cp.add(pnlBoton, BorderLayout.SOUTH);
    }

    public JTable getTabla() { return tabla; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public JPanel panelAgregar() {
        JPanel panelAgregar = new JPanel();
        panelAgregar.setLayout(null); // Necesario para usar setBounds()
        panelAgregar.setBackground(Color.WHITE);

        // Campo ID
        JTextField campoID = new JTextField();
        campoID.setBounds(100, 20, 200, 30);
        panelAgregar.add(campoID);

        // Campo Nombre
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(100, 60, 200, 30);
        panelAgregar.add(campoNombre);

        // Campo Precio
        JTextField campoPrecio = new JTextField();
        campoPrecio.setBounds(100, 100, 200, 30);
        panelAgregar.add(campoPrecio);

        // Campo Cantidad
        JTextField campoCantidad = new JTextField();
        campoCantidad.setBounds(100, 140, 200, 30);
        panelAgregar.add(campoCantidad);

        // Botón Agregar
        JButton botonAgregar = new JButton("Agregar producto");
        botonAgregar.setBounds(100, 190, 200, 40);
        panelAgregar.add(botonAgregar);

        botonAgregar.addActionListener(e -> {
            String id = campoID.getText();
            String nombre = campoNombre.getText();
            String precioTexto = campoPrecio.getText();
            String cantidadTexto = campoCantidad.getText();

            try {
                double precio = Double.parseDouble(precioTexto);
                int cantidad = Integer.parseInt(cantidadTexto);
                int id1 = Integer.parseInt(id);

                Producto nuevo = new Producto(id1,nombre, precio, cantidad); 
                try {
					controlador.agregarProducto(nuevo);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

                JOptionPane.showMessageDialog(panelAgregar, "Producto agregado con éxito.");

                // Limpiar campos
                campoID.setText("");
                campoNombre.setText("");
                campoPrecio.setText("");
                campoCantidad.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panelAgregar, "Precio o cantidad inválidos.");
            }
        });

        return panelAgregar;
    }

}

