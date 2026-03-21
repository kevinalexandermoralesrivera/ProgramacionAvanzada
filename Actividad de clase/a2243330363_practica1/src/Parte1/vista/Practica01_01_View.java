package Parte1.vista;

import javax.swing.*;
import java.awt.*;

public class Practica01_01_View extends JFrame {

    public Practica01_01_View() {

        setTitle("Practica 01_01 - JFrame");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel etiqueta = new JLabel("Soy un JFrame", JLabel.CENTER);
        add(etiqueta, BorderLayout.CENTER);
    }
}