package es.cic.taller.ejercicio07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vaadin.data.Binder;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonaForm extends FormLayout {
    private VerticalLayout layout = new VerticalLayout();
    
    private TextField nombre = new TextField();
    
    private TextField apellidos = new TextField();
    
    private DateTimeField fecha = new DateTimeField();
    
    Collection<Pais> listaPaises = getListaPaises();    
   
    private ComboBox<Pais> pais = new ComboBox<>("Select your country", listaPaises);    
    
    private Binder<Persona> binder = new Binder<>(Persona.class);
    
    private MyUI myUI;
    
    public PersonaForm(MyUI myUI) {
        this.myUI = myUI;
        addComponents(nombre, apellidos, fecha, pais);
        binder.bindInstanceFields(this);
    }
    
    public void setPersona(Persona persona) {
    	binder.setBean(persona);
    }
    
    
    private Collection<Pais> getListaPaises() {
    	List<Pais> listaPaises = new ArrayList<>();
    	
    	Pais pais1 = new Pais();
    	pais1.setNombreCompleto("España");
    	
    	listaPaises.add(pais1);
    	
    	pais1 = new Pais();
    	pais1.setNombreCompleto("Francia");
    	
    	listaPaises.add(pais1);
    	
    	return listaPaises;
    }    

}
