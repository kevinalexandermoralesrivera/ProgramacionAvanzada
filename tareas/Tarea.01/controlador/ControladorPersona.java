package controlador;

import modelo.Persona;
import Vista.VistaPersona;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPersona {

    private VistaPersona vista;

    public ControladorPersona(VistaPersona vista) {
        this.vista = vista;

        this.vista.btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });
    }

    private void agregarPersona() {

        String nombre = vista.txtNombre.getText();
        String ocupacion = vista.txtOcupacion.getText();
        String edad = vista.listaEdad.getSelectedValue();
        String empleo = vista.comboEmpleo.getSelectedItem().toString();
        boolean ciudadano = vista.chkCiudadano.isSelected();
        String tax = vista.txtTax.getText();
        String genero = vista.rbHombre.isSelected() ? "Hombre" : "Mujer";

        Persona p = new Persona(
                nombre, ocupacion, edad,
                empleo, ciudadano, tax, genero
        );

        vista.areaTexto.append(p.mostrarDatos());
    }
}
