package br.com.gsc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
@Repository("RepositoryImpl")
@Transactional
public class RepositoryImpl {
	
	
//	private EntityManagerFactory    emf;
	@PersistenceContext
	private EntityManager        	em;
//	private EntityTransaction    	tx;
	
//	private void initAndBeginDbConnection(){
//		 emf = Persistence.createEntityManagerFactory("gsc");
//		 em = emf.createEntityManager();
//		 tx = em.getTransaction();
//		 tx.begin();
//	}
	
//	private void closeAndCommitDBConnection(){
//		tx.commit();
//		em.close();
//		emf.close();
//	}
	
	public <T> void add(T t) {			
		 this.em.persist(t);
	}

	public <T> void remove(T t) {
		 this.em.remove(t);		
	}

	public <T> void update(T t) {
		this.em.merge(t);
	}

	public <T> T read(T t, Object pk) {
		T response = (T) this.em.find(t.getClass(), pk);
		return response;
	}

	public <T> List<T> findAll(T t, String queryName, String... param) {
		Query query = this.em.createNamedQuery(queryName);
		for(int i=0; i<param.length; i++){
			query.setParameter(i, param[i]);
		}
		List<T> listOfObjects = query.getResultList();
		return listOfObjects;
	}
	
}
