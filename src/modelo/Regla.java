package modelo;

import modelo.excepciones.ExcepcionPosicionFueraTablero;

public abstract class Regla {
	public Regla() { }
	public abstract EstadoCelda calculaSiguienteEstadoCelda(Tablero t, Coordenada c) throws ExcepcionPosicionFueraTablero ;
}
