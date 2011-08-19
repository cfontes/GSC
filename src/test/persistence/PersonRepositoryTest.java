package test.persistence;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.User;
import br.com.gsc.repository.objRepos.PersonRepository;

@Configurable(dependencyCheck=true)
public class PersonRepositoryTest {
	
	@Autowired
	private PersonRepository pr;
	
	User p;
	
	@BeforeTest
	public void beforeTest(){
		p = new User();
		p.setUsername("teste");
	}
	
	@Test(groups = "a")
	public void testAddPersonRepo(){
		pr.addPerson(p);
		assertNotNull(p.getUsername());
	}
	
	@Test(dependsOnGroups = "a")
	public void testFindPersonRepo(){
		User pFromDB = (User) pr.findPersonByID(p.getUsername());
		assertNotNull(pFromDB);
		assertEquals("teste", pFromDB.getUsername());
	}
}
