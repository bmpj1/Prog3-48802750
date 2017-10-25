package modelo;

import modelo.excepciones.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Clase principal del programa que se encarga de enlazar una regla con un tablero y muchos patrones.
 * @author Brian Mathias, Pesci Juliani
 */
public class Juego {
	/**
	 * Atributo privado que almacena un array con los patrones usados en este juego.
	 */
	private ArrayList<Patron> patronesUsados;
	/**
	 * Atributo privado que asocia un juego con un tablero.
	 */
	private Tablero tablero;
	/**
	 * Atributo privado que asocia un juego con una regla.
	 */
	private Regla regla;
	/**
	 * Constructor que inicializa los atributos tablero y regla.
	 * @param tablero Tablero donde se desarrollara el juego de la vida.
	 * @param regla Regla que se encargará de actualizar las celdas del juego.
	 */
	public Juego(Tablero tablero, Regla regla) {
		if(tablero==null || regla==null) { throw new ExcepcionArgumentosIncorrectos(); }
		this.tablero = tablero;
		this.regla = regla;
		patronesUsados = new ArrayList<Patron>();
	}
	/**
	 * Metodo publico que se encarga de intentar cargar un patron en el tablero a partir de una celda inicial, en caso de fallo imprime un error.
	 * @param p Es el patron a cargar.
	 * @param posicionInicial Indica la celda a partir de cual cargar el patron.
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos {
		if(tablero.cargaPatron(p, posicionInicial)) {
			patronesUsados.add(p);
		} else {
			System.err.print("Error cargando plantilla "+p.getNombre()+ " en "+posicionInicial.toString()+"\n");
		}
	}
	/**
	 * Metodo publico que actualiza el tablero. Para ello utiliza la regla y el tablero.
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public void actualiza() throws ExcepcionCoordenadaIncorrecta {
		try {
			HashMap<Coordenada,EstadoCelda> t = new HashMap<Coordenada, EstadoCelda>(); 
			Iterator<Coordenada> iterator = tablero.getPosiciones().iterator();
			while(iterator.hasNext()) {
				Coordenada key = iterator.next();
				t.put(key, regla.calculaSiguienteEstadoCelda(tablero,key));
			}
			Iterator<Coordenada> iter = t.keySet().iterator();
			while(iter.hasNext()) {
				Coordenada key = iter.next();
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
	public Tablero getTablero() {
		return tablero;
	}
	/**
	 * Metodo publico que devuelve un array con los patrones utilizados.
	 * @return Devuelve un array con los patrones usados.
	 */
	public ArrayList<Patron> getPatrones() {
		return patronesUsados;
	}
}
