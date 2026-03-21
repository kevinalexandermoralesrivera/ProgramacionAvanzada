package Parte2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Libreria.Archivotxt_Controlador; 
import java.util.ArrayList;

public class Practica03_d_Vista extends JFrame {
 
    private JTextField txtInsumo;
    private JComboBox<String> comboCategoria;
    private JTextArea textArea;
    private Archivotxt_Controlador gestorArchivo;
    private final String RUTA_ARCHIVO = "datos.csv";

    public Practica03_d_Vista() {
        gestorArchivo = new Archivotxt_Controlador();
        
        
        setTitle("Practica 1 - Sistema de Insumos (MVC)");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

    
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panelEntrada.add(new JLabel("Nombre del Insumo:"));
        txtInsumo = new JTextField();
        panelEntrada.add(txtInsumo);

        panelEntrada.add(new JLabel("Categoría:"));
        comboCategoria = new JComboBox<>(new String[]{"Papelería", "Cómputo", "Limpieza"});
        
      
        this.comboCategoria.setEnabled(true);
        this.comboCategoria.setSelectedIndex(0); 
        panelEntrada.add(comboCategoria);

      
        JButton btnGuardar = new JButton("Guardar ");
        btnGuardar.setMnemonic(KeyEvent.VK_G); 
        panelEntrada.add(btnGuardar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setMnemonic(KeyEvent.VK_S);
        panelEntrada.add(btnSalir);

        add(panelEntrada, BorderLayout.NORTH);

       
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll, BorderLayout.CENTER);

     
        btnGuardar.addActionListener(e -> {
            String nombre = txtInsumo.getText();
            String cat = comboCategoria.getSelectedItem().toString();
            
            if(!nombre.isEmpty()) {
                Insumo_Modelo nuevoInsumo = new Insumo_Modelo(nombre, cat);
                gestorArchivo.guardar(RUTA_ARCHIVO, nuevoInsumo.toCSV(), true);
                txtInsumo.setText("");
                actualizarVista();
            }
        });

       
        btnSalir.addActionListener(e -> System.exit(0));

       
        actualizarVista();
    }

   
    private void actualizarVista() {
        textArea.setText("--- REGISTROS ACTUALES ---\n");
        ArrayList<String> datos = gestorArchivo.leer(RUTA_ARCHIVO);
        for (String linea : datos) {
            textArea.append(linea.replace(",", " - ") + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Practica03_d_Vista().setVisible(true));
    }
}