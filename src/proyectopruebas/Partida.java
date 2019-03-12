package proyectopruebas;

import Utilidades.PedirDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class Partida implements ObligatorioPartida{

    String resultado;
    int farmeo, vision, asesinatos, muertes, asistencias;

    Metodos obx = new Metodos();
    Rivales riva = new Rivales();
    Usuario user = new Usuario();

    public Partida() {

    }

    public Partida(String resultado, int minions, int vision, int asesinatos, int muertes, int asistencias) {
        this.resultado = resultado;
        this.farmeo = minions;
        this.vision = vision;
        this.asesinatos = asesinatos;
        this.muertes = muertes;
        this.asistencias = asistencias;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setMinions(int minions) {
        this.farmeo = minions;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public void setAsesinatos(int asesinatos) {
        this.asesinatos = asesinatos;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public String getResultado() {
        return resultado;
    }

    public int getMinions() {
        return farmeo;
    }

    public int getVision() {
        return vision;
    }

    public int getAsesinatos() {
        return asesinatos;
    }

    public int getMuertes() {
        return muertes;
    }

    public int getAsistencias() {
        return asistencias;
    }
    @Override
    public void resultadoPartida(ArrayList<Rivales> riv, ArrayList<Usuario> tusDatos, ArrayList<Partida> part) throws Excepciones.NoUsuarios{ //Metodo que nos calcula la puntuacion de la partida que recive los ArrayList de tipo Rivales, Usuario y Partida.
        int opciones=0; //Variable numerica empleada en el switch case de guardar partida.
        int tuElo = 0; //Variable numerica que lleva tu Elo y usada para calcular tu resultado final.
        String comprobante; //Variable de texto usada para el selector de victoria/derrota.
        int puntF, puntV, puntA, puntM, puntAs, puntT = 0; //Variables numericas de puntuación usadas para calcular la perdida o ganancia de Elo.
        String nombre=PedirDatos.texto("Nombre del usuario que jugo la partida"); //Variable de texto usada para el guardado de archivos.
        for (Usuario datos : tusDatos) { //Bucle for que asigna tu Elo de ese momento a la variable tuElo.
            if(datos.getNombre().equals(nombre)){
            tuElo = datos.getElo();
            }
        }
        
        Partida parti = new Partida(); //Creacion de un objeto tipo Partida para la asignacion de los valores de la partida.
        parti.setResultado(PedirDatos.texto("Introduzca victoria o derrota")); //Asignacion de valor derrota o victoria al resultado de la partida
        comprobante = parti.getResultado().toLowerCase();// Asignacion a comprobante del resultado de la la partida usando toLowerCase para asegurarnos de que quede en minuscula
        while (!comprobante.equals("victoria") && !comprobante.equals("derrota")) {//Bucle While que se asegura de que se introduzca victoria o derrota y en caso de introducir otra cosa nos pide una nueva introduccion de datos
            parti.setResultado(PedirDatos.texto("Introduzca victoria o derrota"));
            comprobante = parti.getResultado().toLowerCase();
        }
        parti.setMinions(PedirDatos.entero("Introduzca su farmeo")); //Introducir el farmeo de la partida a la variable Minions
        parti.setVision(PedirDatos.entero("Introduzca sus puntos de vision")); //Introducir los puntos de vision a la variable Vision
        parti.setAsesinatos(PedirDatos.entero("Introduzca sus asesinatos")); //Introducir los asesinatos a la variable Asesinatos
        parti.setMuertes(PedirDatos.entero("Introduzca sus muertes")); //Introducir las muertes a la variable Muertes
        parti.setAsistencias(PedirDatos.entero("Introduzca sus asistencias")); //Introducir las asistencias a la variable Asistencias
        part.add(parti); //Añadimos todo esto al ArrayList de Partida
        puntF = obx.mediaFarmeo(part, riv); //Calcula de la puntuacion por Farmeo llamando a la clase metodos y pasandole el ArrayList de Partida y el de los rivales
        puntV = obx.mediaVision(part, riv); //Calcula de la puntuacion por Vision llamando a la clase metodos y pasandole el ArrayList de Partida y el de los rivales
        puntA = obx.mediaAsesinatos(part, riv); //Calcula de la puntuacion por Asesinatos llamando a la clase metodos y pasandole el ArrayList de Partida y el de los rivales
        puntM = obx.mediaMuertes(part, riv); //Calcula de la puntuacion por Muertes llamando a la clase metodos y pasandole el ArrayList de Partida y el de los rivales
        puntAs = obx.mediaAsistencias(part, riv); //Calcula de la puntuacion por Asistencias llamando a la clase metodos y pasandole el ArrayList de Partida y el de los rivales
        puntT = puntF + puntV + puntA + puntM + puntAs; //Suma de las puntuaciones obtenidas.

        if (comprobante.equals("victoria")) { //If con condicion de que la variable comprobante sea igual a victoria.
            JOptionPane.showMessageDialog(null, "Resultado\nTu elo a subido en: " + puntT); //Mensaje que muestra la puntuacion ganada en esa partida.
            tuElo = tuElo + puntT; //Suma del elo actual mas la puntuacion obtenida.
            for (Usuario datos : tusDatos) { //Bucle for each del ArrayList de Usuario.
                if(datos.getNombre().equals(nombre)){ //If que busca en el ArrayList el nombre de Usuario que corresponda al del jugador de la partida.
                datos.rangElo(tuElo); //Asignacion del nuevo elo al usuario
                }
            }
        } else{
            puntT = 20 - puntT; //Como la puntuacion maxima a obtener es 20 le restamos la puntuacion obtenida en esa partida en caso de una partida mejor que la media del equipo rival no se perdera puntuacion.
            JOptionPane.showMessageDialog(null, "Resultado\nTu elo a bajado en: " + puntT); //Mensaje que muestra la puntuacion oerdida en esa partida.
            tuElo=tuElo-puntT; //Resta del elo actual menos la puntuacion obtenida.
            for (Usuario datos : tusDatos) { //Bucle for each del ArrayList de Usuario.
                if(datos.getNombre().equals(nombre)){ //If que busca en el ArrayList el nombre de Usuario que corresponda al del jugador de la partida.
                datos.rangElo(tuElo); //Asignacion del nuevo elo al usuario.
                }
            }
        }
        do { //Bucle do while empleado para el guardado de la partida.
            try { //try catch que trata la excepcion de que no exista el fichero.
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "*****Quiere guardar la partida?*****\n1ºSi\n2ºNo\nPulse el numero indicado segun su preferencia")); //Selector de la opción de guardado o no de la partida
                switch (opciones) { //switch case que segun la opcion seleccionada guarda o sale del.
                    case 1:
                       PrintWriter fich = null; //Para poder escribir en el fichero primero creamos una variable fich de tipo PrintWriter.
                        final String nom = "ultima"; //Variable final de tipo String con el valor ultima.
                        

                        if (tusDatos.isEmpty() == true) { //If que en caso de no tener usuarios no permitira guardar la partida.
                            throw new Excepciones.NoUsuarios("No hay usuarios para visualizar");
                        } else {
                            for (Usuario al : tusDatos) { //Bucle for each que recorre el ArrayList de Usuarios.
                                if(nombre.equals(al.nombre)){ //If que en caso de encontrar el nombre de usuario nos guarde la partida.
                                        fich = new PrintWriter(new FileWriter(nombre+nom + ".txt")); //creacion del fichero empleando el nombre de usuario para el String nom.
                                        JOptionPane.showMessageDialog(null,al); //JOptionPane que nos muestra nuestras estadisticas tras la partida.
                                        fich.println(al); //Escritura en el fichero de los datos del usuario.
                                        fich.println(parti.toString()); //Escrtiura den el fcihero de los datos de la partida.
                                        fich.close(); //Cierre del fichero.
                                }
                            }
                        }
                        
                        opciones=2;
                        break;
                        case 2:
                        break;
                }
            } catch (IOException ex) {
                System.out.println("Error de localizacion del fichero"+ex);
            }

        } while (opciones != 2); //Final del bucle do while.

    }
    @Override
    public void verUltimaPartidaguardada(File fich){ //Metodo para ver la ultima partida guarda del usuario del que le pasemos el fichero
        try { //try catch que se encarga de la excepcion de que no exista el fichero seleccionado
            Scanner sc = new Scanner(fich); //Creacion de objeto Scanner con el fichero
            while(sc.hasNextLine()) {//bucle while para visualizar el fichero linea a linea
                System.out.println(sc.nextLine()); //Visualizacion del fichero por consola
            }
            sc.close(); //Cierre del objeto Scanner
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Usuario no existente o no tiene partidas guardadas");
        }
    }
    @Override
    public String toString() { //toString de los datos de la partida.
        return "\nPartida" + resultado + "\nfarmeo=" + farmeo + "\nvision=" + vision + "\nasesinatos=" + asesinatos + "\nmuertes=" + muertes + "\nasistencias=" + asistencias;
    }
}
