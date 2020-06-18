package lucatic.grupo1.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.persistence.JoinColumn;


/**
* @author Jorge H.
* @author Maira Q.
*/

@Entity
public class Perfil implements Serializable {

	private static final long serialVersionUID = 6529425024800979551L;
	private  static final PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	@Column(unique=true)
	private String username;
	private char genero;
	private short edad;
	@Column(length = 300)
	private String descripcion;
	private String image;
	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;
	private String password = encoder.encode("xxx");
	private boolean enabled = true;
	
	
	
	@ManyToMany
	@JoinTable(
			  name = "materia_perfil", 
			  joinColumns = @JoinColumn(name = "perfil_id"), 
			  inverseJoinColumns = @JoinColumn(name = "materia_id"))
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
	
	@ManyToMany
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
	
	@OneToMany(mappedBy = "matcher",cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Match> matches;
	
	
	@OneToMany(mappedBy = "matched", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Match> matchOf;
	
	public Perfil() {
		super();
	}
	
	
	public Perfil(String nombre, String username, char genero, short edad, String descripcion,
			String image, Provincia provincia) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
		this.image=image;
		this.provincia = provincia;
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


	public void setPassword(String password) {
		this.password = password;
	}



	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Collection<Match> getMatches() {
		return matches;
	}


	public void setMatcher(Collection<Match> matches) {
		this.matches = matches;
	}


	public Collection<Match> getMatchOf() {
		return matchOf;
	}

	public void setMatchOf(Collection<Match> matchOf) {
		this.matchOf = matchOf;
	}
	

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public void setMatches(Collection<Match> matches) {
		this.matches = matches;
	}


	public void generarDefault() {
		this.nombre = "Default";
		this.username = "default";
		this.password = encoder.encode("xxx");
		this.descripcion = "Soy el usuario por defecto. No tengo edad, "
				+ "ni provincia, ni género. Puedes llamarme dios...";
		this.genero = 'O';
		this.image = "genero_otro/default.jpg";
	}

	public void encodePassword() {
		this.password = encoder.encode(this.password);
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + ", descripcion="
				+ descripcion + ", image=" + image + ", enabled=" + enabled + ", gustosInformaticos="
				+ gustosInformaticos + ", descartados=" + descartados + ", descartadores=" + descartadores
				+ ", contactos=" + contactos + ", contactoDe=" + contactoDe + ", roles=" + roles + "]";
	}
	
	

}
