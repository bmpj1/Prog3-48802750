package modelo;
/**
 * 
 * @author Brian Mathias, Pesci Juliani
 */
import java.util.Iterator;
/**
 * Clase que se encarga de definir el proximo estado de una celda al actualizar el juego.
 */

public class ReglaConway {
	/**
	 * Atributo privado que almacenara el proximo estado(VIVA/MUERTA) de una celda.
	 */
	private EstadoCelda nuevoEstado;
	/**
	 * Constructor que inicializa el atributo nuevoEstado a null.
	 */
	public ReglaConway() {
		nuevoEstado = null;
	}
	/**
	 * Metodo publico que se encarga de calcular el proximo estado de una celda.
	 * @param tablero que esta actualmente en juego.
	 * @param posicion de la celda a evaluar.
	 * @return el proximo estado de la celda.
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) {
		//ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		//cordVecinas = tablero.getPosicionesVecinasCCW(posicion);
		int vecinas=0;
		Iterator<Coordenada> cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
		while(cordVecinas.hasNext() && vecinas!=4) {
			Coordenada key = cordVecinas.next();
			if(tablero.getCelda(key)==EstadoCelda.VIVA) {
				vecinas++;
			}
		}
		if(tablero.getCelda(posicion)==EstadoCelda.VIVA && (vecinas==2 || vecinas==3)) {
			nuevoEstado = EstadoCelda.VIVA;
		} 	else if(tablero.getCelda(posicion)==EstadoCelda.MUERTA && vecinas==3) {
			nuevoEstado = EstadoCelda.VIVA;
			} else {
				nuevoEstado = EstadoCelda.MUERTA;
			}
		return nuevoEstado;		
	}
}
