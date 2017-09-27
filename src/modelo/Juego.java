package modelo;

import java.util.ArrayList;

public class Juego {
	private ArrayList<Patron> patronesUsados;
	private Tablero tablero;
	private ReglaConway regla;
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero = tablero;
		this.regla = regla;
	}
	void cargaPatron(Patron p, Coordenada posicionInicial) {
		tablero.cargaPatron(p, posicionInicial);
	}
	public void actualiza() {
		
	}
	public Tablero getTablero() {
		return tablero;
	}
	public ArrayList<Patron> getPatrones() {
		return patronesUsados;
	}
}
