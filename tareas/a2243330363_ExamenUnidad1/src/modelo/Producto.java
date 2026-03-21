package modelo;

public class Producto {

    private int id;
    private String codigo;
    private String nombre;
    private String categoria;
    private int stock;
    private double precioVenta;
    private boolean estado;

    public Producto(int id, String codigo, String nombre, String categoria, int stock, double precioVenta, boolean estado) {

        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {

        return id + "," +
               codigo + "," +
               nombre + "," +
               categoria + "," +
               stock + "," +
               precioVenta + "," +
               estado;
    }
}