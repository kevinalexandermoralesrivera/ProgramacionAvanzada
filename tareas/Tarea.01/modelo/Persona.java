package modelo;

public class Persona {

    private String nombre;
    private String ocupacion;
    private String edad;
    private String empleo;
    private boolean ciudadano;
    private String taxId;
    private String genero;

    public Persona(String nombre, String ocupacion, String edad,
                   String empleo, boolean ciudadano,
                   String taxId, String genero) {

        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.edad = edad;
        this.empleo = empleo;
        this.ciudadano = ciudadano;
        this.taxId = taxId;
        this.genero = genero;
    }

    public String mostrarDatos() {
        return "Nombre: " + nombre +
               "\nOcupación: " + ocupacion +
               "\nEdad: " + edad +
               "\nEmpleo: " + empleo +
               "\nCiudadano USA: " + ciudadano +
               "\nTax ID: " + taxId +
               "\nGénero: " + genero +
               "\n----------------------\n";
    }
}
