package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListDAO<T> {
    final Class<T> clase;
    protected File archivo;
    List<T> lista = new ArrayList<T>();

    public ListDAO(Class<T> clase) throws Exception {
        this.clase = clase;

        this.archivo = new File(clase.getName());
        this.archivo.createNewFile();
    }

    public void load() throws Exception {
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);

        try {
            String cadena = b.readLine();

            if (cadena == null) {
                this.save();
                cadena = "[]";
            }

            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
            Gson g = new Gson();
            for (JsonElement js : gsonArr) {
                lista.add(g.fromJson(js, clase));
            }
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() throws Exception {
        Gson g = new Gson();
        String texto = g.toJson(lista);
        FileWriter fileWriter = new FileWriter(archivo);
        fileWriter.write(texto);
        BufferedWriter bwEscritor = new BufferedWriter(fileWriter);
        bwEscritor.close();
    }

    public List<T> get() {
        return lista;
    }
}