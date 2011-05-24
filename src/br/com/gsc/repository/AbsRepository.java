package br.com.gsc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class that call the right persistence provider to handle the request.
 * @author cristiano
 *
 * @param <T>
 */

public abstract class AbsRepository<T> {

	@Autowired
	private RepositoryImpl repositoryImpl;
	
	public void setRepositoryImpl(RepositoryImpl persistenceProvider){
		this.repositoryImpl = persistenceProvider;
	}
	
	protected void add(T t) {
		repositoryImpl.add(t);		
	}

	protected void remove(T t) {
		repositoryImpl.remove(t);	
	}
	
	protected void update(T t) {
		repositoryImpl.update(t);		
	}

	protected T read(T t, Object pk) {
		return repositoryImpl.read(t, pk);
	}

	protected List<T> execQuery(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
