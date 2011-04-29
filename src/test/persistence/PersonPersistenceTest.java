package test.persistence;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import br.com.gsc.model.tableMapping.Operator;
import br.com.gsc.model.tableMapping.User;

public class PersonPersistenceTest extends PersistenceTest {
	
	
	@Test
	public void testUserPersistence(){
		 tx.begin();
		 User user = new User();
		 user.setName("mickey");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 assertNotNull(user.getId());
		 
		 // lookup entity
		 Long id = user.getId();
		 User userFromDatabase = em.find(User.class, id);
		 assertNotNull(userFromDatabase);
		 assertEquals("mickey", userFromDatabase.getName());	
	}
	
	@Test
	public void testOperatorPersistence(){
		 tx.begin();
		 Operator user = new Operator();
		 user.setName("roger");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 assertNotNull(user.getId());
		 
		 // lookup entity
		 Long id = user.getId();
		 Operator userFromDatabase = em.find(Operator.class, id);
		 assertNotNull(userFromDatabase);
		 assertEquals("roger", userFromDatabase.getName());	
	}
}
