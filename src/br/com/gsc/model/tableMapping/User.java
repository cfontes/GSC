package br.com.gsc.model.tableMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
public class User extends Person{
	
	private String picture;

}
