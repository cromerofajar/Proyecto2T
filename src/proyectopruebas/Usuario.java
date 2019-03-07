package proyectopruebas;

import Utilidades.PedirDatos;
/**
 *
 * @author cromerofajar
 */
public class Usuario{
    String nombre, rango;
    int elo;

    public Usuario() {
        
    }


    public Usuario(String nombre, String rango, int elo) {
        this.nombre = nombre;
        this.rango = rango;
        this.elo = elo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getRango() {
        return rango;
    }

    public int getElo() {
        return elo;
    }
    public void rangElo(int elo){
        this.elo=elo;
        if (elo<=100){
            this.rango="bronce";
        }else if(elo>100 && elo<=200){
            this.rango="plata";
        }else if(elo>200 && elo<=300){
            this.rango="oro";
        }else if(elo>300 && elo<=400){
            this.rango="platino";
        }else if(elo>400 && elo<=500){
            this.rango="diamante";
        }else if(elo>500 && elo<=600){
            this.rango="maestro";
        }else if(elo>600 && elo<=700){
            this.rango="gran maestro";
        }else if(elo>700){
            this.rango="aspirante";
        }
    }
    @Override
    public String toString() {
        return "Jugador"+"\nnombre=" + nombre + "\nrango=" + rango + "\nelo=" + elo;
    }
    
    
    
}
