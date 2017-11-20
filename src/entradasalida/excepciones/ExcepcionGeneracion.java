package entradasalida.excepciones;

public class ExcepcionGeneracion extends Exception {

	public ExcepcionGeneracion() {
		super();
	}

	public ExcepcionGeneracion(String message) {
		super(message);
	}

	public ExcepcionGeneracion(Throwable cause) {
		super(cause);
	}
	
}
