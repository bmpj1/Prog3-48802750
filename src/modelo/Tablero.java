package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que representa la matriz de celdas usadas en el juego de la vida.
 * @author Brian Mathias, Pesci Juliani
 */
public abstract class Tablero {
	/**
	 * Atributo privado que define las dimensiones de un tablero.
	 */
	protected Coordenada dimensiones;
	/**
	 * Atributo privado que se encarga de enlazar pares <Coordenada,Estado>
	 */
	protected HashMap<Coordenada,EstadoCelda> celdas;
	/**
	 * Constructor que asigna unas dimensiones a un tablero e inicializa sus celdas en estado MUERTA.
	 * @param dims Es el tamanyo que tendra el tablero.
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	protected Tablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta
	{
		//dimensiones = new Coordenada(dims); no podemos por que Coordenada es una clase abstracta.
		if(dimensiones==null) { throw new ExcepcionArgumentosIncorrectos();}
		this.dimensiones = dimensiones;
		celdas = new HashMap<Coordenada,EstadoCelda>();
		
	}
	/**
	 * Metodo que devuelve las dimensiones de un tablero.
	 * @return Devuelve las dimensiones del tablero.
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
		
	}
	/**
	 * Metodo que devuelve una coleccion no ordenada de las coordenadas existentes en el tablero.
	 * @return Devuelve el keyset de las celdas.
	 */
	public Collection<Coordenada> getPosiciones() {
		return celdas.keySet();
	}
	/**
	 * Metodo que devuelve el estado de una celda concreta, en caso de que la celda no exista imprime un mensaje de error y devuelve null.
	 * @param c Es la coordenada a evaluar.
	 * @return Devuelve el estado de la celda o null si la celda no existe.
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(celdas.containsKey(posicion)==false) { throw new ExcepcionPosicionFueraTablero(dimensiones, posicion); }
		return celdas.get(posicion);
	}
	/**
	 * Metodo que asigna un estado a una celda que exista en el HashMap.
	 * @param c es la celda a la que quiero cambiar el estado.
	 * @param e es el estado que quiero asignar a 'c'.
	 * @throws ExcepcionPosicionFueraTablero 
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionPosicionFueraTablero {
		if(posicion==null || e==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(celdas.containsKey(posicion)) { celdas.put(posicion, e); }
		else { throw new ExcepcionPosicionFueraTablero(dimensiones, posicion); }
	}
	/**
	 * Metodo que devuelve un array de las celdas vecinas en sentido antihorario.
	 * @param c es la coordenada central, a partir de la cual quiero mirar.
	 * @return Devuelve un array que contiene entre 3 y 8 coordenadas vecinas a 'c'.
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada c) throws ExcepcionPosicionFueraTablero;
	/**
	 * Metodo publico que se encarga de intentar cargar un patron en el tablero.
	 * @param p Es el patron a cargar.
	 * @param a Es la coordenada a partir de la cual se intenta cargar.
	 * @return Devuelve falso en caso de que no se pueda cargar y true en caso contrario.
	 * @throws ExcepcionPosicionFueraTablero 
	 * @throws ExcepcionArgumentosIncorrectos 
	 */
	public void cargaPatron(Patron p, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		
		if(p==null || posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		Iterator<Coordenada> iterator = p.getPosiciones().iterator();
		try {
			while(iterator.hasNext()) {
				Coordenada key = iterator.next();
				if(this.contiene(key.suma(posicion)) == false) {
					throw new ExcepcionPosicionFueraTablero(dimensiones, key.suma(posicion));
				}
			}
			iterator = p.getPosiciones().iterator();
			while(iterator.hasNext()) {
				Coordenada key = iterator.next();
				if(posicion instanceof Coordenada2D) {
					Coordenada2D keyDefensiva = (Coordenada2D) key;
					celdas.put(keyDefensiva.suma(posicion), p.getCelda(keyDefensiva));
				} else if(posicion instanceof Coordenada1D) {
					Coordenada1D keyDefensiva = (Coordenada1D) key;
					celdas.put(keyDefensiva.suma(posicion), p.getCelda(keyDefensiva));					
				}
				
			}
		} catch (ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
	}
	/**
	 * Metodo publico que se encarga de comprobar si una coordenada existe.
	 * @param otra Es la coordenada a comprobar.
	 * @return Contiene Devuelve true en caso de que la celda existe, false en caso contrario.
	 */
	public boolean contiene(Coordenada posicion) {
		if(posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		boolean contiene=false;
		if(celdas.containsKey(posicion)) { contiene = true; }
		return contiene;
	}

 }
/*REFERENCIAS:
*	HashMap: https://www.youtube.com/watch?v=TX5Sucd1CRA
*		 https://www.youtube.com/watch?v=RzTkm_FJRf8
*		 http://www.dlsi.ua.es/asignaturas/prog3/jcf_facil.html#mapas
*
*	ArrayList: https://www.youtube.com/watch?v=XSDhZgSP7G8
*/
