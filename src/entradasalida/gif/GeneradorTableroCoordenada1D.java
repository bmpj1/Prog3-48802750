package entradasalida.gif;

import java.io.File;
import java.util.Iterator;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.d1.Coordenada1D;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
/**
 * Clase que genera gifs a partir de tablero1d
 * @author Brian Mathias, Pesci Juliani
 */
public class GeneradorTableroCoordenada1D implements IGeneradorFichero {
	/**
	 * Constructor vacio.
	 */
	public GeneradorTableroCoordenada1D() { super(); }
	
	/** {@inheritDoc} */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void generaFichero(File fichero, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if(fichero==null || juego==null) { throw new ExcepcionArgumentosIncorrectos();}
		if(!(iteraciones > 0)) { throw new ExcepcionGeneracion("El valor de iteraciones tiene que ser mayor que 0"); }
		
		try {
			Coordenada1D dimensiones = (Coordenada1D) juego.getTablero().getDimensiones();
			ImagenGIF gif = new ImagenGIF(dimensiones.getX(), iteraciones);
			
			for(int j=0; j<iteraciones; j++) {
				/* Recorre las celdas del tablero. */
				Iterator<Coordenada1D> listaCoordenadasTablero = juego.getTablero().getPosiciones().iterator();
				
				while(listaCoordenadasTablero.hasNext()) {
					
					Coordenada1D posicion = (Coordenada1D) listaCoordenadasTablero.next();
					
					if(juego.getTablero().getCelda(posicion) == EstadoCelda.VIVA) {
						gif.pintaCuadrado(posicion.getX(),j);
					}
				}
				
				juego.actualiza();
			}
			 
			gif.guardaFichero(fichero);
			
		} catch (Exception e) {
			throw new ExcepcionEjecucion(e);
		}
	}

}
