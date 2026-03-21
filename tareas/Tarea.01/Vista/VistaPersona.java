package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaPersona extends JFrame {

    public JTextField txtNombre, txtOcupacion, txtTax;
    public JList<String> listaEdad;
    public JComboBox<String> comboEmpleo;
    public JCheckBox chkCiudadano;
    public JRadioButton rbHombre, rbMujer;
    public JButton btnOk;
    public JTextArea areaTexto;

    public VistaPersona() {

        setTitle("Hola mundo");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     
        JPanel panelIzq = new JPanel();
        panelIzq.setLayout(new BoxLayout(panelIzq, BoxLayout.Y_AXIS));

        txtNombre = new JTextField(10);
        txtOcupacion = new JTextField(10);

        listaEdad = new JList<>(new String[]{
                "Menor 18", "18 a 65", "65 o mas"
        });

        comboEmpleo = new JComboBox<>(new String[]{
                "Empleado", "Autoempleado", "Desempleado"
        });

        chkCiudadano = new JCheckBox("Ciudadano estadounidense");
        txtTax = new JTextField(10);

        rbHombre = new JRadioButton("Hombre", true);
        rbMujer = new JRadioButton("Mujer");

        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(rbHombre);
        grupoGenero.add(rbMujer);

        btnOk = new JButton("OK");

        panelIzq.add(new JLabel("Nombre:"));
        panelIzq.add(txtNombre);
        panelIzq.add(new JLabel("Ocupacion:"));
        panelIzq.add(txtOcupacion);
        panelIzq.add(new JLabel("Edad:"));
        panelIzq.add(new JScrollPane(listaEdad));
        panelIzq.add(new JLabel("Empleo"));
        panelIzq.add(comboEmpleo);
        panelIzq.add(chkCiudadano);
        panelIzq.add(new JLabel("Tax ID:"));
        panelIzq.add(txtTax);
        panelIzq.add(rbHombre);
        panelIzq.add(rbMujer);
        panelIzq.add(btnOk);

    
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        add(panelIzq, BorderLayout.WEST);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
    }
}
