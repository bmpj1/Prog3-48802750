package entradasalida;
 
import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;
/**
 * Interfaz que parsea los tableros. 
 * @author Brian Mathias, Pesci Juliani
 */
public interface IParserTablero {
	/**
	 * Metodo que lee un tablero y lo parsea
	 * @param nombre nombre del tablero
	 * @return tablero devuelve un tablero
	 * @throws ExcepcionLectura excepcion que se da al leer.
	 */
	public Tablero leeTablero(String nombre) throws ExcepcionLectura; 
}
