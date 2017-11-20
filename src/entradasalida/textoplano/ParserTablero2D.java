package entradasalida.textoplano;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada1D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

public class ParserTablero2D implements IParserTablero{

	public ParserTablero2D() { }
	@Override
	public Tablero leeTablero(String cadena) throws ExcepcionLectura {
		if(cadena == null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(cadena == "") { throw new ExcepcionLectura("No se aceptan cadenas vacias."); }
		Tablero1D tablero = null;
		
		try {
			int ancho = 0;
			int alto = 0;
			for(int i=0; i<cadena.length(); i++) {
				if(cadena.charAt(i) == '\n') {
					break;
				}
				ancho++;
			}
			for(int i=0; i<cadena.length(); i++) {
				if(cadena.charAt(i) != ' ' && cadena.charAt(i) != '*' cadena.charAt(i) != '\n') {
					throw new ExcepcionLectura("La cadena no es válida.");
				}
				if(i%ancho== 0) {
						alto++;
					} else {
						throw new ExcepcionLectura("Las dimensiones no son correctas.");
					}
				}
			}
			tablero = new Tablero1D(cadena.length());
		
			
			
		} catch (ExcepcionCoordenadaIncorrecta e1) {
			throw new ExcepcionEjecucion(e1);
		} catch (ExcepcionPosicionFueraTablero e1) {
			throw new ExcepcionEjecucion(e1);
		}
		return tablero;
	}

}
