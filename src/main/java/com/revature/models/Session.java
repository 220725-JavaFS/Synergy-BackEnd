package com.revature.models;

import java.util.Objects;

public class Session {
	private String ip;
	private Users user;
	private boolean active;

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getIp() {
		return ip;
	}

	public Session(String ip, Users user, boolean active) {
		super();
		this.ip = ip;
		this.user = user;
		this.active = active;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Session() {
		super();
	}

	public Session(Users user) {
		super();
		this.user = user;
	}

	public Session(String ip, Users user) {
		super();
		this.ip = ip;
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, ip, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		return active == other.active && Objects.equals(ip, other.ip) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Session [ip=" + ip + ", user=" + user + ", active=" + active + "]";
	}

}
