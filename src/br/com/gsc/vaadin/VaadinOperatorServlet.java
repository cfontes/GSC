package br.com.gsc.vaadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import br.com.gsc.model.tableMapping.Person;
import br.com.gsc.repository.objRepos.PersonRepository;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

@Configurable(preConstruction = true,dependencyCheck=true)
public class VaadinOperatorServlet extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2740889749468778716L;

	@Autowired()
	PersonRepository pRepo;
	
	@Override
	public void init() {
		Window window = new Window();
		Panel p = new Panel();
		Label l = new Label("Teste");
		Person person = pRepo.findPersonByID("user");
		Label l2 = new Label(person.getUsername());
		p.addComponent(l);
		p.addComponent(l2);
		window.addComponent(p);
		setMainWindow(window);
		window.getContent().setSizeFull();		
	}
	 
	 
}