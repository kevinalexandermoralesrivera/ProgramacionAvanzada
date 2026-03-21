package modelo;

public class ProductoBebida extends Producto {

    public ProductoBebida(int id, String codigo, String nombre,
                          double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Bebidas", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Líquido";
    }
}