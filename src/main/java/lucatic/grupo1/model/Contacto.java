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


/**
* 
 * @author Jorge H.
 * @author Adnan H.
 * @author Marco R.
 * @author Maira P.
 * @version 18/06/20
 */


@Entity
public class Contacto  implements Serializable {
	
	private static final long serialVersionUID = -2034712900167647762L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="liker_id")
	private Perfil liker;
	
	@ManyToOne
	@JoinColumn(name="liked_id")
	private Perfil liked;

	public Contacto() {
		super();
	}

	public Contacto(Perfil liker, Perfil liked) {
		super();
		this.liker = liker;
		this.liked = liked;
	}

	public Contacto(Long id, Perfil liker, Perfil liked) {
		super();
		this.id = id;
		this.liker = liker;
		this.liked = liked;
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

	public Perfil getLiked() {
		return liked;
	}

	public void setLiked(Perfil liked) {
		this.liked = liked;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((liked == null) ? 0 : liked.hashCode());
		result = prime * result + ((liker == null) ? 0 : liker.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (liked == null) {
			if (other.liked != null)
				return false;
		} else if (!liked.equals(other.liked))
			return false;
		if (liker == null) {
			if (other.liker != null)
				return false;
		} else if (!liker.equals(other.liker))
			return false;
		return true;
	}

	
}
