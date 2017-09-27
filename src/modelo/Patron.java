package modelo;

import java.util.Collection;

public class Patron {
	private String nombre;
	private Tablero tablero;
	public Patron(String nombre, Tablero tablero) {
		this.nombre = nombre;
		this.tablero = tablero;
	}
	public String getNombre() { return nombre; }
	public EstadoCelda getCelda(Coordenada c) {
		
		return null;
	}
	public Collection<Coordenada> getPosiciones() {
		return null;
	}
	public String toString() {
		return null;
	}
}
