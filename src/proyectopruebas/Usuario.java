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

    @Override
    public String toString() {
        return "Jugador"+"\nnombre=" + nombre + "\nrango=" + rango + "\nelo=" + elo;
    }
    
    
    
}
