package proyectopruebas;

import Utilidades.PedirDatos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cromerofajar
 */
public class Metodos {
    
    public void crearUsuario(ArrayList<Usuario>lista){
        String nombre=PedirDatos.texto("Introduce tu nombre de Usuario");
        String rango=PedirDatos.texto("Introduce tu rango");
        int elo=PedirDatos.entero("Introduce tu elo actual");
        Usuario al= new Usuario(nombre,rango,elo);
        lista.add(al);
    }
    
    
    
    public int mediaFarmeo(ArrayList<Partida>part,ArrayList<Rivales>riv){
        int puntuacion=0;
        int tuFarm=0;
        int diferencia;
        int mediaRivFarm=0;
        for(Partida parti:part){
            tuFarm=parti.getMinions();
        }
        for(Rivales riva:riv){
            mediaRivFarm=mediaRivFarm+riva.getFarmeo();
        }
        mediaRivFarm=mediaRivFarm/5;
        if(tuFarm>mediaRivFarm){
            diferencia=tuFarm-mediaRivFarm;
            if(diferencia>10&&diferencia<20){
                puntuacion=puntuacion+1;
            }
            else if(diferencia>=20&&diferencia<30){
                puntuacion=puntuacion+3;
            }
            else if(diferencia>=30){
                puntuacion=puntuacion+5;
            }
            else{
                puntuacion=0;
            }
        }
        return puntuacion;
    }
    
    public int mediaVision(ArrayList<Partida>part,ArrayList<Rivales>riv){
        int puntuacion=0;
        int tuVision=0;
        int diferencia;
        int mediaRivVision=0;
        for(Partida parti:part){
            tuVision=parti.getVision();
        }
        for(Rivales riva:riv){
            mediaRivVision=mediaRivVision+riva.getVision();
        }
        mediaRivVision=mediaRivVision/5;
        if(tuVision>mediaRivVision){
            diferencia=tuVision-mediaRivVision;
            if(diferencia>10&&diferencia<20){
                puntuacion=puntuacion+1;
            }
            else if(diferencia>=20&&diferencia<30){
                puntuacion=puntuacion+3;
            }
            else if(diferencia>=30){
                puntuacion=puntuacion+5;
            }
            else{
                puntuacion=0;
            }
        }
        return puntuacion;
    }
    
    public int mediaAsesinatos(ArrayList<Partida>part,ArrayList<Rivales>riv){
        int puntuacion=0;
        int tuAsesi=0;
        int diferencia;
        int mediaRivAsesi=0;
        for(Partida parti:part){
            tuAsesi=parti.getAsesinatos();
        }
        for(Rivales riva:riv){
            mediaRivAsesi=mediaRivAsesi+riva.getAsesinatos();
        }
        mediaRivAsesi=mediaRivAsesi/5;
        if(tuAsesi>mediaRivAsesi){
            diferencia=tuAsesi-mediaRivAsesi;
            if(diferencia>2&&diferencia<4){
                puntuacion=puntuacion+1;
            }
            else if(diferencia>=4&&diferencia<5){
                puntuacion=puntuacion+3;
            }
            else if(diferencia>=5){
                puntuacion=puntuacion+5;
            }
            else{
                puntuacion=0;
            }
        }
        return puntuacion;
    }
    public int mediaMuertes(ArrayList<Partida>part,ArrayList<Rivales>riv){
        int puntuacion=0;
        int tuEliminado=0;
        int diferencia;
        int mediaRivEliminados=0;
        for(Partida parti:part){
            tuEliminado=parti.getMuertes();
        }
        for(Rivales riva:riv){
            mediaRivEliminados=mediaRivEliminados+riva.getMuertes();
        }
        mediaRivEliminados=mediaRivEliminados/5;
        if(tuEliminado>mediaRivEliminados){
            diferencia=tuEliminado-mediaRivEliminados;
            if(diferencia>=6){
                puntuacion=puntuacion-5;
            }
            else if(diferencia>=4&&diferencia<6){
                puntuacion=puntuacion-3;
            }
            else if(diferencia>2){
                puntuacion=puntuacion-1;
            }
            else{
                puntuacion=0;
            }
        }
        return puntuacion;
    }
    public int mediaAsistencias(ArrayList<Partida>part,ArrayList<Rivales>riv){
        int puntuacion=0;
        int tuAsis=0;
        int diferencia;
        int mediaRivAsis=0;
        for(Partida parti:part){
            tuAsis=parti.getVision();
        }
        for(Rivales riva:riv){
            mediaRivAsis=mediaRivAsis+riva.getVision();
        }
        mediaRivAsis=mediaRivAsis/5;
        if(tuAsis>mediaRivAsis){
            diferencia=tuAsis-mediaRivAsis;
            if(diferencia>2&&diferencia<4){
                puntuacion=puntuacion+1;
            }
            else if(diferencia>=4&&diferencia<5){
                puntuacion=puntuacion+3;
            }
            else if(diferencia>=5){
                puntuacion=puntuacion+5;
            }
            else{
                puntuacion=0;
            }
        }
        return puntuacion;
    }
    
    public void borrarUser(String nombre,ArrayList<Usuario>lista){
    if(lista.isEmpty()==true)
        JOptionPane.showMessageDialog(null,"Introduzca usuario");
    else{
    for(Usuario al:lista){
    if(nombre.equalsIgnoreCase(al.getNombre())){
    lista.remove(al);
    break;
    }}}}
    
    public void verUsers(ArrayList<Usuario>lista){
    if(lista.isEmpty()==true)
        JOptionPane.showMessageDialog(null,"No existen usuarios");
    else{
    for(Usuario al:lista){
    JOptionPane.showMessageDialog(null,al);
    }
    }
    }
    
    
    
    
}