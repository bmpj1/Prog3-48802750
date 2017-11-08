package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

public class Coordenada1D extends Coordenada {
	private int x;
	public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta {
		if(x<0) { throw new ExcepcionCoordenada1DIncorrecta(x); }
		this.x=x;
	}
	public Coordenada1D(Coordenada1D c) {
		if(c==null) { throw new ExcepcionArgumentosIncorrectos(); }
		this.x = c.x;
	}
	public String toString() {
		return "("+x+")";
	}
	public int getX() { return x; }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) obj;
		if (x != other.x)
			return false;
		return true;
	}
	@Override
	public Coordenada1D suma(Coordenada c) throws ExcepcionCoordenadaIncorrecta {
		if(c==null) { throw new ExcepcionArgumentosIncorrectos(); }
		Coordenada1D nuevaCoordenada = null;
		if((c instanceof Coordenada1D)) {
			Coordenada1D other = (Coordenada1D) c;
			nuevaCoordenada = new Coordenada1D(x+other.getX());
		}
		return (nuevaCoordenada);
	}

}
