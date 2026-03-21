package Parte1.main;

import javax.swing.SwingUtilities;
import Parte1.vista.Practica01_01_View;

public class MainPractica01_01 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Practica01_01_View().setVisible(true);
        });
    }
}