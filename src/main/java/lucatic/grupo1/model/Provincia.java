package lucatic.grupo1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */



@Entity
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short id;	
	private String nombre;
	@JsonIgnore
	@OneToMany(mappedBy = "provincia")
	private List<Perfil> perfiles;
	
	public Provincia() {
		super();
	}
	
	public Provincia(String nombre) {
		super();
		this.nombre = nombre;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
