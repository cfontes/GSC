package br.com.gsc.model.tableMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.transaction.annotation.Transactional;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="tb_topics")
@Transactional
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long 			id;
	
	@NotEmpty(message = "O Titulo é obrigatorio")
	@Column(length=150, nullable=false)
	private String			topicTitle;
	
	@NotEmpty(message = "O conteudo é obrigatorio")
	@Column(length=500, nullable=false)
	private String 			topicContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date 			createdIn;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30, nullable=false)
	private TopicTypes topicType;
	
	@OneToMany(mappedBy="topic",cascade=CascadeType.ALL)
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

	public TopicTypes getTopicType() {
		return topicType;
	}

	public void setTopicType(TopicTypes topicType) {
		this.topicType = topicType;
	}

	public Date getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(Date createdInDate) {
		this.createdIn = createdInDate;
	}
	
}
