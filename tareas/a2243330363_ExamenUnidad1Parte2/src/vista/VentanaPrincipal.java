package vista;

import controlador.ControladorProductos;
import controlador.ControladorPuntoVenta;
import modelo.Inventario;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public JDesktopPane desktop;

    private JMenuItem abrirProductos;
    private JMenuItem abrirVentas;

    private Inventario inventario;

    public VentanaPrincipal(Inventario inventario){

        this.inventario = inventario;

        setTitle("Sistema Tienda");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktop = new JDesktopPane();

        setLayout(new BorderLayout());
        add(desktop,BorderLayout.CENTER);

        crearMenu();
    }

    private void crearMenu(){

        JMenuBar barra = new JMenuBar();

        JMenu menu = new JMenu("Módulos");

        abrirProductos = new JMenuItem("Productos");
        abrirVentas = new JMenuItem("Punto de Venta");

        menu.add(abrirProductos);
        menu.add(abrirVentas);

        barra.add(menu);

        setJMenuBar(barra);

        abrirProductos.addActionListener(e -> abrirProductos());
        abrirVentas.addActionListener(e -> abrirVentas());
    }

    private void abrirProductos(){

        VistaProductos vp = new VistaProductos();

        desktop.add(vp);
        vp.setVisible(true);

        new ControladorProductos(vp,inventario);
    }

    private void abrirVentas(){

        VistaPuntoVenta vv = new VistaPuntoVenta();

        desktop.add(vv);
        vv.setVisible(true);

        new ControladorPuntoVenta(vv,inventario);
    }
}