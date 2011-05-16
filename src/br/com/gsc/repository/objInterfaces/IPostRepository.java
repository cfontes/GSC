package br.com.gsc.repository.objInterfaces;

import java.util.List;

import br.com.gsc.model.tableMapping.Post;
import br.com.gsc.model.tableMapping.Topic;

public interface IPostRepository {

	public void addPost(Post t);
	public void removePost(Post t);
	public void updatePost(Post t);
	public List<Post> ListPostByID(String query, Object[] params);
	public Post findTPostByID(Long id);
}
