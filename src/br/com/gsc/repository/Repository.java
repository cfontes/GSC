package br.com.gsc.repository;

import java.util.List;

/**
 * Class that call the right persistence provider to handle the request.
 * @author cristiano
 *
 * @param <T>
 */
public abstract class Repository<T> {

	private RepositoryImpl jpa;
	
	public void setProvider(RepositoryImpl persistenceProvider){
		this.jpa = persistenceProvider;
	}
	
	protected void add(T t) {
		jpa.add(t);
		
	}

	protected void remove(T t) {
		// TODO Auto-generated method stub
		
	}

	protected void update(T t) {
		// TODO Auto-generated method stub
		
	}

	protected T read(T t, long id) {
		return jpa.read(t, id);
	}

	protected List<T> findAll(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
