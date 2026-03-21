package controlador;

import modelo.Inventario;
import modelo.Producto;
import persistencia.ArchivoCSV;
import vista.VistaInventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControladorInventario {

    private VistaInventario vista;
    private Inventario inventario;
    private ArchivoCSV archivo;

    public ControladorInventario(VistaInventario vista, Inventario inventario) {

        this.vista = vista;
        this.inventario = inventario;
        this.archivo = new ArchivoCSV();

        eventos();
        listar();
    }

    private void eventos(){

        vista.buscar.addActionListener(e -> buscar());
        vista.eliminar.addActionListener(e -> eliminar());
        vista.modificar.addActionListener(e -> modificar());
        vista.limpiar.addActionListener(e -> limpiarCampos());
    }

    private void listar(){

        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for(Producto p : inventario.getListaProductos()){

            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getStock(),
                    p.getPrecioVenta(),
                    p.isEstado() ? "Disponible":"Agotado"
            });

        }
    }

    private void buscar(){

        try{

            int id = Integer.parseInt(vista.txtId.getText());

            Producto p = inventario.buscar(id);

            if(p == null){

                JOptionPane.showMessageDialog(null,"Producto no encontrado");
                return;

            }

            vista.txtNombre.setText(p.getNombre());
            vista.comboTipo.setSelectedItem(p.getCategoria());

            if(p.isEstado()) vista.rDisponible.setSelected(true);
            else vista.rAgotado.setSelected(true);

        }catch(Exception e){

            JOptionPane.showMessageDialog(null,"ID inválido");

        }
    }

    private void modificar(){

        try{

            int id = Integer.parseInt(vista.txtId.getText());

            String nombre = vista.txtNombre.getText();

            String categoria = vista.comboTipo.getSelectedItem().toString();

            boolean estado = vista.rDisponible.isSelected();

            Producto nuevo = new Producto(id,"P"+id,nombre,categoria,0,0,estado);

            if(inventario.actualizar(nuevo)){

                archivo.exportarCSV(inventario.getListaProductos());

                listar();

                limpiarCampos();

                JOptionPane.showMessageDialog(null,"Producto actualizado");

            }else{

                JOptionPane.showMessageDialog(null,"Producto no encontrado");

            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(null,"Error al modificar");

        }
    }

    private void eliminar(){

        try{

            int id = Integer.parseInt(vista.txtId.getText());

            int confirm = JOptionPane.showConfirmDialog(null,"¿Eliminar producto?","Confirmación",JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION){

                if(inventario.eliminar(id)){

                    archivo.exportarCSV(inventario.getListaProductos());

                    listar();

                    limpiarCampos();

                    JOptionPane.showMessageDialog(null,"Producto eliminado");

                }else{

                    JOptionPane.showMessageDialog(null,"Producto no encontrado");

                }

            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(null,"Error al eliminar");

        }
    }

    private void limpiarCampos(){

        vista.txtId.setText("");
        vista.txtNombre.setText("");
        vista.rTodos.setSelected(true);

    }
}