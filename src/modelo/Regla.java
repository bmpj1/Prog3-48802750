package modelo;

import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase abstracta que permite la implementación de varias Reglas sin copiar mucho codigo. 
 * @author Brian Mathias, Pesci Juliani.
 *
 */
public abstract class Regla<TipoCoordenada extends Coordenada> {
	/**
	 * Constructor por defecto que no hace nada.
	 */
	public Regla() { }
	/**
	 * Metodo abstracto que se va a encargar de calcular el nuevo estado de una celda del tablero.
	 * @param t Es el tablero a analizar.
	 * @param c Es la posicion a analizar.
	 * @return EstadoCelda Es el próximo estado de la celda.
	 * @throws ExcepcionPosicionFueraTablero Lanza la excepcion cuando la posición está fuera del tablero.
	 */
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero<TipoCoordenada> t, TipoCoordenada c) throws ExcepcionPosicionFueraTablero ;
}
