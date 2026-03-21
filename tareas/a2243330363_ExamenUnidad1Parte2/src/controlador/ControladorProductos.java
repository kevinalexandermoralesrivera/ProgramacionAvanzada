package controlador;

import modelo.*;
import persistencia.ArchivoJSONProductos;
import persistencia.ReporteExcel;
import vista.VistaProductos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ControladorProductos {

    private VistaProductos vista;
    private Inventario inventario;

    private ArchivoJSONProductos archivo;
    private ReporteExcel reporte;

    public ControladorProductos(VistaProductos vista, Inventario inventario){

        this.vista = vista;
        this.inventario = inventario;

        archivo = new ArchivoJSONProductos();
        reporte = new ReporteExcel();

        cargarTabla();
        eventos();
    }

    private void eventos(){

        vista.guardar.addActionListener(e -> guardar());
        vista.limpiar.addActionListener(e -> limpiar());

        vista.btnReporteGeneral.addActionListener(e -> reporteGeneral());
        vista.btnReporteCategoria.addActionListener(e -> reporteCategoria());

        vista.tabla.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> cargarDatosSeleccionados()
        );
    }

    private void cargarTabla(){

        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for(Producto p : inventario.getLista()){

            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getCodigo(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getPrecio(),
                    p.getStock()
            });
        }
    }

    private void cargarDatosSeleccionados(){

        int fila = vista.tabla.getSelectedRow();

        if(fila == -1) return;

        Producto p = inventario.getLista().get(fila);

        vista.txtNombre.setText(p.getNombre());
        vista.txtVenta.setText(String.valueOf(p.getPrecio()));
        vista.txtStock.setText(String.valueOf(p.getStock()));
        vista.comboCategoria.setSelectedItem(p.getCategoria());

        try{
            ImageIcon icono = new ImageIcon(p.getImagen());

            if(icono.getIconWidth() == -1){
                vista.lblImagen.setIcon(null);
                return;
            }

            Image img = icono.getImage().getScaledInstance(120,120,Image.SCALE_SMOOTH);

            vista.lblImagen.setIcon(new ImageIcon(img));

        }catch(Exception e){
            vista.lblImagen.setIcon(null);
        }
    }

    private void guardar(){

        try{

            int id = inventario.generarId();
            String codigo = "P" + id;

            String nombre = vista.txtNombre.getText();
            String categoria = vista.comboCategoria.getSelectedItem().toString();
            double precio = Double.parseDouble(vista.txtVenta.getText());
            int stock = Integer.parseInt(vista.txtStock.getText());

            String imagen = "imagenes/default.png";

            Producto p = crearProducto(id,codigo,nombre,categoria,precio,stock,imagen);

            inventario.agregar(p);

            archivo.guardar(inventario.getLista());

            cargarTabla();
            limpiar();

            JOptionPane.showMessageDialog(vista,"Producto guardado");

        }catch(Exception e){
            JOptionPane.showMessageDialog(vista,"Error al guardar");
        }
    }

    private Producto crearProducto(int id, String codigo, String nombre,
                                   String categoria, double precio, int stock, String imagen){

        switch(categoria){

            case "Abarrotes":
                return new ProductoAbarrote(id,codigo,nombre,precio,stock,imagen);

            case "Bebidas":
                return new ProductoBebida(id,codigo,nombre,precio,stock,imagen);

            case "Lácteos":
                return new ProductoLacteo(id,codigo,nombre,precio,stock,imagen);

            case "Frutas y Verduras":
                return new ProductoFrutaVerdura(id,codigo,nombre,precio,stock,imagen);

            case "Carnes y Pescados":
                return new ProductoCarne(id,codigo,nombre,precio,stock,imagen);

            case "Limpieza":
                return new ProductoLimpieza(id,codigo,nombre,precio,stock,imagen);

            case "Cuidado Personal":
                return new ProductoCuidadoPersonal(id,codigo,nombre,precio,stock,imagen);

            case "Snacks":
                return new ProductoSnack(id,codigo,nombre,precio,stock,imagen);

            case "Mascotas":
                return new ProductoMascota(id,codigo,nombre,precio,stock,imagen);
        }

        return null;
    }

    private void limpiar(){

        vista.txtNombre.setText("");
        vista.txtVenta.setText("");
        vista.txtStock.setText("");
        vista.lblImagen.setIcon(null);
    }

    private void reporteGeneral(){

        reporte.generarReporteGeneral(inventario.getLista());
        JOptionPane.showMessageDialog(vista,"Reporte generado");
    }

    private void reporteCategoria(){

        String categoria = vista.comboCategoria.getSelectedItem().toString();

        reporte.generarPorCategoria(inventario.getLista(), categoria);

        JOptionPane.showMessageDialog(vista,"Reporte por categoría generado");
    }
}