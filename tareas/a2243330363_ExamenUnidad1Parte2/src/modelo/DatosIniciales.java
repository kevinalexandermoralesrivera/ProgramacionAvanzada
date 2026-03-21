package modelo;

public class DatosIniciales {

    public static void cargarProductos(Inventario inventario){

        int id = 1;

        // 🥫 ABARROTES
        inventario.agregar(new ProductoAbarrote(id++,"P1","Arroz 1kg",25,50,"imagenes/arroz.png"));
        inventario.agregar(new ProductoAbarrote(id++,"P2","Frijol 1kg",30,40,"imagenes/frijol.png"));
        inventario.agregar(new ProductoAbarrote(id++,"P3","Azúcar 1kg",22,60,"imagenes/azucar.png"));
        inventario.agregar(new ProductoAbarrote(id++,"P4","Harina 1kg",18,35,"imagenes/harina.png"));
        inventario.agregar(new ProductoAbarrote(id++,"P5","Pasta 200g",12,70,"imagenes/pasta.png"));

        // 🥤 BEBIDAS
        inventario.agregar(new ProductoBebida(id++,"P6","Coca Cola 600ml",18,80,"imagenes/coca.png"));
        inventario.agregar(new ProductoBebida(id++,"P7","Agua 1L",10,100,"imagenes/agua.png"));
        inventario.agregar(new ProductoBebida(id++,"P8","Jugo Naranja",20,60,"imagenes/jugo.png"));
        inventario.agregar(new ProductoBebida(id++,"P9","Café",45,30,"imagenes/cafe.png"));
        inventario.agregar(new ProductoBebida(id++,"P10","Té",25,50,"imagenes/te.png"));

        // 🥛 LÁCTEOS
        inventario.agregar(new ProductoLacteo(id++,"P11","Leche",25,40,"imagenes/leche.png"));
        inventario.agregar(new ProductoLacteo(id++,"P12","Yogurt",15,35,"imagenes/yogurt.png"));
        inventario.agregar(new ProductoLacteo(id++,"P13","Mantequilla",28,25,"imagenes/mantequilla.png"));
        inventario.agregar(new ProductoLacteo(id++,"P14","Crema",20,30,"imagenes/crema.png"));
        inventario.agregar(new ProductoLacteo(id++,"P15","Gelatina",12,50,"imagenes/gelatina.png"));

        // 🍎 FRUTAS Y VERDURAS
        inventario.agregar(new ProductoFrutaVerdura(id++,"P16","Manzana",30,40,"imagenes/manzana.png"));
        inventario.agregar(new ProductoFrutaVerdura(id++,"P17","Plátano",20,50,"imagenes/platano.png"));
        inventario.agregar(new ProductoFrutaVerdura(id++,"P18","Zanahoria",15,60,"imagenes/zanahoria.png"));
        inventario.agregar(new ProductoFrutaVerdura(id++,"P19","Papa",18,70,"imagenes/papa.png"));
        inventario.agregar(new ProductoFrutaVerdura(id++,"P20","Tomate",22,55,"imagenes/tomate.png"));

        // 🥩 CARNES
        inventario.agregar(new ProductoCarne(id++,"P21","Pollo",90,20,"imagenes/pollo.png"));
        inventario.agregar(new ProductoCarne(id++,"P22","Res",150,15,"imagenes/res.png"));
        inventario.agregar(new ProductoCarne(id++,"P23","Cerdo",120,18,"imagenes/cerdo.png"));
        inventario.agregar(new ProductoCarne(id++,"P24","Pescado",110,12,"imagenes/pescado.png"));
        inventario.agregar(new ProductoCarne(id++,"P25","Mariscos",180,10,"imagenes/mariscos.png"));

        // 🧼 LIMPIEZA
        inventario.agregar(new ProductoLimpieza(id++,"P26","Detergente",35,40,"imagenes/detergente.png"));
        inventario.agregar(new ProductoLimpieza(id++,"P27","Suavizante",30,30,"imagenes/suavizante.png"));
        inventario.agregar(new ProductoLimpieza(id++,"P28","Cloro",20,50,"imagenes/cloro.png"));
        inventario.agregar(new ProductoLimpieza(id++,"P29","Papel Higiénico",60,25,"imagenes/papel.png"));
        inventario.agregar(new ProductoLimpieza(id++,"P30","Escoba",80,15,"imagenes/escoba.png"));

        // 🧴 CUIDADO PERSONAL
        inventario.agregar(new ProductoCuidadoPersonal(id++,"P31","Shampoo",45,30,"imagenes/shampoo.png"));
        inventario.agregar(new ProductoCuidadoPersonal(id++,"P32","Jabón",15,60,"imagenes/jabon.png"));
        inventario.agregar(new ProductoCuidadoPersonal(id++,"P33","Pasta Dental",25,40,"imagenes/pasta.png"));
        inventario.agregar(new ProductoCuidadoPersonal(id++,"P34","Desodorante",35,35,"imagenes/desodorante.png"));
        inventario.agregar(new ProductoCuidadoPersonal(id++,"P35","Crema",50,20,"imagenes/crema.png"));

        // 🍫 SNACKS
        inventario.agregar(new ProductoSnack(id++,"P36","Papas",20,80,"imagenes/papas.png"));
        inventario.agregar(new ProductoSnack(id++,"P37","Galletas",18,70,"imagenes/galletas.png"));
        inventario.agregar(new ProductoSnack(id++,"P38","Chocolate",25,60,"imagenes/chocolate.png"));
        inventario.agregar(new ProductoSnack(id++,"P39","Dulces",10,100,"imagenes/dulces.png"));
        inventario.agregar(new ProductoSnack(id++,"P40","Botanas",22,75,"imagenes/botanas.png"));

        // 🐶 MASCOTAS
        inventario.agregar(new ProductoMascota(id++,"P41","Croquetas Perro",250,20,"imagenes/perro.png"));
        inventario.agregar(new ProductoMascota(id++,"P42","Croquetas Gato",220,15,"imagenes/gato.png"));
        inventario.agregar(new ProductoMascota(id++,"P43","Arena Gato",180,10,"imagenes/arena.png"));
        inventario.agregar(new ProductoMascota(id++,"P44","Juguete",50,30,"imagenes/juguete.png"));
        inventario.agregar(new ProductoMascota(id++,"P45","Correa",90,25,"imagenes/correa.png"));

    }
}