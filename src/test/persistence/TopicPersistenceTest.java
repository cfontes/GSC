package test.persistence;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.Post;
import br.com.gsc.model.tableMapping.Topic;
import br.com.gsc.model.tableMapping.User;

public class TopicPersistenceTest extends PersistenceTest{

//	@Test(groups="TopicThenPost")
//	public void testTopic(){
//		
//		 tx.begin();
//		 Topic topic = new Topic();
//		 topic.setTopicContent("test de topic");
//		 topic.setTopicTitle("test");
//		 //User user = new User();
//		 //user.setName("testTopic");
//		 //topic.setPerson(user);
//		 em.persist(topic);
//		 tx.commit();
//		 
//		 // look if the entity was persisted and got an id assigned
//		 assertNotNull(topic.getId());
//		 
//		 // lookup entity
//		 Long id = topic.getId();
//		 Topic TopicFromDatabase = em.find(Topic.class, id);
//		 assertNotNull(TopicFromDatabase);
//		 assertEquals("test de topic", TopicFromDatabase.getTopicContent());
//		
//	}
	
}
