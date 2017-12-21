package modelo.d2;
 
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * Clase de excepcion de la rama Exception  que hereda de ExcepcionCoordenadaIncorrecta. Se utiliza cuando el constructor Coordenada2D(int,int) recibe un negativo en alguno de sus argumentos.
 * @author Brian Mathias, Pesci Juliani
 */
@SuppressWarnings("serial")
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	/**
	 * X Es la anchura que dio error.
	 */
	private int x;
	/**
	 * Y Es la altura que dio error.
	 */
	private int y;
	/**
	 * Constructor que almacena los valores de la coordenada incorrecta.
	 * @param x Es el valor de la anchura que dio error.
	 * @param y Es el valor de la altura que dio error.
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		this.x=x;
		this.y=y;
	}
	/**
	 * Metodo que devuelve un mensaje de error.
	 * @return String Mensaje de error.
	 */
	public String getMessage() {
		return ("Error: Coordenada2D("+x+","+y+") incorrecta.\n");
	}
	/**
	 * Metodo que devuelve el número que dio el error.
	 * @return X Es el número erroneo.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Metodo que devuelve el número que dio el error.
	 * @return Y Es el número erroneo.
	 */
	public int getY() {
		return y;
	}

}
