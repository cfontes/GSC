package br.com.gsc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.gsc.model.tableMapping.User;

/**
 * Class that handles the requests and fetch/add then to the DB.
 * 
 * This could be abstracted to use several persistence providers just by
 * turning this class into an Abstract Class and using dependency injection using it's children.
 * But I only intend to use JPA so to reduce complexity this will be enough.
 * 
 * @author cristiano
 *
 */
public class RepositoryImpl {
	
	private EntityManagerFactory    emf;
	private EntityManager        em;
	private EntityTransaction    tx;
	
	private void initAndBeginDbConnection(){
		 emf = Persistence.createEntityManagerFactory("gsc");
		 em = emf.createEntityManager();
		 tx = em.getTransaction();
		 tx.begin();
	}
	
	private void closeAndCommitDBConnection(){
		tx.commit();
		em.close();
		emf.close();
	}
	
	public <T> void add(T t) {	
		 initAndBeginDbConnection();
		 em.persist(t);
		 closeAndCommitDBConnection();
	}

	public <T> void remove(T t) {
		 initAndBeginDbConnection();
		 em.remove(t);
		 closeAndCommitDBConnection();		
	}

	public <T> void update(T t) {
		initAndBeginDbConnection();
		em.refresh(t);
		closeAndCommitDBConnection();
	}

	@SuppressWarnings("unchecked")
	public <T> T read(T t, long id) {
		initAndBeginDbConnection();
		T response = (T) em.find(t.getClass(), id);
		closeAndCommitDBConnection();
		return response;
	}

	public <T> List<T> findAll(String query, Object[] params) {
		return null;
	}
	
}
