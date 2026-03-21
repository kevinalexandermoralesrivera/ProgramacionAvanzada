package modelo;

public abstract class Producto {

    protected int id;
    protected String codigo;
    protected String nombre;
    protected String categoria;
    protected double precio;
    protected int stock;
    protected String imagen; // ruta local

    public Producto(int id, String codigo, String nombre, String categoria,
                    double precio, int stock, String imagen) {

        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
    }

    // MÉTODO ABSTRACTO (cada tipo puede definirlo diferente si quieres)
    public abstract String getTipoConservacion();

    // GETTERS

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

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getImagen() {
        return imagen;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}