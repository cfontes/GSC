package br.com.gsc.repository.objRepos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.gsc.model.tableMapping.Post;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.AbsRepository;
import br.com.gsc.repository.objInterfaces.IPostRepository;

@Repository("PostRepository")
public class PostRepository extends AbsRepository<Post> implements IPostRepository {

	@Override
	public void addPost(Post t) {
		add(t);
	}

	@Override
	public void removePost(Post t) {
		remove(t);
	}

	@Override
	public void updatePost(Post t) {
		update(t);
	}

	@Override
	public List<Post> ListPostByID(String query, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findTPostByID(Long id) {
		return read(new Post(), id);
	}

}
