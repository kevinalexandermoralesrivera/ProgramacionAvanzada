package modelo;

public class ItemVenta {

    private int codigo;
    private String descripcion;
    private int cantidad;
    private double precioUnitario;

    public ItemVenta(int codigo, String descripcion, int cantidad, double precioUnitario) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getTotal() {

        return cantidad * precioUnitario;
    }

}