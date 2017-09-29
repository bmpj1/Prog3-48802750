package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Tablero {
	private Coordenada dimensiones;
	private HashMap<Coordenada,EstadoCelda> celdas;
	public Tablero(Coordenada dims)
	{
		dimensiones = new Coordenada(dims);
		celdas = new HashMap<Coordenada,EstadoCelda>();
		for(int j=0;j<dims.getY();j++) {
			for(int i=0;i<dims.getX();i++) {
				celdas.put(new Coordenada(i,j), EstadoCelda.MUERTA);
			}
		}
	}
	/**
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
		
	}
	
	public Collection<Coordenada> getPosiciones() {
		return celdas.keySet();
	}
	
	public EstadoCelda getCelda(Coordenada c) {
		if(celdas.containsKey(c)==false) { muestraErrorPosicionInvalida(c); return null; }
		return celdas.get(c);
	}
	
	public void setCelda(Coordenada c, EstadoCelda e) {
		if(celdas.containsKey(c)) { celdas.put(c,e); }
		else { muestraErrorPosicionInvalida(c); }
	}
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada c) {
		ArrayList<Coordenada> cordVecinas = new ArrayList<Coordenada>();
		Coordenada otra;
		/**i 1 2 3 
		 * j ------
		 * 0|0 7 6
		 * 1|1 - 5
		 * 2|2 3 4
		 */
		int j=(c.getY()-1);
		int i=(c.getX()-1);
		// Mantiene constante la i con valor X-1
		// Y aumenta j hasta Y+1
		do {
			otra = new Coordenada(i,j);
			if(celdas.containsKey(otra))
				cordVecinas.add(otra);
			j++;
		} while(j<=(c.getY()+1));
		j--;
		i++;
		// Mantiene constante la j con valor Y+1
		// Y aumenta i hasta X+1
		do {
			otra = new Coordenada(i,j);
			if(celdas.containsKey(otra))
				cordVecinas.add(otra);
			i++;
		}while(i<=(c.getX()+1));
		i--;
		j--;
		// Mantiene constante la i con valor X+1
		// Y disminuye j hasta Y-1
		do {
			otra = new Coordenada(i,j);
			if(celdas.containsKey(otra))
				cordVecinas.add(otra);
			j--;
		}while(j>=(c.getY()-1));
		j++;
		i--;
		// Mantiene constante la j con valor Y-1
		// Y disminuye i hasta X
			otra = new Coordenada(j,i);
			if(celdas.containsKey(otra))
				cordVecinas.add(otra);
		
		return cordVecinas;				
	}
	
	private void muestraErrorPosicionInvalida(Coordenada c) {
		System.out.println("La celda " + c.toString() + " no existe");
	}
	
	public boolean cargaPatron(Patron p, Coordenada a) {
		Iterator<Coordenada> iterator = p.getPosiciones().iterator();
		boolean copiar = true;
		
		while(iterator.hasNext() && copiar) {
			Coordenada key = iterator.next();
			if(contiene(key.suma(a)) == false) {
				muestraErrorPosicionInvalida(key.suma(a));
				copiar = false;
				return copiar;
			}
		}
		iterator = p.getPosiciones().iterator();
		while(iterator.hasNext() && copiar == true) {
			Coordenada key = iterator.next();
			celdas.put(key, p.getCelda(key));
		}
		return copiar;
	}
	
	public boolean contiene(Coordenada otra) {
		if(celdas.containsKey(otra)) { return true; }
		else
			return false;
	}
}
/**REFERENCIAS:
*	HashMap: https://www.youtube.com/watch?v=TX5Sucd1CRA
*		 https://www.youtube.com/watch?v=RzTkm_FJRf8
*		 http://www.dlsi.ua.es/asignaturas/prog3/jcf_facil.html#mapas
*
*	ArrayList: https://www.youtube.com/watch?v=XSDhZgSP7G8
*/
