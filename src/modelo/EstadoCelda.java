package modelo;
/**
 * Clase encargada de enumerar el estado de una celda y asignarle un string.
 * @author Brian Mathias, Pesci Juliani
 *
 */
public enum EstadoCelda { VIVA("*"), MUERTA(" ");
	/**
	 * Atributo privado que se utiliza para devolver el string asociado al estado.
	 */
	private final String estado;
	/**
	 * Constructor que asocia un estado
	 * @param estado Representa el estado de la celda.
	 */
	EstadoCelda(String estado) {
		this.estado = estado;
	}
	/**
	 * Metodo que devuelve el estado de la celda en formato string.
	 * @return String del estado de la celda 
	 */ 
	public String getEstado() {
		return estado;
	}
}
//Referencias: https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=648:enumerados-como-clases-enum-en-java-constructores-metodo-values-ejercicio-ejemplo-resuelto-cu00682b&catid=68&Itemid=188