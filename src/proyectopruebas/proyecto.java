package proyectopruebas;

import Utilidades.PedirDatos;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class proyecto {

    public static void main(String[] args) {
        ArrayList<Usuario> tusDatos = new ArrayList<>();
        ArrayList<Rivales> tusRivales = new ArrayList<>();
        ArrayList<Partida> tusPartidas = new ArrayList<>();
        Metodos obxm = new Metodos();
        Partida obx = new Partida();
        Usuario obxT = new Usuario();
        Rivales obxR = new Rivales();
//        obxR.crearRivalesAleatorio(tusDatos, tusRivales);
//        obx.resultadoPartida(tusRivales, tusDatos, tusPartidas);
        int opciones;
        
        do {
            opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "*****Introduzca el numero que correcponda con su eleccion*****\n\n1ºCrear usuario\n2ºVer usuarios\n3ºBorrar un Usuario por su nombre\n4ºCrear rivales\n5ºCalcular elo partida\n6ºVer Ultima Partida Guardada de un jugador\n7ºSalir"));
            switch (opciones) {
                case 1:
                    obxm.crearUsuario(tusDatos);
                    break;
                case 2:
                    obxm.verUsers(tusDatos);
                    break;
                case 3:
                    String nomeUsuario = JOptionPane.showInputDialog(null, "Ponga el usuario que desea eliminar");
                    obxm.borrarUser(nomeUsuario, tusDatos);
                    break;
                case 4:
                    obxR.crearRivalesAleatorio(tusDatos, tusRivales);
                    JOptionPane.showMessageDialog(null, "Rivales creados con éxito");
                    break;
                case 5:
                    obx.resultadoPartida(tusRivales, tusDatos, tusPartidas);
                    break;
                case 6:
                    String nombre=PedirDatos.texto("Introduce nombre de usuario");
                    nombre=nombre+"ultima.txt";
                    File f=new File(nombre);
                    obx.verUltimaPartidaguardada(f);
                    break;
                case 7:
                    System.exit(0);
            }
        }while(opciones!=0);
    
    }
}