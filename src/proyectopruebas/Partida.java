package proyectopruebas;

import Utilidades.PedirDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void resultadoPartida(ArrayList<Rivales> riv, ArrayList<Usuario> tusDatos, ArrayList<Partida> part) {
        int opciones=0;
        String tuRango = null;
        int tuElo = 0;
        String comprobante;
        int puntF, puntV, puntA, puntM, puntAs, puntT = 0;
        for (Usuario datos : tusDatos) {
            tuElo = datos.getElo();
            tuRango = datos.getRango();
        }
        Partida parti = new Partida();
        parti.setResultado(PedirDatos.texto("Introduzca victoria o derrota"));
        comprobante = parti.getResultado().toLowerCase();
        while (!comprobante.equals("victoria") && !comprobante.equals("derrota")) {
            parti.setResultado(PedirDatos.texto("Introduzca victoria o derrota"));
            comprobante = parti.getResultado().toLowerCase();
            System.out.println(comprobante);
        }
        parti.setMinions(PedirDatos.entero("Introduzca su farmeo"));
        parti.setVision(PedirDatos.entero("Introduzca sus puntos de vision"));
        parti.setAsesinatos(PedirDatos.entero("Introduzca sus asesinatos"));
        parti.setMuertes(PedirDatos.entero("Introduzca sus muertes"));
        parti.setAsistencias(PedirDatos.entero("Introduzca sus asistencias"));
        part.add(parti);
        puntF = obx.mediaFarmeo(part, riv);
        puntV = obx.mediaVision(part, riv);
        puntA = obx.mediaAsesinatos(part, riv);
        puntM = obx.mediaMuertes(part, riv);
        puntAs = obx.mediaAsistencias(part, riv);
        puntT = puntF + puntV + puntA + puntM + puntAs;

        if (comprobante.equals("victoria")) {
            JOptionPane.showMessageDialog(null, "Resultado\nTu elo a subido en: " + puntT);
            tuElo = tuElo + puntT;
            for (Usuario datos : tusDatos) {
                datos.setElo(tuElo);
            }
        } else {
            puntT = 20 - puntT;
            JOptionPane.showMessageDialog(null, "Resultado\nTu elo a bajado en: " + puntT);
        }
        do {
            try {
                opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "*****Quiere guardar la partida?*****\n1ºSi\n2ºNo\nPulse el numero indicado segun su preferencia"));
                switch (opciones) {
                    case 1:
                       PrintWriter fich = null;
                        String nom = "ultima";
                        String nombre=PedirDatos.texto("Nombre del usuario que jugo la partida");

                        if (tusDatos.isEmpty() == true) {
                            JOptionPane.showMessageDialog(null, "No existen usuarios");
                        } else {
                            
                            fich = new PrintWriter(new FileWriter(nombre+nom + ".txt"));
                            for (Usuario al : tusDatos) {
                                System.out.println(al);
                                if(nombre.equals(al.nombre)){
                                        
                                        fich.println(al);
                                        fich.println(parti);
                                        fich.close();
                                }
                            }
                        }
                        
                        opciones=2;
                        break;
                        case 2:
                            opciones=2;
                }
            } catch (IOException ex) {
                Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (opciones != 2);

    }
    @Override
    public void verUltimaPartidaguardada(File fich){
        try {
            Scanner sc = new Scanner(fich);
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String toString() {
        return "\nPartida" + "\nresultado=" + resultado + "\nfarmeo=" + farmeo + "\nvision=" + vision + "\nasesinatos=" + asesinatos + "\nmuertes=" + muertes + "\nasistencias=" + asistencias;
    } 
}
