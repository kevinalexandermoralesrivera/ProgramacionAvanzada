package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaPuntoVenta extends JInternalFrame {

    public JComboBox<String> comboProductos;
    public JTextField txtCantidad;

    public JTable tabla;

    public JButton agregar;
    public JButton eliminar;
    public JButton procesar;

    public JTextField subtotal;
    public JTextField iva;
    public JTextField total;

    public VistaPuntoVenta(){

        super("Punto de Venta",true,true,true,true);

        setSize(900,500);
        setLayout(new BorderLayout());

        JPanel superior = new JPanel();

        comboProductos = new JComboBox<>();
        txtCantidad = new JTextField(5);

        agregar = new JButton("Añadir a Carrito");
        eliminar = new JButton("Eliminar");

        superior.add(new JLabel("Producto"));
        superior.add(comboProductos);
        superior.add(new JLabel("Cantidad"));
        superior.add(txtCantidad);
        superior.add(agregar);
        superior.add(eliminar);

        add(superior,BorderLayout.NORTH);

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Cod");
        modelo.addColumn("Descripción");
        modelo.addColumn("Cant");
        modelo.addColumn("P.Unit");
        modelo.addColumn("Total");

        tabla = new JTable(modelo);

        add(new JScrollPane(tabla),BorderLayout.CENTER);

        JPanel inferior = new JPanel();

        subtotal = new JTextField(8);
        iva = new JTextField(8);
        total = new JTextField(8);

        procesar = new JButton("Procesar Pago");

        inferior.add(new JLabel("Subtotal"));
        inferior.add(subtotal);

        inferior.add(new JLabel("IVA"));
        inferior.add(iva);

        inferior.add(new JLabel("Total"));
        inferior.add(total);

        inferior.add(procesar);

        add(inferior,BorderLayout.SOUTH);
    }
}