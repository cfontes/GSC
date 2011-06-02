package br.com.gsc.model.tableMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="tb_posts")
@Transactional
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long 					id;
	
	@ManyToOne
	@JoinColumn(name = "topics_id", nullable=false)
	private Topic 			topic;
	
	@Column(length=500, nullable=false)
	private String 			content;
	
	@Column(length=150, nullable=false)
	private String 			postTitle;
	
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
	private List<Comment> 	listOfComments = new ArrayList<Comment>();
	
	@ManyToOne
	@JoinColumn(name="person_id", nullable=false)
	private Person 			person;

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Comment> getListOfComments() {
		return listOfComments;
	}
	
	public void addComment(Comment comment){
		this.listOfComments.add(comment);
	}

	public void setListOfComments(List<Comment> listOfComments) {
		this.listOfComments = listOfComments;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
