package practica2_1.modelo;

public class Insumo {
    private String nombre;

    public Insumo(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}