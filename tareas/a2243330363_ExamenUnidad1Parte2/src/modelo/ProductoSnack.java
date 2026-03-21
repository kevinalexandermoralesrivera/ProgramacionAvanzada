package modelo;

public class ProductoSnack extends Producto {

    public ProductoSnack(int id, String codigo, String nombre,
                         double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Snacks", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Impulso";
    }
}