package com.revature.models;

import java.util.Objects;

public class Cover {
	private int id;
	private String url;

	public Cover() {
		super();
	}

	public Cover(String url) {
		super();
		this.url = url;
	}

	public Cover(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cover other = (Cover) obj;
		return id == other.id && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Cover [id=" + id + ", url=" + url + "]";
	}

}
