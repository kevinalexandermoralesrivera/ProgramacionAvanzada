package Parte1.vista;

import javax.swing.*;
import java.awt.*;

public class Practica02_b2_View extends JFrame {

    public JButton botonSalir;

    public Practica02_b2_View() {

        setTitle("Practica02_b2 - MVC");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        botonSalir = new JButton("Salir");
        botonSalir.setMnemonic('S');

        add(botonSalir);
    }
}