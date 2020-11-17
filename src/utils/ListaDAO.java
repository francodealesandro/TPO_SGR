package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListaDAO<T> extends Lista<T> {
    final Class<T> clase;
    protected File archivo;

    public ListaDAO(Class<T> clase) throws Exception {
        super();
        this.clase = clase;

        this.archivo = new File("datos/" + clase.getSimpleName());
        this.archivo.createNewFile();
        load();
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

}