package br.com.gsc.model.tableMapping;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DataSourceRepository {
	
	private static EntityManagerFactory    emf;
	private static EntityManager        em;
	private static EntityTransaction    tx;
	
	public DataSourceRepository() {
		DataSourceRepository.preparePersistence();
	}
	
	private static void preparePersistence(){
		DataSourceRepository.getTransaction();
		DataSourceRepository.getEntityManager();	
	}
	
	public static EntityTransaction getTransaction(){
		if(tx == null){ 
			EntityManager em = DataSourceRepository.getEntityManager();
		 	tx = em.getTransaction();
		}
		return tx;
	}
	
	public static EntityManager getEntityManager(){
		if(em == null){
			emf = Persistence.createEntityManagerFactory("gsc");
			em = emf.createEntityManager();
		}
		return em;
	}
	
	
	public static <T> void add(T t){
		if(t instanceof Entity){
			tx.begin();
			em.persist(t);
			tx.commit();
			DataSourceRepository.cleanConnections();
		}
	}
	
	/**
	 * Generic find method just pass an Entity to get another back.
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> T findPerson(T t){
		
		return null;
	}
	
	/**
	 * A get all generic method, just pass an Entity and get a list of all in DB
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> ArrayList<T> getAll(T t){
		
		return null;
	}
	
	
	/**
	 * 
	 */
	public static void cleanConnections(){
		 em.close();
		 emf.close();
	}
}
