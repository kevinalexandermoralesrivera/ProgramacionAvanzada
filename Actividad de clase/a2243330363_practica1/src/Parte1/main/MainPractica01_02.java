package Parte1.main;

import javax.swing.SwingUtilities;
import Parte1.vista.Practica01_02_View;

public class MainPractica01_02 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Practica01_02_View().setVisible(true);
        });
    }
}