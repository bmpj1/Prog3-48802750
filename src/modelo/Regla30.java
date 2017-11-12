package modelo;

import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Regla30 extends Regla {
	
	public Regla30() {}
	/**
	 * Implementacion del Metodo abstracto de la clase regla que se va a encargar de calcular el nuevo estado de una Coordenada1D del tablero1D.
	 * @param t Es el Tablero1D a analizar.
	 * @param c Es la posicion a analizar.
	 * @return EstadoCelda Es el próximo estado de la celda.
	 * @throws ExcepcionPosicionFueraTablero Lanza la excepcion cuando la posición está fuera del tablero.
	 */
	@Override
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(tablero==null || posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
		
		if( (posicion instanceof Coordenada1D) && (tablero instanceof Tablero1D) ) {
			String vecinas="";
			Iterator<Coordenada> cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
			int i = 0;
			while(cordVecinas.hasNext()) {
			    i++;
			    cordVecinas.next();
			}
			
			cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
			/* Si hay 2 vecinas */
			if(i==2) {
				/* (x-1) */
				Coordenada key = cordVecinas.next();
				vecinas += tablero.getCelda(key).getEstado();
				/* (x) */
				vecinas += tablero.getCelda(posicion).getEstado();
				/* (x+1) */
				key = cordVecinas.next();
				vecinas += tablero.getCelda(key).getEstado();
			}
			
			switch(vecinas)
			{
				case "***":
					return (EstadoCelda.MUERTA);
				case "** ":
					return (EstadoCelda.MUERTA);
				case "* *":
					return (EstadoCelda.MUERTA);
				case "*  ":
					return (EstadoCelda.VIVA);
				case " **":
					return (EstadoCelda.VIVA);
				case " * ":
					return (EstadoCelda.VIVA);
				case "  *":
					return (EstadoCelda.VIVA);
				case "   ":
					return (EstadoCelda.MUERTA);
			}
	
			/* Si hay 1 vecina. */
			return EstadoCelda.MUERTA;
		}
		return null;
	}
}
