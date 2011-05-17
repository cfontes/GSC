package br.com.gsc.model.tableMapping;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
//@Table(name="admins")
@Transactional
public class Admin extends Person {

	//TODO : add fields
		
}
