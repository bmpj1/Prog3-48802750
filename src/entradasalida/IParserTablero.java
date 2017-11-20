package entradasalida;

import entradasalida.excepciones.ExcepcionLectura;
import modelo.Tablero;

public interface IParserTablero {
	public Tablero leeTablero(String nombre) throws ExcepcionLectura; 
}
