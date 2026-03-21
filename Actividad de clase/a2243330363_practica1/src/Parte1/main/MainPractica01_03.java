package Parte1.main;

import javax.swing.SwingUtilities;
import Parte1.vista.Practica01_03_View;

public class MainPractica01_03 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Practica01_03_View().setVisible(true);
        });
    }
}