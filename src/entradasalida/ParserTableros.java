package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import entradasalida.textoplano.ParserTablero1D;
import entradasalida.textoplano.ParserTablero2D;
import modelo.Tablero;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

public class ParserTableros {
	public ParserTableros() { }
	
	public static Tablero leeTablero(String cadena) throws ExcepcionLectura {
		/*Da un error de ExcepcionLectura cuando la entrada sea vacía, o ExcepcionArgumentosIncorrectos 
		 * cuando el parámetro pasado es null. 
		 * Reenvía las excepciones recibidas desde ParserTablero1D y ParserTablero2D.
		if(cadena==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(cadena=="") { throw new ExcepcionLectura("La cadena está vacía"); }
		*/
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
