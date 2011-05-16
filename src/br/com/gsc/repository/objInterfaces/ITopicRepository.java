package br.com.gsc.repository.objInterfaces;

import java.util.List;

import br.com.gsc.model.tableMapping.Person;
import br.com.gsc.model.tableMapping.Topic;

public interface ITopicRepository {

	public void addTopic(Topic t);
	public void removeTopic(Topic t);
	public void updateTopic(Topic t);
	public List<Topic> ListTopicByID(String query, Object[] params);
	public Topic findTopicByID(Long id);
}
