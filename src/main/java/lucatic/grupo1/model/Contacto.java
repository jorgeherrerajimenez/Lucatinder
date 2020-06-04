package lucatic.grupo1.model;

import java.io.Serializable;

/**
* @author Jorge H.
* @author Maira Q.
* @version 04/06/20
* @category MVC
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contacto  implements Serializable {
	
	private static final long serialVersionUID = -2034712900167647762L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="perfil_id")
	private Perfil liker;
	
	private Perfil like;

	public Contacto() {
		super();
	}

	public Contacto(Long id, Perfil liker, Perfil like) {
		super();
		this.id = id;
		this.liker = liker;
		this.like = like;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Perfil getLiker() {
		return liker;
	}

	public void setLiker(Perfil liker) {
		this.liker = liker;
	}

	public Perfil getLike() {
		return like;
	}

	public void setLike(Perfil like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", liker=" + liker + ", like=" + like + "]";
	}

}
