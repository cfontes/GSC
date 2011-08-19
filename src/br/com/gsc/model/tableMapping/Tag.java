package br.com.gsc.model.tableMapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;


@Entity
@Table(name="tb_tags")
@Transactional
public class Tag {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long 			tagId;
	
	@Column(length=150, nullable=false, unique=true)
	private String			tagName;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "tags_topics",
			joinColumns = @JoinColumn(name = "topic_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Topic> 			topics;

}
