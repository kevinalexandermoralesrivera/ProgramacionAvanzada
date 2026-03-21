package modelo;

import java.util.ArrayList;

public class Venta {

    private ArrayList<ItemVenta> items;

    public Venta() {
        items = new ArrayList<>();
    }

    public void agregar(ItemVenta item) {
        items.add(item);
    }

    public ArrayList<ItemVenta> getItems() {
        return items;
    }

    public double getSubtotal() {
        double suma = 0;

        for(ItemVenta i : items){
            suma += i.getTotal();
        }

        return suma;
    }

    public double getIVA() {
        return getSubtotal() * 0.16;
    }

    public double getTotal() {
        return getSubtotal() + getIVA();
    }
}