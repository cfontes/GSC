package test.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PersistenceTest {

	protected EntityManagerFactory    emf;
	protected EntityManager        em;
	protected EntityTransaction    tx;
	
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
}
