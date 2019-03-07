package proyectopruebas;

import java.io.File;
import java.util.ArrayList;



/**
 *
 * @author cromerofajar
 */
public interface ObligatorioPartida {
   void resultadoPartida(ArrayList<Rivales> riv, ArrayList<Usuario> tusDatos, ArrayList<Partida> part);
   void verUltimaPartidaguardada(File fich);
   
}
