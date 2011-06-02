	package br.com.gsc.model.tableMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;
 
@Entity
//@MappedSuperclass
@Transactional
@Inheritance
@DiscriminatorColumn(name="P_TYPE")
@Table(name = "tb_people")
public class Person {
	

	 
//	 @GeneratedValue(strategy=GenerationType.IDENTITY)
//	 private Long           id;
	 @Id
	 @Column(length=50, nullable=false, unique=true)
	 private String			username;
	 private String			email;
	 private Date			date_of_creation;
	 private String 		phone;
	 private String 		password;
	 private String			authority;
	 @OneToMany(mappedBy="person",cascade=CascadeType.ALL)
	 private List<Topic> 	listOfTopics;
	 @OneToMany(mappedBy="person",cascade=CascadeType.ALL)
	 private List<Post> 	listOfPosts;
	 @OneToMany(mappedBy="person",cascade=CascadeType.ALL)
	 private List<Comment> 	listOfComments;
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDate_of_creation() {
		return date_of_creation;
	}
	
	public void setDate_of_creation(Date date_of_creation) {
		this.date_of_creation = date_of_creation;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Topic> getTopics() {
		return listOfTopics;
	}
	
	public void setTopics(List<Topic> topics) {
		this.listOfTopics = topics;
	}
	
	public void addTopic(Topic topic){
		this.listOfTopics.add(topic);
	}
	
	public List<Post> getPost() {
		return listOfPosts;
	}
	
	public void setPost(List<Post> post) {
		this.listOfPosts = post;
	}
	
	public void addPost(Post post){
		listOfPosts.add(post);
	}
	
	public List<Comment> getComments() {
		return listOfComments;
	}
	
	public void setComments(ArrayList<Comment> comments) {
		listOfComments = comments;
	}
	
	public void addComment(Comment comment){
		this.listOfComments.add(comment);
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String autority) {
		this.authority = autority;
	}
	 

}
