package entradasalida;
 
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Coordenada;
import modelo.Regla;
import modelo.Tablero;
import modelo.d1.Coordenada1D;
import modelo.d1.Regla30;
import modelo.d1.Tablero1D;
import modelo.d2.Coordenada2D;
import modelo.d2.ReglaConway;
import modelo.d2.Tablero2D;
import modelo.d2.TableroCeldasCuadradas;
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
	@SuppressWarnings("rawtypes")
	public static IGeneradorFichero creaGeneradorFichero(Tablero tablero,String extension) throws ExcepcionGeneracion 
	{
		if(tablero==null || extension==null) { throw new ExcepcionArgumentosIncorrectos(); }
		IGeneradorFichero genFich= null;
		// Creo la dirección de la clase
		String dirClase = "entradasalida."+ extension + ".GeneradorTablero" + tablero.getDimensiones().getClass().getSimpleName();
/* ---------------------- PREGUNTAR POR ESTE TRY-CATCH --------------------- */
			// Intento instanciar a IGeneradorFichero
			try {
				genFich = (IGeneradorFichero) Class.forName(dirClase).newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new ExcepcionGeneracion(e);
			} catch (ClassNotFoundException e) {
				throw new ExcepcionGeneracion("GeneradorTablero" + tablero.getDimensiones().getClass().getSimpleName());
			}
	
/*DUDA:
 * ·¿El parametro Tablero se podría poner como Tablero<? extends Coordenada> para quitar el warning?
 */
		
 /*---------------------------------------------------------------------------- */
		
		/*
		if(extension.equals("txt")) {
			genFich = new GeneradorFicheroPlano();
			
		} else 
		if(extension.equals("gif")) {
			if(tablero instanceof Tablero1D) 
			{
				genFich = new GeneradorTableroCoordenada1D();
			} else
			if(tablero instanceof Tablero2D) {
				genFich = new GeneradorTableroCoordenada2D();
			} else {
				throw new ExcepcionEjecucion("El tablero no es valido.");
			}
		} else { throw new ExcepcionGeneracion("La extension del archivo no es válida."); }
		*/
		return genFich; 
	}
	/**
	 * Metodo statico que crea reglas para un tablero
	 * @param tablero tablero
	 * @return regla devuelve la regla creada
	 */
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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
/* REFERENCIAS:
 * 		Class: https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html
 * 		Reflexion: http://java-white-box.blogspot.com.es/2016/02/api-reflect-que-es-reflexion-por-donde.html
 * 		Genericidad en Java: http://dis.um.es/docencia/poo/wiki/lib/exe/fetch.php?media=curso2013:tema4-1.pdf
 * 		
 * */