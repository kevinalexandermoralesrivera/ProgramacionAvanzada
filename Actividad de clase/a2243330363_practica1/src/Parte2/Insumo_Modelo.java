package Parte2;

public class Insumo_Modelo {
    private String nombre;
    private String categoria;

    public Insumo_Modelo(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }

   
    public String toCSV() {
        return nombre + "," + categoria;
    }
}