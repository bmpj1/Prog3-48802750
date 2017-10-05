package modelo;

import java.util.Iterator;

public class ReglaConway {
	private EstadoCelda nuevoEstado;
	public ReglaConway() {
		nuevoEstado = null;
	}
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) {
		//ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		//cordVecinas = tablero.getPosicionesVecinasCCW(posicion);
		int vecinas=0;
		Iterator<Coordenada> cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
		while(cordVecinas.hasNext() && vecinas!=4) {
			Coordenada key = cordVecinas.next();
			if(tablero.getCelda(key)==EstadoCelda.VIVA) {
				vecinas++;
			}
		}
		if(tablero.getCelda(posicion)==EstadoCelda.VIVA && (vecinas==2 || vecinas==3)) {
			nuevoEstado = EstadoCelda.VIVA;
		} 	else if(tablero.getCelda(posicion)==EstadoCelda.MUERTA && vecinas==3) {
			nuevoEstado = EstadoCelda.VIVA;
			} else {
				nuevoEstado = EstadoCelda.MUERTA;
			}
		return nuevoEstado;		
	}
}
