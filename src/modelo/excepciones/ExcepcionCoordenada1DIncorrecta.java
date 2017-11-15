package modelo.excepciones;
/**
 * Clase de excepcion de la rama Exception que hereda de ExcepcionCoordenadaIncorrecta. Se utiliza cuando el constructor de Coordenada1D(int) recibe un negativo.
 * @author Brian Mathias, Pesci Juliani
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	/**
	 * X Es un atributo privado que almacena el valor que desencadeno el error.
	 */
	private int x;
	/**
	 * Constructor que almacena el número que produce el error.
	 * @param x Es el valor que desencadeno el error.
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x = x;
	}
	/**
	 * Metodo que devuelve un mensaje de error.
	 * @return String Devuelve le mensaje de error.
	 */
	public String getMessage() {
		return ("Error: Coordenada1D("+x+") incorrecta.\n");
	}
	/**
	 * Metodo que devuelve el número que dio el error.
	 * @return x Es el número erroneo.
	 */
	public int getX() {
		return x;
	}

}
