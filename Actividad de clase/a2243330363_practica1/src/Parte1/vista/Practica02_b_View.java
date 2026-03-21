package Parte1.vista;

import javax.swing.*;
import java.awt.*;

public class Practica02_b_View extends JFrame {
	public JButton boton;
	public JLabel etiqueta;
    public Practica02_b_View() {

        setTitle("Practica 02_b");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel etiqueta = new JLabel("Texto original");
        JButton boton = new JButton("Cambiar texto");

        boton.addActionListener(e ->
            etiqueta.setText("Texto cambiado")
        );

        add(etiqueta);
        add(boton);
    }
}