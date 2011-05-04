package br.com.gsc.model.tableMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_topics")
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long 			id;
	@Column(length=150, nullable=false)
	private String			topicTitle;
	@Column(length=500, nullable=false)
	private String 			topicContent;
	
	@OneToMany(mappedBy="topic")
	private List<Post> 		listOfPosts = new ArrayList<Post>();
	
	@ManyToOne
	@JoinColumn(name="person_id", nullable=false)
	private Person 			person;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product 		product;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Post> getListOfPosts() {
		return listOfPosts;
	}

	public void setListOfPosts(List<Post> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getTopicContent() {
		return topicContent;
	}

	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
