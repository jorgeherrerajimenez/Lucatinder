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
public class Descarte implements Serializable {
	
	private static final long serialVersionUID = -6314638403554564765L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="descartador_id")
	private Perfil descartador;
	
	@ManyToOne
	@JoinColumn(name="descartado_id")
	private Perfil descartado;
	
	
	public Descarte() {
		super();
	}

	public Descarte(Perfil descartador, Perfil descartado) {
		super();
		this.descartador = descartador;
		this.descartado = descartado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfil getDescartador() {
		return descartador;
	}

	public void setDescartador(Perfil descartador) {
		this.descartador = descartador;
	}

	public Perfil getDescartado() {
		return descartado;
	}

	public void setDescartado(Perfil descartado) {
		this.descartado = descartado;
	}

}
