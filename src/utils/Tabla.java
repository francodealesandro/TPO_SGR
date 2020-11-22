package utils;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Tabla<T> extends AbstractTableModel {
    private List<T> lista;

    protected String[] columns;

    public Tabla() {
        this.columns = new String[]{};
        this.lista = new ArrayList<>();
    }

    public Tabla(List<T> lista, String[] columns) {
        this.columns = columns;
        this.lista = lista;
    }

    public String getColumnName(int col) { return columns[col]; }
    public Class getColumnClass(int col) {
        try {
            return lista.get(0).getClass().getField(columns[col]).getType();
        } catch (NoSuchFieldException e) {
            return String.class;
        }
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columns.length;
    }

    //	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object valueReturn = "";
        try {
            valueReturn = lista.get(rowIndex).getClass().getMethod("get" + columns[columnIndex]).invoke(lista.get(rowIndex));
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        } catch (NoSuchMethodException e) {
        }
        return valueReturn;
    }

    public int add(T model) {
        lista.add(model);
        fireTableDataChanged();
        return lista.size() -1;
    }
}
