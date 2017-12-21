package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
 
/**
 * Clase principal del programa que se encarga de enlazar una regla con un tablero y muchos patrones.
 * @author Brian Mathias, Pesci Juliani
 */
public class Juego<TipoCoordenada extends Coordenada> {
	/**
	 * Atributo privado que almacena un array con los patrones usados en este juego.
	 */
	private ArrayList<Patron<TipoCoordenada>> patronesUsados;
	/**
	 * Atributo privado que asocia un juego con un tablero.
	 */
	private Tablero<TipoCoordenada> tablero;
	/**
	 * Atributo privado que asocia un juego con una regla.
	 */
	private Regla<TipoCoordenada> regla;
	/**
	 * Constructor que inicializa los atributos tablero y regla.
	 * @param tablero Tablero donde se desarrollara el juego de la vida.
	 * @param regla Regla que se encargará de actualizar las celdas del juego.
	 */
	public Juego(Tablero<TipoCoordenada> tablero, Regla<TipoCoordenada> regla) {
		if(tablero==null || regla==null) { throw new ExcepcionArgumentosIncorrectos(); }
		this.tablero = tablero;
		this.regla = regla;
		patronesUsados = new ArrayList<Patron<TipoCoordenada>>();
	}
	/**
	 * Metodo publico que se encarga de intentar cargar un patron en el tablero a partir de una celda inicial, en caso de fallo lanza una excepcion.
	 * @param p Es el patron a cargar.
	 * @param posicionInicial Indica la celda a partir de cual cargar el patron.
	 * @throws ExcepcionPosicionFueraTablero Lanza la excepcion cuando el patron no entra en el tablero o la posicion inicial no es valida. 
	 */
	public void cargaPatron(Patron<TipoCoordenada> p, TipoCoordenada posicionInicial) throws ExcepcionPosicionFueraTablero{
		tablero.cargaPatron(p, posicionInicial);
		patronesUsados.add(p);
	}
	/**
	 * Metodo publico que actualiza el tablero. Para ello utiliza la regla y el tablero.
	 */
	public void actualiza() {
		try {
			HashMap<TipoCoordenada,EstadoCelda> t = new HashMap<TipoCoordenada, EstadoCelda>(); 
			Iterator<TipoCoordenada> iterator = tablero.getPosiciones().iterator();
			while(iterator.hasNext()) {
				TipoCoordenada key = iterator.next();
				t.put(key, regla.calculaSiguienteEstadoCelda(tablero,key));
			}
			Iterator<TipoCoordenada> iter = t.keySet().iterator();
			while(iter.hasNext()) {
				TipoCoordenada key = iter.next();
				tablero.setCelda(key, t.get(key));
			}
		} catch(ExcepcionPosicionFueraTablero cause) {
			throw new ExcepcionEjecucion(cause);
		}
	}
	/**
	 * Metodo publico que devuelve el tablero.
	 * @return Devuelve la direccion de memoria del tablero.
	 */
	public Tablero<TipoCoordenada> getTablero() {
		return tablero;
	}
	/**
	 * Metodo publico que devuelve un array con los patrones utilizados.
	 * @return Devuelve un array con los patrones usados.
	 */
	public ArrayList<Patron<TipoCoordenada>> getPatrones() {
		return patronesUsados;
	}
}
