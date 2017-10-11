package modelo;
/**
 * 
 * @author Brian Mathias, Pesci Juliani
 */
/**
 * Clase que se encarga de almacenar un patron y su nombre.
 */

import java.util.Collection;

public class Patron {
	/**
	 * Atributo privado que representa el nombre del patron.
	 */
	private String nombre;
	/**
	 * Atributo privado que representa la estructura de celdas vivas/muertas del patron 
	 */
	private Tablero tablero;
	/**
	 * Constructor por defecto que asigna un nombre y un tablero a un patron.
	 * @param nombre del patron.
	 * @param tablero que almacena la estructura.
	 */
	public Patron(String nombre, Tablero tablero) {
		this.nombre = nombre;
		this.tablero = tablero;
	}
	/**
	 * Metodo publico que devuelve el nombre de un patron.
	 * @return nombre del patron.
	 */
	public String getNombre() { return nombre; }
	/**
	 * Metodo publico que obtiene el estado de una celda concreta.
	 * @param c que representa el estado de una celda concreta.
	 * @return Devuelve el estado VIVA/MUERTA de la celda.
	 */
	public EstadoCelda getCelda(Coordenada c) {
		return tablero.getCelda(c);
	}
	/**
	 * Metodo publico que devuelve una colecion de las celdas existentes. 
	 * @return Devuelve una coleccion de las celdas que tiene el patron.
	 */
	public Collection<Coordenada> getPosiciones() {
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
