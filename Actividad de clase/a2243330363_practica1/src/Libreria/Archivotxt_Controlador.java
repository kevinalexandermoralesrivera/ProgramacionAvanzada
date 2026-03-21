package Libreria;

import java.io.*;
import java.util.ArrayList;

public class Archivotxt_Controlador {

   
    public void guardar(String nombreArchivo, String contenido, boolean anexar) {
        try (FileWriter fw = new FileWriter(nombreArchivo, anexar);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(contenido);
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }

   
    public ArrayList<String> leer(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File file = new File(nombreArchivo);
        if (!file.exists()) return lineas;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }
}