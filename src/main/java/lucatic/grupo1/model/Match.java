package lucatic.grupo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* @author Jorge H.
* @version 10/06/20
*/

@Entity
@Table(name = "matches")
public class Match {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "matcher_id")
	private Perfil matcher;
	
	@ManyToOne
	@JoinColumn(name = "matched_id")
	private Perfil matched;
	
	public Match() {
		super();
	}
	
	public Match(Perfil matcher, Perfil matched) {
		super();
		this.matcher = matcher;
		this.matched = matched;
	}

	public Perfil getMatcher() {
		return matcher;
	}

	public void setMatcher(Perfil matcher) {
		this.matcher = matcher;
	}

	public Perfil getMatched() {
		return matched;
	}

	public void setMatched(Perfil matched) {
		this.matched = matched;
	}
	
}
