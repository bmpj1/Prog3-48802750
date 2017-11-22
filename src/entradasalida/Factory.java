package entradasalida;

import java.util.ArrayList;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.*;
import modelo.excepciones.*;

public class Factory {
	public Factory() { super(); }
	
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero,String extension) throws ExcepcionGeneracion 
	{
		if(tablero==null || extension==null) { throw new ExcepcionArgumentosIncorrectos(); }
		IGeneradorFichero genFich= null;
		if(extension.equals("txt")) {
			genFich = new GeneradorFicheroPlano();
			
		} else 
		if(extension.equals("gif")) {
			if(tablero instanceof Tablero1D) 
			{
				genFich = new GeneradorGIFTablero1D();
			} else
			if(tablero instanceof Tablero2D) {
				genFich = new GeneradorGifAnimadoTablero2D();
			} else {
				throw new ExcepcionEjecucion("El tablero no es valido.");
			}
		} else { throw new ExcepcionGeneracion("La extension del archivo no es válida."); }
		
		return genFich; 
	}
	
	public static Regla creaRegla(Tablero tablero) {
		if(tablero==null) { throw new ExcepcionArgumentosIncorrectos(); }
		Regla regla = null;
		
		if(tablero instanceof Tablero1D) {
			regla = new Regla30();
			
		} else
		if(tablero instanceof Tablero2D){
			regla = new ReglaConway();
			
		} else {throw new ExcepcionEjecucion("El tablero no es valido."); }
		
		return regla; 
	}
	
	public static Tablero creaTablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta {
		if(dimensiones==null) { throw new ExcepcionArgumentosIncorrectos(); }

		if(dimensiones instanceof Coordenada1D) {
			Coordenada1D dims = (Coordenada1D) dimensiones;
			return new Tablero1D(dims.getX());
			
		} else
		if(dimensiones instanceof Coordenada2D){
			Coordenada2D dims = (Coordenada2D) dimensiones;
			return new TableroCeldasCuadradas(dims.getX(),dims.getY());
		} else { throw new ExcepcionEjecucion("El tablero no es valido."); }
		
	}
}