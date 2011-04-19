package test.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.Operator;
import br.com.gsc.model.tableMapping.Person;
import br.com.gsc.model.tableMapping.User;

public class TestPerson {

	private static EntityManagerFactory    emf;
	private static EntityManager        em;
	private static EntityTransaction    tx;
	
	@BeforeClass
	public void prepareStatement(){
		 emf = Persistence.createEntityManagerFactory("gsc");
		 em = emf.createEntityManager();
		 tx = em.getTransaction();
	}
	
	@AfterClass
	public void cleanConnections(){
		 em.close();
		 emf.close();
	}
	
//	@Test
//	public void testPersonPersistence(){
//		 tx.begin();
//		 Person person = new Person();
//		 person.setName("mickey");
//		 em.persist(person);
//		 tx.commit();
//		 
//		 // look if the entity was persisted and got an id assigned
//		 Assert.assertNotNull(person.getId());
//		 
//		 // lookup entity
//		 Long id = person.getId();
//		 Person userFromDatabase = em.find(Person.class, id);
//		 Assert.assertNotNull(userFromDatabase);
//		 Assert.assertEquals("mickey", userFromDatabase.getName());	
//	}
	
	@Test
	public void testUserPersistence(){
		 tx.begin();
		 User user = new User();
		 user.setName("mickey");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 Assert.assertNotNull(user.getId());
		 
		 // lookup entity
		 Long id = user.getId();
		 User userFromDatabase = em.find(User.class, id);
		 Assert.assertNotNull(userFromDatabase);
		 Assert.assertEquals("mickey", userFromDatabase.getName());	
	}
	
	@Test
	public void testOperatorPersistence(){
		 tx.begin();
		 Operator user = new Operator();
		 user.setName("roger");
		 em.persist(user);
		 tx.commit();
		 
		 // look if the entity was persisted and got an id assigned
		 Assert.assertNotNull(user.getId());
		 
		 // lookup entity
		 Long id = user.getId();
		 Operator userFromDatabase = em.find(Operator.class, id);
		 Assert.assertNotNull(userFromDatabase);
		 Assert.assertEquals("roger", userFromDatabase.getName());	
	}
}
