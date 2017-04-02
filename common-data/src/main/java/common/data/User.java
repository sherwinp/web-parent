package common.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USERS", schema = "PUBLIC")
public class User implements Serializable {
	private static final long serialVersionUID = 1000000L;
	@Id
	@Column(name = "U_NAME")
	private String name;
	@Column(name = "U_PASSWORD")
	private String password;
	@Column(name = "U_DESCRIPTION")
	private String description;
	@Column(name = "MODIFIED_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false, insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModified() {
		return modified;
	}

	public String toString() {
		return "User name: " + getName() + " Description: " + getDescription();
	}

	public static User newInstance() {
		final User newUser = new User();
		newUser.modified = new java.util.Date();
		return newUser;
	}

	public static User newInstance(String email, String phone, String postal) {
		final User newUser = new User();
		newUser.modified = new java.util.Date();
		newUser.name = email;
		newUser.description = phone;
		newUser.password = "welcome1";
		return newUser;
	}
}