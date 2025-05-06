package views;

import javax.swing.*;
import java.awt.*;

public class ProductView extends JFrame {
    private JTable tabla = new JTable();
    private JButton btnActualizar = new JButton("Actualizar");

    public ProductView() {
        super("Productos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel pnlBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlBoton.add(btnActualizar);

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
}

