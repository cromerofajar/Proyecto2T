package proyectopruebas;

import Utilidades.PedirDatos;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author cromerofajar
 */
public class Rivales {
    String rango;
    int elo;
    int farmeo, vision,asesinatos,muertes,asistencias;
    
    public void crearRivalesAleatorio(ArrayList<Usuario>tusDatos,ArrayList<Rivales>riva){
        Usuario obx=tusDatos.get(0); //Creacion de un objeto de tipo Usuario
        if(riva.size()>0){ //If que en caso de tener rivales en el el ArrayList de Rivales los borra
        riva.clear();
        }
        String nombre=PedirDatos.texto("Nombre del usuario para el que quieres crear rivales"); //Variable de tipo String que se le asigna el nombre de usuario.
        int chispa=0;
        for(Usuario datos:tusDatos){ //Bucle for each del ArrayList de tipo Usuario
            if(datos.getNombre().equals(nombre)){ //If que se ejecuta al encontrar el nombre del usuario en el ArrayList
        for(int i=0;i<=4;i++){ //Bucle For que nos crea a 4 rivales en funcion del elo del usuario introducido.
            chispa=1;
        if(obx.elo<=100){
            rango="bronce";
            elo=(int)(Math.random()*100);
            farmeo=(int)(Math.random()*130)+100;
            vision=(int)(Math.random()*20);
            asesinatos=(int)(Math.random()*8);
            muertes=(int)(Math.random()*8);
            asistencias=(int)(Math.random()*5);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        else if(obx.elo>100 && obx.elo<=200){
            rango="plata";
            elo=(int)(Math.random()*100)+100;
            farmeo=(int)(Math.random()*150)+100;
            vision=(int)(Math.random()*20)+4;
            asesinatos=(int)(Math.random()*7);
            muertes=(int)(Math.random()*7);
            asistencias=(int)(Math.random()*14);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        else if(obx.elo>200 && obx.elo<=300){
            rango="oro";
            elo=(int)(Math.random()*100)+200;
            farmeo=(int)(Math.random()*170)+100;
            vision=(int)(Math.random()*20)+10;
            asesinatos=(int)(Math.random()*6);
            muertes=(int)(Math.random()*5);
            asistencias=(int)(Math.random()*12);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        else if(obx.elo>300&& obx.elo<=400){
            rango="platino";
            elo=(int)(Math.random()*100)+300;
            farmeo=(int)(Math.random()*150)+150;
            vision=(int)(Math.random()*20)+15;
            asesinatos=(int)(Math.random()*9);
            muertes=(int)(Math.random()*5);
            asistencias=(int)(Math.random()*18);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        else if(obx.elo>400 && obx.elo<=500){
            rango="diamante";
            elo=(int)(Math.random()*100)+400;
            farmeo=(int)(Math.random()*130)+170;
            vision=(int)(Math.random()*20)+20;
            asesinatos=(int)(Math.random()*7);
            muertes=(int)(Math.random()*4);
            asistencias=(int)(Math.random()*14);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        else if(obx.elo>500 && obx.elo<=600){
            rango="maestro";
            elo=(int)(Math.random()*100)+500;
            farmeo=(int)(Math.random()*110)+190;
            vision=(int)(Math.random()*20)+28;
            asesinatos=(int)(Math.random()*6);
            muertes=(int)(Math.random()*4);
            asistencias=(int)(Math.random()*12);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        else if(obx.elo>600 && obx.elo<=700){
            rango="gran maestro";
            elo=(int)(Math.random()*100)+600;
            farmeo=(int)(Math.random()*100)+200;
            vision=(int)(Math.random()*20)+30;
            asesinatos=(int)(Math.random()*6);
            muertes=(int)(Math.random()*4);
            asistencias=(int)(Math.random()*12);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        else if(obx.elo>700){
            rango="aspirante";
            elo=(int)(Math.random()*100)+700;
            farmeo=(int)(Math.random()*90)+210;
            vision=(int)(Math.random()*20)+40;
            asesinatos=(int)(Math.random()*6);
            muertes=(int)(Math.random()*4);
            asistencias=(int)(Math.random()*12);
            Rivales riv=new Rivales(rango,elo,farmeo,vision,asesinatos,muertes,asistencias);
            riva.add(riv);
        }
        }
        }
        }
        if(chispa==0){
            JOptionPane.showMessageDialog(null,"No hay usuarios con ese nombre");
        }
        else{
            JOptionPane.showMessageDialog(null, "Rivales creados con éxito");
        }
        
    }
    
//    public void crearRivalesManual(ArrayList<Usuario>tusdatos){
//        for(int i=0;i==4;i++){
//            rango=PedirDatos.texto("Introduce el rango de tu rival");
//            switch (rango.toLowerCase()){
//                case "bronce": elo=(int)(Math.random()*100);
//                               break;
//                case "plata": elo=(int)(Math.random()*100)+100;
//                              break;
//                case "oro": elo=(int)(Math.random()*100)+200;
//                            break;
//                case "platino": elo=(int)(Math.random()*100)+300;
//                                break;
//                case "diamante": elo=(int)(Math.random()*100)+400;
//                                 break;
//                case "maestro": elo=(int)(Math.random()*100)+500;
//                                break;
//                case "gran maestro": elo=(int)(Math.random()*100)+600;
//                                     break;
//                case "aspirante": elo=(int)(Math.random()*100)+700;
//                                  break;
//            }
//        }
//        
//    }

    public Rivales(String rango, int elo, int farmeo, int vision, int asesinatos, int muertes, int asistencias) {
        this.rango = rango;
        this.elo = elo;
        this.farmeo = farmeo;
        this.vision = vision;
        this.asesinatos = asesinatos;
        this.muertes = muertes;
        this.asistencias = asistencias;
    }

    public Rivales() {
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public void setFarmeo(int farmeo) {
        this.farmeo = farmeo;
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

    public String getRango() {
        return rango;
    }

    public int getElo() {
        return elo;
    }

    public int getFarmeo() {
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
    
}