package modelo;

import java.util.ArrayList;

public class Venta {

    private ArrayList<ItemVenta> carrito;

    public Venta(){

        carrito = new ArrayList<>();
    }

    public void agregarItem(ItemVenta item){

        carrito.add(item);
    }

    public ArrayList<ItemVenta> getCarrito(){

        return carrito;
    }

    public double calcularSubtotal(){

        double suma = 0;

        for(ItemVenta item : carrito){

            suma += item.getTotal();
        }

        return suma;
    }

    public double calcularIVA(){

        return calcularSubtotal() * 0.16;
    }

    public double calcularTotal(){

        return calcularSubtotal() + calcularIVA();
    }
}