package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaInventario extends JInternalFrame {

    public JTextField txtId;
    public JTextField txtNombre;
    public JComboBox<String> comboTipo;

    public JRadioButton rTodos;
    public JRadioButton rDisponible;
    public JRadioButton rAgotado;

    public JButton buscar;
    public JButton limpiar;

    public JButton nuevo;
    public JButton modificar;
    public JButton eliminar;

    public JTable tabla;
    public DefaultTableModel modelo;

    public VistaInventario() {

        setTitle("Inventario");
        setSize(900,500);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setLayout(new BorderLayout());

        // PANEL FILTROS
        JPanel filtros = new JPanel();
        filtros.setBorder(BorderFactory.createTitledBorder("Filtros y Búsqueda"));
        filtros.setLayout(new GridLayout(6,2));

        txtId = new JTextField();
        txtNombre = new JTextField();

        comboTipo = new JComboBox<>();
        comboTipo.addItem("Todos");
        comboTipo.addItem("Electrónica");
        comboTipo.addItem("Ropa");

        rTodos = new JRadioButton("Todos", true);
        rDisponible = new JRadioButton("Disponible");
        rAgotado = new JRadioButton("Agotado");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rTodos);
        grupo.add(rDisponible);
        grupo.add(rAgotado);

        buscar = new JButton("Buscar");
        limpiar = new JButton("Limpiar Filtros");

        filtros.add(new JLabel("ID:"));
        filtros.add(txtId);

        filtros.add(new JLabel("Nombre:"));
        filtros.add(txtNombre);

        filtros.add(new JLabel("Tipo:"));
        filtros.add(comboTipo);

        filtros.add(rTodos);
        filtros.add(rDisponible);
        filtros.add(rAgotado);

        filtros.add(buscar);
        filtros.add(limpiar);

        // TABLA INVENTARIO

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder("Vista de Inventario"));
        panelTabla.add(scroll);

        // BOTONES ACCIONES

        JPanel acciones = new JPanel();

        acciones.setBorder(BorderFactory.createTitledBorder("Acciones de Selección"));

        nuevo = new JButton("Crear Nuevo");
        modificar = new JButton("Modificar");
        eliminar = new JButton("Eliminar");

        acciones.add(nuevo);
        acciones.add(modificar);
        acciones.add(eliminar);

        add(filtros, BorderLayout.WEST);
        add(panelTabla, BorderLayout.CENTER);
        add(acciones, BorderLayout.SOUTH);
    }
}