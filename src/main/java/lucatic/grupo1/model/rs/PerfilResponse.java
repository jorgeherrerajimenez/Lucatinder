package lucatic.grupo1.model.rs;

import lucatic.grupo1.model.Perfil;

public class PerfilResponse {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private short edad;
	private char genero;
	private String image;
	
	public PerfilResponse() {
		super();
	}
	
	public PerfilResponse(Perfil p) {
		this.id = p.getId();
		this.nombre = p.getNombre();
		this.genero = p.getGenero();
		this.descripcion = p.getDescripcion();
		this.edad = p.getEdad();
		this.image = p.getImage();
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
