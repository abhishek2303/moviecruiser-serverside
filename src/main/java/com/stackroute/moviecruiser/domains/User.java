package com.stackroute.moviecruiser.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS")
public class User {
	@Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "USERNAME", length = 50, unique = true)
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @Size(min = 4, max = 100)
//    @JsonIgnore
    private String password;

    @Column(name = "FIRSTNAME", length = 50)
    @Size(min = 4, max = 50)
    private String firstname;

    @Column(name = "LASTNAME", length = 50)
    @Size(min = 4, max = 50)
    private String lastname;

    @Column(name = "EMAIL", length = 50)
    @Size(min = 4, max = 50)
    private String email;

    @Column(name = "ENABLED")
//    @JsonIgnore
    private Boolean enabled;

//    @Column(name = "LASTPASSWORDRESETDATE")
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonIgnore
//    private Date lastPasswordResetDate;
    
    public User() {
    	
    }

    public long getId() {
    	return this.userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

//    public Date getLastPasswordResetDate() {
//        return lastPasswordResetDate;
//    }
//
//    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
//        this.lastPasswordResetDate = lastPasswordResetDate;
//    }
	
	
}
