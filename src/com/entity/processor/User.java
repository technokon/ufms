package com.entity.processor;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Model
@Entity
@Table(name="UFMS_USER")
public class User {
	
	@Id
	@GeneratedValue(generator="USER_SEQ1")
	@SequenceGenerator(name="USER_SEQ1", sequenceName="USER_SEQ1", allocationSize=1)
	@Column(name="ID")
	private long id;
	
	@Column
	private String username;
	
	@Column
	private String salt;
	
	@Column(name="HASHED_PASSWORD")
	private String hashedPassword;
	
	@Column(name="FIRST_NAME")
	private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    public User()  { }
     
    public User(String username, String salt, String hashedPassword,
			String firstName, String lastName) {
		this.username = username;
		this.salt = salt;
		this.hashedPassword = hashedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
	}
    
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	


}
