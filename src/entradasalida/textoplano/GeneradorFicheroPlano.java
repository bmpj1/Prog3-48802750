package entradasalida.textoplano;

import java.io.File;
import java.io.PrintWriter;

import entradasalida.IGeneradorFichero;
import entradasalida.excepciones.ExcepcionGeneracion;
import modelo.Juego;
import modelo.Tablero1D;
import modelo.TableroCeldasCuadradas;
import modelo.excepciones.ExcepcionArgumentosIncorrectos;

/******
 * 
 * @author Usuario
 *
 */
public class GeneradorFicheroPlano implements IGeneradorFichero{

	public GeneradorFicheroPlano() { super(); }
	
	@Override
	public void generaFichero(File file, Juego juego, int iteraciones) throws ExcepcionGeneracion {
		if(file==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(juego==null) { throw new ExcepcionArgumentosIncorrectos(); }
		if(!(iteraciones > 0)) {throw new ExcepcionGeneracion("Las parametro iteraciones no es MAYOR QUE CERO"); }
		
		try {
			PrintWriter p = new PrintWriter(file);
			
			for(int i=0; i<iteraciones; i++) {
				// MIRAR LA PREGUNTA QUE ESTA EN LA CLASE TABLERO
				juego.actualiza();
				if(juego.getTablero() instanceof Tablero1D) {
					Tablero1D tablero = (Tablero1D) juego.getTablero();
					p.print(tablero.generaCadena());
				} else
				if(juego.getTablero() instanceof TableroCeldasCuadradas) {

					TableroCeldasCuadradas tablero = (TableroCeldasCuadradas) juego.getTablero();
					p.print(tablero.generaCadena());
				} else {
					throw new ExcepcionGeneracion("El tablero del juego no implementa la interfaz Imprimible.");
				}

			}
			p.close();
		} catch (Exception e) {
			throw new ExcepcionGeneracion(e);
		}
	}

}
