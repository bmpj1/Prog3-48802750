package modelo.excepciones;

import modelo.Coordenada;
/**
 * Clase de excepcion que hereda de java.lang.Exception. Se utiliza cuando se intenta cargar una Coordenada en un tablero pero esa Coordenada no existe.
 * @author Brian Mathias, Pesci Juliani
 */
@SuppressWarnings("serial")
public class ExcepcionPosicionFueraTablero extends Exception {
	/**
	 * Atributo privado que guarda una Coordenada con las dimensiones del tablero.
	 */
	private Coordenada dimensiones;
	/**
	 * Atributo privado que guarda una Coordenada con la posicion erronea que se intento cargar.
	 */
	private Coordenada coordenada;
	/**
	 * Constructor que almacena las dimensiones y la posicion.
	 * @param dimensiones Es una variable que almacena las dimensiones de un tablero.
	 * @param coordenada Es una variable que almacena la posición que dio el error al cargar.
	 */
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones, Coordenada coordenada) {
		this.dimensiones = dimensiones;
		this.coordenada = coordenada;
	}
	/**
	 * Metodo que devuelve un mensaje de error.
	 * @return String Mensaje de error.
	 */
	public String getMessage() {
		return ("Error: La celda "+coordenada.toString()+" no está dentro de las dimensiones "+dimensiones.toString()+".\n");
	}
	/**
	 * Metodo que devuelve el tamaño del tablero.
	 * @return dimensiones Es el tamaño del tablero.
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	/**
	 * Metodo que devuelve la posicion que dio error al cargar en el tablero.
	 * @return coordenada Es la posicion que dio el error.
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
}
