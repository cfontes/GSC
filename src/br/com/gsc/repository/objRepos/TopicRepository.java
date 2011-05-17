package br.com.gsc.repository.objRepos;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Repository;

import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.repository.AbsRepository;
import br.com.gsc.repository.objInterfaces.ITopicRepository;

@Repository("TopicRepository")
@NamedQueries({
      @NamedQuery(
       name="ListAllTopics",
       query="select * from tb_topics"),
})
public class TopicRepository  extends AbsRepository<Topic> implements ITopicRepository{

	@Override
	public void addTopic(Topic t) {
		add(t);
	}

	@Override
	public void removeTopic(Topic t) {
		remove(t);
	}

	@Override
	public void updateTopic(Topic t) {
		update(t);
	}

	@Override
	public List<Topic> ListTopicByID(String query, Object[] params) {
		return null;
	}

	@Override
	public Topic findTopicByID(Long id) {
		return read(new Topic(),id);	
	}

}
