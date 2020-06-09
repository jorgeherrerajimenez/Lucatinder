package lucatic.grupo1.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.javafaker.Faker;

import javax.persistence.JoinColumn;


/**
* @author Jorge H.
* @author Maira Q.
*/

@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = 6529425024800979551L;
	private static final Role role = new Role("USER");
	private  static final PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String username;
	private char genero;
	private short edad;
	private String descripcion;
	private String password = encoder.encode("xxx");
	private boolean enabled = true;
	
	@ManyToMany
	@JoinTable(
			  name = "materia_perfil", 
			  joinColumns = @JoinColumn(name = "materia_id"), 
			  inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private List<Materia> gustosInformaticos;
	
	
	@OneToMany(mappedBy = "descartador",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Descarte> descartados;
	
	
	@OneToMany(mappedBy = "descartado", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Descarte> descartadores;
	
	
	@OneToMany(mappedBy = "liker",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Contacto> contactos;
	
	
	@OneToMany(mappedBy = "liked", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Contacto> contactoDe;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_role", 
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<Role>();
	
	

	public Perfil() {
		super();
		this.roles.add(Perfil.role);
	}
	
	

	public Perfil(String nombre, String username, char genero, short edad, String descripcion) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
		this.roles.add(Perfil.role);
	}



	public Perfil(Long id, String nombre, String username, char genero, short edad, String descripcion,
			List<Materia> gustosInformaticos) {
		super();
		this.id = id;
		this.username = username;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
		this.gustosInformaticos = gustosInformaticos;
		this.roles.add(Perfil.role);
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

	public static Role getRole() {
		return role;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public List<Descarte> getDescartados() {
		return descartados;
	}

	public void setDescartados(List<Descarte> descartados) {
		this.descartados = descartados;
	}

	public void setGustosInformaticos(List<Materia> gustosInformaticos) {
		this.gustosInformaticos = gustosInformaticos;
	}

	public List<Descarte> getDescartadores() {
		return descartadores;
	}

	public void setDescartadores(List<Descarte> descartadores) {
		this.descartadores = descartadores;
	}

	

	public List<Contacto> getContactos() {
		return contactos;
	}



	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}



	public List<Contacto> getContactoDe() {
		return contactoDe;
	}



	public void setContactoDe(List<Contacto> contactoDe) {
		this.contactoDe = contactoDe;
	}
	

	public String getPassword() {
		return password;
	}


	

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + ", descripcion="
				+ descripcion + ", gustosInformaticos=" + gustosInformaticos + ", descartados=" + descartados
				+ ", descartadores=" + descartadores + ", contactos=" + contactos + ", contactoDe=" + contactoDe + "]";
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void generarFake() {
		Faker f = new Faker();
		this.username = f.funnyName().name();
		this.nombre = this.username;
		this.edad = (short) f.number().numberBetween(18, 90);
		if((f.number().randomDigit() % 2) == 0)
			this.genero = 'M';
		else
			this.genero = 'H';
		this.descripcion = f.lorem().paragraph();
	}
}
