package persistencia;

import modelo.Producto;

import java.io.*;
import java.util.ArrayList;

public class ArchivoCSV {

    private final String ARCHIVO = "productos.csv";

    // GUARDAR PRODUCTOS EN CSV
    public void exportarCSV(ArrayList<Producto> lista){

        try{

            PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO));

            for(Producto p : lista){

                writer.println(p.toString());

            }

            writer.close();

        }catch(IOException e){

            System.out.println("Error al guardar archivo CSV");

        }

    }

    // CARGAR PRODUCTOS DESDE CSV
    public ArrayList<Producto> importarCSV(){

        ArrayList<Producto> lista = new ArrayList<>();

        File archivo = new File(ARCHIVO);

        if(!archivo.exists()){
            return lista;
        }

        try{

            BufferedReader reader = new BufferedReader(new FileReader(archivo));

            String linea;

            while((linea = reader.readLine()) != null){

                if(linea.trim().isEmpty()){
                    continue;
                }

                String[] datos = linea.split(",");

                int id = Integer.parseInt(datos[0]);

                String codigo = datos[1];

                String nombre = datos[2];

                String categoria = datos[3];

                int stock = Integer.parseInt(datos[4]);

                double precio = Double.parseDouble(datos[5]);

                boolean estado = Boolean.parseBoolean(datos[6]);

                Producto p = new Producto(
                        id,
                        codigo,
                        nombre,
                        categoria,
                        stock,
                        precio,
                        estado
                );

                lista.add(p);

            }

            reader.close();

        }catch(Exception e){

            System.out.println("Error al leer CSV");

        }

        return lista;

    }

}