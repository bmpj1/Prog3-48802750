package modelo.excepciones;

import modelo.Coordenada;

public class ExcepcionPosicionFueraTablero extends Exception {
	private Coordenada dimensiones;
	private Coordenada coordenada;
	public ExcepcionPosicionFueraTablero(Coordenada dimensiones, Coordenada coordenada) {
		this.dimensiones = dimensiones;
		this.coordenada = coordenada;
	}
	public String getMessage() {
		return ("mirar mensaje");
	}
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	public Coordenada getCoordenada() {
		return coordenada;
	}
	
}
