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
        File fich=new File("Usuarios.txt");
        File f=null;
        int opciones; //variable de tipo int.
        
        do { //Bucle do while que realiza la funcion de menu del programa
            opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "*****Introduzca el numero que corresponda con su eleccion*****\n\n1ºAñadir usuario\n2ºVer usuarios\n3ºBorrar un Usuario por su nombre\n4ºCrear rivales\n5ºCalcular elo partida\n6ºVer Ultima Partida Guardada de un jugador\n7ºBorrar todos los Usuarios\n8ºSalir")); //Asignacion de la variable opciones, a la vez hace la funcion de texto del menu.
            switch (opciones) { //Switch case que realiza las funcion de menu
                case 1:
                    obxm.crearUsuario(tusDatos);
                    break;
                case 2:
                    obxm.verUsers(fich);
                    break;
                case 3:
                    String nomeUsuario = JOptionPane.showInputDialog(null, "Ponga el usuario que desea eliminar");
                    String contraseña=PedirDatos.texto("Introduce la contraseña del usuario");
                    obxm.borrarUser(nomeUsuario,contraseña, tusDatos);
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
                    obxm.borrarTUsuarios(fich);
                    break;
                case 8:
                    String salir=PedirDatos.texto("Desea salir?\n Esto borrara todos los ficheros");
                    
                    if(salir.equalsIgnoreCase("si")){
                        for(Usuario user: tusDatos){
                            String borrar=user.nombre+"ultima.txt";
                            f=new File(borrar);
                            f.delete();
                        }
                       fich.delete();
                        System.exit(0);
                    }
                    else{
                        break;
                    }
            }
        }while(opciones!=0); //fin del bucle do while
    
    }
}