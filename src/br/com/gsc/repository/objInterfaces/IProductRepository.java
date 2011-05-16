package br.com.gsc.repository.objInterfaces;

import java.util.List;

import br.com.gsc.model.tableMapping.Product;
import br.com.gsc.model.tableMapping.Topic;

public interface IProductRepository {

	public void addProduct(Product t);
	public void removePost(Product t);
	public void updateProduct(Product t);
	public List<Product> ListProductByID(String query, Object[] params);
	public Product findTProductByID(Long id);
	
}
