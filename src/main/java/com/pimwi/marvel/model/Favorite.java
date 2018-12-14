package com.pimwi.marvel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "favorite")
public class Favorite {

	@Id
	private long id;
	
	private boolean favorite;

	public Favorite() { }
	
	public Favorite(long id, boolean favorite) {
		super();
		this.id = id;
		this.favorite = favorite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
}
