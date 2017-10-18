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
public class Tablero {
	/**
	 * Atributo privado que define las dimensiones de un tablero.
	 */
	private Coordenada dimensiones;
	/**
	 * Atributo privado que se encarga de enlazar pares <Coordenada,Estado>
	 */
	private HashMap<Coordenada,EstadoCelda> celdas;
	/**
	 * Constructor que asigna unas dimensiones a un tablero e inicializa sus celdas en estado MUERTA.
	 * @param dims Es el tamanyo que tendra el tablero.
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public Tablero(Coordenada dims) throws ExcepcionCoordenadaIncorrecta
	{
		dimensiones = new Coordenada(dims);
		celdas = new HashMap<Coordenada,EstadoCelda>();
		for(int j=0;j<dims.getY();j++) {
			for(int i=0;i<dims.getX();i++) {
				try {
					celdas.put(new Coordenada(i,j), EstadoCelda.MUERTA);
				} catch(ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
 		}
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
	public EstadoCelda getCelda(Coordenada c) throws ExcepcionPosicionFueraTablero {
		if(c==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(celdas.containsKey(c)==false) { throw new ExcepcionPosicionFueraTablero(dimensiones, c); }
		return celdas.get(c);
	}
	/**
	 * Metodo que asigna un estado a una celda que exista en el HashMap.
	 * @param c es la celda a la que quiero cambiar el estado.
	 * @param e es el estado que quiero asignar a 'c'.
	 * @throws ExcepcionPosicionFueraTablero 
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public void setCelda(Coordenada c, EstadoCelda e) throws ExcepcionPosicionFueraTablero {
		if(c==null || e==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(celdas.containsKey(c)) { celdas.put(c, e); }
		else { throw new ExcepcionPosicionFueraTablero(dimensiones, c); }
	}
	/**
	 * Metodo que devuelve un array de las celdas vecinas en sentido antihorario.
	 * @param c es la coordenada central, a partir de la cual quiero mirar.
	 * @return Devuelve un array que contiene entre 3 y 8 coordenadas vecinas a 'c'.
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada c) throws ExcepcionPosicionFueraTablero {
		ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		if(c==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(celdas.containsKey(c)==false) { throw new ExcepcionPosicionFueraTablero(dimensiones, c); }
		try {
			Coordenada otra;
			int i=(c.getX()-1);
			int j=(c.getY()-1);
			
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				j++;
			} while(j<=(c.getY()+1));
			j--;
			i++;
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				i++;
			}while(i<=(c.getX()+1));
			i--;
			j--;
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				j--;
			}while(j>=(c.getY()-1));
			j++;
			i--;
			if(i>-1 && j>-1) {
				otra = new Coordenada(i,j);
				if(celdas.containsKey(otra))
					cordVecinas.add(otra);
			}
		} catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
		return cordVecinas;				
	}
	/**
	 * Metodo publico que se encarga de imprimir un error.
	 * @param c Es la coordenada que dio el error.
	 */
	private void muestraErrorPosicionInvalida(Coordenada c) {
		System.err.print("Error: La celda " + c.toString() + " no existe\n");
	}
	/**
	 * Metodo publico que se encarga de intentar cargar un patron en el tablero.
	 * @param p Es el patron a cargar.
	 * @param a Es la coordenada a partir de la cual se intenta cargar.
	 * @return Devuelve falso en caso de que no se pueda cargar y true en caso contrario.
	 * @throws ExcepcionPosicionFueraTablero 
	 * @throws ExcepcionArgumentosIncorrectos 
	 */
	public boolean cargaPatron(Patron p, Coordenada a) throws ExcepcionArgumentosIncorrectos, ExcepcionPosicionFueraTablero {
		
		if(p==null || a==null) { throw new ExcepcionArgumentosIncorrectos(); }
		boolean copiar=true;
		Iterator<Coordenada> iterator = p.getPosiciones().iterator();
		try {
			while(iterator.hasNext()) {
				Coordenada key = iterator.next();
				if(this.contiene(key.suma(a)) == false) {
					throw new ExcepcionPosicionFueraTablero(dimensiones, key.suma(a));
				}
			}
			iterator = p.getPosiciones().iterator();
			while(iterator.hasNext()) {
				Coordenada key = iterator.next();
				Coordenada keyDefensiva = new Coordenada(key);
				celdas.put(keyDefensiva.suma(a), p.getCelda(keyDefensiva));
			}
		} catch (ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
		return copiar;
	}
	/**
	 * Metodo publico que se encarga de comprobar si una coordenada existe.
	 * @param otra Es la coordenada a comprobar.
	 * @return Contiene Devuelve true en caso de que la celda existe, false en caso contrario.
	 */
	public boolean contiene(Coordenada otra) {
		if(otra==null) { throw new ExcepcionArgumentosIncorrectos(); }
		boolean contiene=false;
		if(celdas.containsKey(otra)) { contiene = true; }
		return contiene;
	}
	/**
	 * Metodo que devuelve el tablero en formato string.
	 */
	public String toString() {
		int X = dimensiones.getX();
		int Y = dimensiones.getY();
		String impTablero = new String("");
		
		for(int i=-1;i <= X; i++) {
			if(i==-1 || i==X) { impTablero += "+"; }
			else { impTablero += "-"; }
		}
		impTablero += "\n";
		
		for(int j=0; j<Y;j++) {
			impTablero += "|";
			for(int i=0; i<X; i++) {
// ***********Cuidado con esta linea****************.
				try {
					impTablero += celdas.get(new Coordenada(i,j)).getEstado();
				} catch (ExcepcionCoordenadaIncorrecta e) {
				}
//**************************************************.
			}
			impTablero += "|\n";
		}
		
		for(int i=-1;i <= X; i++) {
			if(i==-1 || i==X) { impTablero += "+"; }
			else { impTablero += "-"; }
		}
		impTablero += "\n";
		return impTablero;
 	}
 }
/*REFERENCIAS:
*	HashMap: https://www.youtube.com/watch?v=TX5Sucd1CRA
*		 https://www.youtube.com/watch?v=RzTkm_FJRf8
*		 http://www.dlsi.ua.es/asignaturas/prog3/jcf_facil.html#mapas
*
*	ArrayList: https://www.youtube.com/watch?v=XSDhZgSP7G8
*/
