package br.com.gsc.model.tableMapping;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Entity
//@Table(name="operators")
@Transactional
public class Operator extends Person {

	private String codigo;
	
}
