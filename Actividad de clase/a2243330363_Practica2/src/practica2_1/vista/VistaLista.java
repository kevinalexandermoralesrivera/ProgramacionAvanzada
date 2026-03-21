package practica2_1.vista;

import javax.swing.*;
import java.awt.*;

public class VistaLista extends JFrame {

    public JTextField txtInsumo = new JTextField(15);
    public JButton btnAgregar = new JButton("Agregar");
    public JButton btnGuardar = new JButton("Guardar TXT");
    public DefaultListModel<String> modelo = new DefaultListModel<>();
    public JList<String> lista = new JList<>(modelo);

    public VistaLista(){
        setTitle("Practica01");
        setSize(300,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(txtInsumo);
        add(btnAgregar);
        add(new JScrollPane(lista));
        add(btnGuardar);
    }
}