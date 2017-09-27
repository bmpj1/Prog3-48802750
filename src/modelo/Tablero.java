package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Tablero {
	private Coordenada dimensiones;
	private HashMap<Coordenada,EstadoCelda> celdas;
	public Tablero(Coordenada dims)
	{
		dimensiones = new Coordenada(dims);
		for(int i=0;i<dims.getX();i++) {
			for(int j=0;j<dims.getY();j++) {
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
		if(celdas.containsKey(c)) { muestraErrorPosicionInvalida(c); return null; }
		return celdas.get(c);
	}
	
	public void setCelda(Coordenada c, EstadoCelda e) {
		if(celdas.containsKey(c)) { celdas.put(c,e); }
		else { muestraErrorPosicionInvalida(c); }
	}
	
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada c) {
		return null;
	}
	
	private void muestraErrorPosicionInvalida(Coordenada c) {
		System.out.println("La celda " + c.toString() + " no existe");
	}
	
	public boolean cargaPatron(Patron p, Coordenada a) {
		Coordenada aux = new Coordenada(a.getX()-1,a.getY()-1);
		return false;
	}
	
	public boolean contiene(Coordenada otra) {
		return false;
	}
}
