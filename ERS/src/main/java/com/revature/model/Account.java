package com.revature.model;

import java.sql.Date;

public class Account {
	
	private int id;
	private String username;
	private String password;
	private int role;
	
	public Account() {
		super();
		}



	public Account(int id, String username, String password, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}



	public String getPassword() {
		return password;
	}



	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	
	
}
