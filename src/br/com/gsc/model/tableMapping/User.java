package br.com.gsc.model.tableMapping;

import javax.persistence.Entity;
 
@Entity
//@Table(name="tb_users")
public class User extends Person{
	
	private String picture;

}
