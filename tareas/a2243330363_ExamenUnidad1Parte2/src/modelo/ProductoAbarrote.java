package modelo;

public class ProductoAbarrote extends Producto {

    public ProductoAbarrote(int id, String codigo, String nombre,
                            double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Abarrotes", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "No perecedero";
    }
}