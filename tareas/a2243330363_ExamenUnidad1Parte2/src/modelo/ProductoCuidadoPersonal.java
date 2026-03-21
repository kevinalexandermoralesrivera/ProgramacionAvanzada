package modelo;

public class ProductoCuidadoPersonal extends Producto {

    public ProductoCuidadoPersonal(int id, String codigo, String nombre,
                                   double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Cuidado Personal", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Higiene";
    }
}