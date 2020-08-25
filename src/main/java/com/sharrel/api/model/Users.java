package com.sharrel.api.model;

import java.util.Objects;

public class Users {

	private String username;
	private String password;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;

		if (o == null || getClass() != o.getClass()) 
			return false;

		Users users = (Users) o;

		return Objects.equals(this.username, users.username) && Objects.equals(this.password, users.password)
				&& Objects.equals(this.email, users.email);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("class Users {\n");
		sb.append("    username: ").append(username).append("\n");
		sb.append("    password: ").append(password).append("\n");
		sb.append("    email: ").append(email).append("\n");
		sb.append("}");

		return sb.toString();
	}

}
