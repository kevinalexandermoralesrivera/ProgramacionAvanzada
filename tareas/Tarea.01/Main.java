import Vista.VistaPersona;
import controlador.ControladorPersona;

public class Main {
    public static void main(String[] args) {

        VistaPersona vista = new VistaPersona();
        new ControladorPersona(vista);
        vista.setVisible(true);
    }
}
