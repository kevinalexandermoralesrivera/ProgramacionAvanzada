package modelo;

public class ProductoLacteo extends Producto {

    public ProductoLacteo(int id, String codigo, String nombre,
                          double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Lácteos", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Cadena de frío";
    }
}