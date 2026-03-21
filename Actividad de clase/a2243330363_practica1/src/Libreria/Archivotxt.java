package Libreria;

import java.io.*;
import java.util.ArrayList;

public class Archivotxt {

   
    public void guardar(String nombreArchivo, String contenido, boolean anexar) {
        try (FileWriter fw = new FileWriter(nombreArchivo, anexar);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(contenido);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

   
    public ArrayList<String> leer(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) return lineas;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
        return lineas;
    }
}