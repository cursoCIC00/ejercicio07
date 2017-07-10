package es.cic.taller.ejercicio07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private PersonaForm personaForm = new PersonaForm(this);
	
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();
        Button button3 = new Button("Cambiar persona");
        button3.addClickListener( e -> {
        	Persona persona = leerDesdeBBDD();
        	
        	personaForm.setPersona(persona);
        	PersonaForm auxpersonaForm = new PersonaForm(this);
        	layout.addComponent(auxpersonaForm);
        });
        
        layout.addComponents(button3, personaForm);
        
        setContent(layout);
    }

	private Persona leerDesdeBBDD() {
		Persona persona = new Persona();
		persona.setNombre("Alberto");
		persona.setApellidos("Dopico");
		persona.setFecha(LocalDateTime.now());
		Pais pais = new Pais();
		pais.setNombreCompleto("España");
		persona.setPais(pais);
		return persona;
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
