package practica2_3.vista;

import javax.swing.*;
import java.awt.*;

public class VistaLayouts extends JFrame {

    public VistaLayouts(){

        setTitle("Practica2_3 Layout");
        setSize(300,200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JButton("Norte"),BorderLayout.NORTH);
        add(new JButton("Sur"),BorderLayout.SOUTH);
        add(new JButton("Centro"),BorderLayout.CENTER);
    }
}