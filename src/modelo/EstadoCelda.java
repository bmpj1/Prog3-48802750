package modelo;//https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=648:enumerados-como-clases-enum-en-java-constructores-metodo-values-ejercicio-ejemplo-resuelto-cu00682b&catid=68&Itemid=188

public enum EstadoCelda { VIVA("*"), MUERTA(" ");
	private final String estado;
	
	EstadoCelda(String estado) {
		this.estado = estado;
	}
	
	protected String getEstado() {
		return estado;
	}
}
/** Referencias: 
 * 				//https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=648:enumerados-como-clases-enum-en-java-constructores-metodo-values-ejercicio-ejemplo-resuelto-cu00682b&catid=68&Itemid=188
 */