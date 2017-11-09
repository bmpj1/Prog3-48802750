package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
/**
 * Clase abstracta de Coordenadas que permite la implementación de Coordenadas de varias dimensiones sin copiar demasiado codigo. 
 * @author Brian Mathias, Pesci Juliani
 */
public abstract class Coordenada {
	/**
	 * Constructor base que no hace nada.
	 */
	public Coordenada() { }
	/**
	 * Metodo abstracto que se encarga de sumar dos Coordenadas del mismo tipo. La implementación está en Coordenada1D y 2D.
	 * @param c Coordenada que se va a sumar a esta Cooordenada.
	 * @return Coordenada Devuelve una referencia a una Coordenada1D o 2D. 
	 * @throws ExcepcionCoordenadaIncorrecta Lanza una excepcion cuando la Coordenada no es válida.
	 */
	public abstract Coordenada suma(Coordenada c) throws ExcepcionCoordenadaIncorrecta;
}
