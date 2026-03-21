package Parte1.controlador;

import Parte1.vista.Practica02_b_View;

public class Practica02_b_Controller {

    private Practica02_b_View vista;

    public Practica02_b_Controller(Practica02_b_View vista) {

        this.vista = vista;

        this.vista.boton.addActionListener(e -> cambiarTexto());
    }

    private void cambiarTexto() {
        vista.etiqueta.setText("Texto cambiado");
    }
}