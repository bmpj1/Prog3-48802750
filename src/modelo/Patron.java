package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que se encarga de almacenar un patron y su nombre.
 * @author Brian Mathias, Pesci Juliani
 */
public class Patron<TipoCoordenada extends Coordenada> {
	/**
	 * Atributo privado que representa el nombre del patron.
	 */
	private String nombre;
	/**
	 * Atributo privado que representa la estructura de celdas vivas/muertas del patron 
	 */
	private Tablero<TipoCoordenada> tablero;
	/**
	 * Constructor por defecto que asigna un nombre y un tablero a un patron.
	 * @param nombre Nombre del patron.
	 * @param tablero Tablero que almacena la estructura.
	 */
	public Patron(String nombre, Tablero<TipoCoordenada> tablero) {
		if(nombre == null || tablero==null) { throw new ExcepcionArgumentosIncorrectos(); }
		this.nombre = nombre;
		this.tablero = tablero;
	}
	/**
	 * Metodo publico que devuelve el nombre de un patron.
	 * @return Devuelve el nombre del patron.
	 */
	public String getNombre() { return nombre; }
	/**
	 * Metodo publico que obtiene el estado de una celda concreta.
	 * @param c Coordenada de la cualobtendremos el estado.
	 * @return Devuelve el estado VIVA/MUERTA de la celda.
	 * @throws ExcepcionPosicionFueraTablero Lanza la excepcion cuando la Coordenada que se quiere obtener no es valida.
	 */
	public EstadoCelda getCelda(TipoCoordenada c) throws ExcepcionPosicionFueraTablero {
		if(c==null) { throw new ExcepcionArgumentosIncorrectos(); }
		return tablero.getCelda(c);
	}
	/**
	 * Metodo publico que devuelve una colecion de las celdas existentes. 
	 * @return Devuelve una coleccion de las celdas que tiene el patron.
	 */
	public Collection<TipoCoordenada> getPosiciones() {
		return tablero.getPosiciones();
	}
	/**
	 * Metodo publico que devuelve el nombre del patron seguido de la estructura del tablero en formato, todo ello en formato string.
	 */
	@Override
	public String toString() {
		String s = new String(nombre);
		s += "\n";
		return (s += tablero.toString());
	}
}
