package modelo;

public class ReglaConway {
	private EstadoCelda e;
	public ReglaConway() {
		e = null;
	}
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) {
		return e = EstadoCelda.MUERTA;		
	}
}
