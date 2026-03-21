package Parte1.controlador;

import Parte1.vista.Practica02_a_View;
import javax.swing.JOptionPane;

public class Practica02_a_Controller {

    private Practica02_a_View vista;

    public Practica02_a_Controller(Practica02_a_View vista) {

        this.vista = vista;

        this.vista.boton.addActionListener(e -> mostrarMensaje());
    }

    private void mostrarMensaje() {
        JOptionPane.showMessageDialog(vista,
                "Botón presionado");
    }
}