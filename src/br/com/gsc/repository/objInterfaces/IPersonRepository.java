package br.com.gsc.repository.objInterfaces;

import java.util.List;

import br.com.gsc.model.tableMapping.Person;

public interface IPersonRepository {

	public void addPerson(Person t);
	public void removePerson(Person t);
	public void updatePerson(Person t);
	public List<Person> ListPeopleByID(String query, Object[] params);
	Person findPersonByID(Person t, String username);
}
