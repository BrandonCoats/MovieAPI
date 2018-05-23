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
	private String poster;
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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void copy(Movie mov) {
		this.setPoster(mov.getPoster());
		
	}

}
