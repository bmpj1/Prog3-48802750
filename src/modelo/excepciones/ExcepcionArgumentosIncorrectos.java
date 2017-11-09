package modelo.excepciones;
/**
 * Clase de excepcion de la rama RuntimeException que hereda de ExcepcionEjecucion. Se utiliza cuando un metodo recibe un null en alguno de sus parámetros.
 * @author Brian Mathias, Pesci Juliani
 */
public class ExcepcionArgumentosIncorrectos extends ExcepcionEjecucion {
	/**
	 * Constructor base que envia un string con un mensaje de error al constructor del padre.
	 */
	public 	ExcepcionArgumentosIncorrectos() {
		super("Error en los argumentos.");
	}

}
