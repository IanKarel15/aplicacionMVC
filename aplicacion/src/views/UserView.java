package views;

import models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controllers.UserController;

import java.awt.*;
import java.util.ArrayList;

public class UserView extends JFrame {

    private JTable tabla;
    private DefaultTableModel modeloTabla;
    public UserController controlador;

    public UserView() {
    	
    	controlador = new UserController();
        setTitle("Lista de Usuarios");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] columnas = {"ID", "Nombre", "Email", "Rol", "Teléfono"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);

        ArrayList<User> listaUsuarios = controlador.mandarDatos();
        for (User u : listaUsuarios) {
            Object[] fila = {
                u.getEmpId(),
                u.getFirstName(),
                u.getEmail(),
                u.getRole(),
                u.getPhone()
            };
            modeloTabla.addRow(fila);
        }

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        setVisible(true);
    }
}

