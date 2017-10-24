package modelo;

import java.util.Iterator;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class Regla30 extends Regla {
	
	public Regla30() {}
	
	//current pattern 			111 110 101 100 011 010 001 000
	//new state for center cell  0 	 0 	 0 	 1 	 1 	 1 	 1   0
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		if(tablero==null || posicion==null) { throw new ExcepcionArgumentosIncorrectos(); }
//**** ¿Hay que comprobar que posicion sea una instancia de Coordenada1D?
		Coordenada1D pos = (Coordenada1D) posicion;
		String vecinas="";
		Iterator<Coordenada> cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
		
		// Contar el número de celdas vecinas.
		int i = 0;
		while(cordVecinas.hasNext()) {
		    i++;
		    cordVecinas.next();
		}
		
		cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
		// Si hay 2 vecinas
		if(i==2) {
			// (x-1)
			Coordenada1D key = (Coordenada1D) cordVecinas.next();
			vecinas += tablero.getCelda(key).getEstado();
			// (x);
			vecinas += tablero.getCelda(pos).getEstado();
			// (x+1)
			key = (Coordenada1D) cordVecinas.next();
			vecinas += tablero.getCelda(key).getEstado();
		}
		// Si hay 1 vecina.
		else if(i==1) {
			Coordenada1D key = (Coordenada1D) cordVecinas.next();
			// Si (x-1) existe
			if(key.getX()<pos.getX()) { 
				vecinas += tablero.getCelda(key).getEstado();
				vecinas += tablero.getCelda(pos).getEstado(); 
				vecinas += " ";
			}
			// Si (x+1) existe
			if(key.getX()>pos.getX()) {
				vecinas += " ";
				vecinas += tablero.getCelda(pos).getEstado(); 
				vecinas += tablero.getCelda(key).getEstado();
			}
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
		return null;
	}
}
