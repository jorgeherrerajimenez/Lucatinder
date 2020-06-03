package lucatic.grupo1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.github.javafaker.Faker;

import javax.persistence.JoinColumn;

@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = 6529425024800979551L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private char genero;
	private short edad;
	private String descripcion;
	
	@ManyToMany
	@JoinTable(
			  name = "materia_perfil", 
			  joinColumns = @JoinColumn(name = "materia_id"), 
			  inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private List<Materia> gustosInformaticos;
	
	/*private List<Descarte> descartados;
	
	private List<Match> matchs;
	
	private List<Contacto> contactos;*/
	
	

	public Perfil() {
		super();
	}
	
	

	public Perfil(String nombre, char genero, short edad, String descripcion) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
	}



	public Perfil(Long id, String nombre, char genero, short edad, String descripcion,
			List<Materia> gustosInformaticos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
		this.gustosInformaticos = gustosInformaticos;
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

	public List<Materia> getGustosInformaticos() {
		return gustosInformaticos;
	}
	
	public void generarFake() {
		Faker f = new Faker();
		this.nombre = f.funnyName().name();
		this.edad = (short) f.number().numberBetween(18, 90);
		if((f.number().randomDigit() % 2) == 0)
			this.genero = 'M';
		else
			this.genero = 'H';
		this.descripcion = f.lorem().paragraph();
	}
}
