package modelo.excepciones;
/**
 * Clase de excepcion que hereda de java.lang.Exception. Se utiliza cuando un constructor de Coordenada1D/2D lanza una ExcepcionCoordenada1DIncorrecta() o ExcepcionCoordenada2DIncorrecta(). El programa castea esas excepciones a el tipo de esta clase.
 * @author Brian Mathias, Pesci Juliani
 */
public class ExcepcionCoordenadaIncorrecta extends Exception {
	/**
	 * Constructor que simplemente llama al constructor de java.lang.Exception.
	 */
	public ExcepcionCoordenadaIncorrecta() {
		super(); //Llama al constructor de la superclase que majena ese tipo de argumentos.
	}
}
