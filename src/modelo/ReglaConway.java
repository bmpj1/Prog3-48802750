package modelo;

import java.util.Iterator;

public class ReglaConway {
	private EstadoCelda e;
	public ReglaConway() {
		e = null;
	}
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) {
		//ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		//cordVecinas = tablero.getPosicionesVecinasCCW(posicion);
		int vecinas=0;
		Iterator<Coordenada> cordVecinas = tablero.getPosicionesVecinasCCW(posicion).iterator();
		while(cordVecinas.hasNext()) {
			Coordenada key = cordVecinas.next();
			if(tablero.getCelda(key)==EstadoCelda.VIVA) {
				vecinas++;
			}
		}
		if(tablero.getCelda(posicion)==EstadoCelda.VIVA && (vecinas==2 || vecinas==3)) {
			e = EstadoCelda.VIVA;
		} 	else if(tablero.getCelda(posicion)==EstadoCelda.MUERTA && vecinas==3) {
				e = EstadoCelda.VIVA;
			} else {
				e = EstadoCelda.MUERTA;
			}
		return e;		
	}
}
