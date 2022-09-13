package com.revature.models;

import java.util.Objects;

public class Game {
	private int id;
	private String category;
	private String name;
	private String summary;

	public Game() {
		super();
	}

	public Game(String category, String name, String summary) {
		super();
		this.category = category;
		this.name = name;
		this.summary = summary;
	}

	public Game(int id, String category, String name, String summary) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.summary = summary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name, summary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(category, other.category) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(summary, other.summary);
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", category=" + category + ", name=" + name + ", summary=" + summary + "]";
	}

}
