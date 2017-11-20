package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que hereda de la clase abstracta Tablero. Representa la matriz de celdas unidimensionales usadas en el juego de la vida.
 * @author Brian Mathias, Pesci Juliani
 */
public class Tablero1D extends Tablero implements Imprimible {
	/**
	 * Constructor que crea un tablero a partir de un entero que define su anchura.
	 * @param x Es la anchura del tablero.
	 * @throws ExcepcionCoordenadaIncorrecta Se lanza cuando la coordenada no es valida.
	 */
	public Tablero1D(int x) throws ExcepcionCoordenadaIncorrecta {
		super(new Coordenada1D(x));
		for(int i=0;i<x;i++) {
			try {
				celdas.put(new Coordenada1D(i), EstadoCelda.MUERTA);
			} catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
		}
	}
	/**
	 * Metodo que devuelve un array de las celdas vecinas en sentido antihorario.
	 * @param posicion es la coordenada central, a partir de la cual quiero mirar.
	 * @return Devuelve un array que contiene entre 1 y 2 coordenadas vecinas a 'c'.
	 * @throws ExcepcionPosicionFueraTablero Lanza la excepcion cuando la celda no existe.
	 */
	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		if(posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if((posicion instanceof Coordenada1D)) {
			Coordenada1D c = (Coordenada1D) posicion;
	//****************¿hay que hacer este try~catch igual que en Coordenada2d?******
			try {
				// Faltaba comprobar si la celda que me pasan existe... T_T
				if(celdas.containsKey(c)==false) { throw new ExcepcionPosicionFueraTablero(dimensiones, c); }
				
				if((c.getX()-1)>-1 && celdas.containsKey(new Coordenada1D(c.getX()-1))) { cordVecinas.add(new Coordenada1D(c.getX()-1)); }
				if(celdas.containsKey(new Coordenada1D(c.getX()+1))) { cordVecinas.add(new Coordenada1D(c.getX()+1)); }
			} catch(ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
//******************************************************************************
		}
		return cordVecinas;
	}
	/**
	 * Metodo que hace una representacion gráfica del tablero en formato string.
	 */
	@Override
	public String toString() {
		Coordenada1D dims = (Coordenada1D) dimensiones;
		int X = dims.getX();
		String impTablero = new String("");

		impTablero += "|";
		for(int j=0; j<X;j++) {
// ***********Cuidado con esta linea****************.
			try {
				impTablero += celdas.get(new Coordenada1D(j)).getEstado();
			} catch (ExcepcionCoordenadaIncorrecta e) {
				throw new ExcepcionEjecucion(e);
			}
//**************************************************.
		}
		impTablero += "|\n";
		
		return impTablero;
 	}
	@Override
	public String generaCadena() {
		return this.toString();
	}
	
}
