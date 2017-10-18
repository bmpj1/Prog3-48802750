package modelo.excepciones;

public class ExcepcionEjecucion extends RuntimeException {
	public ExcepcionEjecucion(String message) {
		super(message);
	}

	public ExcepcionEjecucion(Throwable cause) {
		super(cause);
	}
}
