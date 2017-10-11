package modelo;
/**
 * 
 * @author Brian Mathias, Pesci Juliani
 */
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase principal del programa que se encarga de enlazar una regla con un tablero y muchos patrones.
 */
public class Juego {
	/**
	 * Atributo privado que almacena un array con los patrones usados en este juego.
	 */
	private ArrayList<Patron> patronesUsados;
	/**
	 * Atributo privado que asocia un juego con un tablero.
	 */
	private Tablero tablero;
	/**
	 * Atributo privado que asocia un juego con una regla.
	 */
	private ReglaConway regla;
	/**
	 * Constructor que inicializa los atributos tablero y regla.
	 * @param tablero donde se desarrollara el juego de la vida.
	 * @param regla que se encargará de actualizar las celdas del juego.
	 */
	public Juego(Tablero tablero, ReglaConway regla) {
		this.tablero = tablero;
		this.regla = regla;
		patronesUsados = new ArrayList<Patron>();
	}
	/**
	 * Metodo publico que se encarga de intentar cargar un patron en el tablero a partir de una celda inicial, en caso de fallo imprime un error.
	 * @param p es el patron a cargar.
	 * @param posicionInicial indica la celda a partir de cual cargar el patron.
	 */
	public void cargaPatron(Patron p, Coordenada posicionInicial) {
		if(tablero.cargaPatron(p, posicionInicial)==true) {
			patronesUsados.add(p);
		} else {
			System.out.println("Error cargando plantilla "+p.getNombre()+ " en "+posicionInicial.toString());
		}
	}
	/**
	 * Metodo publico que actualiza el tablero. Para ello utiliza la regla y el tablero.
	 */
	public void actualiza() {
		Tablero t = new Tablero(tablero.getDimensiones());
		Iterator<Coordenada> iterator = tablero.getPosiciones().iterator();
		while(iterator.hasNext()) {
			Coordenada key = iterator.next();
			t.setCelda(key, regla.calculaSiguienteEstadoCelda(tablero,key));
		}
		tablero = t;		
	}
	/**
	 * Metodo publico que devuelve el tablero.
	 * @return Devuelve la dirección de memoria del tablero.
	 */
	public Tablero getTablero() {
		return tablero;
	}
	/**
	 * Metodo publico que devuelve un array con los patrones utilizados.
	 * @return un array con los patrones usados.
	 */
	public ArrayList<Patron> getPatrones() {
		return patronesUsados;
	}
}
