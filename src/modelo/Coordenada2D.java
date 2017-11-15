package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * Clase que hereda de la clase abstracta Coordenada. Permite crear Coordenadas de dos dimensiones. 
 * @author Brian Mathias, Pesci Juliani
 */
public class Coordenada2D extends Coordenada{
	/**
	 * Atributo privado que representa el valor X de la coordenada. Representa la anchura en las dimensiones del tablero.
	 */
	private int x;
	/**
	 * Atributo privado que representa el valor Y de la coordenada. Representa la altura en las dimensiones del tablero.
	 */
	private int y;
	/**
	 * Constructor base de la clase que inicializa los atributos X, Y.
	 * @param x Es el valor X de la coordenada.
	 * @param y Es el valor Y de la coordenada.
	 * @throws ExcepcionCoordenadaIncorrecta Lanza un error cuando la coordenada no es válida.
	 */
	public Coordenada2D(int x, int y) throws ExcepcionCoordenadaIncorrecta {
		if( (x<0) || (y<0) ) { throw new ExcepcionCoordenada2DIncorrecta(x, y); }
		this.x = x;
		this.y = y;
	}
	/**
	 * Constructor de copia de coordenadas, asigna los valores de X, Y.
	 * @param otra Es la coordenada que queremos copiar.
	 */
	public Coordenada2D(Coordenada2D otra){
		if( otra == null) { throw new ExcepcionArgumentosIncorrectos(); }
		this.x = otra.getX();
		this.y = otra.getY();
	}
	/**
	 * Metodo que devuelve el valor X de la coordenada.
	 * @return X
	 */
	public int getX() {
		return x;
	}
	/**
	 * Metodo que devuelve el valor Y de la coordenada.
	 * @return Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Metodo que permite comparar si dos coordenadas son iguales.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	/**
	 * Metodo que permite comparar si dos coordenadas son iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Coordenada2D)) {
			return false;
		}
		Coordenada2D other = (Coordenada2D) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
	/**
	 * Metodo que sirve para convertir los atributos a una cadena con el formato deseado.
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	/**
	 * Implementación del metodo abstracto suma de la clase Coordenada que se encarga de sumar dos Coordenadas2D.
	 * @param otra Coordenada que se va a sumar a esta Cooordenada.
	 * @return Coordenada2D Devuelve una referencia a una Coordenada2D. 
	 * @throws ExcepcionCoordenadaIncorrecta Lanza una excepcion cuando la Coordenada no es válida.
	 */
	@Override
	public Coordenada2D suma(Coordenada otra) throws ExcepcionCoordenadaIncorrecta
	{
		if(otra == null) { throw new ExcepcionArgumentosIncorrectos(); }
		Coordenada2D nuevaCoord = null;
		if (otra instanceof Coordenada2D) {
			Coordenada2D other = (Coordenada2D) otra;
			nuevaCoord = new Coordenada2D(x+other.getX(),y+other.getY());
		}
		return (nuevaCoord);
	}
}
