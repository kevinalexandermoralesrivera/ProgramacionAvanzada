package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

    private ArrayList<Producto> lista;

    public Inventario() {
        lista = new ArrayList<>();
    }

    public ArrayList<Producto> getLista() {
        return lista;
    }

    // AGREGAR PRODUCTO
    public void agregar(Producto p) {
        lista.add(p);
    }

    // BUSCAR POR ID
    public Producto buscar(int id) {

        for (Producto p : lista) {

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    // ELIMINAR PRODUCTO
    public boolean eliminar(int id) {

        Iterator<Producto> it = lista.iterator();

        while (it.hasNext()) {

            Producto p = it.next();

            if (p.getId() == id) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    // ACTUALIZAR PRODUCTO
    public boolean actualizar(Producto nuevo) {

        for (Producto p : lista) {

            if (p.getId() == nuevo.getId()) {

                p.setNombre(nuevo.getNombre());
                p.setPrecio(nuevo.getPrecio());
                p.setStock(nuevo.getStock());

                return true;
            }
        }

        return false;
    }

    // GENERAR ID AUTOMÁTICO
    public int generarId() {

        int max = 0;

        for (Producto p : lista) {

            if (p.getId() > max) {
                max = p.getId();
            }
        }

        return max + 1;
    }

    // FILTRAR POR CATEGORÍA
    public ArrayList<Producto> filtrarPorCategoria(String categoria) {

        ArrayList<Producto> filtrados = new ArrayList<>();

        for (Producto p : lista) {

            if (p.getCategoria().equals(categoria)) {
                filtrados.add(p);
            }
        }

        return filtrados;
    }
}