package entradasalida;

import entradasalida.excepciones.ExcepcionGeneracion;
import entradasalida.imagen.GeneradorGIFTablero1D;
import entradasalida.imagen.GeneradorGifAnimadoTablero2D;
import entradasalida.textoplano.GeneradorFicheroPlano;
import modelo.Coordenada;
import modelo.Coordenada1D;
import modelo.Coordenada2D;
import modelo.Regla;
import modelo.Regla30;
import modelo.ReglaConway;
import modelo.Tablero;
import modelo.Tablero1D;
import modelo.Tablero2D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
/**
 * Clase que se encarga de generar instancias. 
 * @author Brian Mathias, Pesci Juliani
 */
public class Factory {
	/**
	 * Constructor base que no hace nada.
	 */
	public Factory() { super(); }
	/**
	 * Metodo estatico que genera ficheros
	 * @param tablero tablero
	 * @param extension extension .txt|.gif
	 * @return genFich Fichero creado
	 * @throws ExcepcionGeneracion Excepcion que se da cuando la extension no es valida.
	 */
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
	/**
	 * Metodo statico que crea reglas para un tablero
	 * @param tablero tablero
	 * @return regla devuelve la regla creada
	 */
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
	/**
	 * Metodo estatico que crea tableros a partir de unas dimensiones
	 * @param dimensiones Coordenada1d o 2d para crear el tablero
	 * @return tablero devuelve el tablero creado.
	 * @throws ExcepcionCoordenadaIncorrecta Excepcion que se da cuando el tablero no es valido
	 */
	public static Tablero creaTablero(Coordenada dimensiones) throws ExcepcionCoordenadaIncorrecta {
		if(dimensiones==null) { throw new ExcepcionArgumentosIncorrectos(); }
		Tablero tablero = null;
		if(dimensiones instanceof Coordenada1D) {
			Coordenada1D dims = (Coordenada1D) dimensiones;
			tablero = new Tablero1D(dims.getX());
			
		} else
		if(dimensiones instanceof Coordenada2D){
			Coordenada2D dims = (Coordenada2D) dimensiones;
			tablero = new TableroCeldasCuadradas(dims.getX(),dims.getY());
		} else { throw new ExcepcionEjecucion("El tablero no es valido."); }
		return tablero;
	}
}