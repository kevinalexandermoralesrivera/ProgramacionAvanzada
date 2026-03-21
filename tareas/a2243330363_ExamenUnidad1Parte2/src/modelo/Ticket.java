package modelo;

import java.util.ArrayList;

public class Ticket {

    private String folio;
    private ArrayList<ItemVenta> items;
    private double subtotal;
    private double iva;
    private double total;

    public Ticket(String folio, ArrayList<ItemVenta> items,
                  double subtotal, double iva, double total) {

        this.folio = folio;
        this.items = items;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public String getFolio() {
        return folio;
    }

    public ArrayList<ItemVenta> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }
}