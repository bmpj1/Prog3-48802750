package modelo;
/**
 * 
 * @author Brian Mathias, Pesci Juliani
 *
 */
/**
 * 
 * Clase que se encarga de crear y copiar coordenadas.
 *
 */
public class Coordenada {
	/**
	 * Atributo privado que representa el valor X de la coordenada. Representa la anchura en las dimensiones del tablero.
	 */
	private int x;
	/**
	 * Atributo privado que representa el valor Y de la coordenada. Representa la altura en las dimensiones del tablero.
	 */
	private int y;
	/**
	 * Atributo estatico y privado que representa el número total de coordenadas creadas.
	 */
	private static int NUMERO_COORDENADAS;
	/**
	 * Constructor base de la clase que inicializa los atributos X, Y e incrementa NUMERO_COORDENADAS.
	 * @param x
	 * @param y
	 */
	public Coordenada(int x, int y) {
		this.x = x;
		this.y = y;
		NUMERO_COORDENADAS++;
	}
	/**
	 * Constructor de copia de coordenadas, asigna los valores de X, Y e incrementa NUMERO_COORDENADA
	 * @param otra
	 */
	public Coordenada(Coordenada otra)
	{
		this.x = otra.getX();
		this.y = otra.getY();
		NUMERO_COORDENADAS++;
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
	 * Metodo que devuelve el numero de coordenadas creadas.
	 * @return NUMERO_COORDENADAS
	 */
	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
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
		if (!(obj instanceof Coordenada)) {
			return false;
		}
		Coordenada other = (Coordenada) obj;
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
	 * Metodo que hace la suma de las coordenadas y devuelve el objeto sumado.
	 * @param otra
	 * @return nueva coordenada.
	 */
	public Coordenada suma(Coordenada otra)
	{
		return new Coordenada(x+otra.getX(),y+otra.getY());
	}
}
