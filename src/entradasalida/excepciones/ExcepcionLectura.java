package entradasalida.excepciones;

public class ExcepcionLectura extends Exception {

	public ExcepcionLectura() {
		super();
	}

	public ExcepcionLectura(String message) {
		super(message);
	}

	public ExcepcionLectura(Throwable cause) {
		super(cause);
	}

}
