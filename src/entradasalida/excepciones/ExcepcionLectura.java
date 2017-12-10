package entradasalida.excepciones;
/**
 * Clase de excepcion que se produce en lectura de tableros 
 * @author Brian Mathias, Pesci Juliani
 */
public class ExcepcionLectura extends Exception {
	/**
	 * Constructor vacio
	 */
	public ExcepcionLectura() {
		super();
	}
	/**
	 * Constructor que recibe un mensaje
	 * @param message Mensaje con información de la excepcion.
	 */
	public ExcepcionLectura(String message) {
		super(message);
	}
	/**
	 * Constructor que recibe una excpecion.
	 * @param cause Excepcion relanzada.
	 */
	public ExcepcionLectura(Throwable cause) {
		super(cause);
	}

}
