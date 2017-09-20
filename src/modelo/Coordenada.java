package modelo;

/** @author Brian Mathias, Pesci, juliani 
 * 
 * */
public class Coordenada {
	/** @Atributo_Privado Valor X de la coordenada. */
	private int x;
	/** @Atributo_Privado Valor Y de la coordenada. */
	private int y;
	/** @Atributo_Privado Número total de coordenadas creadas. */
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
	 * @Constructor Constructor de copia de coordenadas, asigna los valores de X, Y e incrementa NUMERO_COORDENADA
	 */
	public Coordenada(Coordenada otra)
	{
		this.x = otra.getX();
		this.y = otra.getY();
		NUMERO_COORDENADAS++;
	}
	/**
	 * @return Devuelve el valor de x.
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return Devuelve el valor de y.
	 */
	public int getY() {
		return y;
	}
	/**
	 * @return Devuelve el valor de NUMERO_COORDENADAS.
	 */
	public static int getNumeroCoordenadas() {
		return NUMERO_COORDENADAS;
	}
	/**
	 * @Parametros Object obj.
	 * @Función Metodo equals para comparar si dos objetos "Coordenada" comparten atributos.
	 */
	@Override
	public boolean equals(Object obj) {
		/* Comprobar si ambos objetos apuntan a la misma dirección de memoria. */
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Coordenada)) {
			return false;
		}
		/* Castear "obj" a la clase Coordenada. */
		Coordenada other = (Coordenada) obj;
		/* Comprobar si el atributo 'x' es igual en ambos objetos. */
		if (x != other.x) {
			return false;
		}
		/* Comprobar si el atributo 'y' es igual en ambos objetos. */
		if (y != other.y) {
			return false;
		}
		return true;
	}
	
	/** @toString Sirve para convertir los atributos a una cadena con el formato deseado. */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	/**
	 * @Parametros Coordenada(otra).
	 * @Función Crear una nueva coordenada a partir de la suma de otras dos coordenadas.
	 */
	public Coordenada suma(Coordenada otra)
	{
		return new Coordenada(x+otra.getX(),y+otra.getY());
	}
	
	
}
