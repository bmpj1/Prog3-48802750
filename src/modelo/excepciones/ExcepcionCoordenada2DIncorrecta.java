package modelo.excepciones;

public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {
	private int x;
	private int y;
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String getMessage() {
		return ("Error: Coordenada2D("+x+","+y+") incorrecta.\n");
	}

}
