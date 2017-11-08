package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Tablero1D extends Tablero {
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

	@Override
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		if(posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(!(posicion instanceof Coordenada1D)) {
			/*throw excepcion->la coordenada c no es una instancia de Coordenada2D*/
		}
		Coordenada1D c = (Coordenada1D) posicion;
//****************¿hay que hacer este try~catch igual que en Coordenada2d?******
		try {
			
			if((c.getX()-1)>-1 && celdas.containsKey(new Coordenada1D(c.getX()-1))) { cordVecinas.add(new Coordenada1D(c.getX()-1)); }
			if(celdas.containsKey(new Coordenada1D(c.getX()+1))) { cordVecinas.add(new Coordenada1D(c.getX()+1)); }
		} catch(ExcepcionCoordenadaIncorrecta e) {
			throw new ExcepcionEjecucion(e);
		}
//******************************************************************************
		return cordVecinas;
	}

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
	
}
