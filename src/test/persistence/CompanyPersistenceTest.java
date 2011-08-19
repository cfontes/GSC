package test.persistence;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.gsc.model.tableMapping.Company;
import br.com.gsc.model.tableMapping.Product;

public class CompanyPersistenceTest extends PersistenceTest{
		
		Company comp;
		Product prod;
	
		@BeforeTest
		public void setTestVars(){
			 comp = new Company();
			 comp.setName("comp");
			 prod= new Product();
			 prod.setName("car");
			 prod.setCompany(comp);
		}
		
		@Test
		public void testCompanyPersistence(){
			 tx.begin();
			 em.persist(comp);
			 tx.commit();
			 
			 // look if the entity was persisted and got an id assigned
			 assertNotNull(comp.getId());
			 
			 // lookup entity
			 Long id = comp.getId();
			 Company companyFromDatabase = em.find(Company.class, id);
			 assertNotNull(companyFromDatabase);
			 assertEquals("comp", companyFromDatabase.getName());	
		}
		
		@Test
		public void testProductPersistence(){
			 tx.begin();
			 em.persist(prod);
			 tx.commit();
			 
			 // look if the entity was persisted and got an id assigned
			 assertNotNull(prod.getId());
			 
			 // lookup entity
			 Long id = prod.getId();
			 Product productFromDatabase = em.find(Product.class, id);
			 assertNotNull(productFromDatabase);
			 assertEquals("car", productFromDatabase.getName());	
		}

}
