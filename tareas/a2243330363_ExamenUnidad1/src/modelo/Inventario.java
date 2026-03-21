package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

    private ArrayList<Producto> listaProductos;

    public Inventario() {

        listaProductos = new ArrayList<>();
    }

    public ArrayList<Producto> getListaProductos() {

        return listaProductos;
    }

    // VALIDAR DUPLICADOS
    public boolean existe(int id) {

        Iterator<Producto> it = listaProductos.iterator();

        while(it.hasNext()){

            Producto p = it.next();

            if(p.getId() == id){

                return true;
            }
        }

        return false;
    }

    // INSERTAR
    public void insertar(Producto p){

        listaProductos.add(p);
    }

    // BUSCAR
    public Producto buscar(int id){

        Iterator<Producto> it = listaProductos.iterator();

        while(it.hasNext()){

            Producto p = it.next();

            if(p.getId() == id){

                return p;
            }
        }

        return null;
    }

    // ELIMINAR
    public boolean eliminar(int id){

        Iterator<Producto> it = listaProductos.iterator();

        while(it.hasNext()){

            Producto p = it.next();

            if(p.getId() == id){

                it.remove();
                return true;
            }
        }

        return false;
    }

    // ACTUALIZAR
    public boolean actualizar(Producto nuevo){

        Iterator<Producto> it = listaProductos.iterator();

        while(it.hasNext()){

            Producto p = it.next();

            if(p.getId() == nuevo.getId()){

                p.setNombre(nuevo.getNombre());
                p.setCategoria(nuevo.getCategoria());
                p.setStock(nuevo.getStock());
                p.setPrecioVenta(nuevo.getPrecioVenta());
                p.setEstado(nuevo.isEstado());

                return true;
            }
        }

        return false;
    }

    // OBTENER SIGUIENTE ID
    public int obtenerSiguienteId(){

        int max = 0;

        for(Producto p : listaProductos){

            if(p.getId() > max){

                max = p.getId();
            }
        }

        return max + 1;
    }
}