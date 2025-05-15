package controllers;

import models.ProductModel;
import views.ProductView;
import views.Producto;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProductController {
    private ProductModel modelo;
    private ProductView vista;

    public ProductController(ProductModel modelo, ProductView vista) {
        this.modelo = modelo;
        this.vista = vista;

        
        cargarYMostrar();
        vista.getBtnActualizar().addActionListener(e -> cargarYMostrar());

        SwingUtilities.invokeLater(() -> vista.setVisible(true));
    }

    private void cargarYMostrar() {
        try {
            List<Map<String, Object>> productos = modelo.obtenerProductos();
            DefaultTableModel tm = new DefaultTableModel(
                new String[]{"ID", "Nombre", "Precio", "Stock"}, 0
            );
            for (Map<String, Object> p : productos) {
                tm.addRow(new Object[]{
                    p.get("id"), p.get("nombre"), p.get("precio"), p.get("stock")
                });
            }
            vista.getTabla().setModel(tm);
        } catch (IOException ex) {
            ex.printStackTrace();
            vista.mostrarError("Error leyendo productos.json:\n" + ex.getMessage());
        }
    }

    public void agregarProducto(Producto nuevo) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("id", nuevo.getId());
        obj.put("nombre", nuevo.getNombre());
        obj.put("precio", nuevo.getPrecio());
        obj.put("stock", nuevo.getStock());

        modelo.agregarProducto(obj);
    }
   
    

   
    	
    	


    
}
