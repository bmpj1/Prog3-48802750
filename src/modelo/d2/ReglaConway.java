package modelo.d2;

import java.util.Iterator;

import modelo.EstadoCelda;
import modelo.Regla;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que se encarga de definir el proximo estado de una celda al actualizar el juego. 
 * @author Brian Mathias, Pesci Juliani
 */
public class ReglaConway extends Regla<Coordenada2D> {
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
	 * Metodo publico que se encarga de calcular el proximo estado de una celda en un Tablero2D.
	 * @param tablero Tablero2D que esta actualmente en juego.
	 * @param posicion Coordenada2D de la celda a evaluar.
	 * @return Devuelve el proximo estado de la celda.
	 * @throws ExcepcionPosicionFueraTablero Lanza la excepcion cuando la posicion está fuera del tablero.
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero<Coordenada2D> tablero, Coordenada2D posicion) throws ExcepcionPosicionFueraTablero {
		if(tablero==null || posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		
		if( (posicion instanceof Coordenada2D) && (tablero instanceof Tablero2D)) {
			int vecinas=0;
			Iterator<Coordenada2D> cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
			while(cordVecinas.hasNext() && vecinas!=4) {
				Coordenada2D key = cordVecinas.next();
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
		}
		return nuevoEstado;		
	}
}
