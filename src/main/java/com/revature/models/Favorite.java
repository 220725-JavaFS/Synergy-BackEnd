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
public class Favorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonBackReference
	private Users Users;
	@Column(nullable = false)
	private int gameId;

	public Favorite() {
		super();
	}

	public Favorite(Users Users, int gameId) {
		super();
		this.Users = Users;
		this.gameId = gameId;
	}

	public Favorite(int id, Users Users, int gameId) {
		super();
		this.id = id;
		this.Users = Users;
		this.gameId = gameId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUsers() {
		return Users;
	}

	public void setUsers(Users Users) {
		this.Users = Users;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameId, id, Users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorite other = (Favorite) obj;
		return gameId == other.gameId && id == other.id && Objects.equals(Users, other.Users);
	}

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", Users=" + Users + ", gameId=" + gameId + "]";
	}

}
