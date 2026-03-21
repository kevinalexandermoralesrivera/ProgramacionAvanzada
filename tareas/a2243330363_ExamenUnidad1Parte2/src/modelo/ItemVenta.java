package modelo;

public class ItemVenta {

    private Producto producto;
    private int cantidad;

    public ItemVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return cantidad * producto.getPrecio();
    }
}