package com.pimwi.marvel.service.response;

public class Characters {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String description;

	private Thumbnail thumbnail;

	
	public Characters(int id, String name, String description, Thumbnail thumbnail) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.thumbnail = thumbnail;
	}

	
	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
