package entradasalida;
 
import java.io.File;

import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;
/**
 * Interfaz que enlaza los generadores de ficheros
 * @author Brian Mathias, Pesci Juliani
 */
public interface IGeneradorFichero {
	/**
	 * Metodo que genera un fichero.
	 * @param fichero fichero
	 * @param juego juego 
	 * @param iteraciones numero de iteraciones
	 * @throws ExcepcionGeneracion Excepcion que se puede lanzar.
	 */
	@SuppressWarnings("rawtypes")
	public void generaFichero(File fichero, Juego juego, int iteraciones) throws ExcepcionGeneracion;
}