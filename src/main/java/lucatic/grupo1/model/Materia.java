package lucatic.grupo1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Materia implements Serializable {
	
	private static final long serialVersionUID = 6292177161988922695L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + "]";
	}
}

