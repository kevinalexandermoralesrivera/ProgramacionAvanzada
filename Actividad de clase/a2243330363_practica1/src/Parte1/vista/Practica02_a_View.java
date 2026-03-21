package Parte1.vista;


import javax.swing.*;
import java.awt.*;

public class Practica02_a_View extends JFrame {
	public JButton boton;
	public JLabel etiqueta;
    public Practica02_a_View() {

        setTitle("Practica 02_a");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton boton = new JButton("Presioname");

        boton.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Botón presionado")
        );

        add(boton);
    }
}