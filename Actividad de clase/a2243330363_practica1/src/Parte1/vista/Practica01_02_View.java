package Parte1.vista;

import javax.swing.*;
import java.awt.*;

public class Practica01_02_View extends JWindow {

    public Practica01_02_View() {

        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel etiqueta = new JLabel("Soy un JWindow", JLabel.CENTER);
        add(etiqueta, BorderLayout.CENTER);
    }
}