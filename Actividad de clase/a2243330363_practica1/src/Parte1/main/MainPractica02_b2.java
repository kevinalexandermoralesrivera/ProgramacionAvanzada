package Parte1.main;

import javax.swing.SwingUtilities;
import Parte1.vista.Practica02_b2_View;

public class MainPractica02_b2 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Practica02_b2_View().setVisible(true);
        });
    }
}