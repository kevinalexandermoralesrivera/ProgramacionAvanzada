package main;

import modelo.Inventario;
import modelo.Producto;
import persistencia.ArchivoCSV;
import vista.VentanaPrincipal;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

   
        Inventario inventario = new Inventario();

      
        ArchivoCSV archivo = new ArchivoCSV();

        ArrayList<Producto> datos = archivo.importarCSV();
        inventario.getListaProductos().addAll(datos);


        VentanaPrincipal ventana = new VentanaPrincipal(inventario);

        ventana.setVisible(true);

    }
}