package br.com.gsc.repository.objRepos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.gsc.model.tableMapping.Comment;
import br.com.gsc.repository.AbsRepository;
import br.com.gsc.repository.objInterfaces.ICommentRepository;

@Repository("CommentRepository")
public class CommentRepository extends AbsRepository<Comment> implements ICommentRepository {
	
	@Override
	public void addComment(Comment t) {
		add(t);
	}

	@Override
	public void removeComment(Comment t) {
		remove(t);
	}

	@Override
	public void updateComment(Comment t) {
		update(t);
	}

	@Override
	public List<Comment> ListCommentByID(String query, Object[] params) {
		return null;
	}

	@Override
	public Comment findCommentByID(Long id) {
		read(new Comment(), id);
		return null;
	}

}
