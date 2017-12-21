package modelo.d2;
 
import modelo.EstadoCelda;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
/**
 * Clase que hereda de la clase abstracta Tablero. Representa la matriz de celdas bidimensionales usadas en el juego de la vida.
 * @author Brian Mathias, Pesci Juliani
 */
public abstract class Tablero2D extends Tablero<Coordenada2D> {
	/**
	 * Constructor que crea un tablero de dos dimensiones y pone todas sus celdas como muertas.
	 * @param ancho Es la anchura del tablero.
	 * @param alto Es la altura del tablero.
	 * @throws ExcepcionCoordenadaIncorrecta Lanza la excepcion cuando el ancho o el alto es negativo.
	 */
	public Tablero2D(int ancho, int alto) throws ExcepcionCoordenadaIncorrecta {
		
		super(new Coordenada2D(ancho,alto));
		Coordenada2D dims = new Coordenada2D(ancho,alto);
		
		for(int j=0;j<dims.getY();j++) {
			for(int i=0;i<dims.getX();i++) {
				try {
					celdas.put(new Coordenada2D(i,j), EstadoCelda.MUERTA);
				} catch(ExcepcionCoordenadaIncorrecta e) {
					throw new ExcepcionEjecucion(e);
				}
			}
 		}
	}
	
}
