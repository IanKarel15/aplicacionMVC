package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.AuthController;

public class InicioView extends JFrame {

    private AuthController controlador;

    public InicioView(AuthController controlador) {
    	
        this.controlador = controlador;
        setTitle("HomeView");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(10, 10));

        JPanel panelInicio = new JPanel();
        panelInicio.setBackground(Color.white);
        panelInicio.setLayout(null);
        add(panelInicio);

        JButton btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setBounds(20,20,175, 30);
        panelInicio.add(btnUsuarios);
        btnUsuarios.addActionListener(e -> {});

        JButton btnRegistros = new JButton("Registros");
        btnRegistros.setBounds(205,20,175, 30);
        panelInicio.add(btnRegistros);
        btnRegistros.addActionListener(e -> {});

        JButton btnConfig = new JButton("Configuración");
        btnConfig.setBounds(395,20,180, 30);
        panelInicio.add(btnConfig);
        btnConfig.addActionListener(e -> {});
        
        JPanel panelWidgets = new JPanel(new GridLayout(1, 4, 10, 10));
        panelWidgets.setBackground(Color.WHITE);
        panelWidgets.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelWidgets.setBounds(20, 70, 555, 120);

        panelWidgets.add(crearWidget("Contador", Color.black,Color.white));
        panelWidgets.add(crearWidget("Mensajes", Color.white,Color.black));
        panelWidgets.add(crearWidget("Hora", Color.black,Color.white));
        panelWidgets.add(crearWidget("Estadísticas", Color.white,Color.black));
        
        

        panelInicio.add(panelWidgets);

        

        setVisible(true);
    }
    
    private JPanel crearWidget(String texto, Color color, Color colorLetra) {
        JPanel widget = new JPanel(new BorderLayout());
        widget.setBackground(color);
        
        widget.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
        widget.setPreferredSize(new Dimension(120, 100));

        JLabel lblTexto = new JLabel(texto, SwingConstants.CENTER);
        lblTexto.setBorder(new EmptyBorder(5, 5, 5, 5));
        lblTexto.setForeground(colorLetra);
        widget.add(lblTexto, BorderLayout.CENTER);

        return widget;
    }

    
}

