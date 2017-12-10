package entradasalida.excepciones;
/**
 * Clase de excepcion que se da al generar un fichero. 
 * @author Brian Mathias, Pesci Juliani
 */ 
public class ExcepcionGeneracion extends Exception {
	/**
	 * Constructor vacio de excepcion
	 */
	public ExcepcionGeneracion() {
		super();
	}
	/**
	 * Constructor de excepcion a partir de un String
	 * @param message Mensaje de error
	 */
	public ExcepcionGeneracion(String message) {
		super(message);
	}
	/**
	 * Constructor de excepcion a partir de un throw
	 * @param cause Tipo de excpecion que le pasan.
	 */
	public ExcepcionGeneracion(Throwable cause) {
		super(cause);
	}
	
}
