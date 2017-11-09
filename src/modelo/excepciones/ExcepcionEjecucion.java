package modelo.excepciones;
/**
 * Clase de excepcion que hereda de RuntimeException. Se utiliza cuando un metodo captura ExcepcionCoordenadaIncorrecta, sirve para indicar que ha habido un error en tiempo de ejecucion.
 * @author Brian Mathias, Pesci Juliani
 */
public class ExcepcionEjecucion extends RuntimeException {
	/**
	 * Metodo que llama al constructor de RuntimeException y le envia un string con un mensaje de error.
	 * @param message Es un mensaje que recibe.
	 */
	public ExcepcionEjecucion(String message) {
		super(message);
	}
	/**
	 * Metodo que llama al constructor de RuntimeException y le envia un throwable.
	 * @param cause Es una excpecion de algún tipo que se dio en tiempo de ejecucion.
	 */
	public ExcepcionEjecucion(Throwable cause) {
		super(cause);
	}
}
