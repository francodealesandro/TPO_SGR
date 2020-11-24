package utils;

import com.google.gson.*;
import model.Operacion;

import java.io.*;
import java.util.ArrayList;

public class ListaDAO<T> extends ArrayList<T> {
    final Class<T> clase;
    final File archivo;
    final Gson g;

    public ListaDAO(Class<T> clase) throws Exception {
        super();
        this.clase = clase;

        this.archivo = new File("datos/" + clase.getSimpleName());
        this.archivo.createNewFile();

        GsonBuilder gsonBilder = new GsonBuilder();
        gsonBilder.registerTypeAdapter(Operacion.class, new InterfaceAdapter<Operacion>());
        g = gsonBilder.create();

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
            for (JsonElement js : gsonArr) {
                this.add(g.fromJson(js, clase));
            }
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() throws Exception {
        String texto = g.toJson(this);
        FileWriter fileWriter = new FileWriter(archivo);
        fileWriter.write(texto);
        BufferedWriter bwEscritor = new BufferedWriter(fileWriter);
        bwEscritor.close();
    }

}