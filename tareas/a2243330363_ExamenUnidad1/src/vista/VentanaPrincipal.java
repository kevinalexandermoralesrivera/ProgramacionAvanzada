package vista;

import controlador.ControladorInventario;
import controlador.ControladorProductos;
import controlador.ControladorPuntoVenta;
import modelo.Inventario;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public JDesktopPane desktop;

    private JMenuItem abrirInventario;
    private JMenuItem abrirProductos;
    private JMenuItem abrirVentas;

    private Inventario inventario;

    public VentanaPrincipal(Inventario inventario){

        this.inventario = inventario;

        setTitle("Sistema de Inventario y Punto de Venta");
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

        abrirInventario = new JMenuItem("Inventario");
        abrirProductos = new JMenuItem("Productos");
        abrirVentas = new JMenuItem("Punto de Venta");

        menu.add(abrirInventario);
        menu.add(abrirProductos);
        menu.add(abrirVentas);

        barra.add(menu);

        setJMenuBar(barra);

        abrirInventario.addActionListener(e -> abrirInventario());

        abrirProductos.addActionListener(e -> abrirProductos());

        abrirVentas.addActionListener(e -> abrirVentas());

    }

    private void abrirInventario(){

        VistaInventario vi = new VistaInventario();

        desktop.add(vi);

        vi.setVisible(true);

        new ControladorInventario(vi,inventario);

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