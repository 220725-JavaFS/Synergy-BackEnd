package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonBackReference
	private User user;
	@Column(nullable = false)
	private int gameId;
	@Column(nullable = false)
	private int rating;

	public Rating() {
		super();
	}

	public Rating(User user, int gameId, int rating) {
		super();
		this.user = user;
		this.gameId = gameId;
		this.rating = rating;
	}

	public Rating(int id, User user, int gameId, int rating) {
		super();
		this.id = id;
		this.user = user;
		this.gameId = gameId;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameId, id, rating, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		return gameId == other.gameId && id == other.id && rating == other.rating && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", user=" + user + ", gameId=" + gameId + ", rating=" + rating + "]";
	}

}
