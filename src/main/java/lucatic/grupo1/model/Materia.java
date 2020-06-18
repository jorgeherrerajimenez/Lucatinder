package lucatic.grupo1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */


@Entity
public class Materia implements Serializable {
	
	private static final long serialVersionUID = 6292177161988922695L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private short id;
	private String nombre;
	
	@ManyToMany(mappedBy = "gustosInformaticos")
	private List<Perfil> perfiles;
	
	
	public Materia() {
		super();
	}
	public Materia(String nombre) {
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
		return "Materia [id=" + id + ", nombre=" + nombre + "]";
	}
}

