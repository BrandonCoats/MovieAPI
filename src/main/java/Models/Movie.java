package Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="movies")
public class Movie {
	@Id
	@Column(name="movies")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String genre;
	
	private String title;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String posterId;
	@ManyToMany
	@JoinColumn(name="roles")
	private List<Actor> actors;
	public Movie() {
		
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getPosterId() {
		return posterId;
	}

	public void setPosterId(String posterId) {
		this.posterId = posterId;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void copy(Movie mov) {
		this.setPosterId(mov.getPosterId());
		
	}

}
