package test.persistence;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.User;
import br.com.gsc.repository.RepositoryImpl;
import br.com.gsc.repository.objRepos.PersonRepository;

public class PersonRepositoryTest {
	
	User p;
	PersonRepository pr;
	
	@BeforeTest
	public void beforeTest(){
		p = new User();
		p.setName("Mago");
		pr = new PersonRepository();
		pr.setProvider(new RepositoryImpl());
	}
	
	@Test(groups = "a")
	public void testAddPersonRepo(){
		pr.addPerson(p);
		assertNotNull(p.getId());
	}
	
	@Test(dependsOnGroups = "a")
	public void testFindPersonRepo(){
		User pFromDB = (User) pr.findPersonByID(p, p.getId());
		assertNotNull(pFromDB);
		assertEquals("Mago", pFromDB.getName());
	}
}
