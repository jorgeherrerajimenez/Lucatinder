package lucatic.grupo1.model.rs;

public class PerfilResponse {
	
	private String nombre;
	private String descripcion;
	private short edad;
	private char genero;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public short getEdad() {
		return edad;
	}
	
	public void setEdad(short edad) {
		this.edad = edad;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}