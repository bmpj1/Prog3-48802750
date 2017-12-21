package entradasalida.txt;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Tablero1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que parsea tableros 1d
 * @author Brian Mathias, Pesci Juliani
 */
public class ParserTablero1D implements IParserTablero{
	/**
	 * Constructor vacio.
	 */
	public ParserTablero1D() { }
	/** {@inheritDoc} */
	public Tablero<Coordenada1D> leeTablero(String cadena) throws ExcepcionLectura {
		if(cadena == null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(cadena == "") { throw new ExcepcionLectura("No se aceptan cadenas vacias."); }
		Tablero1D tablero = null;
		
		try {
			tablero = new Tablero1D(cadena.length());
		
			for(int i=0; i<cadena.length(); i++) {
				
				if(cadena.charAt(i)==' '){
					tablero.setCelda(new Coordenada1D(i), EstadoCelda.MUERTA);
				}
				else if(cadena.charAt(i)=='*') {
					tablero.setCelda(new Coordenada1D(i), EstadoCelda.VIVA);
				} 
				else {
					throw new ExcepcionLectura("El signo "+cadena.charAt(i)+" no es válido");
				}
				
			}
			
		} catch (ExcepcionCoordenadaIncorrecta e1) {
			throw new ExcepcionEjecucion(e1);
		} catch (ExcepcionPosicionFueraTablero e1) {
			throw new ExcepcionEjecucion(e1);
		}
		return tablero;
	}
	 
}
