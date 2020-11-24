package ar.edu.unlam.pb220202c.eva03;

public class VehiculoNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehiculoNotFoundException(String descripcion) {
		super(descripcion);
	}
}
