package practica2_2.controlador;

import practica2_2.vista.VistaTabla;

public class ControladorTabla {

    public ControladorTabla(VistaTabla v){

        v.btn.addActionListener(e -> {

            String nom = v.txtNom.getText();
            String pre = v.txtPre.getText();

            v.modelo.addRow(new Object[]{nom,pre});
        });
    }
}