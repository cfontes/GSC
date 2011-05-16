package test.persistence;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.User;
import br.com.gsc.repository.RepositoryImpl;
import br.com.gsc.repository.objRepos.PersonRepository;

public class PersonRepositoryTest {
	
	User p;
	@Autowired
	PersonRepository pr;
	
	@BeforeTest
	public void beforeTest(){
		p = new User();
		p.setUserName("Mago");
	}
	
	@Test(groups = "a")
	public void testAddPersonRepo(){
		pr.addPerson(p);
		assertNotNull(p.getUserName());
	}
	
	@Test(dependsOnGroups = "a")
	public void testFindPersonRepo(){
		User pFromDB = (User) pr.findPersonByID(p.getUserName());
		assertNotNull(pFromDB);
		assertEquals("Mago", pFromDB.getUserName());
	}
}
