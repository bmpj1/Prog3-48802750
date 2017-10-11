package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
	 * @param dims es el tamanyo que tendra el tablero.
	 */
	public Tablero(Coordenada dims)
	{
		dimensiones = new Coordenada(dims);
		celdas = new HashMap<Coordenada,EstadoCelda>();
		for(int j=0;j<dims.getY();j++) {
			for(int i=0;i<dims.getX();i++) {
				celdas.put(new Coordenada(i,j), EstadoCelda.MUERTA); 			}
 		}
	}
	/**
	 * Metodo que devuelve las dimensiones de un tablero.
	 * @return dimensiones del tablero.
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
		
	}
	/**
	 * Metodo que devuelve una coleccion no ordenada de las coordenadas existentes en el tablero.
	 * @return
	 */
	public Collection<Coordenada> getPosiciones() {
		return celdas.keySet();
	}
	/**
	 * Metodo que devuelve el estado de una celda concreta, en caso de que la celda no exista imprime un mensaje de error y devuelve null.
	 * @param c es la coordenada a evaluar.
	 * @return Devuelve el estado de la celda o null si la celda no existe.
	 */
	public EstadoCelda getCelda(Coordenada c) {
		if(celdas.containsKey(c)==false) { muestraErrorPosicionInvalida(c); return null; }
		return celdas.get(c);
	}
	/**
	 * Metodo que asigna un estado a una celda que exista en el HashMap.
	 * @param c es la celda a la que quiero cambiar el estado.
	 * @param e es el estado que quiero asignar a 'c'.
	 */
	public void setCelda(Coordenada c, EstadoCelda e) {
		if(celdas.containsKey(c)) { celdas.put(c,e); }
		else { muestraErrorPosicionInvalida(c); }
	}
	/**
	 * Metodo que devuelve un array de las celdas vecinas en sentido antihorario.
	 * @param c es la coordenada central, a partir de la cual quiero mirar.
	 * @return Devuelve un array que contiene entre 3 y 8 coordenadas vecinas a 'c'.
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada c) {
		ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		Coordenada otra;
		int i=(c.getX()-1);
		int j=(c.getY()-1);
		do {
			otra = new Coordenada(i,j);
			if(celdas.containsKey(otra))
				cordVecinas.add(otra);
			j++;
		} while(j<=(c.getY()+1));
		j--;
		i++;
		do {
			otra = new Coordenada(i,j);
			if(celdas.containsKey(otra))
				cordVecinas.add(otra);
			i++;
		}while(i<=(c.getX()+1));
		i--;
		j--;
		do {
			otra = new Coordenada(i,j);
			if(celdas.containsKey(otra))
				cordVecinas.add(otra);
			j--;
		}while(j>=(c.getY()-1));
		j++;
		i--;
		otra = new Coordenada(i,j);
		if(celdas.containsKey(otra))
			cordVecinas.add(otra);
		
		return cordVecinas;				
	}
	/**
	 * Metodo publico que se encarga de imprimir un error.
	 * @param c es la coordenada que dio el error.
	 */
	private void muestraErrorPosicionInvalida(Coordenada c) {
		System.out.println("Error: La celda " + c.toString() + " no existe");
	}
	/**
	 * Metodo publico que se encarga de intentar cargar un patron en el tablero.
	 * @param p es el patron a cargar.
	 * @param a es la coordenada a partir de la cual se intenta cargar.
	 * @return devuelve falso en caso de que no se pueda cargar y true en caso contrario.
	 */
	public boolean cargaPatron(Patron p, Coordenada a) {
		Iterator<Coordenada> iterator = p.getPosiciones().iterator();
		boolean copiar = true;
		
		while(iterator.hasNext() && copiar) {
			Coordenada key = iterator.next();
			if(this.contiene(key.suma(a)) == false) {
				muestraErrorPosicionInvalida(key.suma(a));
				copiar = false;
				return copiar;
			}
		}
		iterator = p.getPosiciones().iterator();
		while(iterator.hasNext()) {
			Coordenada key = iterator.next();
			Coordenada keyDefensiva = new Coordenada(key);
			celdas.put(keyDefensiva.suma(a), p.getCelda(keyDefensiva));
		}
		return copiar;
	}
	/**
	 * Metodo publico que se encarga de comprobar si una coordenada existe.
	 * @param otra es la coordenada a comprobar.
	 * @return devuelve true en caso de que la celda existe, false en caso contrario.
	 */
	public boolean contiene(Coordenada otra) {
		if(celdas.containsKey(otra)) { return true; }
		else
			return false;
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
				impTablero += celdas.get(new Coordenada(i,j)).getEstado(); 
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
