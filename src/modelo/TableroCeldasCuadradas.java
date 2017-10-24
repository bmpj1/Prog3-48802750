package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class TableroCeldasCuadradas extends Tablero2D {

	public TableroCeldasCuadradas(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		super(ancho, alto);
	}
	/**
	 * Metodo que devuelve un array de las celdas vecinas en sentido antihorario.
	 * @param c es la coordenada central, a partir de la cual quiero mirar.
	 * @return Devuelve un array que contiene entre 3 y 8 coordenadas vecinas a 'c'.
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		if(posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(!(posicion instanceof Coordenada2D)) {
			/*throw excepcion->la coordenada c no es una instancia de Coordenada2D*/
		}
		Coordenada2D c = (Coordenada2D) posicion;
		if(celdas.containsKey(c)==false) { throw new ExcepcionPosicionFueraTablero(dimensiones, c); }
		try {
			Coordenada2D otra;
			
			
			int i=(c.getX()-1);
			int j=(c.getY()-1);
			
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada2D(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				j++;
			} while(j<=(c.getY()+1));
			j--;
			i++;
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada2D(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				i++;
			}while(i<=(c.getX()+1));
			i--;
			j--;
			do {
				if(i>-1 && j>-1) {
					otra = new Coordenada2D(i,j);
					if(celdas.containsKey(otra))
						cordVecinas.add(otra);
				}
				j--;
			}while(j>=(c.getY()-1));
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
	 */
	public String toString() {
		Coordenada2D dims = (Coordenada2D) dimensiones;
		int X = dims.getX();
		int Y = dims.getY();
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
					impTablero += celdas.get(new Coordenada2D(i,j)).getEstado();
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
