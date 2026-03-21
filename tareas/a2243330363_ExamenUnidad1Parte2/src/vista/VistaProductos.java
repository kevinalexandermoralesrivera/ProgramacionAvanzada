package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaProductos extends JInternalFrame {

    public JTextField txtNombre;
    public JTextField txtVenta;
    public JTextField txtStock;

    public JComboBox<String> comboCategoria;

    public JLabel lblImagen;

    public JButton guardar;
    public JButton limpiar;

    public JButton btnReporteGeneral;
    public JButton btnReporteCategoria;

    public JTable tabla;

    public VistaProductos(){

        super("Productos", true, true, true, true);

        setSize(950,550);
        setLayout(new BorderLayout());

        // 🔹 PANEL IZQUIERDO (FORMULARIO)
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        txtNombre = new JTextField(12);
        txtVenta = new JTextField(8);
        txtStock = new JTextField(8);

        comboCategoria = new JComboBox<>(new String[]{
                "Abarrotes","Bebidas","Lácteos",
                "Frutas y Verduras","Carnes y Pescados",
                "Limpieza","Cuidado Personal",
                "Snacks","Mascotas"
        });

        // 🖼️ IMAGEN
        lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(120,120));
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        guardar = new JButton("Guardar");
        limpiar = new JButton("Limpiar");

        btnReporteGeneral = new JButton("Reporte General");
        btnReporteCategoria = new JButton("Reporte Categoría");

        c.gridx=0;c.gridy=0;
        form.add(new JLabel("Nombre:"),c);

        c.gridx=1;
        form.add(txtNombre,c);

        c.gridx=0;c.gridy=1;
        form.add(new JLabel("Categoría:"),c);

        c.gridx=1;
        form.add(comboCategoria,c);

        c.gridx=0;c.gridy=2;
        form.add(new JLabel("Precio:"),c);

        c.gridx=1;
        form.add(txtVenta,c);

        c.gridx=0;c.gridy=3;
        form.add(new JLabel("Stock:"),c);

        c.gridx=1;
        form.add(txtStock,c);

        c.gridx=0;c.gridy=4;c.gridwidth=2;
        form.add(lblImagen,c);

        c.gridy=5;c.gridwidth=1;
        form.add(guardar,c);

        c.gridx=1;
        form.add(limpiar,c);

        c.gridx=0;c.gridy=6;c.gridwidth=2;
        form.add(btnReporteGeneral,c);

        c.gridy=7;
        form.add(btnReporteCategoria,c);

        // 🔹 TABLA
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        panelTabla.add(scroll);

        add(form,BorderLayout.WEST);
        add(panelTabla,BorderLayout.CENTER);
    }
}