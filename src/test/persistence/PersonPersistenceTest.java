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
		 user.setUserName("mickey");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 assertNotNull(user.getUserName());
		 
		 // lookup entity
		 String username = user.getUserName();
		 User userFromDatabase = em.find(User.class, username);
		 assertNotNull(userFromDatabase);
		 assertEquals("mickey", userFromDatabase.getUserName());	
	}
	
	@Test
	public void testOperatorPersistence(){
		 tx.begin();
		 Operator user = new Operator();
		 user.setUserName("roger");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 assertNotNull(user.getUserName());
		 
		 // lookup entity
		 String username = user.getUserName();
		 Operator userFromDatabase = em.find(Operator.class, username);
		 assertNotNull(userFromDatabase);
		 assertEquals("roger", userFromDatabase.getUserName());	
	}
}
