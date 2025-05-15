package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ProductModel {
    private static final String ARCHIVO = "productos.json";

    public List<Map<String, Object>> obtenerProductos() throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                sb.append(linea);
            }
        }

        JSONArray arr = new JSONArray(sb.toString());
        List<Map<String, Object>> lista = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            Map<String, Object> map = new HashMap<>();
            map.put("id", obj.getInt("id"));
            map.put("nombre", obj.getString("nombre"));
            map.put("precio", obj.getDouble("precio"));
            map.put("stock", obj.getInt("stock"));
            lista.add(map);
        }

        return lista;
    }

    public void agregarProducto(JSONObject nuevoProducto) throws IOException {
        // Leer productos actuales
        JSONArray productos;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO, StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                sb.append(linea);
            }
            productos = new JSONArray(sb.toString());
        } catch (FileNotFoundException e) {
            productos = new JSONArray(); // Si no existe, crear nuevo arreglo
        }

        // Agregar nuevo producto
        productos.put(nuevoProducto);

        // Escribir el nuevo JSON en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, StandardCharsets.UTF_8))) {
            writer.write(productos.toString(4)); 
        }
    }
}
