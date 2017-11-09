package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
/**
 * Clase que hereda de la clase abstracta Coordenada. Permite crear coordenadas de una dimension. 
 * @author Brian Mathias, Pesci Juliani
 */
public class Coordenada1D extends Coordenada {
	/**
	 * X Es un atributo privado que define la posicion de una coordenada o el ancho de un tablero1D.
	 */
	private int x;
	/**
	 * Constructor que crea una coordenada a partir de un entero.
	 * @param x Es la posicion de la coordenada en un Tablero1D o las dimensiones del mismo.
	 * @throws ExcepcionCoordenadaIncorrecta Lanza un error cuando la coordenada no es válida.
	 */
	public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta {
		if(x<0) { throw new ExcepcionCoordenada1DIncorrecta(x); }
		this.x=x;
	}
	/**
	 * Constructor de copia de coordenadas1D. En caso de que la coordenada sea nula lanza ExcepcionArgumentosIncorrectos().
	 * @param c Es la coordenada de 1 dimension que se va a copiar.
	 */
	public Coordenada1D(Coordenada1D c) {
		if(c==null) { throw new ExcepcionArgumentosIncorrectos(); }
		
		if(c instanceof Coordenada1D)
			this.x = c.x;
	}
	/**
	 * Metodo publico que permite convertir la coordenada en un string.
	 */
	public String toString() {
		return "("+x+")";
	}
	/**
	 * Metodo publico que devuelve el valor x de la coordenada.
	 * @return x Es la posicion en un tablero o la dimension en el mismo.
	 */
	public int getX() { return x; }
	/**
	 * Metodo hashCode de la clase Coordenada1D.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}
	/**
	 * Metodo equals de la clase Coordenada1D.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) obj;
		if (x != other.x)
			return false;
		return true;
	}
	/**
	 * Implementación del metodo abstracto suma de la clase Coordenada que se encarga de sumar dos Coordenadas1D.
	 * @param c Coordenada que se va a sumar a esta Cooordenada.
	 * @return Coordenada1D Devuelve una referencia a una Coordenada1D. 
	 * @throws ExcepcionCoordenadaIncorrecta Lanza una excepcion cuando la Coordenada no es válida.
	 */
	@Override
	public Coordenada1D suma(Coordenada c) throws ExcepcionCoordenadaIncorrecta {
		if(c==null) { throw new ExcepcionArgumentosIncorrectos(); }
		Coordenada1D nuevaCoordenada = null;
		if((c instanceof Coordenada1D)) {
			Coordenada1D other = (Coordenada1D) c;
			nuevaCoordenada = new Coordenada1D(x+other.getX());
		}
		return (nuevaCoordenada);
	}

}
