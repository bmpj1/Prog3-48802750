package modelo;

import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;

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
}
