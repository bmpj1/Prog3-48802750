package modelo.excepciones;

import com.sun.rmi.rmid.ExecOptionPermission;

public class ExcepcionEjecucion extends RuntimeException {
	public ExcepcionEjecucion() {
		super();
	}
	public ExcepcionEjecucion(String message) {
		super(message);
	}

	public ExcepcionEjecucion(Throwable cause) {
		super(cause);
	}
}
