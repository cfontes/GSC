package br.com.gsc.model.tableMapping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="operators")
public class Operator extends Person {

	private String codigo;
	
}
