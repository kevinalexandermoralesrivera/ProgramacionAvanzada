package controlador;

import modelo.Inventario;
import modelo.Producto;
import vista.VistaProductos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControladorProductos {

    private VistaProductos vista;
    private Inventario inventario;

    public ControladorProductos(VistaProductos vista, Inventario inventario){

        this.vista = vista;
        this.inventario = inventario;

        cargarTabla();

        vista.guardar.addActionListener(e -> guardarProducto());
        vista.limpiar.addActionListener(e -> limpiarCampos());

    }

    private void cargarTabla(){

        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for(Producto p : inventario.getListaProductos()){

            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getCodigo(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getStock(),
                    p.getPrecioVenta(),
                    p.isEstado()
            });
        }
    }

    private void guardarProducto(){

        try{

            int id = inventario.obtenerSiguienteId(); // AQUÍ SE GENERA EL NUEVO ID

            String codigo = "P" + id;

            String nombre = vista.txtNombre.getText();

            String categoria = vista.comboCategoria.getSelectedItem().toString();

            int stock = Integer.parseInt(vista.txtStock.getText());

            double precioVenta = Double.parseDouble(vista.txtVenta.getText());

            boolean estado = vista.activo.isSelected();

            Producto p = new Producto(
                    id,
                    codigo,
                    nombre,
                    categoria,
                    stock,
                    precioVenta,
                    estado
            );

            inventario.insertar(p);

            cargarTabla();

            limpiarCampos();

            JOptionPane.showMessageDialog(vista,"Producto agregado correctamente");

        }catch(Exception ex){

            JOptionPane.showMessageDialog(vista,"Error al guardar producto");

        }

    }

    private void limpiarCampos(){

        vista.txtNombre.setText("");
        vista.txtStock.setText("");
        vista.txtVenta.setText("");
        vista.txtCompra.setText("");
        vista.txtDescripcion.setText("");

    }

}