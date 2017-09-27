package modelo;
public class Tablero {
	/** @Atributo Dimensiones es un objeto de la clase Coordena. */
	private Coordenada dimensiones;
	/**
	 * Constructor base de la clase tablero, crea una nueva Coordenada en el tablero.
	 * Para ello utiliza el constructor de copia de la clase Coordenada.
	 * @param dims
	 */
	public Tablero(Coordenada dims)
	{
		dimensiones = new Coordenada(dims);
	}
	/**
	 * @return the dimensiones
	 */
	public Coordenada getDimensiones() {
		return dimensiones;
	}
	/**
	 * @param dimensiones the dimensiones to set
	 */
	public void setDimensiones(Coordenada dimensiones) {
		this.dimensiones = dimensiones;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tablero [dimensiones=" + dimensiones + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		if (dimensiones == null) {
			if (other.dimensiones != null)
				return false;
		} else if (!dimensiones.equals(other.dimensiones))
			return false;
		return true;
	}
	
}
