package br.com.gsc.model.tableMapping;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
 
@MappedSuperclass
@Table(name = "People")
public abstract class Person {
	

	@Id
	 @GeneratedValue
	 private Long           id;
	 @Column(length=30, nullable=false)
	 private String			name;
	 private String			email;
	 private Date			date_Of_creation;
	 private String 		phone;
	
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate_Of_creation() {
		return date_Of_creation;
	}
	public void setDate_Of_creation(Date date_Of_creation) {
		this.date_Of_creation = date_Of_creation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	 

}
