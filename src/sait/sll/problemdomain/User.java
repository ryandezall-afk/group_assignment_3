package sait.sll.problemdomain;

import java.io.Serializable;

/**
 * Represents a user.
 *
 * @version 2025
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String email;
	private transient String password;

	/**
	 * Creates a User object with specified arguments.
	 *
	 * @param id user ID.
	 * @param name user name.
	 * @param email user e-mail address.
	 * @param password user password.
	 */
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/**
	 * Gets the user ID.
	 *
	 * @return user ID.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the user ID.
	 *
	 * @param id new user ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the user name.
	 *
	 * @return user name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the user name.
	 *
	 * @param name new user name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the user email address.
	 *
	 * @return e-mail address.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the user email address.
	 *
	 * @param email new e-mail address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the user password.
	 *
	 * @return password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the user password.
	 *
	 * @param password new password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Checks if the passed password is correct.
	 *
	 * @param password password to check.
	 * @return true if password is correct, false otherwise.
	 */
	public boolean isCorrectPassword(String password) {
		if (this.password == null && password == null) {
			return true;
		}
		if (this.password == null || password == null) {
			return false;
		}
		return this.password.equals(password);
	}

	/**
	 * Checks if object is equal to another object.
	 *
	 * @param obj the object to compare to.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}

		User other = (User) obj;
		return this.id == other.id
				&& stringEquals(this.name, other.name)
				&& stringEquals(this.email, other.email);
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.id;
		result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
		result = 31 * result + (this.email == null ? 0 : this.email.hashCode());
		return result;
	}

	private boolean stringEquals(String first, String second) {
		if (first == second) {
			return true;
		}
		if (first == null || second == null) {
			return false;
		}
		return first.equals(second);
	}
}
