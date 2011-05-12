package br.com.gsc.model.tableMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
//@MappedSuperclass
@Inheritance
@DiscriminatorColumn(name="P_TYPE")
@Table(name = "tb_people")
public abstract class Person {
	

	 
//	 @GeneratedValue(strategy=GenerationType.IDENTITY)
//	 private Long           id;
	 @Id
	 @Column(length=50, nullable=false, unique=true)
	 private String			username;
	 private String			email;
	 private Date			date_of_creation;
	 private String 		phone;
	 private String 		password;
	 private String			autority;
	 @OneToMany(mappedBy="person")
	 private List<Topic> 	listOfTopics;
	 @OneToMany(mappedBy="person")
	 private List<Post> 	listOfPosts;
	 @OneToMany(mappedBy="person")
	 private List<Comment> 	listOfComments;
	
//	public Long getId() {
//		return id;
//	}
//	 
//	public void setId(Long id) {
//		this.id = id;
//	}
	
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
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String userName) {
		this.username = userName;
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

	public String getAutority() {
		return autority;
	}

	public void setAutority(String autority) {
		this.autority = autority;
	}
	 

}
