package br.com.gsc.repository.objRepos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.gsc.model.tableMapping.Product;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.AbsRepository;
import br.com.gsc.repository.objInterfaces.IProductRepository;

@Repository("ProductRepository")
public class ProductRepository extends AbsRepository<Product> implements IProductRepository {

	@Override
	public void addProduct(Product t) {
		add(t);
	}

	@Override
	public void removePost(Product t) {
		remove(t);
	}

	@Override
	public void updateProduct(Product t) {
		update(t);
	}

	@Override
	public List<Product> ListProductByID(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findTProductByID(Long id) {
		return read(new Product(),id);
	}


}
