package entradasalida.imagen;

import java.io.File;
import java.util.Iterator;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import gifs.ImagenGIF;
import gifs.ImagenGIFAnimado;
import modelo.Coordenada;
import modelo.Coordenada2D;
import modelo.EstadoCelda;
import modelo.Juego;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;
/**
 * Clase que genera gif animados de tablero2d. 
 * @author Brian Mathias, Pesci Juliani
 */ 
public class GeneradorGifAnimadoTablero2D implements IGeneradorFichero {
	/**
	 * Constructor vacio
	 */
	public GeneradorGifAnimadoTablero2D() { super(); }
	
	@Override
	public void generaFichero(File fichero, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if(fichero==null || juego==null) { throw new ExcepcionArgumentosIncorrectos();}
		if(!(iteraciones > 0)) { throw new ExcepcionGeneracion("El valor de iteraciones tiene que ser mayor que 0"); }
		
		try {
			Coordenada2D dimensiones = (Coordenada2D) juego.getTablero().getDimensiones();

			ImagenGIFAnimado gifAnimado = new ImagenGIFAnimado(100);
			
			for(int j=0; j<iteraciones; j++) {
													/*		ANCHURA				ALTURA		*/
				ImagenGIF fotograma = new ImagenGIF(dimensiones.getX(), dimensiones.getY());

				/* Recorre las celdas del tablero. */
				Iterator<Coordenada> listaCoordenadasTablero = juego.getTablero().getPosiciones().iterator();
				while(listaCoordenadasTablero.hasNext()) {
					
					Coordenada2D posicion = (Coordenada2D) listaCoordenadasTablero.next();
					
					if(juego.getTablero().getCelda(posicion) == EstadoCelda.VIVA) {
						fotograma.pintaCuadrado(posicion.getX(),posicion.getY());
					}
				}
				gifAnimado.addFotograma(fotograma);
				juego.actualiza();
			}
			
			gifAnimado.guardaFichero(fichero);
/*-------------- ¿QUE PASA CON ESTE CATCH? -------------*/
		} catch (ExcepcionPosicionFueraTablero e) {
			throw new ExcepcionEjecucion(e);
		}/* catch (ExcepcionCoordenadaIncorrecta er) {
			throw new ExcepcionEjecucion(er);
		}*/
	}
	
}
