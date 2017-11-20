package entradasalida;

import java.io.File;

import modelo.Juego;

public interface IGeneradorFichero {
	public void generaFichero(File fichero, Juego juego, int iteraciones);
}
