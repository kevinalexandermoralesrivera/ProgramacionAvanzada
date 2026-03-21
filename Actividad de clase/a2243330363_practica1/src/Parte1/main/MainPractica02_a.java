package Parte1.main;

import javax.swing.SwingUtilities;
import Parte1.vista.Practica02_a_View;

public class MainPractica02_a {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Practica02_a_View().setVisible(true);
        });
    }
}