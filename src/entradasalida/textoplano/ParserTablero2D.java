package entradasalida.textoplano;

import java.util.HashMap;

import entradasalida.IParserTablero;
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Coordenada;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.TableroCeldasCuadradas;
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
		TableroCeldasCuadradas tablero = null;
		
		try {
			int ancho = 0;
			int alto = 0;
			int celdasPorLinea = 0;
			HashMap<Coordenada, EstadoCelda> hash = new HashMap<Coordenada,EstadoCelda>();
			
			for(int i=0; i<cadena.length();i++) {
				if(cadena.charAt(i) != ' ' && cadena.charAt(i) != '*' && cadena.charAt(i) != '\n') { throw new ExcepcionLectura("La cadena no es válida."); }
				
				if(cadena.charAt(i)=='\n' && (i+1)<cadena.length()) {
					if(alto==0) { celdasPorLinea=ancho; }alto++;
					if(ancho != celdasPorLinea) { throw new ExcepcionLectura("El tablero no tiene unas dimensiones válidas"); }
					
					ancho=0;
					
				} else {
					if(cadena.charAt(i)!='\n') { 
						ancho++;
						
						Coordenada2D key = new Coordenada2D(ancho-1, alto);
						EstadoCelda value = null;
				
						if(cadena.charAt(i)=='*') { value = EstadoCelda.VIVA; }
						else if(cadena.charAt(i)==' ') { value = EstadoCelda.MUERTA; }
						
						hash.put(key, value);
					}
				}
			}
			/* Comprobar si la ultima linea esta bien */
			if(ancho != celdasPorLinea) { throw new ExcepcionLectura("El tablero no tiene unas dimensiones válidas"); }
			alto++;
			
			tablero = new TableroCeldasCuadradas(ancho,alto);
			
			for(int j=0;j<alto; j++) {
				
				for(int i=0; i<ancho; i++) {
					
					tablero.setCelda(new Coordenada2D(i,j), hash.get(new Coordenada2D(i,j)));
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
