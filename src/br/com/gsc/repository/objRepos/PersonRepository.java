package br.com.gsc.repository.objRepos;

import java.util.List;

import br.com.gsc.model.tableMapping.Person;
import br.com.gsc.repository.Repository;
import br.com.gsc.repository.objInterfaces.IPersonRepository;

public class PersonRepository extends Repository<Person> implements IPersonRepository{

	@Override
	public void addPerson(Person t) {
		add(t);
	}

	@Override
	public void removePerson(Person t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Person t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findPersonByID(Person t, long id) {
		return read(t, id);
	}

	@Override
	public List<Person> ListPeopleByID(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
