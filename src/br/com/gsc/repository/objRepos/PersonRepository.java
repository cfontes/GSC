package br.com.gsc.repository.objRepos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.gsc.model.tableMapping.Person;
import br.com.gsc.repository.AbsRepository;
import br.com.gsc.repository.objInterfaces.IPersonRepository;

@Repository("PersonRepository")
public class PersonRepository extends AbsRepository<Person> implements IPersonRepository{

	@Override
	public void addPerson(Person t) {
		add(t);
	}

	@Override
	public void removePerson(Person t) {
		remove(t);
	}

	@Override
	public void updatePerson(Person t) {
		update(t);
	}

	@Override
	public Person findPersonByID(Person t, String username) {
		return read(t, username);
	}
	
	public Person findPersonByUsername(Person t, String username){
		
		
		return t;		
	}

	@Override
	public List<Person> ListPeopleByID(String query, Object[] params) {
		return null;
	}

}
