package br.com.gsc.model.tableMapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String name;
	@ManyToOne
	@JoinColumn(name="companies_id")
	Company company;
	
	@OneToMany(mappedBy="product")
	List<Topic> listOfTopics;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
