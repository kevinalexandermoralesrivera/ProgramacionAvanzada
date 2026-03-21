package practica2_1.controlador;

import practica2_1.vista.VistaLista;
import java.io.*;

public class ControladorLista {

    VistaLista vista;

    public ControladorLista(VistaLista v){
        this.vista = v;

        vista.btnAgregar.addActionListener(e ->
            vista.modelo.addElement(vista.txtInsumo.getText())
        );

        vista.btnGuardar.addActionListener(e -> guardar());
    }

    private void guardar(){
        try{
            PrintWriter pw = new PrintWriter("insumos.txt");
            for(int i=0;i<vista.modelo.size();i++)
                pw.println(vista.modelo.get(i));
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}