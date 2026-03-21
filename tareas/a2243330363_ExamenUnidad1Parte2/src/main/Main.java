package main;

import modelo.*;
import persistencia.ArchivoJSONProductos;
import vista.VentanaPrincipal;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        ArchivoJSONProductos archivo = new ArchivoJSONProductos();

      
        ArrayList<Producto> lista = archivo.cargar();

        if(lista.isEmpty()){

        
            DatosIniciales.cargarProductos(inventario);

           
            archivo.guardar(inventario.getLista());

        }else{

            inventario.getLista().addAll(lista);
        }

        // 🖥️ ABRIR SISTEMA
        VentanaPrincipal v = new VentanaPrincipal(inventario);
        v.setVisible(true);
    }
}