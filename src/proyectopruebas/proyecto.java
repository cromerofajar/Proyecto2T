package proyectopruebas;

import Excepciones.NoUsuarios;
import Utilidades.PedirDatos;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class proyecto {

    public static void main(String[] args) throws NoUsuarios, IOException {
        ArrayList<Usuario> tusDatos = new ArrayList<>();
        ArrayList<Rivales> tusRivales = new ArrayList<>();
        ArrayList<Partida> tusPartidas = new ArrayList<>();
        Metodos obxm = new Metodos();
        Partida obx = new Partida();
        Rivales obxR = new Rivales();
        File f=null;
        int opciones; //variable de tipo int.
        
        do { //Bucle do while que realiza la funcion de menu del programa
            opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "*****Introduzca el numero que corresponda con su eleccion*****\n\n1ºAcceder usuario\n2ºVer usuarios conectados\n3ºBorrar datos guardados de usuario y cerrar su sesion\n4ºCrear rivales\n5ºCalcular elo partida\n6ºVer Ultima Partida Guardada de un jugador\n7ºSalir")); //Asignacion de la variable opciones, a la vez hace la funcion de texto del menu.
            switch (opciones) { //Switch case que realiza las funcion de menu
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
                    f=new File(nombre);
                    obx.verUltimaPartidaguardada(f);
                    break;
                case 7:
                    String salir=PedirDatos.texto("Desea salir?");
                    
                    if(salir.equalsIgnoreCase("si")){
                        System.exit(0);
                    }
                    else{
                        break;
                    }
            }
        }while(opciones!=0); //fin del bucle do while
    
    }
}