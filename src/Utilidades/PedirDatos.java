package Utilidades;

import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class PedirDatos {
    
    public static int entero(String mensaje){
        return Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
    }

    public static String texto(String mensaje) {
        return JOptionPane.showInputDialog(null,mensaje);
    }
    
    
    
}
