package controlador;

import modelo.Inventario;
import modelo.Producto;
import vista.VistaPuntoVenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ControladorPuntoVenta {

    private VistaPuntoVenta vista;
    private Inventario inventario;

    public ControladorPuntoVenta(VistaPuntoVenta vista, Inventario inventario){

        this.vista = vista;
        this.inventario = inventario;

        refrescarProductos();

        vista.agregar.addActionListener(e -> agregarProducto());
        vista.eliminar.addActionListener(e -> eliminarProducto());
        vista.procesar.addActionListener(e -> procesarPago());

        // 🔥 MOSTRAR IMAGEN
        vista.comboProductos.addActionListener(e -> mostrarImagen());
    }

    public void refrescarProductos(){

        vista.comboProductos.removeAllItems();

        for(Producto p : inventario.getLista()){
            vista.comboProductos.addItem(
                    p.getCodigo()+" - "+p.getNombre()
            );
        }
    }

    private void mostrarImagen(){

        int index = vista.comboProductos.getSelectedIndex();

        if(index == -1) return;

        Producto p = inventario.getLista().get(index);

        try{
            String ruta = p.getImagen();

            ImageIcon icono = new ImageIcon(ruta);

            if(icono.getIconWidth() == -1){
                System.out.println("No se encontró imagen: " + ruta);
                vista.lblImagen.setIcon(null);
                return;
            }

            Image img = icono.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);

            vista.lblImagen.setIcon(new ImageIcon(img));

        }catch(Exception e){
            vista.lblImagen.setIcon(null);
        }
    }

    private void agregarProducto(){

        int index = vista.comboProductos.getSelectedIndex();

        if(index == -1){
            JOptionPane.showMessageDialog(vista,"Seleccione un producto");
            return;
        }

        try{

            int cantidad = Integer.parseInt(vista.txtCantidad.getText());

            Producto p = inventario.getLista().get(index);

            double precio = p.getPrecio();

            double total = cantidad * precio;

            DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();

            modelo.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    cantidad,
                    precio,
                    total
            });

            calcularTotales();

        }catch(Exception ex){
            JOptionPane.showMessageDialog(vista,"Cantidad inválida");
        }
    }

    private void eliminarProducto(){

        int fila = vista.tabla.getSelectedRow();

        if(fila == -1){
            JOptionPane.showMessageDialog(vista,"Seleccione un producto");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.removeRow(fila);

        calcularTotales();
    }

    private void calcularTotales(){

        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();

        double subtotal = 0;

        for(int i=0;i<modelo.getRowCount();i++){
            subtotal += (double) modelo.getValueAt(i,4);
        }

        double iva = subtotal * 0.16;
        double total = subtotal + iva;

        vista.subtotal.setText(String.valueOf(subtotal));
        vista.iva.setText(String.valueOf(iva));
        vista.total.setText(String.valueOf(total));
    }

    private void procesarPago(){

        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();

        if(modelo.getRowCount()==0){
            JOptionPane.showMessageDialog(vista,"No hay productos en el carrito");
            return;
        }

        StringBuilder ticket = new StringBuilder();

        ticket.append("===== TICKET DE VENTA =====\n");

        for(int i=0;i<modelo.getRowCount();i++){

            ticket.append(modelo.getValueAt(i,0))
                  .append(" | ")
                  .append(modelo.getValueAt(i,1))
                  .append(" | Cant: ").append(modelo.getValueAt(i,2))
                  .append(" | P.Unit: ").append(modelo.getValueAt(i,3))
                  .append(" | Total: ").append(modelo.getValueAt(i,4))
                  .append("\n");
        }

        ticket.append("----------------------------\n");
        ticket.append("Subtotal: ").append(vista.subtotal.getText()).append("\n");
        ticket.append("IVA: ").append(vista.iva.getText()).append("\n");
        ticket.append("TOTAL: ").append(vista.total.getText()).append("\n");
        ticket.append("============================");

        JOptionPane.showMessageDialog(vista,ticket.toString(),"Ticket",JOptionPane.INFORMATION_MESSAGE);

        modelo.setRowCount(0);

        vista.subtotal.setText("");
        vista.iva.setText("");
        vista.total.setText("");
    }
}