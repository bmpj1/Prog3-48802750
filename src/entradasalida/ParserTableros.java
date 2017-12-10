package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
/**
 * Clase que se encarga de parsear tableros 
 * @author Brian Mathias, Pesci Juliani
 */
public class ParserTableros {
	/**
	 * Constructor vacio.
	 */
	public ParserTableros() { }
	/**
	 * Metodo que devuelve un tablero
	 * @param cadena cadena a descomponer
	 * @return pt1d.leeTablero(cadena) devuelve el tablero creado
	 * @throws ExcepcionLectura excepcion que se da al leer la cadena.
	 */
	public static Tablero leeTablero(String cadena) throws ExcepcionLectura {
		
		if(cadena==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(cadena=="") { throw new ExcepcionLectura("La cadena está vacía"); }
		
		for(int i=0; i<cadena.length(); i++) {
			if(cadena.charAt(i) == '\n') {
				ParserTablero2D pt2d = new ParserTablero2D();
				return pt2d.leeTablero(cadena);
			}
		}
		ParserTablero1D pt1d = new ParserTablero1D();
		return pt1d.leeTablero(cadena);
	}
}
