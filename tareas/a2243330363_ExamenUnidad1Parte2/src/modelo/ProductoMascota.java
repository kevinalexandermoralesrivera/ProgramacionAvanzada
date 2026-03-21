package modelo;

public class ProductoMascota extends Producto {

    public ProductoMascota(int id, String codigo, String nombre,
                           double precio, int stock, String imagen) {

        super(id, codigo, nombre, "Mascotas", precio, stock, imagen);
    }

    @Override
    public String getTipoConservacion() {
        return "Volumen";
    }
}