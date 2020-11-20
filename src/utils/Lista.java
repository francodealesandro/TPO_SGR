package utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lista<T> extends AbstractListModel {
    protected List<T> lista = new ArrayList<T>();

    public Lista() {
    }

    public List<T> get() {
        return lista;
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public T getElementAt(int index) {
        return lista.get(index);
    }

    public int add(T newModel) {
        lista.add(newModel);
        fireContentsChanged(this, 0, lista.size());

        return lista.size()-1;
    }

}