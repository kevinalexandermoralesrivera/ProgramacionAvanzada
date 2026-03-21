package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaProductos extends JInternalFrame {

    public JTextField txtId;
    public JTextField txtNombre;
    public JTextArea txtDescripcion;
    public JComboBox<String> comboCategoria;
    public JTextField txtCompra;
    public JTextField txtVenta;
    public JTextField txtStock;

    public JRadioButton activo;
    public JRadioButton desactivado;

    public JTable tabla;

    public JButton guardar;
    public JButton limpiar;

    public VistaProductos() {

        super("Productos", true, true, true, true);
        setSize(900,500);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Alta y Edición"));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        txtId = new JTextField(10);
        txtId.setEnabled(false);

        txtNombre = new JTextField(15);
        txtDescripcion = new JTextArea(3,15);

        comboCategoria = new JComboBox<>(new String[]{"Electrónica","Ropa","Comida"});

        txtCompra = new JTextField(8);
        txtVenta = new JTextField(8);
        txtStock = new JTextField(8);

        activo = new JRadioButton("Activo");
        desactivado = new JRadioButton("Desactivado");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(activo);
        grupo.add(desactivado);

        guardar = new JButton("Guardar Cambios");
        limpiar = new JButton("Limpiar");

        c.gridx=0;c.gridy=0;
        panelFormulario.add(new JLabel("Nombre Producto:"),c);

        c.gridx=1;
        panelFormulario.add(txtNombre,c);

        c.gridx=0;c.gridy=1;
        panelFormulario.add(new JLabel("Descripción:"),c);

        c.gridx=1;
        panelFormulario.add(new JScrollPane(txtDescripcion),c);

        c.gridx=0;c.gridy=2;
        panelFormulario.add(new JLabel("Categoría:"),c);

        c.gridx=1;
        panelFormulario.add(comboCategoria,c);

        c.gridx=0;c.gridy=3;
        panelFormulario.add(new JLabel("Precio Compra:"),c);

        c.gridx=1;
        panelFormulario.add(txtCompra,c);

        c.gridx=0;c.gridy=4;
        panelFormulario.add(new JLabel("Precio Venta:"),c);

        c.gridx=1;
        panelFormulario.add(txtVenta,c);

        c.gridx=0;c.gridy=5;
        panelFormulario.add(new JLabel("Stock:"),c);

        c.gridx=1;
        panelFormulario.add(txtStock,c);

        c.gridx=0;c.gridy=6;
        panelFormulario.add(activo,c);

        c.gridx=1;
        panelFormulario.add(desactivado,c);

        c.gridx=0;c.gridy=7;
        panelFormulario.add(guardar,c);

        c.gridx=1;
        panelFormulario.add(limpiar,c);

        add(panelFormulario,BorderLayout.WEST);

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Stock");
        modelo.addColumn("P.Venta");
        modelo.addColumn("Estado");

        tabla = new JTable(modelo);

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder("Catálogo de Productos"));

        panelTabla.add(new JScrollPane(tabla),BorderLayout.CENTER);

        add(panelTabla,BorderLayout.CENTER);
    }
}