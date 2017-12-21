package modelo.d2;
 
import java.util.ArrayList;

import modelo.EstadoCelda;
import modelo.Imprimible;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que hereda de la clase abstracta Tablero2D. Representa la matriz de celdas bidimensionales usadas en el juego de la vida.
 * @author Brian Mathias, Pesci Juliani
 */
public class TableroCeldasCuadradas extends Tablero2D implements Imprimible {
	/**
	 * Constructor que crea un tablero de 2 dimensiones delegando la funcionalidad a la superClase.
	 * @param ancho Anchura del tablero.
	 * @param alto Altura del tablero.
	 * @throws ExcepcionCoordenadaIncorrecta Lanza la excepcion cuando alguno de sus parametros es negativo.
	 */
	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho, alto);
	}
	/**
	 * Implementacion del Metodo abstracto que devuelve un array de las celdas vecinas en sentido antihorario.
	 * @param posicion Es la coordenada central, a partir de la cual quiero mirar.
	 * @return Devuelve un array que contiene entre 3 y 8 coordenadas vecinas a 'c'.
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public ArrayList<Coordenada2D> getPosicionesVecinasCCW(Coordenada2D posicion) throws ExcepcionPosicionFueraTablero {
		ArrayList<Coordenada2D> cordVecinas = new ArrayList<Coordenada2D>();
		if(posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		
		if(celdas.containsKey(posicion)==false) { throw new ExcepcionPosicionFueraTablero(dimensiones, posicion); }
		try {
			Coordenada2D otra;
			
			int i=(posicion.getX()-1);
			int j=(posicion.getY()-1);
			
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada2D(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				j++;
			} while(j<=(posicion.getY()+1));
			j--;
			i++;
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada2D(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				i++;
			}while(i<=(posicion.getX()+1));
			i--;
			j--;
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada2D(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				j--;
			}while(j>=(posicion.getY()-1));
			j++;
			i--;
			if(i>-1 && j>-1) {
				otra = new Coordenada2D(i,j);
				if(celdas.containsKey(otra))
					cordVecinas.add(otra);
			}
		} catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
		return cordVecinas;				
	}
	/**
	 * Metodo que devuelve el tablero en formato string.
	 * @return String Devuelve el tablero en formato String.
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
					EstadoCelda estado = (EstadoCelda) celdas.get(new Coordenada2D(i,j));
					impTablero += estado.getEstado();
				} catch (ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
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
	@Override
	public String generaCadena() {
		return this.toString();
	}
}
