package Parte1.controlador;

import Parte1.vista.Practica02_b2_View;

public class Practica02_b2_Controller {

    private Practica02_b2_View vista;

    public Practica02_b2_Controller(Practica02_b2_View vista) {

        this.vista = vista;

        this.vista.botonSalir.addActionListener(e -> salir());
    }

    private void salir() {
        System.exit(0);
    }
}