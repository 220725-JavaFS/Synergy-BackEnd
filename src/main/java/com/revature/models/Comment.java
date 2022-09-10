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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonBackReference
	private Users Users;
	@Column(nullable = false)
	private int gameId;
	@Column(nullable = false)
	private String comment;

	public Comment() {
		super();
	}

	public Comment(Users Users, int gameId, String comment) {
		super();
		this.Users = Users;
		this.gameId = gameId;
		this.comment = comment;
	}

	public Comment(int id, Users Users, int gameId, String comment) {
		super();
		this.id = id;
		this.Users = Users;
		this.gameId = gameId;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, gameId, id, Users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(comment, other.comment) && gameId == other.gameId && id == other.id
				&& Objects.equals(Users, other.Users);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", Users=" + Users + ", gameId=" + gameId + ", comment=" + comment + "]";
	}

}
