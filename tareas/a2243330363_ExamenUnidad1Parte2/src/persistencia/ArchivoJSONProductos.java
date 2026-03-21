package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelo.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArchivoJSONProductos {

    private final String ARCHIVO = "productos.json";

    private Gson gson;

    public ArchivoJSONProductos(){
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // GUARDAR
    public void guardar(ArrayList<Producto> lista){

        ArrayList<ProductoDTO> dtos = new ArrayList<>();

        for(Producto p : lista){

            ProductoDTO dto = new ProductoDTO();

            dto.id = p.getId();
            dto.codigo = p.getCodigo();
            dto.nombre = p.getNombre();
            dto.categoria = p.getCategoria();
            dto.precio = p.getPrecio();
            dto.stock = p.getStock();
            dto.imagen = p.getImagen();

            dtos.add(dto);
        }

        try(FileWriter writer = new FileWriter(ARCHIVO)){

            gson.toJson(dtos, writer);

        }catch(Exception e){
            System.out.println("Error al guardar JSON");
        }
    }

    // CARGAR
    public ArrayList<Producto> cargar(){

        ArrayList<Producto> lista = new ArrayList<>();

        try(FileReader reader = new FileReader(ARCHIVO)){

            Type tipoLista = new TypeToken<ArrayList<ProductoDTO>>(){}.getType();

            ArrayList<ProductoDTO> dtos = gson.fromJson(reader, tipoLista);

            if(dtos == null) return lista;

            for(ProductoDTO dto : dtos){

                Producto p = crearProducto(dto);

                lista.add(p);
            }

        }catch(Exception e){
            return lista;
        }

        return lista;
    }

    // CREAR PRODUCTO SEGÚN CATEGORÍA
    private Producto crearProducto(ProductoDTO dto){

        switch(dto.categoria){

            case "Abarrotes":
                return new ProductoAbarrote(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Bebidas":
                return new ProductoBebida(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Lácteos":
                return new ProductoLacteo(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Frutas y Verduras":
                return new ProductoFrutaVerdura(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Carnes y Pescados":
                return new ProductoCarne(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Limpieza":
                return new ProductoLimpieza(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Cuidado Personal":
                return new ProductoCuidadoPersonal(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Snacks":
                return new ProductoSnack(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            case "Mascotas":
                return new ProductoMascota(dto.id,dto.codigo,dto.nombre,dto.precio,dto.stock,dto.imagen);

            default:
                return null;
        }
    }
}