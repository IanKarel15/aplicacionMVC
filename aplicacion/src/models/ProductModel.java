// models/ProductModel.java
package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductModel {
    private static final String RECURSO = "files/productos.json";

    public List<Map<String, Object>> obtenerProductos() throws IOException {
        InputStream in = getClass()
            .getClassLoader()
            .getResourceAsStream(RECURSO);
        if (in == null) throw new IOException("No se encontró " + RECURSO + " en classpath");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = r.readLine()) != null) {
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
}

