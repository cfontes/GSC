package test.persistence;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Configurable;
import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.Admin;
import br.com.gsc.model.tableMapping.User;

public class PersonPersistenceTest extends PersistenceTest {
	
	
	@Test
	public void testUserPersistence(){
		 tx.begin();
		 User user = new User();
		 user.setUsername("user");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 assertNotNull(user.getUsername());
		 
		 // lookup entity
		 String username = user.getUsername();
		 User userFromDatabase = em.find(User.class, username);
		 assertNotNull(userFromDatabase);
		 assertEquals("user", userFromDatabase.getUsername());	
	}
	
	@Test
	public void testAdminPersistence(){
		 tx.begin();
		 Admin user = new Admin();
		 user.setUsername("admin");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 assertNotNull(user.getUsername());
		 
		 // lookup entity
		 String username = user.getUsername();
		 Admin userFromDatabase = em.find(Admin.class, username);
		 assertNotNull(userFromDatabase);
		 assertEquals("admin", userFromDatabase.getUsername());	
	}
}
