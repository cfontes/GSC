package br.com.gsc.repository;

import java.util.List;

/**
 * Class that call the right persistence provider to handle the request.
 * @author cristiano
 *
 * @param <T>
 */
public class Repository<T> implements IRepository<T> {

	private RepositoryImpl jpa;
	
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T read(T t, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
