package modelo;

public class ProductoCarne extends Producto {

    public ProductoCarne(int id, String codigo, String nombre,
                         double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Carnes y Pescados", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Congelado / Fresco";
    }
}