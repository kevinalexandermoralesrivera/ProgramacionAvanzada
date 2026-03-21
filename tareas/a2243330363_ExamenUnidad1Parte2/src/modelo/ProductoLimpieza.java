package modelo;

public class ProductoLimpieza extends Producto {

    public ProductoLimpieza(int id, String codigo, String nombre,
                            double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Limpieza", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Químico";
    }
}