package Parte1.vista;

import javax.swing.*;
import java.awt.*;

public class Practica01_03_View extends JDialog {

    public Practica01_03_View() {

        setTitle("Practica 01_03 - JDialog");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setModal(true);
        setLayout(new BorderLayout());

        JLabel etiqueta = new JLabel("Soy un JDialog", JLabel.CENTER);
        add(etiqueta, BorderLayout.CENTER);
    }
}