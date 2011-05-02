package test.persistence;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.Post;

public class PostPersistenceTest extends PersistenceTest{
	
//	@Test(dependsOnGroups="TopicThenPost")
//	public void testPost(){
//		
//		 tx.begin();
//		 Post post = new Post();
//		 post.setContent("test de post");
//		 em.persist(post);
//		 tx.commit();
//		 
//		 // look if the entity was persisted and got an id assigned
//		 assertNotNull(post.getId());
//		 
//		 // lookup entity
//		 Long id = post.getId();
//		 Post PostFromDatabase = em.find(Post.class, id);
//		 assertNotNull(PostFromDatabase);
//		 assertEquals("test de post", PostFromDatabase.getContent());
//		
//	}
	

}
