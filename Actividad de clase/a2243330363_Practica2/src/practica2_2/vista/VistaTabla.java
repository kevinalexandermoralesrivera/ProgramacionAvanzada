package practica2_2.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaTabla extends JFrame {

    public JTextField txtNom = new JTextField(8);
    public JTextField txtPre = new JTextField(5);
    public JButton btn = new JButton("Agregar");

    public DefaultTableModel modelo =
        new DefaultTableModel(new String[]{"Nombre","Precio"},0);

    public JTable tabla = new JTable(modelo);

    public VistaTabla(){
        setTitle("Practica2_2");
        setSize(400,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(txtNom);
        add(txtPre);
        add(btn);
        add(new JScrollPane(tabla));
    }
}