package modelo;

public class ProductoFrutaVerdura extends Producto {

    public ProductoFrutaVerdura(int id, String codigo, String nombre,
                                double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Frutas y Verduras", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Perecedero";
    }
}