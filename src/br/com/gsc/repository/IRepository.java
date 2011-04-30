package br.com.gsc.repository;

import java.util.List;

/**
 * This is the repository interface to use as an abstraction.
 * @author cristiano
 *
 * @param <T>
 */
public interface IRepository<T> {
	
	public void add(T t);
	public void remove(T t);
	public void update(T t);
	public T read(T t, long id);
	public List<T> findAll(String query, Object[] params);
}
