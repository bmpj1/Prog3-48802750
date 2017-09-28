package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Juego {
	private ArrayList<Patron> patronesUsados;
	private Tablero tablero;
	private ReglaConway regla;
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero = tablero;
		this.regla = regla;
	}
	void cargaPatron(Patron p, Coordenada posicionInicial) {
		if(tablero.cargaPatron(p, posicionInicial)==true) {
			patronesUsados.add(p);
		} else {
			System.out.println("Error cargando plantilla "+p.getNombre()+ " en "+posicionInicial.toString());
		}
	}
	public void actualiza() {
		Tablero t = new Tablero(tablero.getDimensiones());
		Iterator<Coordenada> iterator = tablero.getPosiciones().iterator();
		while(iterator.hasNext()) {
			Coordenada key = iterator.next();
			t.setCelda(key, regla.calculaSiguienteEstadoCelda(tablero,key));
		}
		tablero = t;		
	}
	public Tablero getTablero() {
		return tablero;
	}
	public ArrayList<Patron> getPatrones() {
		return patronesUsados;
	}
}
