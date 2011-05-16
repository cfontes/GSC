package br.com.gsc.repository.objInterfaces;

import java.util.List;

import br.com.gsc.model.tableMapping.Comment;

public interface ICommentRepository {

	public void addComment(Comment t);
	public void removeComment(Comment t);
	public void updateComment(Comment t);
	public List<Comment> ListCommentByID(String query, Object[] params);
	public Comment findCommentByID(Long id);
	
}
